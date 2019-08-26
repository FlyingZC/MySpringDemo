# 该工程将所有 SpringDemo 汇总
父 pom 基于 spring3.2.8

## _03_IoCOverview

### com.baobaotao.resource 包
1. spring resource接口实现类 实现不同类型资源的加载
FileSourceExample

2. 通过“classpath:”、“file:”等资源地址前缀识别不同的资源类型，还支持Ant风格带通配符的资源地址
PatternResolverTest

### BeanFactory中bean的生命周期
com.baobaotao.beanfactory 包
1. com.baobaotao.beanfactory.BeanFactoryTest
测试BeanFactory中bean的生命周期

2. com.baobaotao.beanfactory.BeanLifeCycle
测试BeanFactory中bean的生命周期,在1的基础上,向BeanFactory中注册了 MyBeanPostProcessor 和 MyInstantiationAwareBeanPostProcessor

### ApplicationContext的生命周期
1. com.baobaotao.context.ApplicationContextLifeCycle
ApplicationContext的生命周期

2. com.baobaotao.context.anno 包
 AnnoBeansAware扫描自定义注解

3. com.baobaotao.context.cycle 包
循环依赖

## _04_BeanWire

### 属性注入 和 构造器注入 和 工厂方法注入
com.baobaotao.ditype
xml配置
属性注入 和 构造器注入 和 工厂方法注入
constructor-arg

### 方法注入
com.baobaotao.injectfun 包
lookup-method 和 replaced-method

### 配置继承
com.baobaotao.tagdepend 包
parent 和 depency-on 

### FactoryBean 
com.baobaotao.fb 包
FactoryBean

### 注解配置,自动装配bean
com.baobaotao.anno 包
context:component-scan

###
com.baobaotao.attr 包
property xml配置

###
com.baobaotao.conf 包
使用 @Bean 注解配置bean,用的很少

###
com.baobaotao.impt 包
p标签配置
p:name

###
com.baobaotao.scope
scope配置,singleton或prototype

### xml id配置bean
com.baobaotao.simple 包


## _05_AdvancedTopic
###
com.baobaotao.editor 包
自定义属性编辑器

###
com.baobaotao.beanprop

###
com.baobaotao.event
事件监听

### 国际化
com.baobaotao.i18n

###
com.baobaotao.placeholder
1.使用placeholderConfigurer引入配置文件
2.使用<context:property-placeholder >引入配置文件


## 06_SpringAOP
### 代理
com.baobaotao.proxy
JDK代理, cglib代理
z01 普通实现
z02 JDK代理
z03 cglib代理

### 增强 编程式 aop
com.baobaotao.advice 
前置增强,后置增强,环绕增强,异常抛出增强
advice 和 interceptor 

分硬编码 和 xml配置 两种
TestBeforeAdvice

### 引介增强 
com.baobaotao.introduce
introduce 引介
引介增强是一种比较特殊的增强类型，它不是在目标方法周围织入增强，而是为目标类创建新的方法和属性，
所以引介增强的连接点是类级别的，而非方法级别的。通过引介增强，我们可以为目标类添加一个接口的实现，
即原来目标类未实现某个接口，通过引介增强可以为目标类创建实现某接口的代理。

Spring定义了引介增强接口IntroductionInterceptor，该接口没有定义任何的方法，
Spring为该接口提供了DelegatingIntroductionInterceptor实现类，一般情况下，我们通过扩展该实现类定义自己的引介增强类。

### 切面
com.baobaotao.advisor
增强被织入到目标类的所有方法中，假设我们希望有选择地织入到目标类某些特定的方法中，就需要使用切点进行目标连接点的定位了.

切点 + 增强 = 切面

### springaoplearning
com\zc\springaoplearning\Application 测试类
配置文件在 springaoplearning 目录下
测试类

## _07_AspectJSchemaAOP
### advice包 编程式 aop
### introduce 引介

###
com.baobaotao.anno
Java注解的使用示例

###
com.baobaotao.aspectj
spring aspectj注解配置

####
com.baobaotao.aspectj.basic 包
@DeclareParents注解的使用 引介增强注解
包含EnableSellerAspect类 和 配置文件

####
com.baobaotao.aspectj.fun 包
切点函数之 annotation的使用
切面之 @AfterReturning

com.baobaotao.aspectj.example 包
切点函数之 execution的使用
@Before("execution(* greetTo(..))")

切面之@Before

com.baobaotao.aspectj.advanced 包
@AspectJ可以使用切点函数定义切点，我们还可以`使用逻辑运算符对切点进行复合运算得到复合的切点`

###
com.baobaotao.schema
基于xml配置aspectj aop


##  _08_Transaction
###
T01JdbcTransationTest
JDBC事务测试

###
T02BbtForumTx
xml方式配置事务

实体类
Forum论坛 -> Topic主题 -> Post投稿
 
###
T03BbtForumAnno

###
TestBbtForumAspectj

###
TestBbtForumPfb

###
TestForumService

###
TestMultiForumTx
















