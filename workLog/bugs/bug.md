# bug log


### 待解决
       mapper.xml文件在打包的时候不进入target中;

### bug log 

    1. bean配置问题 提示找不到userMapper (2016-01-03)  
       * UserMapper 缺少 注解 @Repository
       * mybatis-generator生成的时候缺少的,检查generator的配置文件

    2. IllegalArgumentException: Property 'sqlSessionFactory' or 'sqlSessionTemplate' are required

    3.No MyBatis mapper was found

    4.mapper.xml文件在打包的时候不进入target中;