package cn.link.controller;

import cn.link.bean.User;
import cn.link.common.Response;
import cn.link.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 控制层
 *
 * @author Link
 * @version 1.0
 * @date 2020/10/23 22:21
 */
@RequestMapping("/test")
public class UserController {

    @Autowired
    UserService userService;

    @ResponseBody
    @PostMapping("/add")
    public Response addUser(User user) {

        return userService.addUser(user) ? Response.success() : Response.fail();

    }

    @ResponseBody
    @GetMapping("/query")
    public Response<List<User>> queryUser() {

        List<User> users = userService.queryUser();

        return Response.success(users);

    }

}
