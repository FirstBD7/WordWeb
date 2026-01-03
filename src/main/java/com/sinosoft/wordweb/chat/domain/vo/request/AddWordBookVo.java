package com.sinosoft.wordweb.chat.domain.vo.request;

import lombok.Data;

@Data
public class AddWordBookVo {
    private String bookName;
    private String userName;
    private String wordName;
    private int masterStatus;
    private int isCollect;
}
