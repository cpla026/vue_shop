// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App.vue'
import router from './router'
import '@/plugins/element.js'
// 导入全局样式表
import '@/assets/css/global.css'
// 导入 axios
import axios from 'axios'
// 请求根路径 结合 config/index.js 中 proxyTable 看
axios.defaults.baseURL = "/shop/";
// 通过axios请求拦截器添加 token，保证每次请求接口的时候会在请求头中携带 token
axios.interceptors.request.use(config => {
  // console.log(config)
  /**
   * 为config的headers 添加 Authorization（自定义，在后端会使用它接收token） 字段
   * 将登陆之后获取的token 赋值给Authorization字段，传给后端验证
   */
  config.headers.Authorization = window.sessionStorage.getItem('token')
  return config
})
Vue.prototype.$http = axios

Vue.config.productionTip = false
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})