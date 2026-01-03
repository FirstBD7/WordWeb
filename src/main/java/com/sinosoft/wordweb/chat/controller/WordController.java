package com.sinosoft.wordweb.chat.controller;

import com.sinosoft.wordweb.chat.domain.vo.request.AddWordVo;
import com.sinosoft.wordweb.chat.domain.vo.response.PageResult;
import com.sinosoft.wordweb.chat.domain.vo.response.Result;
import com.sinosoft.wordweb.chat.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/word")
@RestController
public class WordController {
    @Autowired
    private WordService wordService;

    @PostMapping("/add")
    public Result<Integer> addWord(@RequestBody AddWordVo vo)
    {
        wordService.addWord(vo);
        System.out.println(vo.toString());
        return Result.success();
    }

    @GetMapping("/getAll")
    public Result<List<AddWordVo>> getWord()
    {
        return Result.success(wordService.getWord());
    }

    @DeleteMapping("/delete/{name}")
    public Result<Integer> deleteWord(@PathVariable("name") String name)
    {
        return Result.success(wordService.deleteWord(name));
    }

    @PostMapping("/getList")
    public Result<PageResult<AddWordVo>> getList(@RequestParam(defaultValue = "1") int pageNo,
                                          @RequestParam(defaultValue = "10") int pageSize)
    {
        return Result.success(wordService.getList(pageNo, pageSize));
    }
}
