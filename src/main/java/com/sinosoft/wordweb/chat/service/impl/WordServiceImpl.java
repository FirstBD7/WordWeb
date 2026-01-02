package com.sinosoft.wordweb.chat.service.impl;

import com.sinosoft.wordweb.chat.domain.entity.Word;
import com.sinosoft.wordweb.chat.domain.vo.request.AddWordVo;
import com.sinosoft.wordweb.chat.mapper.WordMapper;
import com.sinosoft.wordweb.chat.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordServiceImpl implements WordService {
    @Autowired
    private WordMapper wordMapper;

    @Override
    public int addWord(AddWordVo vo) {
        Word word = new Word();
        word.setWordName(vo.getWordName());
        word.setWordMeaning(vo.getWordMeaning());
        word.setWordClassify(vo.getWordClassify());
        if(wordMapper.save(word))
        {
            return 1;
        }
        return 0;
    }

    @Override
    public List<Word> getWord() {
        return wordMapper.list();
    }

    @Override
    public Integer deleteWord(String wordName) {
        return wordMapper.removeByName(wordName);
    }
}
