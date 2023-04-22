# note-system-web

> env
1. node 16.6.0+

[参考文献]

Editor Markdown API-URL
[https://nhn.github.io/tui.editor/latest/]

Editor wangeditor URL
[https://www.wangeditor.com/v5/for-frame.html#%E4%BD%BF%E7%94%A8-1]

> Todo
```
npm install @wangeditor/editor @wangeditor/editor-for-vue
1. 增加评论回复功能-创建表
2. 完成整个展示页面（评论+回复+收藏+喜欢+点赞等）+详细页面
3. 收藏+喜欢+点赞 --- 存入 localStorage

// https://downloads.mysql.com/archives/community/

下载 mysql 包 (下载tar而不是rpm 一个资源包里包含rpm的插件)然后 解压

tar -xvf mysql-community-server-8.0.tar
不要加 z [-zxvf] 会报 [gzip: stdin: not in gzip format]

上传压缩包时，可能报文件超过500M过大，则通过 xftp 上传

1. 打开终端, 选择新建远程连接
选择sftp, + 服务器 IP

下载和上传文件

> scp
直接打开终端, 输入命令, 登录远程后即可下载上传文件
```
ssh root@ip
```
下载: scp root@ip:/usr/xxx/a.txt /documents
上传: scp /documents/a.txt root@ip:/usr/xxx
下载和上传文件夹时, 在 scp 后面加 -r 如: scp -r /documents/web root@ip:/usr/documents
注意: 本地文件路径和服务器文件路径之间由空格区分
> sftp(ftp)
需要打开终端, 并选择新建远程连接
选择sftp, 服务器 IP, 输入密码
下载: get /usr/local/a.text /documents  # 前为服务器路径, 后为本地下载路径
上传: put /documents/a.text /usr/local  # 前为本地上传文件路径 [如果找不到文件对应路径,直接拖动文件到终端], 后为服务器路径

scp 与 sftp 区别
较为方便, 功能单一
sftp支持传输中断后继续传输, 一般传输大文件, 使用较多

```

