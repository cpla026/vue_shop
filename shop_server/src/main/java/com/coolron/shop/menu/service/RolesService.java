package com.coolron.shop.menu.service;

import com.coolron.shop.menu.dao.RolesMapper;
import com.coolron.shop.menu.domain.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 2019/11/12.
 */
@Service
public class RolesService {

    @Autowired
    private RolesMapper rolesMapper;

    public List<Roles> list() {
        return rolesMapper.list();
    }

    public Roles getInfo(Integer id) {
        return rolesMapper.selectByPrimaryKey(id);
    }

    public int saveOrUpdate(Roles roles) {
        int i = 0;
        if(null != roles.getId()) {
            i = rolesMapper.updateByPrimaryKeySelective(roles);
        }
        i = rolesMapper.insertSelective(roles);
        return i;
    }

    public int delete(Integer id) {
         return rolesMapper.deleteByPrimaryKey(id);
    }

    public int deleteRights(Integer roleId, Integer menuId) {
        return rolesMapper.deleteRights(roleId, menuId);
    }

    public int saveRoleRights(Integer roleId, String rids) {
        return 0;
    }
}
