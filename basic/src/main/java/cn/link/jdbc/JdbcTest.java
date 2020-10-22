package cn.link.jdbc;

import cn.link.jdbc.bean.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Jdbc测试类
 *
 * @author Link
 * @version 1.0
 * @date 2020/10/22 12:36
 */
public class JdbcTest {

    private User user;

    @Before
    public void init() {

        user = new User();

        user.setUserId("qq88888888");
        user.setName("Totoro");
        user.setAge(22);

    }

    @Test
    public void createTest() throws Exception {

        String sql = "INSERT INTO user(`userId`, `name`, `age`, `status`) values (?, ?, ?)";

        System.out.println("create: " + JdbcReview.update(sql, new Object[]{user.getUserId(), user.getName(), user.getAge()}));

    }



    @Test
    public void updateTest() throws Exception {

        String sql = "UPDATE user SET `name` = ?, `age` = ? WHERE `userId` = ?";

        System.out.println("update: " + JdbcReview.update(sql, new Object[]{user.getName(), user.getAge(), user.getUserId()}));

    }

    @Test
    public void deleteTest() throws Exception {

        String sql =  "UPDATE user SET `status` = 0 WHERE `userId` = ?";

        System.out.println("delete: " + JdbcReview.update(sql, new Object[]{user.getUserId()}));

    }

    @Test
    public void queryTest() throws Exception {

        System.out.println("query:");

        String sql = "SELECT * FROM user WHERE `age` = ?";

        List<User> users = JdbcReview.query(sql, User.class, new Object[]{22});

        System.out.println(users);

    }



}
