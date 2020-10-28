package cn.link.mapper;

import cn.link.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * UserMapper
 *
 * @author Link
 * @version 1.0
 * @date 2020/10/26 21:26
 */
@Mapper
public interface UserMapper {

    /**
     * 新增用户
     * @return
     */
    int addUser(@Param("user") User user);

    /**
     * 批量新增用户
     * @param users
     * @return
     */
    int addUserBatch(@Param("users") List<User> users);

    /**
     * 查询用户
     * @return
     */
    List<User> queryUser();



}
