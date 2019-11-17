package com.coolron.shop.menu.service;

import com.coolron.shop.menu.dao.MenuMapper;
import com.coolron.shop.menu.domain.Menu;
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
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;

    public List<Menu> list(String type) {
        List<Menu> menuList = new ArrayList<Menu>();
        menuList = menuMapper.list();
        if("tree".equals(type)){
            menuList = getTree(menuList);
        }
        return menuList;
    }

    public int save(Menu menu){
        //List<Menu> list = JSON.parseArray(json, Menu.class);
        //List<Menu> list = JSON.parseObject(json, List.class);
//        for (Menu menu1 : list) {
//            int i = menuMapper.insertSelective(menu1);
//        }
        int i = menuMapper.insertSelective(menu);
        return 0;
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
}
