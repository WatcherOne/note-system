## 云服务器环境配置

* [ ] @<span style="color:#4b96e6">watcher</span>
* [ ] @[github.com](https://github.com/WatcherOne)

***

#### <span style="color:green">linux实例开启root用户远程登录</span>

><b> linux系统部分是默认禁用 SSHD 服务中root用户远程登录的，导致登录时提示用户名或密码错误 </b>

1. 通过 VNC登录 开启 root 远程登录 - 初次进入需要重置密码 [密码限制-6位大小写]
2. 重置后 <span style="color:red">登录 VNC</span> , 默认维持300s左右时间, 超过无任何操作时会自动断开
3. 然后实例登录, 需要外面实例先进行实例密码重置, <span style="color:red">实例登录</span>: root + 密码 [不限位数大小写]
4. 进入VNC界面后，打开 SSH 配置文件

    ```shell
    vim /etc/ssh/sshd_config
    ```
    ![VNC界面](http://39.106.78.182/download/image/vnc界面.png)
5. 按 i 进入编辑模式，将「PermitRootLogin」和「PasswordAuthentication」设为 yes

    ```vim
    PermitRootLogin yes
    PasswordAuthentication yes
    ```
    ![VNC界面](http://39.106.78.182/download/image/sshd配置.png)
6. 按 esc 键退出 i 编辑模式，输入 :wq 保存修改退出
7. 重启SSHD服务 即可通过 ssh服务 root远程登录

    ```shell
    systemctl restart sshd.service
    ```

8. 本地开启 ssh 服务「需要有sshd服务才可以用ssh登录」

    ```
    ssh root@IP
    - 输入密码登录
    - ctrl + D 退出登录
    ```

***

#### <span style="color:green">配置Tomcat</span>

1. 去 Apache 官网下载 压缩包（或 [tomcat-8.5](http://39.106.78.182/download/package/apache-tomcat-8.5.88.tar.gz)）

2. 将源码包上传到服务器上并解压

    ```shell
    tar -xzvf tomcat-8.5.tar.gz
    ```

3. 将解压的文件夹移到指定位置（或在指定位置解压）

    ```shell
    mv tomcat-8.5.tar.gz /usr/local/tomcat
    ```

5. 拷贝文件 catalina.sh 到 init.d 下, 并在 init.d 开头添加下面语句
    > 是为了方便启动和停止 tomcat (自启动)

    ```vim
    # chkconfig: 112 63 37
    # description: tomcat server init script
    # Source Function Library
    . /etc/init.d/functions

    JAVA_HOME=/usr/local/java/       # jdk安装路径
    CATALINA_HOME=/usr/local/tomcat  # tomcat安装路径
    ```

6. 保存后，执行下面语句
    > chkconfig --list   # 查看系统服务 (下面命令执行后可查看是否包含了tomcat)

    ```shell
    chmod 755 /etc/init.d/tomcat  # 修改文件或文件夹权限 755 权限
    chkconfig --add tomcat        # 将tomcat添加到系统服务中（方便自启动）
    chkconfig tomcat on           # on 设置开机自启动 off 关闭自启动
    ```
   ![查看系统服务](http://39.106.78.182/download/image/service-list.png)
7. 配置环境变量

    ```shell
    vim /etc/profile

    export CATALINA_HOME=/usr/local/tomcat/tomcat-8.5     // 配置 tomcat 路径别名
    export PATH=$PATH:$JAVA_HOME/bin:$CATALINA_HOME/bin   // 将 别名/bin 添加到 环境变量PATH 中
    ```
    
8. 读取并执行配置

    ```shell
    source /etc/profile
    ```

9. 启动 Tomcat
    > <span style="color:rgb(241, 123, 123)">/usr/local/tomcat/bin/startup.sh</span>

    ```shell
    ./startup.sh          // 进入 bin 目录下, 执行 = 开启 tomcat 服务
    ./shutdown.sh         // 进入 bin 目录下, 执行 = 关闭 tomcat 服务
    startup.sh            // 当配有环境变量时, 任何位置执行 [好像不太行,还是需要进入/bin]
    service tomcat start  // 任何位置开启 tomcat 服务
    service tomcat stop   // 任何位置关闭 tomcat 服务
    ```
    > 因为加入了系统服务中所有可以 service 启动; 因为 /etc/rc.d/init.d 下设置有 tomcat 启动脚本; service 命令执行时linux去 /etc/rc.d/init.d 找对应的脚本

10. 查看 Tomcat 状态

    ```shell
    ps -ef|grep java

    // # 当出现如下一行结果表示 tomcat 服务关闭状态, 否则开启
    // root 7010 1 0 Oct19 ? 00:30:30 [java]
    ```

11. Tomcat 对应 8080 端口服务能访问需要以下两点
    - 防火墙关闭
    - 云服务器完全组设置有入方向的 8080 端口
    - /tomcat/conf/server.xml 配置文件 <Connector port="8080"... />
    ![tomcat配置](http://39.106.78.182/download/image/tomcat配置.png)

***

#### <span style="color:green">配置JDK</span>

1. 安装 jdk8 [官网资源包](https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html) ｜ [已下好的资源包](http://39.106.78.182/download/package/jdk-8u371-linux-x64.tar.gz)

2. 上传压缩包到指定目录下, 并解压
    ```shell
    tar -zxvf jdk-8u221.tar.gz -C /usr/local/java
    ```

3. 配置环境变量

    ```shell
    vim /etc/profile

    export JAVA_HOME=/usr/local/java/jdk-8      // 安装的JDK路径
    export JRE_HOME=/usr/local/java/jdk-8/jre   // JDK中JRE路径
    export CLASSPATH=".:$JAVA_HOME/lib:$JRE_HOME/lib"
    export PATH=$JAVA_HOME/bin:$PATH            // 其它环境变量用 : 连接
    ```
    > 为了防止所有命令找不到时加的，其实用上面的配置即可
    ```shell
    export PATH=/usr/local/sbin:/usr/local/bin:/sbin:/bin:/usr/sbin:/usr/bin:/root/bin
    ```

3. 读取并执行配置

    ```shell
    source /etc/profile
    ```

4. 查看JDK是否安装成功

    ```shell
    java -version
    ```
***

#### <span style="color:green">下载工具</span>

|  | **wget**  | **yum** |
| ---- | --- | --- |
| 定义 | 下载工具 | 软件包管理器 |
| 描述 | 是通过HTTP、HTTPS、FTP三个最常见的TCP/IP协议下载，并可以使用HTTP代理，名字是World Wide Web”与“get”的结合 | 是redhat, centos 系统下的软件安装方式，基于Linux，是一个在Fedora和RedHat以及CentOS中的Shell前端软件包管理器，是基于RPM包管理，能够从指定的服务器自动下载RPM包并且安装，可以自动处理依赖性关系，并且一次安装所有依赖的软件包 |
| 区别 | wget好比迅雷下载中心 | yum就像是应用商店，里面有很多软件当然也有没有的 |

***

#### <span style="color:green">安装 Nginx</span>

1. 查看可安装的版本

    ```shell
    yum list nginx*
    ```

2. 安装某一个版本

    > -y 表示自动同意安装

    ```shell
    yum install -y nginx.x86_64
    ```

3. nginx配置文件

    ```shell
    vim /etc/nginx/nginx.conf
    ```
    > 注意 root 与 alias 的区别

    ![nginx配置](http://39.106.78.182/download/image/nginx配置.png)

4. 启动 **nginx** 服务

    ```shell
    nginx -t [-c /etc/nginx/nginx/conf]  # 查看nginx配置文件是否正确

    start nginx
    systemctl start nginx    # 两种方式都可以
    ```

5. nginx常用命令

    ```shell
    systemctl status nginx  # 查看nginx状态
    nginx -s reload         # 重启nginx（每次修改了配置文件都需要重启）
    nginx -s stop           # 关闭nginx
    ```
    ![nginx状态](http://39.106.78.182/download/image/nginx状态.png)

***

#### <span style="color:green">安装 Mysql</span>

1. 下载对应的安装包

    ```
    wget https://dev.mysql.com/get/mysql57-community-release-el6-9.noarch.rpm
    ```

2. 安装用来配置mysql的 yum源的rpm包

    ```
    yum localinstall -y mysql57-community-release-el6-9.noarch.rpm
    ```
    > 安装成功后, 会在/etc/yum.repos.d/下会多出几个mysql的yum源的配置

    [图片C]
    > 在第三步安装报错时可能是需要如下解决
    > 打开配置源将 6 -> 7   1 -> 0

    ```
    vim /etc/yum.repos.d/mysql-community.repo
    ```
    [图片D]
    
3. 安装 mysql

    ```
    yum install -y mysql-community-server --nogpgcheck  # nogpgcheck 不校验数字签名
    ```

4. 启动 mysql

    ```
    systemctl status mysqld          # 查看状态
    systemctl start mysqld.service   # 启动 mysql
    ```

5. 查看初始密码

    ```
    grep "password" /var/log/mysqld.log
    ```

6. root 连接数据库

    > mysql 命令台命令一定以 ';' 结尾
    ```
    mysql -u root -p  # 登录root账号
    alter user 'root'@'localhost' identified by '密码';   # 修改密码[有密码策略要求的]
    flush privileges;   # 刷新权限
    exit;               # 退出mysql命令台
    ```

7. 修改 mysql 权限类问题

    ```
    show databases;              # 显示所有数据库
    use mysql;                   # 使用mysql这个数据库来修改管理员权限
    select user,host from user;  # 从mysql这个数据库中的user表中取出 user,host字段
    ```
    [图片3]
    > localhost 表示允许本地登录, 想要远程登录mysql, 需要修改权限为 %

    ```
    update user set host='%' where user = 'root';
    flush privileges;   # 设置了一定要刷新
    ```
    > 更新密码加密规则以适应低版本连接
    > 授权root远程登录, 后面密码代表登录密码

    ```
    alter user 'root'@'%' IDENTIFIED WITH mysql_native_password BY '登录密码';
    ```

***

#### <span style="color:green">安装 Git & Nvm</span>

1. 安装 git

    ```shell
    yum install -y git
    ```

2. 配置 git

    ```shell
    git --version # 查看版本

    git config --global user.name "xxx"   # 配置git
    git config --global user.email "xxx"  # 配置git
    git config -l  # 查看配置
    ```

4. 安装 nvm

    > 通过 git 来安装 nvm
    ```shell
    git clone https://github.com/cnpm/nvm.git ~/.nvm && cd ~/.nvm && git checkout `git describe --abbrev=0 --tags`
    ```
    > ~/.nvm 表示创建你的本地项目目录

5. 配置 nvm 环境

    ```shell
    echo ". ~/.nvm/nvm.sh" >> /etc/profile
    ```

6. 读取并执行配置

    ```shell
    source /etc/profile
    ```

7. 查看nvm

    > 查看 nvm [常用命令](http://)
    ```shell
    nvm --version
    ```

***

#### linux命令

> vim / vi 命令

| 命令 | 操作 | 说明 |
| --- | --- | --- |
| vim/vi 文件地址 |  | 当文件存在时, 进入vim模式；否则新建文件并进入vim模式 |
|  | 按 i | 进去insert编辑模式 |
|  | 按 esc | 退出某种编辑模式 |
|  | :q | 在退出模式下未修改时直接退出 |
|  | :q! | 在退出模式下强制退出 [放弃修改并退出] |
|  | :wq | 在退出模式下保存修改并退出vim/vi |

> 常见命令

| 命令 | 说明 |
| --- | --- |
| chkconfig --list | 列出所有的系统服务 |
| mkdir xxx | 在当前位置新建文件夹 xxx |
| kill -9 pid | 杀死 pid 的进程 |
| firewall-cmd --state | 查看防火墙状态 |
| systemctl start firewalld.service | 开启防火墙 |
| systemctl stop firewalld.service | 关闭防火墙 |
| mv xx.text /home/xx | 移动文件到指定目录下 |
| systemctl start mysqld | 启动mysql服务 |
| systemctl stop mysqld | 关闭mysql服务 |
| systemctl restart mysqld | 重启mysql服务 |

***

**<span style="color:#a16946">查看文献</span>**

1. [阿里云服务器操作文档](https://help.aliyun.com/product/25365.html?spm=a2c4g.108426.0.0.26fe64bfV9kcOW)
