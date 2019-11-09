<template>
  <div>
      <!-- 面包屑导航区 -->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>用户管理</el-breadcrumb-item>
      <el-breadcrumb-item>用户列表</el-breadcrumb-item>
    </el-breadcrumb>


    <!-- 卡片视图 -->
    <el-card class="box-card">
        <!-- 使用栅格布局 -->
        <el-row :gutter="20">
            <el-col :span="7">
                    <!-- 搜索框 -->
                <el-input placeholder="请输入内容" clearable @clear="getUserList" class="input-with-select" v-model="queryInfo.query">
                    <el-button slot="append" icon="el-icon-search" @click="getUserList"></el-button>
                </el-input>
            </el-col>
            <el-col :span="4">
                <el-button type="primary" @click="addDialogVisible = true">添加</el-button>
            </el-col>
        </el-row>

        <!-- 列表区域 -->
        <el-table :data="userList"  border stripe style="width: 100%">
            <!-- 索引列 -->
            <el-table-column type="index" width="50"></el-table-column>
            <!-- 字段列 -->
            <el-table-column prop="username" label="姓名" width="180"></el-table-column>
            <el-table-column prop="email" label="邮箱" width="180"></el-table-column>
            <el-table-column prop="mobile" label="电话" width="180"></el-table-column>
            <el-table-column prop="role_name" label="角色" width="180"></el-table-column>
            <!-- Boolean值不可以直接渲染 -->
            <el-table-column label="状态" width="180">
                <!-- 作用域插槽 通过 slot-scope 接收当前作用域的数据 -->
                <template slot-scope="scope">
                    <!-- scope.row 可以拿到对应行的所有数据 -->
                    <!-- {{scope.row}} -->
                    <el-switch v-model="scope.row.mg_state" active-color="#13ce66" inactive-color="#ff4949" @change="userStateChange(scope.row)">
                    </el-switch>
                </template>
            </el-table-column>
            <el-table-column label="操作" width="190px">
                <!-- 对行的操作需要拿到对应列的id 使用作用域插槽 -->
                <template slot-scope="scope"> 
                    <!-- 修改按钮 -->
                    <el-button type="primary" icon="el-icon-edit" size="mini"></el-button>
                    <!-- 给按钮添加提示 -->
                    <el-tooltip class="item" effect="dark" content="分配角色" placement="top" :enterable="false">
                        <!-- 分配角色 -->
                        <el-button type="warning" icon="el-icon-share" size="mini"></el-button>
                    </el-tooltip>
                    <!-- 删除按钮 -->
                    <el-button type="danger" icon="el-icon-delete" size="mini"></el-button>
                </template>
            </el-table-column>
        </el-table>
            
        <!-- 分页条 -->
        <!-- layout 有哪些功能 -->
        <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
            :current-page="queryInfo.pageNum" :page-sizes="[1, 2, 5, 10]" :page-size="queryInfo.pageSize"
            layout="total, sizes, prev, pager, next, jumper" :total="total">
        </el-pagination>

        <!-- 添加用户的弹框 -->
        <!-- :visible.sync 对话框的显示与否 -->
        <!-- :before-close 对护框关闭之前触发的事件 -->
        <el-dialog title="添加用户" :visible.sync="addDialogVisible" width="50%" :before-close="handleClose" @close="addDialogClose">
            <!-- 主题区域 -->
            <el-form :model="addForm" :rules="addFormRules" ref="addFormRef" label-width="70px" class="demo-ruleForm">
                <!-- 用户名 -->
                <!-- prop 验证规则属性 -->
                <el-form-item label="用户名" prop="username">
                    <el-input v-model="addForm.username"></el-input>
                </el-form-item>
                <!-- 密码 -->
                <el-form-item label="密码" prop="password">
                    <el-input v-model="addForm.password"></el-input>
                </el-form-item>
                <!-- 邮箱 -->
                <el-form-item label="邮箱" prop="email">
                    <el-input v-model="addForm.email"></el-input>
                </el-form-item>
                <!-- 电话 -->
                <el-form-item label="电话" prop="mobile">
                    <el-input v-model="addForm.mobile"></el-input>
                </el-form-item>
            </el-form>


            <!-- 底部区域 -->
            <span slot="footer" class="dialog-footer">
                <el-button @click="resetForm('addFormRef')">重置</el-button>
                <el-button @click="addDialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="addUser">确 定</el-button>
            </span>
        </el-dialog>

    </el-card>
  </div>
</template>
<script>
export default {
    data() {
        // 自定义校验规则校验邮箱
        var checkEmail = (rule, value, callback) => {
            // 正则
            // const regEmail = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/
            const regEmail = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/
            if(regEmail.test(value)) {
                // 合法的邮箱
                return callback()
            }
            callback(new Error('请输入合法的邮箱地址'))
        };

        // 自定义手机号的校验规则
        var checkMobil = (rule, value, callback) => {
            const regMobil = /^1[3456789]\d{9}$/
            if(regMobil.test(value)) {
                // 合法的邮箱
                return callback()
            }
            callback(new Error('请输入合法的手机号'))
        };

        return {
            userList: [],
            queryInfo: {
                query: '',
                pageNum: 1,
                pageSize: 2
            },
            total: 0,
            // 控制添加用户对话框的显示与隐藏
            addDialogVisible: false,
            // 添加用户的表单数据
            addForm: {
                username: 'Ron',
                password: '123456',
                email: 'swron@163.com',
                mobile: '13799999999'
            },
            // 表单验证规则
            addFormRules: {
                username: [
                    { required: true, message: '请输入用户名', trigger: 'blur' },
                    { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
                ],
                password: [
                    { required: true, message: '请输入密码', trigger: 'blur' },
                    { min: 6, max: 10, message: '长度在 6 到 10 个字符', trigger: 'blur' }
                ],
                email: [
                    { required: true, message: '请输入邮箱', trigger: 'blur' },
                    { validator: checkEmail, trigger: 'blur' }
                ],
                mobile: [
                    { required: true, message: '请输入邮箱', trigger: 'blur' },
                    { validator: checkMobil, trigger: 'blur' }
                ]
            }
        }
    },
    created() {
        this.getUserList()
    },
    methods: {
        // 获取用户列表
        async getUserList() {
            await this.$http.get('user/list', { params:this.queryInfo }).then(result => {
                // console.log(result)
                if(result.data.status === 200) {
                    return this.userList = result.data.data;
                }
                this.$message.error('请求出错:' + result.data.msg)
            })
        },
        // 监听 pageSize 改变的事件
        handleSizeChange(newSize) {
            // console.log(newSize)
            this.queryInfo.pageSize = newSize
            // 根据新的pageSize 发送请求
            this.getUserList()
        },
        // pageNum 改变
        handleCurrentChange(newPageNum){
            this.queryInfo.pageNum = newPageNum
            this.getUserList()
        },
        // 监听switch 状态的改变
        async userStateChange(userInfo) {
            // console.log(userInfo)
            await this.$http.put(`user/update/${userInfo.id}/${userInfo.mg_state}`).then(result => {
                console.log(result)
                if(result.data.status === 200) {
                    return this.$message.success('修改成功')
                }
                // 数据库中的状态更新失败 页面上的转态不可以改变
                userInfo.mg_state = !userInfo.mg_state
                this.$message.error('请求出错:' + result.data.msg)
            })
        },
        // 添加用户
        addUser() {
            // 提交表单前校验表单
            this.$refs.addFormRef.validate(async valid => {
                if(!valid) return
                // 校验通过 添加用户
                await this.$http.post('user/save', this.addForm).then(result => {
                    if(result.data.status === 200) {
                        console.log(result)
                        this.$message.success('添加用户成功')
                        // 关闭对话框
                        this.addDialogVisible = false
                        // 刷新页面
                        this.getUserList()
                        return
                    }
                    this.$message.error('请求出错:' + result.data.msg)

                })
            })
            this.addDialogVisible = false
        },
        // 对话框关闭触发的事件
        handleClose (){
            this.addDialogVisible = false
            // console.log('>>>>>>> 关闭对话框 >>>>')
        },
        // 重置表单
        resetForm(addFormRef) {
            // console.log(addFormRef)
            // this.$refs[addFormRef].resetFields()
            this.$refs.addFormRef.resetFields()
        },
        // 关闭表单的操作
        addDialogClose() {
            this.$refs.addFormRef.resetFields()
        }

    }
}
</script>
<style lang="less" scoped>

    
</style>