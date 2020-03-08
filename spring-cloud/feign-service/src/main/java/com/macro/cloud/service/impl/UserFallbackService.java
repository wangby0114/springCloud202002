package com.macro.cloud.service.impl;

import com.macro.cloud.domain.CommonResult;
import com.macro.cloud.domain.User;
import com.macro.cloud.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserFallbackService implements UserService {
    @Override
    public CommonResult create(User user) {
        User defaultUser = new User(1, "defaultUser", "1111111");
        return new CommonResult(defaultUser);
    }

    @Override
    public CommonResult<User> getUser(Integer id) {
        User defaultUser = new User(1, "defaultUser", "111111");
        return new CommonResult<>(defaultUser);
    }

    @Override
    public CommonResult<User> getUserByUserName(String userName) {
        User defaultUser = new User(1, "defaultUser", "111111");
        return new CommonResult<>(defaultUser);
    }

    @Override
    public CommonResult update(User user) {
        return new CommonResult(500, "调用失败，服务被降级");
    }

    @Override
    public CommonResult delete(Integer id) {
        return new CommonResult(500, "调用失败，服务被降级");
    }
}
