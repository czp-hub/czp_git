package com.fh.loginController;

import com.fh.bean.UserBean;
import com.fh.jwt.JwtUtils;
import com.fh.service.UserService;
import com.fh.utils.response.ResponseServer;
import com.fh.utils.response.ServerEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
@CrossOrigin(maxAge = 3600,origins = "http://localhost:8080")
public class logController {

    @Autowired
    private UserService userService;

    @PostMapping("/queryLong")
    public ResponseServer queryLong(@RequestParam String userName, @RequestParam String password){

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        UserBean user = userService.queryUserName(userName);

        if(user == null){
            return  ResponseServer.error(ServerEnum.INEXISTENCE_NULL);
        }


        if(!userName.equals(user.getUserName())){
            return  ResponseServer.error(ServerEnum.USERNAME_NOTEXIST);
        }

        if(user.getErrorTime()!= null){
            if(new Date().getTime()<user.getErrorTime().getTime()){
                return  ResponseServer.error(ServerEnum.ERROR_LIMIT);
            }else if(System.currentTimeMillis()>user.getErrorTime().getTime() && user.getErrorCount()==3){
                user.setErrorTime(null);
                user.setErrorCount(0);
                userService.updateUser(user);
            }
        }


        if(user.getErrorCount()==3){
            user.setErrorTime(new Date(new Date().getTime()+50000));
            userService.updateUser(user);
            return  ResponseServer.error(ServerEnum.ERROR_LIMIT);
        }

        if(!password.equals(user.getPassword())){
            user.setErrorCount(user.getErrorCount()+1);
            userService.updateUser(user);
            return  ResponseServer.error(ServerEnum.PASSWORD_WRONG);
        }

        user.setLoginTime(new Date());
        userService.updateUser(user);
        request.setAttribute("user",user);
        UserBean user1 = (UserBean) request.getAttribute("user");
        HttpSession session = request.getSession();
        session.setAttribute("longin",user);
        Map<String,Object> map = new HashMap<>();
        map.put("userName",user.getUserName());

        String token= JwtUtils.createToken(map);
        map.put("token",token);
        return ResponseServer.success(token);
    }

}
