package com.coolron.shop.menu.dao;

import com.coolron.shop.menu.domain.Roles;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RolesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Roles record);

    int insertSelective(Roles record);

    Roles selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Roles record);

    int updateByPrimaryKey(Roles record);

    List<Roles> list();

    @Select("")
    int deleteRights(Integer roleId, Integer menuId);
}