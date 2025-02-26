package com.javatechie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Date;

@Service
public class JobService {

    @Autowired
    private NotificationService service;

    @Scheduled(cron = "${cron_interval}",zone = "IST")
    public void process() {
        System.out.println("job started on " + new Date());
        try {
            service.sendDailyReports();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
