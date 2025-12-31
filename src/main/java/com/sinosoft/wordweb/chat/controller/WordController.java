package com.sinosoft.wordweb.chat.controller;


import com.sinosoft.wordweb.chat.domain.vo.request.AddWordVo;
import com.sinosoft.wordweb.chat.domain.vo.response.Result;
import com.sinosoft.wordweb.chat.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
