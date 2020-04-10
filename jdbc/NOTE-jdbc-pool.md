# pool
 > 在spring-boot1.x中，默认使用的是Tomcat的DataSource
>在spring-boot2.x中，使用的是HikariCP
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