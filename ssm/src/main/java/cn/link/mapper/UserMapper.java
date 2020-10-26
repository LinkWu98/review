package cn.link.mapper;

import cn.link.bean.User;
import org.apache.ibatis.annotations.Mapper;

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
    int addUser(List<User> users);

    /**
     * 批量新增用户
     * @param users
     * @return
     */
    int addUserBatch(List<User> users);

    /**
     * 查询用户
     * @return
     */
    List<User> queryUser();



}
