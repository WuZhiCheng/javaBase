package com.example.disruptor.controller;

import com.example.disruptor.data.NotifyServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: wuzhicheng
 * @date: 21:15 2019/6/16
 * @company:北京今汇在线
 */
@RestController
@RequestMapping("/dis")
@Log4j2
public class DisController {
    @Autowired
    NotifyServiceImpl notifyService;

    @GetMapping("test")
    @ResponseBody
    public String testLog() {
        log.info("=============");
        notifyService.sendNotify("Hello,World!");
        return "hello,world";
    }
}
