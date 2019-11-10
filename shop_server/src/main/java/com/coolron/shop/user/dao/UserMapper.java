package com.coolron.shop.user.dao;

import com.coolron.shop.user.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    @Select("select * from user")
    List<User> list();

    Integer findTotalCount(@Param("page") Map<String, Object> page);

    List<User> pageList(@Param("page") Map<String, Object> page);
}