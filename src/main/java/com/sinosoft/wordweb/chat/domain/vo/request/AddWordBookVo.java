package com.sinosoft.wordweb.chat.domain.vo.request;

import lombok.Data;

@Data
public class AddWordBookVo {
    private String bookName;
    private int userId;
    private int wordId;
    private int masterStatus;
    private int isCollect;
}
