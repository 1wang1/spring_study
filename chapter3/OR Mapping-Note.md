1. @NoRepositoryBean
> 表示 spring 不会为这个repository 生成一个bean
2. @GeneratedValue(strategy = GenerationType.IDENTITY) 
> strategy = GenerationType.IDENTITY 加入后，不会创建sequence，而是使用数据库默认的 IDENTITY
3. 方法的Options 注解
>需要添加keyColumn="id", keyProperty="id". 才会在插入后自动注入Coffee 的id;高版本的starter取消了keyProperty() default “id”