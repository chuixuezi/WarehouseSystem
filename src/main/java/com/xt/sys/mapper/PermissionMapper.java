package com.xt.sys.mapper;

import com.xt.sys.domain.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xt
 * @since 2020-05-29
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    //根据权限或菜单id删除权限各角色的数据
    void deleteRolePermissionByPid(@Param("id")Serializable id);
}
