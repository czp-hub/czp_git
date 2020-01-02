package com.fh.controller;

import com.fh.service.RightService;
import com.fh.utils.response.ResponseServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("rights")
public class RightController {

    @Autowired
    private RightService rightService;

    /**
     * 初始化权限菜单
     * @return
     */
    @GetMapping("/{pId}")
    public ResponseServer showSystemList(@PathVariable Integer pId){
        return rightService.showSystemList(pId);
    }

}
