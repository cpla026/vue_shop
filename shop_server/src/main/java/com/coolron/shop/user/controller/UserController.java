package com.coolron.shop.user.controller;

import com.coolron.shop.common.utils.ApiResult;
import com.coolron.shop.common.utils.PageBean;
import com.coolron.shop.user.domain.User;
import com.coolron.shop.user.domain.UserForm;
import com.coolron.shop.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

        /* String json = "[\n" +
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
        return ApiResult.ok(JSON.parseObject(json,List.class));*/


        Map<String, Object> page = new HashMap<String, Object>(4);
        page.put("begin", (pageNum - 1) * pageSize);     // 查询起始值
        page.put("pageSize", pageSize);                 // 当前页记录数
        page.put("username", query);                    // username 模糊查询

        // 分页查询
        PageBean<User> pageBean = userService.pageList(page, pageSize);
        pageBean.setCurrpage(pageNum); // 当前页
        pageBean.setPageSize(pageSize); // 每页记录数

        return ApiResult.ok(pageBean);

    }

    @GetMapping("/{id}")
    public ApiResult getInfo(@PathVariable(value = "id") Integer id){
        User user = userService.getInfo(id);
        return ApiResult.ok(user);
    }
    @DeleteMapping("/{id}")
    public ApiResult delete(@PathVariable(value = "id") Integer id){
        int i = userService.delete(id);
        return ApiResult.ok(i);
    }

    @PostMapping("/save")
    public ApiResult save(@RequestBody UserForm userForm){

        int i = userService.save(userForm);
        return ApiResult.ok(i);
    }

    @PutMapping("update/{id}/{mg_state}")
    public ApiResult update(@PathVariable(value = "id") Integer id,
                             @PathVariable(value = "mg_state") Boolean state){
        User user = new User();
        user.setId(id);
        user.setMg_state(state);

        int i = userService.update(user);
        return ApiResult.ok(i);
    }

    @PostMapping("update")
    public ApiResult updateUser(@RequestBody User user){
        int i = userService.update(user);
        return ApiResult.ok(i);
    }

    /**
     * 给用户分配角色
     * @param userId
     * @param rid
     * @return
     */
    @PutMapping("/{userId}/role")
    public ApiResult saveRole(@PathVariable(value = "userId") Integer userId,
                              @RequestBody String rid){
        //int i = userService.saveRole(userId, rid);
        return ApiResult.ok(userId + ": " + rid);
    }

}
