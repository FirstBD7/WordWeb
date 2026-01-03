package com.sinosoft.wordweb.chat.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WordBook {
    private int id;
    private String bookName;
    private int userId;
    private int wordId;
    private int masterStatus;
    private int isCollect;
}
