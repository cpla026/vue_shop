# shop_web

> a vue case

### Build Setup

``` bash
# install dependencies
npm install

# serve with hot reload at localhost:8080
npm run dev

# build for production with minification
npm run build

# build for production and view the bundle analyzer report
npm run build --report
```

### 开发登录功能

1、创建 login 分支（git branch 查看当前项目所有分支）
git checkout -b login

2、less-loader 安装
依赖  开发依赖
依次安装less-loader  less  
cnpm install less less-loader --save-dev

3、安装 element ui
cnpm i element-ui -S

#### 登录成功:

1. 保存 token 除登录之外的接口都需要携带token。token只应在当前项目有效，token存放到sessionStorage(只在当前会话有效、localStorage持久化的存储机制）中。

2. 导航跳转到后台主页。

3. 路由导航守卫控制访问权限(router 路由配置中)

   ```js
   const router = new VueRouter({
     routes
   })
   /**
    * 挂载路由导航守卫
    * to : 要访问的路径
    * from: 从哪个路径来
    * next: 放行(两种方式) next() 直接放行  next('/path') 指定路径强制跳转
    */
   router.beforeEach((to, from, next) => {
     // 登录也直接放行
     if(to.path === '/login') return next();
     // 根据token 做下一步操作
     const usertoken = window.sessionStorage.getItem('token');
     // token 为空
     if(!usertoken) return next('/login');
     // 放行
     next();
   })
   export default router
   ```

#### 退出登录

> 基于token的方式,只需要销毁sessionStorage中的token即可,后续请求就会跳转到登录页面,

```js
methods: {
    logout() {
        // 清除token
        window.sessionStorage.clear();
        // 跳转到登录业
        this.$router.push("/login");
    }
}
```







