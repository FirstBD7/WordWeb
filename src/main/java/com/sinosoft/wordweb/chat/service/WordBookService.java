package com.sinosoft.wordweb.chat.service;

import com.sinosoft.wordweb.chat.domain.vo.request.AddWordBookVo;
import com.sinosoft.wordweb.chat.domain.vo.response.ResponseBookVo;

import java.util.List;

public interface WordBookService {
    void addWord(AddWordBookVo vo);

    List<ResponseBookVo> getAll(String bookName, int userId);
}
