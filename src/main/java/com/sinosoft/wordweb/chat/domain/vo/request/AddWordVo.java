package com.sinosoft.wordweb.chat.domain.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("添加单词请求体")
public class AddWordVo {
    @ApiModelProperty("单词英文名")
    private String wordName;
    @ApiModelProperty("单词中文名")
    private String wordMeaning;
    @ApiModelProperty("单词分类")
    private String wordClassify;
}
