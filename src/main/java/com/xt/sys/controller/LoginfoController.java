package com.xt.sys.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xt.sys.common.DataGridView;
import com.xt.sys.common.ResultObj;
import com.xt.sys.domain.Loginfo;
import com.xt.sys.service.LoginfoService;
import com.xt.sys.vo.LoginfoVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xt
 * @since 2020-05-30
 */
@RestController
@RequestMapping("/loginfo")
public class LoginfoController {

    @Autowired
    private LoginfoService loginfoService;

    /**
     * 全查询
     *
     * @param loginfoVo
     * @return
     */
    @RequestMapping("loadAllLoginfo")
    public DataGridView loadAllLoginfo(LoginfoVo loginfoVo) {
        IPage<Loginfo> page = new Page<>(loginfoVo.getPage(), loginfoVo.getLimit());

        QueryWrapper<Loginfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(loginfoVo.getLoginname()), "loginname", loginfoVo.getLoginname());
        queryWrapper.like(StringUtils.isNotBlank(loginfoVo.getLoginip()), "loginip", loginfoVo.getLoginip());
        queryWrapper.ge(loginfoVo.getStartTime() != null, "logintime", loginfoVo.getStartTime());
        queryWrapper.le(loginfoVo.getEndTime() != null, "logintime", loginfoVo.getEndTime());
        queryWrapper.orderByDesc("logintime");
        this.loginfoService.page(page, queryWrapper);
        return new DataGridView(page.getTotal(), page.getRecords());

    }

    /**
     *
     * @param id
     * @return 删除
     */
    @RequestMapping("deleteLoginfo")
    public ResultObj deleteLoginfo(Integer id){
        try {
            this.loginfoService.removeById(id);
            return ResultObj.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     *
     * @param loginfoVo
     * @return 批量删除
     */
    @RequestMapping("batchDeleteLoginfo")
    public ResultObj batchDeleteLoginfo(LoginfoVo loginfoVo){
        try {
            Collection<Serializable> idList=new ArrayList<>();
            for (Integer id : loginfoVo.getIds()) {
                idList.add(id);
            }
            this.loginfoService.removeByIds(idList);
            return ResultObj.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
}

