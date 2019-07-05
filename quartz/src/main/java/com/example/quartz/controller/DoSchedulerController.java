package com.example.quartz.controller;

import com.example.quartz.scheduler.CronScheduler;
import org.quartz.SchedulerException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 调用, 启动 HiJob
 */
@RestController
@RequestMapping("/quartz")
public class DoSchedulerController {

    @RequestMapping("/doHiJob")
    public Object doHiJob() throws SchedulerException {
//        StartScheduler.doHiJob();
        CronScheduler.cronScheduler();
        return "OK";
    }
}