package com.zackku.api.scheduler.config;

import com.dangdang.ddframe.job.api.ElasticJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;

/**
 * @author Zack
 * @date 2018/6/8
 */
public class ElasticJobUtil {

    /**
     * 生成LiteJobConfiguration，overwrite、simple
     * @param jobClass
     * @param cron
     * @return
     */
    public static LiteJobConfiguration buildLiteSimpleJobConfig(Class<? extends ElasticJob> jobClass, String cron) {
        JobCoreConfiguration jobCoreConfiguration = JobCoreConfiguration.newBuilder(jobClass.getName(), cron, 1).build();
        SimpleJobConfiguration simpleJobConfiguration = new SimpleJobConfiguration(jobCoreConfiguration,jobClass.getCanonicalName());
        return LiteJobConfiguration.newBuilder(simpleJobConfiguration).overwrite(true).build();
    }

}
