package com.sinosoft.wordweb.chat.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("word")
public class Word {
    /**
     * id
     */
    @TableId(value = "word_id", type = IdType.AUTO)
    private Integer wordId;

    /**
     * 单词英文名
     */
    @TableField(value = "word_english_name")
    private String wordEnglishName;

    /**
     * 单词中文名
     */
    @TableField(value = "word_chinese_name")
    private String wordChineseName;

    /**
     * 单词分类
     */
    @TableField(value = "word_classify")
    private String wordClassify;
}
