package com.sinosoft.wordweb.chat.service;

import com.sinosoft.wordweb.chat.domain.vo.response.LoginResponseVo;

public interface UserService {

    LoginResponseVo login(String userName, String passWord);
}
