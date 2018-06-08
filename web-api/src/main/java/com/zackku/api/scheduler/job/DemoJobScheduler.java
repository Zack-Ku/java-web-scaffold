package com.zackku.api.scheduler.job;

import com.dangdang.ddframe.job.event.JobEventConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.zackku.api.scheduler.config.ElasticJobUtil;
import com.zackku.api.scheduler.job.DemoJob;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author Zack
 * @date 2018/6/1
 */
@Configuration
public class DemoJobScheduler {

    @Resource
    private ZookeeperRegistryCenter regCenter;

    @Resource
    private JobEventConfiguration jobEventConfiguration;

    @Value("${job.demojob.corn: 0 */1 * * * ?}")
    private String cron;

    @Value("${job.demojob.description: demo定时任务}")
    private String jobName;

    @Bean
    public DemoJob createdJob() {
        return new DemoJob();
    }

    @Bean(initMethod = "init")
    public JobScheduler demoJobConfig(DemoJob demoJob) {
        LiteJobConfiguration liteJobConfiguration = ElasticJobUtil.buildLiteSimpleJobConfig(demoJob.getClass(), cron);
        return new SpringJobScheduler(demoJob, regCenter, liteJobConfiguration, jobEventConfiguration);
    }
}
