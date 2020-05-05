1. @NoRepositoryBean
    > 表示 spring 不会为这个repository 生成一个bean
2. @GeneratedValue(strategy = GenerationType.IDENTITY) 
    > strategy = GenerationType.IDENTITY 加入后，不会创建sequence，而是使用数据库默认的 IDENTITY
3. 方法的Options 注解
    >需要添加keyColumn="id", keyProperty="id". 才会在插入后自动注入Coffee 的id;高版本的mybatis取消了keyProperty() default “id”
4. Result Maps collection does not contain value for
    > 可能是application.properties中没有配置：mybatis.type-aliases-package和mybatis.type-handlers-package
    > 也可能是是返回的resultType错写成了resultMap
5. spring data JPA的response是如何从接口变成bean的
    - JpaRepositoriesRegistrar
        - 激活@EnableJpaRepositories
        - 返回JpaRepositoryConfigExtension
    - RepositoryBeanDefinitionRegistrarSupport.registerBeanDefinitions
        - 注册Repository Bean（类型是JpaRepositoryFactoryBean）
    - RepositoryConfigurationExtentionSupport.getResponsitoryConfigurations
        - 取得所有 Repository配置
    - JpaRepositoryFactory.getTargetRepository
        - 创建Repository
6. 关于model超类上的@MappedSuperclass
    > 1.标注为@MappedSuperclass的类将不是一个完整的实体类，他将不会映射到数据库表，但是他的属性都将映射到其子类的数据库字段中。    
    2.标注为@MappedSuperclass的类不能再标注@Entity或@Table注解，也无需实现序列化接口。
7. windows下docker环境的安装
   > https://mp.weixin.qq.com/s?__biz=Mzg3MzAyODY2Nw==&mid=100000009&idx=1&sn=bcb5680973c15835be0abd50f4d290ff&chksm=4ee70c5d7990854bdcfca932d05aab2ba17acec4ef3224e29a593fcdcadd1981154638c3fad4#rd    
   >2.新建并启动容器
   >视频的课件上给出了Linux环境的命令：

    >  `docker run --name mongo -p 27017:27017 -v ~/docker-data/mongo:/data/db -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=admin -d mongo`

    >如果在Windows电脑上，我们需要修改后再执行，主要是修改-v后面的映射目录。理论上我们改成下面这样即可执行（需提前在D盘创建两层文件夹docker-data和mongo）。`-v d:/docker-data/mongo:/data/db`

    >  然而，在Windows 10环境下这是一个巨坑，实际会出现权限问题，无法正常启动。
解决办法是，不使用具体的本地目录，而是用Docker的数据卷（Volume），可以理解为虚拟磁盘。
首先，创建数据卷：
`docker volume create --name mongodata`
然后，新建并启动容器：

    > `docker run --name mongo -p 27017:27017 -v mongodata:/data/db -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=admin -d mongo`

    可用ps命令查看是否启动成功：

    `docker ps`
    `docker images` 查看所有镜像

    > 3.登录MongoDB 登录到 MongoDB 容器中：

    > `docker exec -it mongo bash`
通过 Shell 连接 MongoDB：`mongo -u admin -p admin`
第二次开启docker容器时，使用start 命令：`docker start [OPTIONS] CONTAINER [CONTAINER...]`
