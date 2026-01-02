package com.sinosoft.wordweb.chat.mapper;

import com.sinosoft.wordweb.chat.domain.entity.Word;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WordMapper {

    boolean save(Word word);

    List<Word> list();

    Word selectByName(String wordName);

    Integer removeByName(String wordName);

    boolean updateWord(Word word);

    boolean updateSelectTimes(String wordName);
}
