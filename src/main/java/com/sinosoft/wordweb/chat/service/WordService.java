package com.sinosoft.wordweb.chat.service;

import com.github.pagehelper.PageInfo;
import com.sinosoft.wordweb.chat.domain.entity.Word;
import com.sinosoft.wordweb.chat.domain.vo.request.AddWordVo;
import com.sinosoft.wordweb.chat.domain.vo.response.PageResult;

import java.util.List;

public interface WordService {
    void addWord(AddWordVo vo);

    List<AddWordVo> getWord();

    Integer deleteWord(String wordName);

    PageResult<AddWordVo> getList(int pageNo, int pageSize);
}
