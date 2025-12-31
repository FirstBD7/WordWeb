package com.sinosoft.wordweb.chat.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sinosoft.wordweb.chat.domain.entity.Word;
import com.sinosoft.wordweb.chat.mapper.WordMapper;
import org.springframework.stereotype.Service;

@Service
public class WordDao extends ServiceImpl<WordMapper, Word> {

}
