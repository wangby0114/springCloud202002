package com.macro.cloud.controller;


import com.macro.cloud.domain.CommonResult;
import com.macro.cloud.domain.User;
import com.macro.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserFeignController {

    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    public CommonResult getUser(@PathVariable Integer id){
        return userService.getUser(id);
    }

    @GetMapping("/getUserByUserName")
    public CommonResult getUserByUserName(@RequestParam String userName) {
        return userService.getUserByUserName(userName);
    }

    @PostMapping("/create")
    public CommonResult create(@RequestBody User user) {
        return userService.create(user);
    }

    @PostMapping("/update")
    public CommonResult update(@RequestBody User user) {
        return userService.update(user);
    }

    @PostMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Integer id) {
        return userService.delete(id);
    }

}
