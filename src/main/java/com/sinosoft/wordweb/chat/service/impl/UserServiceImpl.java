package com.sinosoft.wordweb.chat.service.impl;

import com.sinosoft.wordweb.chat.domain.vo.response.LoginResponseVo;
import com.sinosoft.wordweb.chat.mapper.UserMapper;
import com.sinosoft.wordweb.chat.service.UserService;
import com.sinosoft.wordweb.chat.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public LoginResponseVo login(String userName, String passWord) {
        LoginResponseVo loginResponseVo = new LoginResponseVo();
        if(userMapper.login(userName, passWord) != null)
        {
            loginResponseVo.setToken(JwtUtils.generateToken(userName));
            loginResponseVo.setUserName(userName);
            return loginResponseVo;
        }
        return loginResponseVo;
    }
}
