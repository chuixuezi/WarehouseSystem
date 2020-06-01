package com.xt.sys.vo;

import com.xt.sys.domain.Notice;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author xt
 * @since 2020-05-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class NoticeVo extends Notice {

    public static final long serialVersionUID = 1L;

    private Integer page;
    private Integer limit;

    private Integer[] ids;//接受多个id

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
}
