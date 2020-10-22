## Java Review

[toc]

### JDBC

#### 基本流程

1. Properties 读取配置文件参数

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



































### 