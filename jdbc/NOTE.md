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