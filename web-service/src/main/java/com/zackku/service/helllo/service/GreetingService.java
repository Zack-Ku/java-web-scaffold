package com.zackku.service.helllo.service;

import com.zackku.common.LogUtil;
import com.zackku.service.helllo.domain.Greeting;
import com.zackku.service.helllo.mapper.GreetingMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author Zack
 * @date 2018/4/21
 */
@Service
public class GreetingService {
    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingService.class);
    private static final String TEMPLATE = "this is %s!";

    private GreetingMapper greetingMapper;

    @Autowired
    public GreetingService(GreetingMapper greetingMapper) {
        this.greetingMapper = greetingMapper;
    }

    @CachePut(cacheNames = "greeting", key = "#result.id")
    public Greeting createGreet(String name) {
        Greeting greeting = new Greeting();
        greeting.setContent(String.format(TEMPLATE, name));
        LogUtil.info(LOGGER, "create greet", "greeting:{}", greeting);
        greetingMapper.insert(greeting);
        return greeting;
    }

    @Cacheable(value = "greeting", key = "#id")
    public Greeting findGreat(Long id) {
        Greeting greeting = greetingMapper.findOne(id);
        return greeting;
    }
}
