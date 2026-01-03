package com.sinosoft.wordweb.chat.service.impl;

import com.sinosoft.wordweb.chat.domain.entity.WordBook;
import com.sinosoft.wordweb.chat.domain.vo.request.AddWordBookVo;
import com.sinosoft.wordweb.chat.domain.vo.response.ResponseBookVo;
import com.sinosoft.wordweb.chat.mapper.UserMapper;
import com.sinosoft.wordweb.chat.mapper.WordBookMapper;
import com.sinosoft.wordweb.chat.mapper.WordMapper;
import com.sinosoft.wordweb.chat.service.WordBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordBookServiceImpl implements WordBookService {
    @Autowired
    private WordBookMapper wordBookMapper;
    @Autowired
    private WordMapper wordMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public void addWord(AddWordBookVo vo) {
        WordBook wordBook = new WordBook();
        wordBook.setBookName(vo.getBookName());
        wordBook.setWordId(wordMapper.selectWordIdByWordName(vo.getWordName()));
        wordBook.setUserId(userMapper.selectUserIdByUserName(vo.getUserName()));
        wordBook.setIsCollect(vo.getIsCollect());
        wordBook.setMasterStatus(vo.getMasterStatus());
        wordBookMapper.addWord(wordBook);
    }

    @Override
    public List<ResponseBookVo> getAll(String bookName, String userName) {
        return wordBookMapper.getAll(bookName, userMapper.selectUserIdByUserName(userName));
    }
}
