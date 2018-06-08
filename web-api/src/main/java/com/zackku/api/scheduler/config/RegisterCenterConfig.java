package com.zackku.api.scheduler.config;

import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Zack
 * @date 2018/6/1
 */
@Configuration
public class RegisterCenterConfig {
    @Bean
    public ZookeeperConfiguration zkConfig(@Value("${elasticjob.zk.url}") final String serverLists,
                                           @Value("${elasticjob.zk.namespace}") final String namespace) {
        return new ZookeeperConfiguration(serverLists, namespace);
    }

    @Bean(initMethod = "init")
    public ZookeeperRegistryCenter regCenter(ZookeeperConfiguration config) {
        return new ZookeeperRegistryCenter(config);
    }

}
