# MongoDB术语解释
| SQL术语/概念 | MongoDB术语/概念 | 解释/说明                           |
| :----------- | :--------------- | :---------------------------------- |
| database     | database         | 数据库                              |
| table        | collection       | 数据库表/集合                       |
| row          | document         | 数据记录行/文档                     |
| column       | field            | 数据字段/域                         |
| index        | index            | 索引                                |
| table joins  |                  | 表连接,MongoDB不支持                |
| primary key  | primary key      | 主键,MongoDB自动将_id字段设置为主键 |
# windows10下docker环境的安装
> https://mp.weixin.qq.com/s?__biz=Mzg3MzAyODY2Nw==&mid=100000009&idx=1&sn=bcb5680973c15835be0abd50f4d290ff&chksm=4ee70c5d7990854bdcfca932d05aab2ba17acec4ef3224e29a593fcdcadd1981154638c3fad4#rd
>第二次开启docker容器时，使用start 命令：`docker start [OPTIONS] CONTAINER [CONTAINER...]`
>登录MongoDB 登录到 MongoDB 容器中： `docker exec -it mongo bash`通过 Shell 连接 MongoDB：`mongo -u admin -p admin`
> 链接mongoDb数据库后`use dbname`创建数据库，`show users;`展示所有该数据库下的用户
创建mongodb用户，在use 数据库后，执行以下脚本：
```sql
db.createUser(
	{
		user: "springbucks",
		pwd: "springbucks",
		roles: [
			{ role: "readWrite", db: "springbucks" }
		]
	}
)
```
这个时候使用`show dbs `查看所有数据库，不会看到springbucks库，因为库中没有任何数据，插入一些数据后再使用show命令就可以看到了
> 在 MongoDB 中，集合只有在内容插入后才会创建! 就是说，创建集合(数据表)后要再插入一个文档(记录)，集合才会真正创建。
# 关于Template和Repository
1. 从存储库（Repository）摘要开始，只使用查询派生机制或手动定义的查询声明简单查询。
2. 对于更复杂的查询，请将手动实现的方法添加到存储库（如此处所述）。对于实现，使用 MongoTemplate 。

# redis
1. 获取镜像：`docker pull redis`
2. 创建redis容器，并运行命令：`docker run --name redis -d -p 6379:6379 redis`
    - 语法：`docker run [OPTIONS] IMAGE [COMMAND] [ARG...]`
    - -d:后台运行容器，并返回容器id
    - -p:指定端口映射，格式为： 主机(宿主)端口:容器端口
    - --name: 为容器指定一个名称；
#Jedis
> Spring Data Redis 
>1. 支持的客户端Jedis / Lettuce
>2. RedisTemplate
>3. Repository支持
1. Jedis不是线程安全的
2. 通过JedisPool获得Jedis实例
# Redis线上两种常用的两种部署模式
1. 哨兵模式  Redis Sentinel
2. 集群模式 Redis Cluster
# spring缓存
@EnableCaching
> 开启对缓存的支持
- @Cacheable
> 如果结果在缓存里面，直接取；
- @CacheEvict
> 缓存清理
- @CachePut
> 不管缓存情况，缓存设置
- @Caching
> 缓存打包：设置清理
- @CacheConfig
> 缓存设置


 