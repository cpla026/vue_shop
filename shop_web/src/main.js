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
Vue.prototype.$http = axios

Vue.config.productionTip = false
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})