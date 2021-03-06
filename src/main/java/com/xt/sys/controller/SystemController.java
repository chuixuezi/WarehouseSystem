package com.xt.sys.controller;

import org.springframework.stereotype.Controller;
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
     *
     * @return 跳转到工作台
     */
    @RequestMapping("/toDeskManager")
    public String toDeskManager(){
        return "system/index/deskManager";
    }

    /**
     *
     * @return 跳转到日志管理
     */
    @RequestMapping("/toLoginfoManager")
    public String toLoginfoManager(){
        return "system/loginfo/loginfoManager";
    }

    /**
     *
     * @return 跳转到公告管理
     */
    @RequestMapping("/toNoticeManager")
    public String toNoticeManager(){
        return "system/notice/noticeManager";
    }


    /**
     * @return 跳转到部门管理
     */
    @RequestMapping("toDeptManager")
    public String toDeptManager(){
        return "system/dept/deptManager";
    }
    /**
     * @return 跳转到部门管理左页面
     */
    @RequestMapping("toDeptLeft")
    public String toDeptLeft(){
        return "system/dept/deptLeft";
    }
    /**
     * @return 跳转到部门管理右页面
     */
    @RequestMapping("toDeptRight")
    public String toDeptRight(){
        return "system/dept/deptRight";
    }

    
    /**
     * @return 跳转到菜单管理
     */
    @RequestMapping("toMenuManager")
    public String toMenuManager(){
        return "system/menu/menuManager";
    }
    /**
     * @return 跳转到菜单管理左页面
     */
    @RequestMapping("toMenuLeft")
    public String toMenuLeft(){
        return "system/menu/menuLeft";
    }
    /**
     * @return 跳转到菜单管理右页面
     */
    @RequestMapping("toMenuRight")
    public String toMenuRight(){
        return "system/menu/menuRight";
    }
    
    /**
     * @return 跳转到权限管理
     */
    @RequestMapping("toPermissionManager")
    public String toPermissionManager(){
        return "system/permission/permissionManager";
    }
    /**
     * @return 跳转到权限管理左页面
     */
    @RequestMapping("toPermissionLeft")
    public String toPermissionLeft(){
        return "system/permission/permissionLeft";
    }
    /**
     * @return 跳转到权限管理右页面
     */
    @RequestMapping("toPermissionRight")
    public String toPermissionRight(){
        return "system/permission/permissionRight";
    }
}
