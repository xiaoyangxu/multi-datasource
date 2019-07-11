package com.xxy.service;

import com.xxy.model.User;

import java.util.List;

/**
 * Created by xxy on 2019/7/11.
 */
public interface UserService {
    public List<User> selectUsers();

    public User getUser(Integer id);

    public int insertUser(User user);

    public int saveUser(User user);
}
