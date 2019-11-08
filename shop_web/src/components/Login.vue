<template>
  <div class="login_container">
    <div class="login-box">
      <!-- 图标区域 -->
      <div class="avatar_box">
        <img src="../assets/logo.png">
      </div>
      <!-- 登录表单区域
          rules：校对规则
          ref：表单引用对象
      -->
      <el-form class="login_form" :model="loginForm" :rules="rules" ref="loginFormRef">
        <!-- 用户名 -->
        <el-form-item label-width="0px" prop="username" >
          <el-input prefix-icon="el-icon-s-custom" v-model="loginForm.username" ></el-input>
        </el-form-item>
        <!-- 密码 -->
        <el-form-item label-width="0px" prop="password">
          <el-input type="password" prefix-icon="el-icon-key" v-model="loginForm.password"></el-input>
        </el-form-item>
        <!-- 按钮 -->
        <el-form-item label-width="0px" class="btns">
          <el-button type="primary" @click="login">登录</el-button>
          <el-button type="info" @click="resetForm('loginFormRef')">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      loginForm: {
        username: 'ron',
        password: '123456'
      },
      // 表单验证规则
      rules: {
        username: [
          { required: true, message: '请输入用户名称', trigger: 'blur' },
          { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          { min: 6, max: 10, message: '长度在 6 到 10 个字符', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    // 重置表单
    resetForm (loginFormRef) {
      console.log(loginFormRef)
      // this.$refs[loginFormRef].resetFields()
      this.$refs.loginFormRef.resetFields()
    },
    login () {
      // 表单预验证
      this.$refs.loginFormRef.validate((valid) => {
        // console.log(valid)
        if (!valid) return false
        // 验证通过发起http请求
        this.$http.post('user/login', this.loginForm).then(result => {
          console.log(result);
          if(result.data.status !== 200){
              // return this.$message.error('错了哦，这是一条错误消息');
              return this.$message({
                message: '警告哦，这是一条警告消息',
                type: 'warning'
              })
          }
          // this.$message({
          //   message: '恭喜你，登录成功',
          //   type: 'success'
          // })
          this.$message.success('登录成功')
          // 将登录成功后的 token 保存到 sessionStorage 中
          window.sessionStorage.setItem('token', result.data.data.token)
          // 通过编程式导航跳转到后台主页
          this.$router.push('/home')
        })
      })
    }
  }
}
</script>

<style scoped lang="less">
.login_container {
  background-color: #2b4b6b;
  height: 100%;
}
.login-box {
  width: 450px;
  height: 300px;
  background-color: #fff;
  // 圆角
  border-radius: 3px;
  // 绝对定位 距左侧50% top 50%
  position: absolute;
  left: 50%;
  top: 50%;
  // 子盒子绝对定位后并没有在页面正中间
  // transform 位移 横轴 纵轴各 -50%
  transform: translate(-50%, -50%);

  // 图标
  .avatar_box {
    height: 130px;
    width: 130px;
    // 边框
    border: 1px solid #eee;
    border-radius: 50%;
    // 图片距离边框10px
    padding: 10px;
    box-shadow: 0 0 10px #ddd;
    // 将图标移动到登录盒子的中中间靠上
    // 向左移动盒子的一半 向右移动自己的一半 向上移动自己的一半即可
    position: absolute;
    // 距离左侧
    left: 50%;
    transform: translate(-50%, -50%);
    background-color: #fff;
    img {
      height: 100%;
      width: 100%;
      border-radius: 50%;
      background-color: #eee;
    }
  }
}
.login_form {
  position: absolute;
  bottom: 0;
  width: 100%;
  padding: 0 20px;
  box-sizing: border-box;
}

.btns {
  // 将按钮移到左边
  // 弹性盒子模型
  display: flex;
  // 横轴尾部对齐
  justify-content: flex-end;
}
</style>
