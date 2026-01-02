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

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
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
//        if(StringUtils.isNotBlank(wordMapper.selectByName(vo.getWordName()).getWordName())
//                && StringUtils.isNotBlank(wordMapper.selectByName(vo.getWordName()).getWordMeaning())){
//        }
        if(wordMapper.selectByName(vo.getWordName()) != null)
        {
            try {
                wordMeaning = translateUtil.getTransResult(vo.getWordName());
                if(StringUtils.isBlank(wordMeaning))
                {
                    log.info("翻译结果为空");
                }
            }catch (Exception e)
            {
                log.info(e.getMessage());
            }
            word.setWordName(vo.getWordName());
            word.setWordMeaning(wordMeaning);
            word.setWordClassify(vo.getWordClassify());
            wordMapper.updateWord(word);
        }
        if(wordMapper.selectByName(vo.getWordName()) == null){
            try {
                wordMeaning = translateUtil.getTransResult(vo.getWordName());
                if(StringUtils.isBlank(wordMeaning)) {
                    log.info("翻译结果为空");
                }
            }
            catch (Exception e)
            {
                log.info(e.getMessage());
            }
            word.setWordName(vo.getWordName());
            word.setWordMeaning(wordMeaning);
            word.setWordClassify(vo.getWordClassify());
            wordMapper.save(word);
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
