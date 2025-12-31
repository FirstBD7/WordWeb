package com.sinosoft.wordweb.chat.service.impl;

import com.sinosoft.wordweb.chat.dao.WordDao;
import com.sinosoft.wordweb.chat.domain.entity.Word;
import com.sinosoft.wordweb.chat.domain.vo.request.AddWordVo;
import com.sinosoft.wordweb.chat.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordServiceImpl implements WordService {
    @Autowired
    private WordDao wordDao;
    @Override
    public int addWord(AddWordVo vo) {
        Word word = new Word();
        word.setWordEnglishName(vo.getWordEnglishName());
        word.setWordChineseName(vo.getWordChineseName());
        word.setWordClassify(vo.getWordClassify());
        if(wordDao.save(word))
        {
            return 1;
        }
        return 0;
    }
}
