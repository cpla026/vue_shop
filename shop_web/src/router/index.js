import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '@/components/Login'
import Home from '@/components/Home'
import Welcome from '@/components/Welcome'

// 用户相关组件
import Users from '@/components/user/Users.vue'
// 权限相关组件
import Rights from '@/components/power/Rights.vue'
import Roles from '@/components/power/Roles.vue'


Vue.use(VueRouter)

const routes = [
  { path: '/', redirect: '/login' },
  { path: '/login', component: Login },
  { 
    path: '/home', 
    component: Home, 
    // 从home中重定向到welcome
    redirect: '/welcome',
    children: [
      { path: '/welcome', component: Welcome },
      { path: '/users', component: Users },
      { path: '/rights', component: Rights },
      { path: '/roles', component: Roles }
    ]
  }
  
]

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
  if (to.path === '/login') return next()
  // 根据token 做下一步操作
  const usertoken = window.sessionStorage.getItem('token')
  // token 为空
  if (!usertoken) return next('/login')
  // 放行
  next()
})

export default router
