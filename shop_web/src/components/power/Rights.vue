<template>
    <div>
        <!-- 面包屑导航区 -->
        <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>权限管理</el-breadcrumb-item>
            <el-breadcrumb-item>权限列表</el-breadcrumb-item>
        </el-breadcrumb>

        <!-- 卡片视图 -->
        <el-card class="box-card">
            <!-- 列表区域 -->
            <el-table :data="rightsList"  border stripe style="width: 100%">
                <!-- 索引列 -->
                <el-table-column type="index"></el-table-column>
                <!-- 字段列 -->
                <el-table-column prop="authName" label="权限名称"></el-table-column>
                <el-table-column prop="path" label="路径"></el-table-column>
                <el-table-column prop="level" label="等级" >
                    <template slot-scope="scope">
                        <el-tag v-if="scope.row.level === '0'">一级</el-tag>
                        <el-tag v-if="scope.row.level === '1'" type="success">二级</el-tag>
                        <el-tag v-if="scope.row.level === '2'" type="warning">三级</el-tag>
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
            rightsList: []
        }
    },
    created() {
        this.getRightsList()
    },
    methods: {
        // 获取权限列表
        async getRightsList() {
            await this.$http.get('/rights/list').then(result => {
                if(result.data.status === 200) {
                    return this.rightsList = result.data.data
                }
                this.$message.error('获取权限列表失败')
            })
        }
    }
}
</script>
<style lang="less" scoped>
    
</style>