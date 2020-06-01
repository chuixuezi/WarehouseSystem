package com.xt.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sys")
public class SystemController {

    /*
    * 跳转到登陆页面
    * */

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "system/index/login";
    }

    @RequestMapping("/index")
    public String index(){
        return "system/index/index";
    }

    /**
     * 跳转到工作台
     * @return
     */
    @RequestMapping("/toDeskManager")
    public String toDeskManager(){
        return "system/index/deskManager";
    }

    @RequestMapping("/toLoginfoManager")
    public String toLoginfoManager(){
        return "system/loginfo/loginfoManager";
    }

}
