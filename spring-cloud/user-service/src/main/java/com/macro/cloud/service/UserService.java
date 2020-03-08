package com.macro.cloud.service;

import com.macro.cloud.domain.User;

import javax.swing.*;
import java.util.List;

public interface UserService {

    void create(User user);

    List<User> getAllUers();

    User getUser(Integer id);

    void update(User user);

    void delete(Integer id);

    User getByUsername(String userName);

    List<User> getUserByIds(List<Integer> ids);

}
