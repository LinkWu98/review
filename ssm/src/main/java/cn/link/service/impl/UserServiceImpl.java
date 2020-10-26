package cn.link.service.impl;

import cn.link.bean.User;
import cn.link.mapper.UserMapper;
import cn.link.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Link
 * @version 1.0
 * @date 2020/10/26 23:27
 * @description
 */
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean addUser(User user) {

        List<User> userList = new ArrayList<>();

        userList.add(user);

        userMapper.addUser(userList);

        return false;
    }

    @Override
    public int addUserBatch(List<User> users) {

        return userMapper.addUserBatch(users);

    }

    @Override
    public List<User> queryUser() {

        return null;

    }
}
