package com.xt.sys.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xt.sys.common.DataGridView;
import com.xt.sys.common.ResultObj;
import com.xt.sys.common.TreeNode;
import com.xt.sys.domain.Dept;
import com.xt.sys.domain.Notice;
import com.xt.sys.service.DeptService;
import com.xt.sys.vo.DeptVo;
import com.xt.sys.vo.NoticeVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.awt.dnd.DropTarget;
import java.util.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xt
 * @since 2020-06-02
 */
@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;


    /**
     * @param deptVo
     * @return 加载左侧树形图
     */
    @RequestMapping("loadDeptManagerLeftTreeJson")
    public DataGridView loadDeptManagerLeftTreeJson(DeptVo deptVo) {
        List<Dept> list = this.deptService.list();

        List<TreeNode> treeNodes = new ArrayList<>();

        for (Dept dept : list) {
            Boolean spreed = dept.getOpen() == 1 ? true : false;
            treeNodes.add(new TreeNode(dept.getId(), dept.getPid(), dept.getTitle(), spreed));
        }
        return new DataGridView(treeNodes);
    }


    /**
     * @return 查询
     */
    @RequestMapping("loadAllDept")
    public DataGridView loadAllDept(DeptVo deptVo) {
        IPage<Dept> page = new Page<>(deptVo.getPage(), deptVo.getLimit());
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(deptVo.getTitle()), "title", deptVo.getTitle());
        queryWrapper.like(StringUtils.isNotBlank(deptVo.getAddress()), "address", deptVo.getAddress());
        queryWrapper.like(StringUtils.isNotBlank(deptVo.getRemark()), "remark", deptVo.getRemark());
        queryWrapper.orderByAsc("ordernum");
        queryWrapper.eq(deptVo.getId() != null, "id", deptVo.getId()).or().eq(deptVo.getId() != null, "pid", deptVo.getId());
        this.deptService.page(page, queryWrapper);
        return new DataGridView(page.getTotal(), page.getRecords());
    }

    /**
     * @param deptVo
     * @return 添加部门
     */
    @RequestMapping("addDept")
    public ResultObj addDept(DeptVo deptVo){
        try{
            deptVo.setCreatetime(new Date());
           this.deptService.save(deptVo);
           return ResultObj.ADD_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * @param deptVo
     * @return 修改部门
     */
    @RequestMapping("updateDept")
    public ResultObj updateDept(DeptVo deptVo){
        try{
            deptVo.setCreatetime(new Date());
           this.deptService.updateById(deptVo);
           return ResultObj.UPDATE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    //加载最大的排序码
    @RequestMapping("loadDeptMaxOrderNum")
    public Map<String,Object> loadDeptMaxOrderNum(){
        Map<String ,Object> map=new HashMap<>();
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("ordernum");
        List<Dept> list = this.deptService.list(queryWrapper);
        if (list.size()>0){
            map.put("value",list.get(0).getOrdernum()+1);
        }else {
            map.put("value",1);
        }
        return map;
    }
}

