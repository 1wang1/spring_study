# mvnw
 > mvnw是Maven Wrapper的缩写。因为我们安装Maven时，默认情况下，系统所有项目都会使用全局安装的这个Maven版本。但是，对于某些项目来说，它可能必须使用某个特定的Maven版本，这个时候，就可以使用Maven Wrapper，它可以负责给这个特定的项目安装指定版本的Maven，而其他项目不受影响。
>简单地说，Maven Wrapper就是给一个项目提供一个独立的，指定版本的Maven给它使用。

>发现多了mvnw、mvnw.cmd和.mvn目录，我们只需要把mvn命令改成mvnw就可以使用跟项目关联的Maven。例如：
>https://www.liaoxuefeng.com/wiki/1252599548343744/1305148057976866
 
```
mvnw clean package
```
# lombok
> POJO的getter/setter/toString；异常处理；I/O流的关闭操作等等，这些样板代码既没有技术含量，又影响着代码的美观，Lombok应运而生。
>idea中使用lombok需要先安装插件：IntelliJ Lombok plugin
>https://www.jianshu.com/p/365ea41b3573

# actuator
> Spring Boot Actuator可以帮助你监控和管理Spring Boot应用，比如健康检查、审计、统计和HTTP追踪等。所有的这些特性可以通过JMX或者HTTP endpoints来获得。
Actuator同时还可以与外部应用监控系统整合，比如 Prometheus, Graphite, DataDog, Influx, Wavefront, New Relic等。这些系统提供了非常好的仪表盘、图标、分析和告警等功能，使得你可以通过统一的接口轻松的监控和管理你的应用。
Actuator使用Micrometer来整合上面提到的外部应用监控系统。这使得只要通过非常小的配置就可以集成任何应用监控系统。
>https://www.jianshu.com/p/d5943e303a1f
>http://localhost:8080/actuator/beans
# 类路径下的schema.sql和data.sql脚本。
> 这个是由Spring Boot的自动配置在启动过程中执行的，并非由我们的代码来执行的
# springboot中使用alibaba的druid要注意：
> 1. 在引入的spring-boot-starter-jdbc依赖中，要排除HikariCP
> 2. 在pom中引入druid-spring-boot-starter
>
# 连接池选择的考量点：
1. **可靠性**
2. **性能**
3. 功能
4. 可运维性
    + 密码加密等
5. 可扩展性（加分项）
6. 其他
    - 社区是否活跃
    
# spring中常用的Bean注解
1. @Component
   > 通用bean
2. @Repository
> 数据操控的bean
3. @Service
> 业务的服务
4. @Controller
> spring mvc
 - @RestController
 > rest请求

# 当未初始化DataSource时，SpringBoot会自动配置
> : Spring Boot的自动配置发现CLASSPATH里有H2，你又没有配置DataSource，就自动配置了一个H2的DataSource

# spring 事务的传播特性
共7种，但是文档中只有三项
1. PROPAGATION_REQUIRED
    - 当前有事务就用当前的，没有就用新的
2. PROPAGATION_SUPPORTS
    - 事务可又可无，不是必须的
3. PROPAGATION_MANDATORYD
    - 当前一定要有事务，不然就抛异常
4. PROPAGATION_REQUIRES_NEW
    - 无论是否有事务，都起一个新的
5. PROPAGATION_NOT_SUPPORTED
    - 不支持事务，按非事务方式运行
6. PROPAGATION_NEVER
    - 不支持事务，如果有事务则抛出异常
7. PROPAGATION_NESTED
    - 当前有事务，就在当前事务里再起一个事务