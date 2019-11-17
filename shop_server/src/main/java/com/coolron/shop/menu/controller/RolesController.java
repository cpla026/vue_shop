package com.coolron.shop.menu.controller;

import com.coolron.shop.common.utils.ApiResult;
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

    /**
     * 角色列标 包含角色对应的权限(菜单)
     * @return
     */
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

    /**
     * 删除对应角色的权限
     * @param roleId   角色id
     * @param rightId  权限id   即菜单id
     * @return
     */
    @DeleteMapping("/{roleId}/{rightId}")
    public ApiResult deleteRights(@PathVariable(value = "roleId") Integer roleId,
                                @PathVariable(value = "rightId") Integer rightId){
        int i = rolesService.deleteRights(roleId, rightId);
        return ApiResult.ok(i);
    }

    /**
     * 给对应的角色分配功能  菜单
     * @param roleId  角色id
     * @param rids 功能id使用 , 拼接字符串
     * @return
     */
    @PostMapping("/{roleId}/rights/{rids}")
    public ApiResult saveRoleRights(@PathVariable(value = "roleId") Integer roleId,
                                    @PathVariable(value = "rids") String rids){
        int i = rolesService.saveRoleRights(roleId, rids);
        return ApiResult.ok(roleId + ": " + rids);
    }

}
