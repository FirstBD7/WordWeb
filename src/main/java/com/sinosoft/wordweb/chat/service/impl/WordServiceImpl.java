package com.sinosoft.wordweb.chat.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sinosoft.wordweb.chat.domain.entity.Word;
import com.sinosoft.wordweb.chat.domain.vo.request.AddWordVo;
import com.sinosoft.wordweb.chat.domain.vo.response.PageResult;
import com.sinosoft.wordweb.chat.mapStruct.GlobalObjectConverter;
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
    @Autowired
    private GlobalObjectConverter converter;
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
    public List<AddWordVo> getWord() {
        return converter.wordListToAddWordVoList(wordMapper.list());
    }

    @Override
    public Integer deleteWord(String wordName) {
        return wordMapper.removeByName(wordName);
    }

//    public List<AddWordVo> wordListToAddWordVoList(List<Word> wordList) {
//        // 将List<word>转成List<AddWordVo>
//        return converter.wordListToAddWordVoList(wordList);
//    }

    @Override
    public PageResult<AddWordVo> getList(int pageNo, int pageSize) {
        //开启分页查询
        PageHelper.startPage(pageNo, pageSize);
        //查询所有的数据
        List<Word> list = wordMapper.list();
        //把数据进行分页
        PageInfo<Word> pageInfo = new PageInfo<>(list);
        //把分页结果返回
        PageResult<AddWordVo> pageResult = new PageResult<>();
        pageResult.setItems(converter.wordListToAddWordVoList(pageInfo.getList()));
        pageResult.setTotal(pageInfo.getTotal());
        pageResult.setPageNo(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        return pageResult;
    }
}
