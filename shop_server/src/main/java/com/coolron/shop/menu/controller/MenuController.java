package com.coolron.shop.menu.controller;/**
 * Created by Administrator on 2019/11/9.
 */

import com.coolron.shop.common.utils.ApiResult;
import com.coolron.shop.menu.domain.Menu;
import com.coolron.shop.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: xf
 * @Date: 2019/11/9 12:19
 * @Description:
 */
@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/rights/{type}")
    public ApiResult list(@PathVariable(value = "type") String type){
        List<Menu> list = menuService.list(type);
        return ApiResult.ok(list);
    }

    @PostMapping("menu/save")
    public ApiResult save(@RequestBody Menu menu){
        int i = menuService.save(menu);
        return ApiResult.ok(i);
    }

    @GetMapping("menu/getMenus")
    public ApiResult getMenus(){
        List<Menu> list = menuService.list("tree");
        return ApiResult.ok(list);
    }

}
