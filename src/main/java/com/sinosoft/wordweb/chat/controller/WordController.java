package com.sinosoft.wordweb.chat.controller;

import com.sinosoft.wordweb.chat.domain.entity.Word;
import com.sinosoft.wordweb.chat.domain.vo.request.AddWordVo;
import com.sinosoft.wordweb.chat.domain.vo.response.Result;
import com.sinosoft.wordweb.chat.service.WordService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/word")
@RestController
public class WordController {
    @Autowired
    private WordService wordService;

    @PostMapping("/add")
    public Result<Integer> addWord(@RequestBody AddWordVo vo)
    {
        int addWordNum = wordService.addWord(vo);
        System.out.println(vo.toString());
        return Result.success(addWordNum);
    }

    @GetMapping("/getAll")
    public Result<List<Word>> getWord()
    {
        return Result.success(wordService.getWord());
    }

    @DeleteMapping("/delete/{name}")
    public Result<Integer> deleteWord(@PathVariable("name") String name)
    {
        return Result.success(wordService.deleteWord(name));
    }
}
