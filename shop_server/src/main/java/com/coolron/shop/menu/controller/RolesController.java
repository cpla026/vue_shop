package com.coolron.shop.menu.controller;

import com.coolron.shop.common.utils.ApiResult;
import com.coolron.shop.menu.domain.Menu;
import com.coolron.shop.menu.domain.Roles;
import com.coolron.shop.menu.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by user on 2019/11/12.
 */
@RestController
@RequestMapping("roles")
public class RolesController {
    @Autowired
    private RolesService rolesService;

    @GetMapping("/list")
    public ApiResult list(){
        List<Roles> list = rolesService.list();
        return ApiResult.ok(list);
    }

    @GetMapping("/{id}")
    public ApiResult getInfo(@PathVariable(value = "id") Integer id){
        Roles roles = rolesService.getInfo(id);
        return ApiResult.ok(roles);
    }

    @PostMapping("/save")
    public ApiResult save(@RequestBody Roles roles){
        int i = rolesService.saveOrUpdate(roles);
        return ApiResult.ok(i);
    }

    @PutMapping("/update")
    public ApiResult update(@RequestBody Roles roles){
        int i = rolesService.saveOrUpdate(roles);
        return ApiResult.ok(i);
    }

    @DeleteMapping("/{id}")
    public ApiResult delete(@PathVariable(value = "id") Integer id){
        int i = rolesService.delete(id);
        return ApiResult.ok(i);
    }

}
