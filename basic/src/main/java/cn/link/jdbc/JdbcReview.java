package cn.link.jdbc;


import cn.link.jdbc.bean.User;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * JDBC 基础回顾
 *
 * @author Link
 * @version 1.0
 * @date 2020/10/22 10:50
 */
public class JdbcReview {

    public static String url;

    public static String username;

    public static String password;

    //静态代码块使用 Properties 读取 jdbc配置文件参数并赋值
    static {

        try {

            Properties properties = new Properties();
            properties.load(JdbcReview.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * 注册驱动 & 获取数据库连接
     *
     * @return 数据库连接
     */
    public static Connection getConnection() throws Exception {

        //1. 注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2. 通过 url(格式: jdbc:mysql://ip:port/dbname), username, password 连接数据库, 获取连接
        return DriverManager.getConnection(url, username, password);

    }

    /**
     * 增、删、改
     *
     * @param sql
     * @param args
     * @return
     * @throws Exception
     */
    public static int update(String sql, Object[] args) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int result = 0;

        try {
            //1. 建立连接
            connection = getConnection();

            //2. 开启手动事务
            connection.setAutoCommit(false);

            //2. 预编译 sql语句
            preparedStatement = connection.prepareStatement(sql);

            //3. 给占位符赋值
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }

            //4. 执行sql，返回执行结果
            result = preparedStatement.executeUpdate();

            //5. 提交事务
            connection.commit();

        } catch (Exception e) {

            e.printStackTrace();
            //5. 出现异常回滚
            if (connection != null) {
                connection.rollback();
            }

        }finally {

            //6. 关闭资源
            closeResource(preparedStatement, connection, null);

        }

        return result;

    }

    /**
     * 查询
     * <p>
     * 为什么泛型要写在返回值前？ 这样程序才知道返回值是什么
     *
     * @param sql
     * @param clazz
     * @param args
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> List<T> query(String sql, Class<T> clazz, Object[] args) throws Exception {

        //1. 获取连接
        Connection connection = getConnection();

        //2. 给占位符赋值 (占位符和参数必须是一一对应的)
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            // + 1 -> 占位符从 1 开始
            preparedStatement.setObject(i + 1, args[i]);

        }

        //3. 执行并解析结果集
        ResultSet resultSet = preparedStatement.executeQuery();

        //4. 获取元数据的列数，给每一列所对应的属性赋值
        ResultSetMetaData metaData = resultSet.getMetaData();
        //每行的总列数(总字段个数)
        int totalColNum = metaData.getColumnCount();

        ArrayList<T> data = new ArrayList<>();

        //5. 遍历结果集中的每一行,
        while (resultSet.next()) {

            T t = clazz.newInstance();

            //5.1 遍历每一列给对象对应的属性赋值
            for (int colIndex = 1; colIndex <= totalColNum; colIndex++) {

                //5.2 获取当前行指定列的值
                Object value = resultSet.getObject(colIndex);

                //5.3 遍历每个字段，给对应的字段赋值
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {

                    if (StringUtils.equals(field.getName(), metaData.getColumnName(colIndex))) {
                        field.setAccessible(true);
                        field.set(t, value);
                    }

                }

            }

            //5.4 存入集合中
            data.add(t);

        }

        //6. 关闭资源
        closeResource(preparedStatement, connection, resultSet);

        return data;

    }


    /**
     * 关闭资源
     */
    public static void closeResource(PreparedStatement preparedStatement, Connection connection, ResultSet resultSet) {

        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }


}
