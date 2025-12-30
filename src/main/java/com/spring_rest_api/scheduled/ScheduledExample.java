package com.spring_rest_api.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledExample {
    @Scheduled(cron = "00 38 18 * * *")
    public void writeOneToTen() {
for (int i=1;i<=10;i++)
        System.out.println(i+ " " );
    }
}
