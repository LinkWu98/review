package cn.link.datasource;

import cn.link.bean.User;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库连接池测试
 *
 * @author Link
 * @version 1.0
 * @date 2020/10/23 21:23
 */
public class DataSourceTest {

    private DruidPooledConnection connection;

    private User user;


    @Before
    public void init() throws SQLException {

        connection = DataSourceReview.getConnection();

        user = new User();
        user.setUserId("qq88888888");
        user.setName("Hikaru");
        user.setAge(22);

    }

    /**
     * 初始化的连接不会真正的被关闭，而是放回线程池中
     * @throws SQLException
     */
    @Test
    public void connectionTest() throws SQLException {

        List<DruidPooledConnection> connectionList = new ArrayList<>();

        System.out.println("===遍历获取5个连接===");

        for (int i = 0; i < 5; i++) {

            DruidPooledConnection connection = DataSourceReview.getConnection();
            connectionList.add(connection);
            System.out.println(connection);

        }

        System.out.println("===关闭一个连接再获取，再看5个连接===");

        connectionList.get(4).close();
        connectionList.add(4, DataSourceReview.getConnection());
        connectionList.forEach(System.out::println);


    }

    @Test
    public void dataSourceTest() throws SQLException {

        String sql = "UPDATE user SET `name` = ?, `age` = ? WHERE `userId` = ?";

        System.out.println("update: " + DataSourceReview.update(connection, sql, new Object[]{user.getName(), user.getAge(), user.getUserId()}));

    }

}
