package com.macro.cloud.service.impl;

import com.macro.cloud.domain.User;
import com.macro.cloud.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private List<User> userList;

    @PostConstruct
    public void initData() {
        userList = new ArrayList<User>();
        userList.add(new User(1, "macro", "111"));
        userList.add(new User(2, "andy", "222"));
        userList.add(new User(3, "mark", "333"));
    }

    @Override
    public void create(User user) {
        userList.add(user);
    }

    @Override
    public List<User> getAllUers() {
        return userList;
    }

    @Override
    public User getUser(Integer id) {
        List<User> findUserList = userList.stream().filter(userItem -> userItem.getId().equals(id)).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(findUserList)) {
            return findUserList.get(0);
        }
        return null;
    }

    @Override
    public void update(User user) {
        userList.stream().filter(userItem -> userItem.getId().equals(user.getId())).forEach(userItem -> {
            userItem.setUserName(user.getUserName());
            userItem.setPassWord(user.getPassWord());
        });
    }

    @Override
    public void delete(Integer id) {
        User user = getUser(id);
        if (user != null) {
            userList.remove(user);
        }
    }

    @Override
    public User getByUsername(String userName) {
        List<User> findUserList = userList.stream().filter(userItem -> userItem.getUserName().equals(userName)).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(findUserList)) {
            return findUserList.get(0);
        }
        return null;
    }

    @Override
    public List<User> getUserByIds(List<Integer> ids) {
        return userList.stream().filter(userItem -> ids.contains(userItem.getId())).collect(Collectors.toList());
    }
}
