import axios from 'axios'

// 跨域请求时是否需要凭证
axios.defaults.withCredentials = true
axios.defaults.timeout = 10000
axios.defaults.headers['Content-Type'] = 'application/json;charset=utf-8'

// 创建axios实例
const service = axios.create({
    baseURL: process.env.VUE_APP_BASE_API,
    timeout: 60000
})

// 响应拦截器
service.interceptors.response.use(res => {
    return res.data
}, error => {
    // Todo 做一个错误消息提示
    // 添加异常处理
    let { message } = error
    if (message == 'Network Error') {
        message = '后端接口连接异常'
    } else if (message.includes('timeout')) {
        message = '系统接口请求超时'
    } else if (message.includes('Request failed with status code')) {
        message = '系统接口' + message.substr(message.length - 3) + '异常'
    }
    return console.error(message)
})

export default service
