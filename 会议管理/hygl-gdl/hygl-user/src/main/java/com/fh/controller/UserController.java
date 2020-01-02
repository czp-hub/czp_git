package com.fh.controller;

import com.fh.bean.UserBean;
import com.fh.service.UserService;
import com.fh.utiles.PageBean;
import com.fh.utils.ResponseServer;
import com.fh.utils.ServerEnum;
import com.fh.utils.exceptionAOP.Interceptor.LoginAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@CrossOrigin(maxAge = 2000,origins ="http://localhost:8080")
@RequestMapping("/user")

public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/queryLong")
    /*@LoginAnnotation*/
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
        return ResponseServer.success(ServerEnum.LOGIN_SUCCESS);
    }

    @GetMapping("/queryUser")
    @LoginAnnotation
    public PageBean<UserBean> queryUser(UserBean userBean){
        return userService.queryUser(userBean);
    }

    @PutMapping("/toAddUser")
    @LoginAnnotation
    public ResponseServer toAddUser(UserBean userBean, Integer id){
        if(id != null){
            userService.updateUser(userBean);
            return ResponseServer.success(ServerEnum.ADD_SUCCESS);
        }
        userBean.setLoginTime(new Date());
        userService.addUser(userBean);
        return ResponseServer.success(ServerEnum.ADD_SUCCESS);
    }


    @DeleteMapping
    @LoginAnnotation
    public ResponseServer deleteUser(Integer id){
        userService.deleteUser(id);
        return ResponseServer.success(ServerEnum.DELETE_SUCCESS);
    }

    @PostMapping
    @LoginAnnotation
    public ResponseServer togoUser(Integer id){
        UserBean userBean = userService.togoUser(id);
        return ResponseServer.success(userBean);
    }

}
