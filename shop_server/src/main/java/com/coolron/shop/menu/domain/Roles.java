package com.coolron.shop.menu.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Roles {
    private Integer id;

    private String roleName;

    private String roleDesc;

    private Date createTime;

    // 拥有的菜单(逗号分隔)
    private String menuIds;

    // 角色对应的权限(该角色下拥有哪些菜单)
    private List<Menu> children = new ArrayList<Menu>();
}