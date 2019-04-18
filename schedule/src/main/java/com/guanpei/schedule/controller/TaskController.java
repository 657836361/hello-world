package com.guanpei.schedule.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ScheduledFuture;

@RestController
public class TaskController {


    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Value("${test.per20Sec.cron}")
    private String cron;

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    private ScheduledFuture<?> task;

    @GetMapping("/start")
    public void start()
    {
        task = threadPoolTaskScheduler.schedule(()->{
            logger.info("开始");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {

            }
            logger.info("结束");
        },trigger->{
            return new CronTrigger(cron).nextExecutionTime(trigger);
        });

    }

    @GetMapping("/stop")
    public void stopCron1()
    {
        if(task != null){
            logger.info("是否停止成功：{}",task.cancel(true));
        }else {
            logger.info("停止失败，任务尚未启动");
        }
    }

}
