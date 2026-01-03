package com.sinosoft.wordweb.chat.controller;

import com.sinosoft.wordweb.chat.domain.vo.request.AddWordBookVo;
import com.sinosoft.wordweb.chat.domain.vo.response.ResponseBookVo;
import com.sinosoft.wordweb.chat.domain.vo.response.Result;
import com.sinosoft.wordweb.chat.service.WordBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/wordBook")
@RestController
public class WordBookController {
    @Autowired
    private WordBookService wordBookService;

    @PostMapping("/addWord")
    public Result<AddWordBookVo> addWordBook(@RequestBody AddWordBookVo vo) {
        wordBookService.addWord(vo);
        return Result.success();
    }

    @GetMapping("/getAll")
    public Result<List<ResponseBookVo>> getWordBookAll(@RequestParam(defaultValue = "默认单词本") String bookName,
                                                       @RequestParam Integer userId){
        return Result.success(wordBookService.getAll(bookName, userId));
    }
}
