package com.macro.cloud.service;

import com.macro.cloud.domain.CommonResult;
import com.macro.cloud.domain.User;
import com.macro.cloud.service.impl.UserFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "USER-SERVICE", fallback = UserFallbackService.class)
public interface UserService {

    @PostMapping("/user/create")
    public CommonResult create(@RequestBody User user);

    @GetMapping("/user/{id}")
    public CommonResult<User> getUser(@PathVariable Integer id);

    @RequestMapping("/user/getByUserName")
    public CommonResult<User> getUserByUserName(@RequestParam String userName);

    @RequestMapping("/user/update")
    public CommonResult update(@RequestBody User user);

    @RequestMapping("/user/delete/{id}")
    public CommonResult delete(@PathVariable Integer id);

}
