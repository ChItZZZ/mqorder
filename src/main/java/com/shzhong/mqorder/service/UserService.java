package com.shzhong.mqorder.service;

import com.shzhong.mqorder.entity.User;
import com.shzhong.mqorder.entity.UserExample;
import com.shzhong.mqorder.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
@Slf4j
public class UserService {

    @Resource
    UserMapper userMapper;

    public boolean checkAuth(String username,String password){
        UserExample userExample = new UserExample();
        userExample.or().andUsernameEqualTo(username).andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(userExample);
        return users.size() > 0;
    }
}
