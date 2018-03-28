package com.msww.ms.user.tasks;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Scheduled(fixedRate = 300000000)
    // @Scheduled(cron = "4-40 * * * * ?")
    public void reportCurrentDate() {
        System.out.println("Current System Date: " + simpleDateFormat.format(new Date()));
    }
}
