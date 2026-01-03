package com.sinosoft.wordweb.chat.mapStruct;

import com.sinosoft.wordweb.chat.domain.entity.Word;
import com.sinosoft.wordweb.chat.domain.vo.request.AddWordVo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

// 全局通用映射器：忽略未匹配字段，支持所有简单映射
@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE // 全局忽略未匹配的字段，无需逐个配置
)
public interface GlobalObjectConverter {

    // 按需添加通用映射方法，支持不同实体/VO的组合
//    <T> T convert(Object source, Class<T> targetType); // 通用泛型方法（注：MapStruct不直接支持泛型动态映射，需显式声明具体方法）

    // 显式声明常用映射（字段名一致时无需@Mapping注解）
//    AddWordVo wordToAddWordVo(Word word);

    // 批量映射
    List<AddWordVo> wordListToAddWordVoList(List<Word> wordList);
}
