package com.coolron.shop.user.service;

import com.coolron.shop.common.utils.PageBean;
import com.coolron.shop.user.dao.UserMapper;
import com.coolron.shop.user.domain.User;
import com.coolron.shop.user.domain.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Auther: xf
 * @Date: 2018/12/18 17:35
 * @Description:
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> list() {
        List<User> list = userMapper.list();
        return list;
    }

    public User getInfo(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public PageBean<User> pageList(Map<String, Object> page, int pageSize) {
        PageBean<User> pageBean = new PageBean<User>();

        // 当前条件下的总记录数
        Integer totalCount = userMapper.findTotalCount(page);
        pageBean.setTotalCount(totalCount);

        // 总页数 总记录数除以每页记录数向上取整
        double tc = totalCount; // 将总记录数转换为double
        Double ceilTotal = Math.ceil(tc / pageSize); // 向上取整
        int totalPage = ceilTotal.intValue();
        pageBean.setTotalPage(totalPage);

        List<User> list = userMapper.pageList(page);
        pageBean.setPageList(list);

        return pageBean;
    }

    public int save(UserForm userForm) {
        User user = new User();
        user.setCreate_time(new Date());
        user.setEmail(userForm.getEmail());
        user.setMg_state(true);
        user.setMobile(userForm.getMobile());
        user.setPassword(userForm.getPassword());
        user.setUsername(userForm.getUsername());

        int i = userMapper.insertSelective(user);
        return i;
    }

    public int update(User user) {
        int i = userMapper.updateByPrimaryKeySelective(user);
        return i;
    }

    public int delete(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }
}
