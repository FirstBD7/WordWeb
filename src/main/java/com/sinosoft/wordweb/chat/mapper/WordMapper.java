package com.sinosoft.wordweb.chat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sinosoft.wordweb.chat.domain.entity.Word;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WordMapper extends BaseMapper<Word> {

}
