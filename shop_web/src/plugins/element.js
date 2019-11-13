import Vue from 'vue'
import { Button, Form, FormItem, Input } from 'element-ui'
// 消息弹框
import { Message } from 'element-ui'
// 基础布局组件
import { Container, Header, Aside, Main } from 'element-ui'
// 菜单组件
import { Menu, Submenu, MenuItem, MenuItemGroup, Breadcrumb, BreadcrumbItem } from 'element-ui'
// 卡片 列表相关
import { Card, Row, Col, Table, TableColumn, Switch, Tooltip, Pagination, Dialog, MessageBox,Tag } from 'element-ui'
// 树形控件
import { Tree } from 'element-ui'
// 选择框
import { Select, Option } from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

Vue.use(Button)
Vue.use(Form)
Vue.use(FormItem)
Vue.use(Input)
Vue.use(Container)
Vue.use(Header)
Vue.use(Aside)
Vue.use(Main)
Vue.use(Menu)
Vue.use(Submenu)
Vue.use(MenuItem)
Vue.use(MenuItemGroup)
Vue.use(Breadcrumb)
Vue.use(BreadcrumbItem)
Vue.use(Card)
Vue.use(Row)
Vue.use(Col)
Vue.use(Table)
Vue.use(TableColumn)
// 开关
Vue.use(Switch)
// 提示
Vue.use(Tooltip)
// 分页
Vue.use(Pagination)
// 弹框
Vue.use(Dialog)
Vue.use(Tag)
// 树形控件
Vue.use(Tree)
Vue.use(Select)
Vue.use(Option)
// 消息弹框
Vue.prototype.$message = Message
Vue.prototype.$confirm = MessageBox.confirm
