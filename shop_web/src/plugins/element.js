import Vue from 'vue'
import { Button, Form, FormItem, Input } from 'element-ui'
// 消息弹框
import { Message } from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

Vue.use(Button)
Vue.use(Form)
Vue.use(FormItem)
Vue.use(Input)
Vue.prototype.$message = Message
