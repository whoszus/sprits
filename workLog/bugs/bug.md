# bug log


### 待解决


### bug log 

    1. bean配置问题 提示找不到userMapper (2016-01-03)  
       * UserMapper 缺少 注解 @Repository
       * mybatis-generator生成的时候缺少的,检查generator的配置文件

    2. IllegalArgumentException: Property 'sqlSessionFactory' or 'sqlSessionTemplate' are required

    3.No MyBatis mapper was found,
        应该是 bug 4 的原因;

    4.mapper.xml文件在打包的时候不进入target中;

    5.HTTP Status 406 - The resource identified by this request is only capable of generating responses with characteristics not acceptable according to the request "accept" headers.
      (将spring mvc 的拦截改为*.html之后出现)  @ResponseBody
      *jackson 问题?
      * stackoverflow 上 :   1) You didn't specify the application/json in your Accept header 2) You need to specify produces="application/json" in your @RequestMapping

