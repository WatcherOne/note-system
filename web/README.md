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
```

proxy_set_header Host $http_host;
proxy_set_header X-Real-IP $remote_addr;
proxy_set_header REMOTE-HOST $remote_addr;
proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
proxy_pass http://localhost:8080/api;

nohup java -jar ruoyi.jar &

nohup: no hang up, 不挂起，用于在系统后台不挂断地运行命令，退出终端不会影响程序的运行

ps -ef | grep java
杀死进程 重新部署
kill -9 pid

