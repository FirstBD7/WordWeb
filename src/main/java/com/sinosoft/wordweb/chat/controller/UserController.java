package com.sinosoft.wordweb.chat.controller;

import com.alibaba.fastjson.JSONObject;
import com.sinosoft.wordweb.chat.domain.vo.response.Result;
import com.sinosoft.wordweb.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result<String> login(@RequestBody String user) {
        JSONObject jsonObject = JSONObject.parseObject(user);
        String userName = jsonObject.getString("userName");
        String passWord = jsonObject.getString("passWord");
        return Result.success(userService.login(userName, passWord));
    }
}
