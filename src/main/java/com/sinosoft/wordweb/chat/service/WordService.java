package com.sinosoft.wordweb.chat.service;

import com.sinosoft.wordweb.chat.domain.entity.Word;
import com.sinosoft.wordweb.chat.domain.vo.request.AddWordVo;

import java.util.List;

public interface WordService {
    int addWord(AddWordVo vo);

    List<Word> getWord();

    Integer deleteWord(String wordName);
}
