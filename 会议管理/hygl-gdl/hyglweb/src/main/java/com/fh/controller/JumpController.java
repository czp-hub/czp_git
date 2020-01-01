package com.fh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("jumpController")
public class JumpController {

    //跳页面的方法
    @RequestMapping("jumpPage")
    public String jumpDept(String url) {
        return url;
    }
}
