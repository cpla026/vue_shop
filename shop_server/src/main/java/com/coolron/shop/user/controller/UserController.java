package com.coolron.shop.user.controller;

import com.alibaba.fastjson.JSON;
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
    public ApiResult list(
            @RequestParam(value = "query", required = false) String query,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1", required = false) int pageNum){
        //List<User> list = userService.list();

        String json = "[\n" +
                "    {\n" +
                "        \"create_time\": 1486720211,\n" +
                "        \"email\": \"adsfad@qq.com\",\n" +
                "        \"id\": 500,\n" +
                "        \"mg_state\": true,\n" +
                "        \"mobile\": \"12345678\",\n" +
                "        \"role_name\": \"超级管理员\",\n" +
                "        \"username\": \"admin\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"create_time\": 1483720453,\n" +
                "        \"email\": \"0804@qq.com\",\n" +
                "        \"id\": 501,\n" +
                "        \"mg_state\": true,\n" +
                "        \"mobile\": \"68686867\",\n" +
                "        \"role_name\": \"超级管理员\",\n" +
                "        \"username\": \"ron\"\n" +
                "    }\n" +
                "]";
        return ApiResult.ok(JSON.parseObject(json,List.class));
    }

    @GetMapping("/{id}")
    public ApiResult getInfo(@PathVariable(value = "id") String id){
        User user = userService.getInfo(id);
        return ApiResult.ok(user);
    }
    @PostMapping("/save")
    public ApiResult save(@RequestBody Map map){

        return ApiResult.ok(map);
    }

    @PutMapping("update/{id}/{mg_state}")
    public ApiResult update(@PathVariable(value = "id") String id,
                             @PathVariable(value = "mg_state") Boolean state){
        Map map = new HashMap<String, Object>(2);
        map.put("id", id);
        map.put("mg_state", state);
        map.put("status", 200);
        return ApiResult.ok(map);
    }
}
