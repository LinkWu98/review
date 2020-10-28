# Java Review

[toc]

## JDBC

### 基本流程

1. Properties 读取配置文件参数

   1. 相关知识点

      properties.load(InputStream in)

      Class 类的 getResourceAsStream 是从当前包下读

      ClassLoader 类的getResourceAsStream 是从类路径开始读 (比如resource目录)

2. 注册驱动 & 获取数据库连接

3. 事务

   ```java
   //开启事务
   connnection.setAutoCommit(false);
   //提交事务
   connection.commit();
   //回滚事务
   connection.rollback();
   ```

4. 执行sql (PreparedStatement - **？占位符**，防止 SQL 注入)

5. 获取并解析结果集(ResultSet)

   ResultSet => MetaData => ColumnCount、ColumnName（反射赋值）

6. 关闭资源(PreparedStatement, Connection, ResultSet)

   

## SSM

表现层（UI）、业务逻辑层（BLL）、数据访问层（DAL）

整合配置文件思路：

1. 包扫描注入容器： Controller、Service

2.  Bean对象：

   SqlSessionFactoryBean(MapperLocation、ConfigLocation、DataSource)

   DataSource

   InternalResourceViewResolver



### SpringMVC

**核心**：DispatcherServlet

问题和解决：

1. **不添加如下配置，访问 controller 会报 404**

   ```xml
   <mvc:default-servlet-handler/>
   ```

   

2. **添加了也无法返回数据**

   mvc在返回 JSON 格式时默认使用 jackson

   1. 导 Jackson 包

   2. 上方配置中添加其他messageConverter(如FastJson)

   ```xml
   <mvc:annotation-driven>
           <mvc:message-converters register-defaults="false">
               <bean id="fastJsonHttpMessageConverter"
       class="com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter">
                   <property name="supportedMediaTypes">
                       <list>
                           <!-- 这里顺序不能反，一定先写 text/html,不然 IE执行AJAX时，返回JSON出现下载文件 -->
                           <value>text/html;charset=UTF-8</value>
                           <value>application/json;charset=UTF-8</value>
                       </list>
                   </property>
               </bean>
           </mvc:message-converters>
       </mvc:annotation-driven>
   ```

   



### Spring

**核心**：AOP（整个框架都基于代理、事务管理...）、IOC（管理对象的容器）、DI

### Mybatis

**核心**：SqlSessionFactoryBean



## 其他

#### POST请求两种格式

最基本的页面表单提交格式：application/x-www-form-urlencoded

文件上传：multipart/form-data