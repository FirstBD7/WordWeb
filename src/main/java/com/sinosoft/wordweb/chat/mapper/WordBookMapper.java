package com.sinosoft.wordweb.chat.mapper;

import com.sinosoft.wordweb.chat.domain.entity.WordBook;
import com.sinosoft.wordweb.chat.domain.vo.response.ResponseBookVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WordBookMapper {

    void addWord(WordBook wordBook);

    List<ResponseBookVo> getAll(String bookName, int userId);
}
