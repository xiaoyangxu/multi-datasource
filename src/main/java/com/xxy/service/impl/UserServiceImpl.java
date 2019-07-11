package com.xxy.service.impl;

import com.xxy.annotation.Master;
import com.xxy.mapper.UserMapper;
import com.xxy.model.User;
import com.xxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xxy on 2019/7/11.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> selectUsers(){
        return userMapper.selectUsers();
    }

    public User getUser(Integer id){
        return userMapper.getUser(id);
    }

    public int insertUser(User user){
        return userMapper.insertUser(user);
    }

    @Master
    public int saveUser(User user){
        return userMapper.insertUser(user);
    }
}
