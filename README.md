一、新建表
    1. 新建二张表 命名为：user_0、user_1
    2. User实体类
    3. UserControlle 类
    4. UserMapper 类
    5. application.yml配置
    6. 启动类 @MapperScan("com.atguigu.springboot.mapper") 扫描mappe
二、启动项目
    1. 项目启动后，先执行 localhost:8080/test/insertTest  测试插入九条数据，数据会分片到两个表
    2. 单个查询 @GetMapping("/selectTest") 根据cid去自动获取去那个表中获取数据
    3. 全查询 @GetMapping("/selectListTest") 去两个表中都进行查询然后汇总给我们
    5. 分页查询 需要先配置mybatis-plus分页配置类：MybatisPlusConfig
        @GetMapping("/selectListPage")
        会向所有的表中去进行一遍分页查询，第一个表数据不够就会加上另一个表分页拿到的值
    6. 非分片属性查询
        先把user_0表性别修改两个为女，然后进行查询！看看没有分片的字段是否能够只去user_0去查询,
        不是分片的字段查询，回去所有的表去查询一遍