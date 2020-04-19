1. @NoRepositoryBean
> 表示 spring 不会为这个repository 生成一个bean
2. @GeneratedValue(strategy = GenerationType.IDENTITY) 
> strategy = GenerationType.IDENTITY 加入后，不会创建sequence，而是使用数据库默认的 IDENTITY