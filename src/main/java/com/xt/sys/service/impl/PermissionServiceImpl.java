package com.xt.sys.service.impl;

import com.xt.sys.domain.Permission;
import com.xt.sys.mapper.PermissionMapper;
import com.xt.sys.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xt
 * @since 2020-05-29
 */
@Service
@Transactional
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    @Override
    public boolean removeById(Serializable id) {
        PermissionMapper permissionMapper = this.getBaseMapper();
        //根据权限或菜单id删除权限各角色的数据

        permissionMapper.deleteRolePermissionByPid(id);
        return super.removeById(id);//删除权限表的数据
    }
}
