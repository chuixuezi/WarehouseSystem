package com.xt.sys.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xt.sys.common.*;
import com.xt.sys.domain.Permission;
import com.xt.sys.domain.User;
import com.xt.sys.service.PermissionService;
import com.xt.sys.vo.PermissionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xt
 * @since 2020-05-29
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private PermissionService permissionService;

    /**
     * @param permissionVo
     * @return 加载菜单
     */
    @RequestMapping("loadIndexLeftMenuJson")
    public DataGridView loadIndexLeftMenuJson(PermissionVo permissionVo) {
        //查询所有菜单
        QueryWrapper<Permission> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type", Constast.TYPE_MENU);
        queryWrapper.eq("available", Constast.AVAILABLE_TRUE);

        User user = (User) WebUtils.getSession().getAttribute("user");
        List<Permission> list = null;
        if (user.getType() == Constast.USER_TYPE_SUPER) {
            list = permissionService.list(queryWrapper);
        } else {
            //根据用户id+角色+权限去查
            list = permissionService.list(queryWrapper);
        }
        List<TreeNode> treeNodes = new ArrayList<>();
        for (Permission p : list) {
            Integer id=p.getId();
            Integer pId=p.getPid();
            String title=p.getTitle();
            String icon=p.getIcon();
            String href=p.getHref();
            Boolean spread=p.getOpen()==Constast.OPEN_TRUE?true:false;
            treeNodes.add(new TreeNode(id,pId,title,icon,href,spread));
        }
        //构造层级关系
        List<TreeNode> list2 = TreeNodeBuilder.build(treeNodes, 1);

        return new DataGridView(list2);
    }
}

