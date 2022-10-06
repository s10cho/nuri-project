package com.nuri.batch.service;

import static java.time.LocalDateTime.now;

import org.jobrunr.jobs.JobId;
import org.jobrunr.scheduling.BackgroundJob;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    static {
        System.out.println(1);
        JobId jobId = BackgroundJob.schedule(now().plusMinutes(1), () -> System.out.println("1234"));
    }

}
