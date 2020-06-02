package com.xt.sys.vo;

import com.xt.sys.domain.Dept;
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
public class DeptVo extends Dept {

    public static final long serialVersionUID = 1L;

    private Integer page;
    private Integer limit;

}
