<template>

  <el-container class="home-container">
    <!-- Header 区域 -->
    <el-header>
      <div>
        <img src="../assets/people.png" alt="">
        <span>vue shop system</span>
      </div>
      <el-button type="danger" @click="logout" >退出登录</el-button>
    </el-header>
    <el-container>
      <!-- Aside 侧边栏 -->
      <!-- 宽度根据是否折叠指定 -->
      <el-aside :width="isCollapse ? '64px' : '200px'">
        <!-- 左侧上部菜单折叠 -->
        <div class="toggle-button" @click="toggleCollapse">
          |||
        </div>
        <!-- 左侧菜单 -->
        <!-- collapse Boolean 是否折叠 -->
        <!-- router Boolean 是否使用 vue-router 的模式，启用该模式会在激活导航时以 index 作为 path 进行路由跳转 -->
        <!-- 所以index 的值最好由后端动态指定 -->
        <!-- default-active 激活高亮 -->
        <el-menu
          background-color="#333744"
          text-color="#fff"
          active-text-color="#409BFF" 
          :unique-opened="true"
          :collapse="isCollapse"
          :collapse-transition="false"
          :router="true"
          :default-active="activePath">
          <!-- 一级菜单 
              index 只接收字符串
          -->
          <el-submenu :index="item.path" v-for="item in menuList" :key="item.id">
            <!-- 一级菜单模板区域 -->
            <template slot="title">
              <!-- 图标 -->
              <i :class="item.icon"></i>
              <!-- 文本 -->
              <span>{{ item.authName }}</span>
            </template>

            <!-- 二级菜单 
                循环所有一级菜单中的二级菜单
            -->
            <el-menu-item :index="subItem.path" v-for="subItem in item.children" 
            :key="subItem.id" @click="saveNavState(subItem.path)">
              <template slot="title">
                <!-- 图标 -->
                <i :class="subItem.icon"></i>
                <!-- 文本 -->
                <span>{{ subItem.authName }}</span>
              </template>
            </el-menu-item>
          </el-submenu>
          
        </el-menu>
      </el-aside>
      <!-- Main 内容区 -->
      <el-main>
        <!-- 路由占位符 -->
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  data() {
    return {
      // 左侧菜单数据
      menuList: [],
      // 是否折叠
      isCollapse: false,
      // 呗激活的连接地址
      activePath: ''
    }
  },
  created() {
    // 页面加载就调用获取菜单的函数
    this.getMenuList(),
    // 页面加载获取连接地址
    this.activePath = window.sessionStorage.getItem('activePath')
  },
  methods: {
    // 获取菜单
    getMenuList() {
      this.$http.get('menu/getMenus').then(result => {
        if(result.data.status === 200){
          return this.menuList = result.data.data
        }
        this.$message.error('请求出错:' + result.data.msg)
      })
    },
    // 鼠标的折叠
    toggleCollapse() {
      this.isCollapse = !this.isCollapse
    },
    //点击二级菜单高亮,保存链接的激活状态
    saveNavState(activePath) {
      window.sessionStorage.setItem('activePath', activePath),
      this.activePath = activePath
    },
    // 退出登录
    logout() {
      // 清除token
      window.sessionStorage.clear()
      // 跳转到登录业
      this.$router.push('/login')
    }

  }
}
</script>

<style lang="less" scoped>
.home-container {
  height: 100%;
}
// 组件名就是它的类名
.el-header {
  background-color: #373d41;
  display: flex;
  justify-content: space-between;
  // 左边距
  padding-left: 0px;
  // 文本居中 字体颜色  大小
  align-items: center;
  color: #fff;
  font-size: 20px;
  // 嵌套的div
  > div {
    display: flex;
    align-items: center;
    height: 100%;
    > img {
      height: 100%;
    }
    > span {
      // span 距离 img 15px
      margin-left: 15px;
    }
  }
}
.el-aside {
  background-color: #333744;
  // 解决菜单展开边框对不齐
  > .el-menu {
    border-right: none
  }
}
.el-main {
  background-color: #eaedf1
}
// 菜单上测折叠筐
.toggle-button {
  background-color: #4a5064;
  color: #fff;
  font-size: 10px;
  line-height: 24px;
  text-align: center;
  // ||| 之间的间距
  letter-spacing: 0.2em;
  // 鼠标变成小手
  cursor: pointer;
}
</style>>