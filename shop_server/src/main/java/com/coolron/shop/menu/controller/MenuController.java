package com.coolron.shop.menu.controller;/**
 * Created by Administrator on 2019/11/9.
 */

import com.alibaba.fastjson.JSON;
import com.coolron.shop.common.utils.ApiResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: xf
 * @Date: 2019/11/9 12:19
 * @Description:
 */
@RestController
@RequestMapping("menu")
public class MenuController {

    @GetMapping("getMenus")
    public ApiResult getMenus(){
        String json = "[\n" +
                "    {\n" +
                "        \"authName\": \"商品管理\",\n" +
                "        \"children\": [\n" +
                "            {\n" +
                "                \"authName\": \"商品列表\",\n" +
                "                \"children\": [],\n" +
                "                \"icon\": \"el-icon-menu\",\n" +
                "                \"id\": 101,\n" +
                "                \"path\": \"goods\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"authName\": \"分类参数\",\n" +
                "                \"children\": [],\n" +
                "                \"icon\": \"el-icon-menu\",\n" +
                "                \"id\": 102,\n" +
                "                \"path\": \"params\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"authName\": \"商品分类\",\n" +
                "                \"children\": [],\n" +
                "                \"icon\": \"el-icon-menu\",\n" +
                "                \"id\": 103,\n" +
                "                \"path\": \"categories\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"icon\": \"el-icon-s-goods\",\n" +
                "        \"id\": 100,\n" +
                "        \"path\": \"goods\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"authName\": \"权限管理\",\n" +
                "        \"children\": [\n" +
                "            {\n" +
                "                \"authName\": \"角色列表\",\n" +
                "                \"children\": [],\n" +
                "                \"icon\": \"el-icon-menu\",\n" +
                "                \"id\": 111,\n" +
                "                \"path\": \"roles\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"authName\": \"权限列表\",\n" +
                "                \"children\": [],\n" +
                "                \"icon\": \"el-icon-menu\",\n" +
                "                \"id\": 112,\n" +
                "                \"path\": \"rights\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"icon\": \"el-icon-s-shop\",\n" +
                "        \"id\": 110,\n" +
                "        \"path\": \"roles\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"authName\": \"用户管理\",\n" +
                "        \"children\": [\n" +
                "            {\n" +
                "                \"authName\": \"用户列表\",\n" +
                "                \"children\": [],\n" +
                "                \"icon\": \"el-icon-menu\",\n" +
                "                \"id\": 121,\n" +
                "                \"path\": \"users\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"icon\": \"el-icon-user-solid\",\n" +
                "        \"id\": 120,\n" +
                "        \"path\": \"users\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"authName\": \"订单管理\",\n" +
                "        \"children\": [\n" +
                "            {\n" +
                "                \"authName\": \"订单列表\",\n" +
                "                \"children\": [],\n" +
                "                \"icon\": \"el-icon-menu\",\n" +
                "                \"id\": 131,\n" +
                "                \"path\": \"orders\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"icon\": \"el-icon-s-order\",\n" +
                "        \"id\": 130,\n" +
                "        \"path\": \"orders\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"authName\": \"数据统计\",\n" +
                "        \"children\": [\n" +
                "            {\n" +
                "                \"authName\": \"数据报表\",\n" +
                "                \"children\": [],\n" +
                "                \"icon\": \"el-icon-menu\",\n" +
                "                \"id\": 141,\n" +
                "                \"path\": \"reports\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"icon\": \"el-icon-data-analysis\",\n" +
                "        \"id\": 140,\n" +
                "        \"path\": \"reports\"\n" +
                "    }\n" +
                "]";
        return ApiResult.ok(JSON.parseObject(json,List.class));
    }
}
