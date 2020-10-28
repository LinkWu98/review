package cn.link.controller;

import cn.link.bean.User;
import cn.link.common.Response;
import cn.link.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 控制层
 *
 * @author Link
 * @version 1.0
 * @date 2020/10/23 22:21
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 跳转登录页
     * @return
     */
    @GetMapping("/toLoginPage")
    public String toLoginPage() {
        return "login";
    }

    /**
     * 登录
     * @return
     */
    @ResponseBody
    @GetMapping("/login")
    public Response doLogin() {
        return Response.succeed();
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @ResponseBody
    @PostMapping("/add")
    public Response addUser(User user) {

        return userService.addUser(user) ? Response.succeed() : Response.fail();

    }

    /**
     * 批量新增用户
     *
     * @return
     */
    @ResponseBody
    @PostMapping("/add/batch")
    public Response addUserBatch(@RequestBody List<User> users) {

        return userService.addUserBatch(users) ? Response.succeed() : Response.fail();

    }

    /**
     * 批量查询用户
     *
     * @return
     */
    @ResponseBody
    @GetMapping("query")
    public Response<List<User>> queryUser() {

        List<User> users = userService.queryUser();

        return Response.succeed(users);

    }

}
