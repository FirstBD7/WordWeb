package com.sinosoft.wordweb.chat.domain.entity;

import lombok.Data;

import java.util.Date;


@Data
public class User {
    /**
     * id
     */
    private Integer userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String passWord;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 最后更新时间
     */
    private Date updateTime;
}
