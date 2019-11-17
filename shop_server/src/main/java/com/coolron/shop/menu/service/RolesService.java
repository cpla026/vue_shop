package com.coolron.shop.menu.service;

import com.coolron.shop.menu.dao.MenuMapper;
import com.coolron.shop.menu.dao.RolesMapper;
import com.coolron.shop.menu.domain.Menu;
import com.coolron.shop.menu.domain.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 2019/11/12.
 */
@Service
public class RolesService {

    @Autowired
    private RolesMapper rolesMapper;

    @Autowired
    private MenuMapper menuMapper;

    public List<Roles> list() {
        List<Roles> rolesList = rolesMapper.list();

        for (Roles roles : rolesList) {
            String[] menuIds = roles.getMenuIds().split(",");
            List<Menu> menuList = menuMapper.getMenuByIds(menuIds);
            List<Menu> menuTree = getTree(menuList);
            roles.setChildren(menuTree);
        }
        return rolesList;
    }

    /**
     * 组装树
     * @param menuList
     * @return
     */
    private  List<Menu> getTree(List<Menu> menuList){
        List<Menu> resultList = new ArrayList<Menu>();
        Map<Integer, Menu> menuMap = new HashMap<Integer, Menu>();
        for (Menu t : menuList) {
            menuMap.put(t.getId(), t);
        }
        for (Menu p : menuList) {
            if (p.getPid() == 0){
                // 父节点
                resultList.add(p);
            } else {
                // 子节点
                // 获取它的父节点
                Menu parent = menuMap.get(p.getPid());
                parent.getChildren().add(p);
            }
        }
        return resultList;
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
        // 删除原始角色
        rolesMapper.deleteRoleRights(roleId);
        int i = rolesMapper.saveRoleRights(roleId, rids);
        return i;
    }
}
