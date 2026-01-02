package com.sinosoft.wordweb.chat.service.impl;

import com.sinosoft.wordweb.chat.mapper.UserMapper;
import com.sinosoft.wordweb.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public String login(String userName, String passWord) {
        if(userMapper.login(userName, passWord) != null)
        {
            return "登录成功";
        }
        return "登录失败";
    }
}
