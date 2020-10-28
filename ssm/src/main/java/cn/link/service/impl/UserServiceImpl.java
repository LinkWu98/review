package cn.link.service.impl;

import cn.link.bean.User;
import cn.link.mapper.UserMapper;
import cn.link.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Link
 * @version 1.0
 * @date 2020/10/26 23:27
 * @description
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean addUser(User user) {

        int result = userMapper.addUser(user);

        return result != 0;
    }

    @Override
    public boolean addUserBatch(List<User> users) {

        return userMapper.addUserBatch(users) != 0;

    }

    @Override
    public List<User> queryUser() {

        return userMapper.queryUser();

    }

}
