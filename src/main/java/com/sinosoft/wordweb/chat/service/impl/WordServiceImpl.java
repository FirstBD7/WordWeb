package com.sinosoft.wordweb.chat.service.impl;

import com.sinosoft.wordweb.chat.domain.entity.Word;
import com.sinosoft.wordweb.chat.domain.vo.request.AddWordVo;
import com.sinosoft.wordweb.chat.mapper.WordMapper;
import com.sinosoft.wordweb.chat.service.WordService;
import com.sinosoft.wordweb.chat.utils.TranslateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class WordServiceImpl implements WordService {
    @Autowired
    private WordMapper wordMapper;
    TranslateUtil translateUtil = new TranslateUtil();
    @Override
    public void addWord(AddWordVo vo) {
        String wordMeaning = null;
        Word word = new Word();
        Word wordFlag = wordMapper.selectByName(vo.getWordName());

        if(wordFlag != null)
        {
            try {
                if(StringUtils.isBlank(wordFlag.getWordMeaning()))
                {
                    wordMeaning = translateUtil.getTransResult(vo.getWordName());
                    word.setWordName(vo.getWordName());
                    word.setWordMeaning(wordMeaning);
                    word.setWordClassify(vo.getWordClassify());
                    wordMapper.updateWord(word);
                }
                wordMapper.updateSelectTimes(vo.getWordName());
            }catch (Exception e)
            {
                log.info(e.getMessage());
            }
        }
        if(wordFlag == null){
            try {
                wordMeaning = translateUtil.getTransResult(vo.getWordName());
                word.setWordName(vo.getWordName());
                word.setWordMeaning(wordMeaning);
                word.setWordClassify(vo.getWordClassify());
                wordMapper.save(word);
            }
            catch (Exception e)
            {
                log.info(e.getMessage());
            }
        }
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
