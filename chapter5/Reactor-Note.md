#reactive（响应式编程）
spring5中除了web-MVC也有了webflux：它可以以reactive的形式访问web
# 核心概念
1. Opeators-Publisher/Subscriber(类似生产者消费者，消息的发送者，接受者)
    - Nothing Happens Until You subscribe()——调用scriber之前，不会执行任何东西
    - Flux[0..N] - onNext()、 onComplete、onError()——N个元素的序列，遇到下个元素、执行完毕、错误时执行
    - Mono[0..1] - onNext()、 onComplete、onError()——0或1个元素
2. Backpressure（反压力，上游生产速度非常快而下游的subscriber跟不上上游的生产速度时，可以做到，虽然上游一下生产出200个元素，但是订阅者，每次可以只request几个）
    - Subscription
    - onRequest()--每次请求x个、onCancel（）-取消订阅、onDispose（）-终止订阅
3. 线程调度 Schedulers
    - immediate() / single() / newSingle()——当前线程、单独可复用的线程、新启一个
    - elastic() / parallel() / newParallel()——缓存的线程池上去做，空闲60秒后会回收、固定线程池，不会被回收、指定线程池
4. 错误处理理
   - onError / onErrorReturn / onErrorResume
   - doOnError / doFinally
   
# FAQ
1. springboot2.0之后,不会自动执行data.sql，和schema.sql
pom里面的数据库驱动要指定对应的version，而且2.0要加上
```xml
schema:
- classpath:sql/department.sql
- classpath:sql/employee.sql
initialization-mode: always
```
