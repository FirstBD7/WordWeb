package com.sinosoft.wordweb.chat.mapper;

import com.sinosoft.wordweb.chat.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User login(@Param("userName") String userName, @Param("passWord") String passWord);
}
