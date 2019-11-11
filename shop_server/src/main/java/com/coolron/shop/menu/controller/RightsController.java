package com.coolron.shop.menu.controller;/**
 * Created by Administrator on 2019/11/11.
 */

import com.alibaba.fastjson.JSON;
import com.coolron.shop.common.utils.ApiResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: xf
 * @Date: 2019/11/11 22:32
 * @Description:
 */
@RestController
public class RightsController {



    @GetMapping("/roles")
    public ApiResult roles(){
        String json = "[\n" +
                "    {\n" +
                "        \"children\": [\n" +
                "            {\n" +
                "                \"authName\": \"商品管理\",\n" +
                "                \"children\": [\n" +
                "                    {\n" +
                "                        \"authName\": \"商品列表\",\n" +
                "                        \"children\": [],\n" +
                "                        \"icon\": \"el-icon-menu\",\n" +
                "                        \"id\": 101,\n" +
                "                        \"level\": \"1\",\n" +
                "                        \"path\": \"goods\",\n" +
                "                        \"pid\": 100\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"authName\": \"分类参数\",\n" +
                "                        \"children\": [],\n" +
                "                        \"icon\": \"el-icon-menu\",\n" +
                "                        \"id\": 102,\n" +
                "                        \"level\": \"1\",\n" +
                "                        \"path\": \"params\",\n" +
                "                        \"pid\": 100\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"authName\": \"商品分类\",\n" +
                "                        \"children\": [],\n" +
                "                        \"icon\": \"el-icon-menu\",\n" +
                "                        \"id\": 103,\n" +
                "                        \"level\": \"1\",\n" +
                "                        \"path\": \"categories\",\n" +
                "                        \"pid\": 100\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"icon\": \"el-icon-s-goods\",\n" +
                "                \"id\": 100,\n" +
                "                \"level\": \"0\",\n" +
                "                \"path\": \"goods\",\n" +
                "                \"pid\": 0\n" +
                "            },\n" +
                "            {\n" +
                "                \"authName\": \"权限管理\",\n" +
                "                \"children\": [\n" +
                "                    {\n" +
                "                        \"authName\": \"角色列表\",\n" +
                "                        \"children\": [],\n" +
                "                        \"icon\": \"el-icon-menu\",\n" +
                "                        \"id\": 111,\n" +
                "                        \"level\": \"1\",\n" +
                "                        \"path\": \"roles\",\n" +
                "                        \"pid\": 110\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"authName\": \"权限列表\",\n" +
                "                        \"children\": [],\n" +
                "                        \"icon\": \"el-icon-menu\",\n" +
                "                        \"id\": 112,\n" +
                "                        \"level\": \"1\",\n" +
                "                        \"path\": \"rights\",\n" +
                "                        \"pid\": 110\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"icon\": \"el-icon-s-shop\",\n" +
                "                \"id\": 110,\n" +
                "                \"level\": \"0\",\n" +
                "                \"path\": \"roles\",\n" +
                "                \"pid\": 0\n" +
                "            },\n" +
                "            {\n" +
                "                \"authName\": \"用户管理\",\n" +
                "                \"children\": [\n" +
                "                    {\n" +
                "                        \"authName\": \"用户列表\",\n" +
                "                        \"children\": [],\n" +
                "                        \"icon\": \"el-icon-menu\",\n" +
                "                        \"id\": 121,\n" +
                "                        \"level\": \"1\",\n" +
                "                        \"path\": \"users\",\n" +
                "                        \"pid\": 120\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"icon\": \"el-icon-user-solid\",\n" +
                "                \"id\": 120,\n" +
                "                \"level\": \"0\",\n" +
                "                \"path\": \"users\",\n" +
                "                \"pid\": 0\n" +
                "            },\n" +
                "            {\n" +
                "                \"authName\": \"订单管理\",\n" +
                "                \"children\": [\n" +
                "                    {\n" +
                "                        \"authName\": \"订单列表\",\n" +
                "                        \"children\": [],\n" +
                "                        \"icon\": \"el-icon-menu\",\n" +
                "                        \"id\": 131,\n" +
                "                        \"level\": \"1\",\n" +
                "                        \"path\": \"orders\",\n" +
                "                        \"pid\": 130\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"icon\": \"el-icon-s-order\",\n" +
                "                \"id\": 130,\n" +
                "                \"level\": \"0\",\n" +
                "                \"path\": \"orders\",\n" +
                "                \"pid\": 0\n" +
                "            },\n" +
                "            {\n" +
                "                \"authName\": \"数据统计\",\n" +
                "                \"children\": [\n" +
                "                    {\n" +
                "                        \"authName\": \"数据报表\",\n" +
                "                        \"children\": [],\n" +
                "                        \"icon\": \"el-icon-menu\",\n" +
                "                        \"id\": 141,\n" +
                "                        \"level\": \"1\",\n" +
                "                        \"path\": \"reports\",\n" +
                "                        \"pid\": 140\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"icon\": \"el-icon-data-analysis\",\n" +
                "                \"id\": 140,\n" +
                "                \"level\": \"0\",\n" +
                "                \"path\": \"reports\",\n" +
                "                \"pid\": 0\n" +
                "            }\n" +
                "        ],\n" +
                "        \"id\": 30,\n" +
                "        \"roleDesc\": \"技术负责人\",\n" +
                "        \"roleName\": \"主管\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"children\": [\n" +
                "            {\n" +
                "                \"authName\": \"商品管理\",\n" +
                "                \"children\": [\n" +
                "                    {\n" +
                "                        \"authName\": \"商品列表\",\n" +
                "                        \"children\": [],\n" +
                "                        \"icon\": \"el-icon-menu\",\n" +
                "                        \"id\": 101,\n" +
                "                        \"level\": \"1\",\n" +
                "                        \"path\": \"goods\",\n" +
                "                        \"pid\": 100\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"authName\": \"分类参数\",\n" +
                "                        \"children\": [],\n" +
                "                        \"icon\": \"el-icon-menu\",\n" +
                "                        \"id\": 102,\n" +
                "                        \"level\": \"1\",\n" +
                "                        \"path\": \"params\",\n" +
                "                        \"pid\": 100\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"authName\": \"商品分类\",\n" +
                "                        \"children\": [],\n" +
                "                        \"icon\": \"el-icon-menu\",\n" +
                "                        \"id\": 103,\n" +
                "                        \"level\": \"1\",\n" +
                "                        \"path\": \"categories\",\n" +
                "                        \"pid\": 100\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"icon\": \"el-icon-s-goods\",\n" +
                "                \"id\": 100,\n" +
                "                \"level\": \"0\",\n" +
                "                \"path\": \"goods\",\n" +
                "                \"pid\": 0\n" +
                "            }\n" +
                "        ],\n" +
                "        \"id\": 10,\n" +
                "        \"roleDesc\": \"测试人员\",\n" +
                "        \"roleName\": \"测试\"\n" +
                "    }\n" +
                "]";
        
        return ApiResult.ok(JSON.parseObject(json, List.class));
    }
    @GetMapping("/rights/{type}")
    public ApiResult list(@PathVariable(value = "type") String type){
        String listRights = "[\n" +
                "    {\n" +
                "        \"authName\": \"商品管理\",\n" +
                "        \"children\": [],\n" +
                "        \"icon\": \"el-icon-s-goods\",\n" +
                "        \"id\": 100,\n" +
                "        \"level\": \"0\",\n" +
                "        \"path\": \"goods\",\n" +
                "        \"pid\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"authName\": \"商品列表\",\n" +
                "        \"children\": [],\n" +
                "        \"icon\": \"el-icon-menu\",\n" +
                "        \"id\": 101,\n" +
                "        \"level\": \"1\",\n" +
                "        \"path\": \"goods\",\n" +
                "        \"pid\": 100\n" +
                "    },\n" +
                "    {\n" +
                "        \"authName\": \"分类参数\",\n" +
                "        \"children\": [],\n" +
                "        \"icon\": \"el-icon-menu\",\n" +
                "        \"id\": 102,\n" +
                "        \"level\": \"1\",\n" +
                "        \"path\": \"params\",\n" +
                "        \"pid\": 100\n" +
                "    },\n" +
                "    {\n" +
                "        \"authName\": \"商品分类\",\n" +
                "        \"children\": [],\n" +
                "        \"icon\": \"el-icon-menu\",\n" +
                "        \"id\": 103,\n" +
                "        \"level\": \"1\",\n" +
                "        \"path\": \"categories\",\n" +
                "        \"pid\": 100\n" +
                "    },\n" +
                "    {\n" +
                "        \"authName\": \"权限管理\",\n" +
                "        \"children\": [],\n" +
                "        \"icon\": \"el-icon-s-shop\",\n" +
                "        \"id\": 110,\n" +
                "        \"level\": \"0\",\n" +
                "        \"path\": \"roles\",\n" +
                "        \"pid\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"authName\": \"角色列表\",\n" +
                "        \"children\": [],\n" +
                "        \"icon\": \"el-icon-menu\",\n" +
                "        \"id\": 111,\n" +
                "        \"level\": \"1\",\n" +
                "        \"path\": \"roles\",\n" +
                "        \"pid\": 110\n" +
                "    },\n" +
                "    {\n" +
                "        \"authName\": \"权限列表\",\n" +
                "        \"children\": [],\n" +
                "        \"icon\": \"el-icon-menu\",\n" +
                "        \"id\": 112,\n" +
                "        \"level\": \"1\",\n" +
                "        \"path\": \"rights\",\n" +
                "        \"pid\": 110\n" +
                "    },\n" +
                "    {\n" +
                "        \"authName\": \"用户管理\",\n" +
                "        \"children\": [],\n" +
                "        \"icon\": \"el-icon-user-solid\",\n" +
                "        \"id\": 120,\n" +
                "        \"level\": \"0\",\n" +
                "        \"path\": \"users\",\n" +
                "        \"pid\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"authName\": \"用户列表\",\n" +
                "        \"children\": [],\n" +
                "        \"icon\": \"el-icon-menu\",\n" +
                "        \"id\": 121,\n" +
                "        \"level\": \"1\",\n" +
                "        \"path\": \"users\",\n" +
                "        \"pid\": 120\n" +
                "    },\n" +
                "    {\n" +
                "        \"authName\": \"订单管理\",\n" +
                "        \"children\": [],\n" +
                "        \"icon\": \"el-icon-s-order\",\n" +
                "        \"id\": 130,\n" +
                "        \"level\": \"0\",\n" +
                "        \"path\": \"orders\",\n" +
                "        \"pid\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"authName\": \"订单列表\",\n" +
                "        \"children\": [],\n" +
                "        \"icon\": \"el-icon-menu\",\n" +
                "        \"id\": 131,\n" +
                "        \"level\": \"1\",\n" +
                "        \"path\": \"orders\",\n" +
                "        \"pid\": 130\n" +
                "    },\n" +
                "    {\n" +
                "        \"authName\": \"数据统计\",\n" +
                "        \"children\": [],\n" +
                "        \"icon\": \"el-icon-data-analysis\",\n" +
                "        \"id\": 140,\n" +
                "        \"level\": \"0\",\n" +
                "        \"path\": \"reports\",\n" +
                "        \"pid\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"authName\": \"数据报表\",\n" +
                "        \"children\": [],\n" +
                "        \"icon\": \"el-icon-menu\",\n" +
                "        \"id\": 141,\n" +
                "        \"level\": \"1\",\n" +
                "        \"path\": \"reports\",\n" +
                "        \"pid\": 140\n" +
                "    }\n" +
                "]";

        String treeRights = "[\n" +
                "    {\n" +
                "        \"authName\": \"商品管理\",\n" +
                "        \"children\": [\n" +
                "            {\n" +
                "                \"authName\": \"商品列表\",\n" +
                "                \"children\": [],\n" +
                "                \"icon\": \"el-icon-menu\",\n" +
                "                \"id\": 101,\n" +
                "                \"level\": \"1\",\n" +
                "                \"path\": \"goods\",\n" +
                "                \"pid\": 100\n" +
                "            },\n" +
                "            {\n" +
                "                \"authName\": \"分类参数\",\n" +
                "                \"children\": [],\n" +
                "                \"icon\": \"el-icon-menu\",\n" +
                "                \"id\": 102,\n" +
                "                \"level\": \"1\",\n" +
                "                \"path\": \"params\",\n" +
                "                \"pid\": 100\n" +
                "            },\n" +
                "            {\n" +
                "                \"authName\": \"商品分类\",\n" +
                "                \"children\": [],\n" +
                "                \"icon\": \"el-icon-menu\",\n" +
                "                \"id\": 103,\n" +
                "                \"level\": \"1\",\n" +
                "                \"path\": \"categories\",\n" +
                "                \"pid\": 100\n" +
                "            }\n" +
                "        ],\n" +
                "        \"icon\": \"el-icon-s-goods\",\n" +
                "        \"id\": 100,\n" +
                "        \"level\": \"0\",\n" +
                "        \"path\": \"goods\",\n" +
                "        \"pid\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"authName\": \"权限管理\",\n" +
                "        \"children\": [\n" +
                "            {\n" +
                "                \"authName\": \"角色列表\",\n" +
                "                \"children\": [],\n" +
                "                \"icon\": \"el-icon-menu\",\n" +
                "                \"id\": 111,\n" +
                "                \"level\": \"1\",\n" +
                "                \"path\": \"roles\",\n" +
                "                \"pid\": 110\n" +
                "            },\n" +
                "            {\n" +
                "                \"authName\": \"权限列表\",\n" +
                "                \"children\": [],\n" +
                "                \"icon\": \"el-icon-menu\",\n" +
                "                \"id\": 112,\n" +
                "                \"level\": \"1\",\n" +
                "                \"path\": \"rights\",\n" +
                "                \"pid\": 110\n" +
                "            }\n" +
                "        ],\n" +
                "        \"icon\": \"el-icon-s-shop\",\n" +
                "        \"id\": 110,\n" +
                "        \"level\": \"0\",\n" +
                "        \"path\": \"roles\",\n" +
                "        \"pid\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"authName\": \"用户管理\",\n" +
                "        \"children\": [\n" +
                "            {\n" +
                "                \"authName\": \"用户列表\",\n" +
                "                \"children\": [],\n" +
                "                \"icon\": \"el-icon-menu\",\n" +
                "                \"id\": 121,\n" +
                "                \"level\": \"1\",\n" +
                "                \"path\": \"users\",\n" +
                "                \"pid\": 120\n" +
                "            }\n" +
                "        ],\n" +
                "        \"icon\": \"el-icon-user-solid\",\n" +
                "        \"id\": 120,\n" +
                "        \"level\": \"0\",\n" +
                "        \"path\": \"users\",\n" +
                "        \"pid\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"authName\": \"订单管理\",\n" +
                "        \"children\": [\n" +
                "            {\n" +
                "                \"authName\": \"订单列表\",\n" +
                "                \"children\": [],\n" +
                "                \"icon\": \"el-icon-menu\",\n" +
                "                \"id\": 131,\n" +
                "                \"level\": \"1\",\n" +
                "                \"path\": \"orders\",\n" +
                "                \"pid\": 130\n" +
                "            }\n" +
                "        ],\n" +
                "        \"icon\": \"el-icon-s-order\",\n" +
                "        \"id\": 130,\n" +
                "        \"level\": \"0\",\n" +
                "        \"path\": \"orders\",\n" +
                "        \"pid\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"authName\": \"数据统计\",\n" +
                "        \"children\": [\n" +
                "            {\n" +
                "                \"authName\": \"数据报表\",\n" +
                "                \"children\": [],\n" +
                "                \"icon\": \"el-icon-menu\",\n" +
                "                \"id\": 141,\n" +
                "                \"level\": \"1\",\n" +
                "                \"path\": \"reports\",\n" +
                "                \"pid\": 140\n" +
                "            }\n" +
                "        ],\n" +
                "        \"icon\": \"el-icon-data-analysis\",\n" +
                "        \"id\": 140,\n" +
                "        \"level\": \"0\",\n" +
                "        \"path\": \"reports\",\n" +
                "        \"pid\": 0\n" +
                "    }\n" +
                "]";

        if("list".equals(type)) {
            return ApiResult.ok(JSON.parseObject(listRights, List.class));
        }
        if("tree".equals(type)) {
            return ApiResult.ok(JSON.parseObject(treeRights, List.class));
        }
        return ApiResult.ok();
    }
}
