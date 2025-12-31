package com.sinosoft.wordweb.chat.controller;


import com.sinosoft.wordweb.chat.domain.vo.request.AddWordVo;
import com.sinosoft.wordweb.chat.domain.vo.response.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/word")
public class WordController {

    @PostMapping("/add")
    public Result<String> addWord(@RequestBody AddWordVo vo)
    {
        System.out.println(vo);
        return Result.success("添加成功");
    }
}
