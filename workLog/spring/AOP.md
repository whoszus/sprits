##AOP


1.	简介
	专门用于处理系统中分布于各个模块（不同方法）中的交叉关注点的问题，如事务管理、安全检查、缓存、对象池管理等；AOP用于横向抽取业务逻辑中重复的部分,在需要使用到的位置通过声明切点的方式weaving Advice(织入增强)获得;


	AOP 实现的关键就在于 AOP 框架自动创建的 AOP 代理，AOP 代理则可分为静态代理和动态代理两大类，其中静态代理是指使用 AOP 框架提供的命令进行编译，从而在编译阶段就可生成 AOP 代理类，因此也称为编译时增强；而动态代理则在运行时借助于 JDK 动态代理、CGLIB 等在内存中“临时”生成 AOP 动态代理类，因此也被称为运行时增强。

	a. AOP术语:
	    连接点 (Joinpoint) : 程序执行的某个特定的位置; 类初始化前\后 ,某个Method调用前后,方法异常抛出后;  (keyWord  : 位置)
	    切点  (Pointcut)  :  想要切入的特殊的连接点; 一个切点可以匹配多个连接点(一般通过正则表达式 例如 *service(..) 匹配任意多个以service结尾的方法 );
	    增强  (Advice)    : 其实就是横向抽取出来的那段代码;
	    引介  (Introduction) : 特俗的Advice ,可以为类添加属性跟方法; 可以为某个类实现接口..
	    织入 (weaving) :  将Target & Advice 编译到一个class文件中; 分为三种:
	        编译期织入: AspectJ 运行命令,特殊的java编译器; 反射;
	        类装载织入: AspecJ 使用, 反射;
	        动态代理织入: spring 使用 ,底层为CGLIB;
	b.



2.	实现方式；

	a.	使用 AspectJ 的编译时增强进行 AOP

	AspectJ 是 Java 语言的一个 AOP 实现，其主要包括两个部分：第一个部分定义了如何表达、定义 AOP 编程中的语法规范，通过这套语言规范，我们可以方便地用 AOP 来解决 Java 语言的一个的一个中存在的交叉关注点问题；另一个部分是工具部分，包括编译器、调试工具等。

	b.	 Spring AOP

	Spring AOP 无需使用任何特殊命令对 Java 源代码进行编译，它采用运行时动态地、在内存中临时生成“代理类”的方式来生成 AOP 代理。

	Spring 允许使用 AspectJ Annotation 用于定义方面（Aspect）、切入点（Pointcut）和增强处理（Advice），Spring 框架则可识别并根据这些 Annotation 来生成 AOP 代理。没有使用 AspectJ 的编译器或者织入器（Weaver），底层依然使用的是 Spring AOP，依然是在运行时动态生成 AOP 代理，并不依赖于 AspectJ 的编译器或者织入器。

	在spring配置文件中使用   <aop:aspectj-autoproxy/>  <!-- 启动 @AspectJ 支持 --> 当启动了 @AspectJ 支持后，只要我们在 Spring 容器中配置一个带 @Aspect 注释的 Bean，Spring 将会自动识别该 Bean，并将该 Bean 作为方面 Bean 处理。


	@Aspect
	 public class AfterReturningAdviceTest
	 {
	 // 匹配 org.crazyit.app.service.impl 包下所有类的、
	 // 所有方法的执行作为切入点
	 @AfterReturning(returning="rvt",
	 pointcut="execution(* org.crazyit.app.service.impl.*.*(..))")
	 public void log(Object rvt)
	 {
	 System.out.println("获取目标方法返回值 :" + rvt);
	 System.out.println("模拟记录日志功能 ...");
	 }
	 }

	 上面 Aspect 类使用了 @Aspect 修饰，这样 Spring 会将它当成一个方面 Bean 进行处理。调用 org.crazyit.app.service.impl 包下的所有类的所有方法之后织入 log(Object rvt) 方法。

	 Spring AOP 会动态选择使用 JDK 动态代理、CGLIB 来生成 AOP 代理，如果目标类实现了接口，Spring AOP 则无需 CGLIB 的支持，直接使用 JDK 提供的 Proxy 和 InvocationHandler 来生成 AOP 代理即可。


3. Spring AOP底层实现探索 -CGLIB动态代理和JDK动态代理

	a.反射机制在生成类的过程中比较高效，而asm在生成类之后的相关执行过程中比较高效（可以通过将asm生成的类进行缓存，这样解决asm生成类过程低效问题）

	b.稍后给出完整源码解析；





