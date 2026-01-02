package com.sinosoft.wordweb.chat.domain.entity;

import lombok.Data;

@Data
public class Word {
    /**
     * id
     */
    private Integer wordId;

    /**
     * 单词英文名
     */
    private String wordName;

    /**
     * 单词中文名
     */
    private String wordMeaning;

    /**
     * 单词分类
     */
    private String wordClassify;
}
