<template>
  <div>
    <el-button type="danger" @click="logout">退出登录</el-button>
    <h1>Home Page</h1>
  </div>
</template>

<script>
export default {
  methods: {
    logout() {
      // 清除token
      window.sessionStorage.clear();
      // 跳转到登录业
      this.$router.push("/login");
    }
  }
};
</script>

<style lang="less" scoped>
</style>>