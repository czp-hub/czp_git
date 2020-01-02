package com.fh.controller;

import com.fh.Interceptor.LoginAnnotation;
import com.fh.bean.UserBean;
import com.fh.service.UserService;
import com.fh.utiles.PageBean;
import com.fh.utils.response.ResponseServer;
import com.fh.utils.response.ServerEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin(maxAge = 3600,origins = "http://localhost:8080",exposedHeaders = "NOLONGIN")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

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
