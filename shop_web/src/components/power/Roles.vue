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
                        <!-- <pre>{{scope.row.children}}</pre> -->
                        <el-row :class="['dbbottom', i1 === 0 ? 'bdtop' : '', 'vcenter']" v-for="(item1,i1) in scope.row.children" :key="item1.id">
                            <!-- 渲染一级权限 -->
                            <el-col :span="5">
                                <el-tag closable @close="removeRightById(scope.row, item1.id)">{{ item1.authName }}</el-tag>
                                <i class="el-icon-caret-right"></i>
                            </el-col>

                            <!-- 渲染二/三级权限 -->
                            <el-col :span="19">
                                <!-- for 循环渲染二级权限 -->
                                <el-row :class="[i2 !== 0 ? 'bdtop': '', 'vcenter']" v-for="(item2, i2) in item1.children" :key="item2.id">
                                    <el-col :span="6">
                                        <el-tag closable type="success" @close="removeRightById(scope.row, item2.id)">{{ item2.authName }}</el-tag>
                                         <i class="el-icon-caret-right"></i>
                                    </el-col>
                                    <!-- 三级权限 -->
                                    <el-col :span="18">
                                        <el-tag closable type="warning" v-for="(item3) in item2.children" :key="item3.id" @close="removeRightById(scope.row, item3.id)">
                                            {{item3.authName}}
                                        </el-tag>
                                    </el-col>
                                </el-row>
                            </el-col>
                            

                        </el-row>
                    </template>
                </el-table-column>

                <!-- 索引列 -->
                <el-table-column type="index" width="50"></el-table-column>
                <!-- 字段列 -->
                <el-table-column prop="roleName" label="角色名称" ></el-table-column>
                <el-table-column prop="roleDesc" label="角色描述" ></el-table-column>
                <el-table-column label="操作" >
                    <!-- 对行的操作需要拿到对应列的id 使用作用域插槽 -->
                    <template slot-scope="scope"> 
                        <!-- 修改按钮 -->
                        <el-button type="primary" icon="el-icon-edit" size="mini" @click="showEditDialog(scope.row.id)">编辑</el-button>
                        <!-- 给按钮添加提示 -->
                        <el-tooltip class="item" effect="dark" content="分配角色" placement="top" :enterable="false">
                            <!-- 分配角色 -->
                            <el-button type="warning" icon="el-icon-share" size="mini" @click="setRightDialog">分配权限</el-button>
                        </el-tooltip>
                        <!-- 删除按钮 -->
                        <el-button type="danger" icon="el-icon-delete" size="mini" @click="deleteUser(scope.row.id)">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
        </el-card>

        <!-- 分配权限的弹框 -->
        <el-dialog
            title="分配权限"
            :visible.sync="setRightDialogVisible"
            width="50%">
            <!-- 树形控件 -->
            <el-tree :data="rightsList" :props="treeProps" show-checkbox node-key="id" default-expand-all="true" :default-checked-keys="checkedArr"></el-tree>
            <span slot="footer" class="dialog-footer">
                <el-button @click="setRightDialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="setRightDialogVisible = false">确 定</el-button>
            </span>
        </el-dialog>
    </div>
</template>
<script>
export default {
    data() {
        return {
            // 角色
            rolelist: [],
            // 权限
            rightsList: [],
            // 分配权限弹框标识
            setRightDialogVisible: false,
            // 树形控件属性绑定
            treeProps: {
                children: 'children',
                label: 'authName'
            },
            // 默认选中的节点id
            checkedArr: [100,200]
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
        },
        // 通过id删除权限
        removeRightById(role, rightId) {
            // 弹框提示是否删除
            this.$confirm('此操作将永久该权限, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(async () => {
                // 两参数: 角色id  权限id
                await this.$http.delete(`roles/${role.id}/${rightId}`).then(result => {
                    if(result.data.status === 200) {
                        this.$message({type: 'success',message: '删除成功!'});
                        // 删除成功之后重新请求列表会使页面刷新
                        this.getRolelist()
                        // 解决问题:删除后返回最新的权限数据赋值给scope.row
                        // role = result.data.data
                        return 
                    }
                    this.$message.error('删除失败')
                })

                
            }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '已取消删除'
                });          
            });
        },
        // 分配权限的弹框
        async setRightDialog() {
            // 获取所有权限的数据
            await this.$http.get('rights/tree').then(result => {
                if(result.data.status === 200) {
                    this.rightsList = result.data.data
                    return console.log(this.rightsList)
                }
            })
            this.setRightDialogVisible = true
        }
    }
}
</script>
<style lang="less" scoped>
.el-tag {
    margin: 7px;
}    
.bdtop {
    border-top: 1px solid #eee;
}
.dbbottom {
    border-bottom: 1px solid #eee;
}
// 纵向居中对齐
.vcenter {
    display: flex;
    align-items: center;
}
</style>