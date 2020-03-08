package com.macro.cloud.controller;

import com.macro.cloud.domain.CommonResult;
import com.macro.cloud.domain.User;
import com.macro.cloud.service.UserService;
import org.bouncycastle.est.CSRRequestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public CommonResult create(@RequestBody User user) {
        userService.create(user);
        return new CommonResult(200, "操作成功");
    }

    @GetMapping("/getAllUers")
    public CommonResult<List<User>> getAllUers() {
        List<User> list = userService.getAllUers();
        return new CommonResult<>(list);
    }

    @GetMapping("/{id}")
    public CommonResult<User> getUser(@PathVariable Integer id) {
        User user = userService.getUser(id);
        LOGGER.info("根据id获取用户信息，用户名称为：{}", user.getUserName());
        return new CommonResult(user);
    }

    @GetMapping("/getUserByIds")
    public CommonResult<List<User>> getUserByIds(@RequestParam List<Integer> ids) {
        List<User> userList = userService.getUserByIds(ids);
        LOGGER.info("根据ids获取用户信息，用户列表为：{}", userList);
        return new CommonResult<>(userList);
    }

    @RequestMapping("getByUserName")
    public CommonResult<User> getUserByUserName(@RequestParam String userName) {
        User user = userService.getByUsername(userName);
        return new CommonResult<User>(user);
    }

    @RequestMapping("/update")
    public CommonResult update(@RequestBody User user) {
        userService.update(user);
        return new CommonResult(200, "操作成功");
    }

    @RequestMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Integer id) {
        userService.delete(id);
        return new CommonResult(200, "操作成功");
    }
}
