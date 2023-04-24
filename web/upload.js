import client from 'scp2'

// 第一个参数：本地打包文件位置
client.scp('./dist/', {
    host: '',          // 服务器的IP地址
    port: 22,          // 服务器端口, 默认一般22
    username: 'root',  // 服务器用户，默认一般root
    password: '',      // 服务器登录密码
    path: '/home/',    // 项目部署服务器目标位置
}, err => {
    if (err) {
        console.log('部署前端文件失败：\n', err)
    } else {
        console.log('部署前端项目成功！')
    }
})
