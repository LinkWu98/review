package cn.link.service;

import cn.link.bean.User;

import java.util.List;

/**
 * @author Link
 * @version 1.0
 * @date 2020/10/26 23:10
 * @description 用户服务类
 */
public interface UserService {

    /**
     * 新增用户
     * @param user
     * @return
     */
    boolean addUser(User user);

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
