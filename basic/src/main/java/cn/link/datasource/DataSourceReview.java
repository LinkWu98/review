package cn.link.datasource;

import cn.link.jdbc.JdbcReview;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 数据库连接池回顾
 *
 * @author Link
 * @version 1.0
 * @date 2020/10/23 20:56
 */
public class DataSourceReview extends JdbcReview {

    /**
     * 使用德鲁伊连接池
     */
    private static final DruidDataSource dataSource = new DruidDataSource();

    static {

        try {

            //1. Properties 读取配置文件中的连接池参数
            Properties properties = new Properties();
            properties.load(DataSourceReview.class.getClassLoader().getResourceAsStream("datasource.properties"));

            //2. 设置参数
            dataSource.setDriverClassName(properties.getProperty("driverClassName"));
            dataSource.setUrl(properties.getProperty("url"));
            dataSource.setUsername(properties.getProperty("username"));
            dataSource.setPassword(properties.getProperty("password"));
            dataSource.setInitialSize(Integer.parseInt(properties.getProperty("initialSize")));
            dataSource.setMaxActive(Integer.parseInt(properties.getProperty("maxActive")));
            dataSource.setMaxWait(Integer.parseInt(properties.getProperty("maxWait")));

        } catch (IOException e) {

            System.out.println("连接池初始化失败");

        }

    }

    /**
     * 获取连接，连接池中的连接会启动时初始化，即使 close，也只是放回池中，不会关闭
     * @return
     * @throws SQLException
     */
    public static DruidPooledConnection getConnection() throws SQLException {

        return dataSource.getConnection();

    }


}
