package com.hhx.web_code.gee100;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author hhx
 * @date 2022/7/22
 * @note
 */
public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("MyJob.execute");
    }

    public static void main(String[] args) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withIdentity("myJob1","group1").build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger1","group3")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(2)
                        .repeatForever()).build();

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();

        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();
    }
}
