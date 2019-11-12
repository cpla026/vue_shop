<template>
    <div>
        <!-- 面包屑导航区 -->
        <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>权限管理</el-breadcrumb-item>
            <el-breadcrumb-item>角色列表</el-breadcrumb-item>
        </el-breadcrumb>

        <!-- 卡片视图 -->
        <el-card class="box-card">
            <!-- 按钮 -->
            <el-row >
                <el-col >
                    <el-button type="primary" @click="addDialogVisible = true">添加角色</el-button>
                </el-col>
            </el-row>

            <!-- 列表区域 -->
            <el-table :data="rolelist"  border stripe style="width: 100%">
                <!-- 展开列 -->
                <el-table-column type="expand" width="50">
                    <template slot-scope="scope">
                        <pre>{{scope.row.children}}</pre>
                    </template>
                </el-table-column>

                <!-- 索引列 -->
                <el-table-column type="index" width="50"></el-table-column>
                <!-- 字段列 -->
                <el-table-column prop="roleName" label="角色名称" ></el-table-column>
                <el-table-column prop="roleDesc" label="角色描述" ></el-table-column>
                <el-table-column label="操作" width="350px">
                    <!-- 对行的操作需要拿到对应列的id 使用作用域插槽 -->
                    <template slot-scope="scope"> 
                        <!-- 修改按钮 -->
                        <el-button type="primary" icon="el-icon-edit" size="mini" @click="showEditDialog(scope.row.id)">编辑</el-button>
                        <!-- 给按钮添加提示 -->
                        <el-tooltip class="item" effect="dark" content="分配角色" placement="top" :enterable="false">
                            <!-- 分配角色 -->
                            <el-button type="warning" icon="el-icon-share" size="mini">分配权限</el-button>
                        </el-tooltip>
                        <!-- 删除按钮 -->
                        <el-button type="danger" icon="el-icon-delete" size="mini" @click="deleteUser(scope.row.id)">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
        </el-card>
    </div>
</template>
<script>
export default {
    data() {
        return {
            rolelist: []
        }
    },
    created() {
        this.getRolelist()
    },
    methods: {
        // 角色列表
        async getRolelist() {
            await this.$http.get('roles').then(result => {
                if(result.data.status === 200) {
                    return this.rolelist = result.data.data
                }
                this.$message.error('获取角色列表失败')
            })
        }
    }
}
</script>
<style lang="less" scoped>
    
</style>