# note-system-web

> **当前环境**
- node 16.6.0+
- vue/cli 4+

> **Todo**
```
npm install @wangeditor/editor @wangeditor/editor-for-vue
1. 增加评论回复功能-创建表
2. 完成整个展示页面（评论+回复+收藏+喜欢+点赞等）+详细页面
3. 收藏+喜欢+点赞 --- 存入 localStorage
```

> **参考文献**

- [Editor Markdown API](https://nhn.github.io/tui.editor/latest/)
- [Editor wangeditor API](https://www.wangeditor.com/v5/for-frame.html#%E4%BD%BF%E7%94%A8-1)

> **遇到的问题**
1. 安装依赖启动报错
    ```
    SyntaxError: Invalid or unexpected token
    /node_modules/@vue/compiler-sfc/dist/compiler-sfc.cjs.js
    ```
    > 解决方法 (删除依赖，依次执行下面的语句)
    ```shell
    npm cache clean --force
    npm i
    ```

2. 安装 scp2 时，需要单独安装
    ```
    npm ERR! Invalid Version: 0.1.0a2
    ```
    > 需要执行下面命令，去掉审核标准
    ```shell
    npm install scp2 --no-audit
    ```

3. 修改 gitignore 文件后
    ```
    git rm -r --cached .   # 将文件夹从暂存区中删除
    git add .              # 然后操作下面的步骤
    ```
