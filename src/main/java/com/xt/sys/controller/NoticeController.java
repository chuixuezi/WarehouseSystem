package com.xt.sys.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xt.sys.common.DataGridView;
import com.xt.sys.common.ResultObj;
import com.xt.sys.common.WebUtils;
import com.xt.sys.domain.Notice;
import com.xt.sys.domain.User;
import com.xt.sys.service.NoticeService;
import com.xt.sys.vo.NoticeVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.awt.dnd.DropTarget;
import java.util.Date;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xt
 * @since 2020-06-01
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;


    /**
     * @return 查询
     */
    @RequestMapping("loadAllNotice")
    public DataGridView loadAllNotice(NoticeVo noticeVo) {
        IPage<Notice> page = new Page<>(noticeVo.getPage(), noticeVo.getLimit());
        QueryWrapper<Notice> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(noticeVo.getTitle()), "title", noticeVo.getTitle());
        queryWrapper.like(StringUtils.isNotBlank(noticeVo.getOpername()), "opername", noticeVo.getOpername());
        queryWrapper.ge(noticeVo.getStartTime() != null, "createtime", noticeVo.getStartTime());
        queryWrapper.le(noticeVo.getEndTime() != null, "createtime", noticeVo.getEndTime());
        this.noticeService.page(page, queryWrapper);
        return new DataGridView(page.getTotal(), page.getRecords());
    }


    /**
     * @param noticeVo
     * @return 添加
     */
    @RequestMapping("addNotice")
    public ResultObj addNotice(NoticeVo noticeVo) {
        try {
            noticeVo.setCreatetime(new Date());
            User user = (User) WebUtils.getSession().getAttribute("user");
            noticeVo.setOpername(user.getName());
            this.noticeService.save(noticeVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;

        }

    }
}