# windows下docker环境的安装&镜像的安装

[Docker操作-《玩转Spring全家桶》学习笔记](https://mp.weixin.qq.com/s?__biz=Mzg3MzAyODY2Nw==&mid=100000009&idx=1&sn=bcb5680973c15835be0abd50f4d290ff&chksm=4ee70c5d7990854bdcfca932d05aab2ba17acec4ef3224e29a593fcdcadd1981154638c3fad4#rd)
1. linux环境可以直接执行：`docker run --name mongo -p 27017:27017 -v ~/docker-data/mongo:/data/db -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=admin -d mongo`
1. `docker volume create --name  mongodata`创建docker数据卷，可以理解为虚拟磁盘
2. windows环境：`docker run --name mongo -p 27017:27017 -v mongodata:/data/db -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=admin -d mongo`-v参数指定了存储位置为新创建的数据卷
3. linux下mysql镜像的运行：`docker run --name mysql -d -p 3306:3306 -v ~/dockerdata/
    mysql:/var/lib/mysql -e MYSQL_DATABASE=springbucks
    -e MYSQL_USER=springbucks -e MYSQL_PASSWORD=springbucks
    -e MYSQL_ROOT_PASSWORD=root_password mysql`

# run

```dockerfile
docker run [OPTIONS] IMAGE [COMMAND] [ARG...]
```

+ -a stdin: 指定标准输入输出内容类型，可选 STDIN/STDOUT/STDERR 三项；
+ -d: 后台运行容器，并返回容器ID；
+ -i: 以交互模式运行容器，通常与 -t 同时使用；
+ -P: 随机端口映射，容器内部端口随机映射到主机的高端口
+ -p: 指定端口映射，格式为：主机(宿主)端口:容器端口
+ -t: 为容器重新分配一个伪输入终端，通常与 -i 同时使用；
+ --name="nginx-lb": 为容器指定一个名称；
+ --dns 8.8.8.8: 指定容器使用的DNS服务器，默认和宿主一致；
+ --dns-search example.com: 指定容器DNS搜索域名，默认和宿主一致；
+ -h "mars": 指定容器的hostname；
+ -e username="ritchie": 设置环境变量；
+ --env-file=[]: 从指定文件读入环境变量；
+ --cpuset="0-2" or --cpuset="0,1,2": 绑定容器到指定CPU运行；
+ -m :设置容器使用内存最大值；
+ --net="bridge": 指定容器的网络连接类型，支持 bridge/host/none/container: 四种类型；
+ --link=[]: 添加链接到另一个容器；
+ --expose=[]: 开放一个端口或一组端口；
+ --volume , -v: 绑定一个卷

# volume 
1. `docker volume create my-vol`
2. `docker volume ls` 
3. `docker volume inspect my-vol` 查看数据卷
4. `docker volume rm my-vol`