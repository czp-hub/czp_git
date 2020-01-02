package com.fh.Interceptor;

import com.fh.exception.AuthenticateException;
import com.fh.jwt.JwtUtils;
import com.fh.utils.UtilsTools;
import com.fh.utils.response.ResponseServer;
import com.fh.utils.response.ServerEnum;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Order(7)
public class LoginAnnotationAop {

    @Around(value = "execution(* com.fh.controller.*.*(..))&&@annotation(loginAnnotation)")
    public Object loginPoint(ProceedingJoinPoint joinPoint, LoginAnnotation loginAnnotation){

         HttpServletRequest request = UtilsTools.getRequest();
        String token = request.getHeader("token");
        //判断前台是否有token值
        if (StringUtils.isBlank(token) || token==""){
            throw new AuthenticateException(ServerEnum.TOKEN_TIMEOUT);
        }
        //判断token值知否正确
        ResponseServer responseServer = JwtUtils.resolverToken(token);
        if (responseServer.getCode()!=200){
            throw new AuthenticateException(ServerEnum.TOKEN_TIMEOUT);
        }
        Claims claims = (Claims) responseServer.getData();
        String userName= (String) claims.get("userName");
        request.setAttribute("userName",userName);

        Object obj = null;
        try {
            obj = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }


        return obj;
    }
}
