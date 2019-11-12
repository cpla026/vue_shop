package com.coolron.shop.menu.dao;

import com.coolron.shop.menu.domain.Menu;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    @Select("select id, auth_name as authName, pid, path, level, icon from menu ")
    List<Menu> list();
}