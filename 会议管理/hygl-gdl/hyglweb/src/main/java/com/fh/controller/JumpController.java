package com.fh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("jumpController")
public class JumpController {

    //跳页面的方法
    @RequestMapping("jumpPage")
    public String jumpDept(String url) {
        return url;
    }

    @RequestMapping("togoUser")
    public ModelAndView togoUser(Integer id){
        ModelAndView mav=new ModelAndView("User/updateUser");
        mav.addObject("id",id);
        return mav;
    }
}
