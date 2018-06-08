package com.zackku.api.scheduler.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.zackku.common.LogUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author Zack
 * @date 2018/6/1
 */
@Slf4j
public class DemoJob implements SimpleJob {
    private static int count = 1;

    @Override
    public void execute(ShardingContext shardingContext) {
        count++;
        LogUtil.info(log, "demo scheduler", "processing,date:{},count:{}", new Date(), count);
    }
}
