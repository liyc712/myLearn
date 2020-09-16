package com.liyc.springboot.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author lyc
 * @Date 2020-9-16 14:41
 * @ClassName SchedulerTask
 * @Description 定时任务
 */

@Component
//开启定时任务
@EnableScheduling
public class SchedulerTask {
    private static final Logger log = LoggerFactory.getLogger(SchedulerTask.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-HH:mm:ss");


    @Scheduled(cron="*/6 * * * * ?")
    private void process(){
        log.info("第一个定时任务 {}",dateFormat.format(new Date()));
    }

    @Scheduled(fixedRate = 6000)
    public void reportCurrentTime() {
        log.info("第二个定时任务：{}" ,dateFormat.format(new Date()));
    }
}
