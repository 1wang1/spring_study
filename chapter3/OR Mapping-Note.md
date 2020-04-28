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
