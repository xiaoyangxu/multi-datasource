package com.xxy.mapper;

import com.xxy.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by xxy on 2019/7/11.
 */
@Mapper
public interface UserMapper {

    List<User> selectUsers();

    User getUser(Integer id);

    int insertUser(User user);
}
