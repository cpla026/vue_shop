package com.coolron.shop.user.controller;

import com.coolron.shop.common.utils.ApiResult;
import com.coolron.shop.user.domain.User;
import com.coolron.shop.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: xf
 * @Date: 2018/12/18 20:34
 * @Description:
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ApiResult login(@RequestBody User user){
        if(!"ron".equals(user.getUsername())){
            return ApiResult.build(400,"密码或用户名不对");
        }
        if(user.getPassword().length() < 4){
            return ApiResult.build(400,"密码或用户名不对");
        }
        Map map = new HashMap<String, String>();
        map.put("token", "How`s it going? Ron!");
        return ApiResult.ok(map);
    }

    @GetMapping("/list")
    public ApiResult list(){
        List<User> list = userService.list();
        return ApiResult.ok(list);
    }

    @GetMapping("/{id}")
    public ApiResult getInfo(@PathVariable(value = "id") String id){
        User user = userService.getInfo(id);
        return ApiResult.ok(user);
    }
}
