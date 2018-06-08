package com.zackku.service.hello.service.impl;

import com.zackku.common.LogUtil;
import com.zackku.service.hello.domain.Greeting;
import com.zackku.service.hello.mapper.GreetingMapper;
import com.zackku.service.hello.service.GreetingService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Zack
 * @date 2018/4/21
 */
@Service
@Slf4j
public class GreetingServiceImpl implements GreetingService {
    private static final String TEMPLATE = "this is %s!";

    private GreetingMapper greetingMapper;

    @Autowired
    public GreetingServiceImpl(GreetingMapper greetingMapper) {
        this.greetingMapper = greetingMapper;
    }

    @Override
    @CachePut(cacheNames = "greeting", key = "#result.id")
    public Greeting createGreet(String name) {
        Greeting greeting = new Greeting();
        greeting.setContent(String.format(TEMPLATE, name));
        LogUtil.info(log, "create greet", "greeting:{}", greeting);
        greetingMapper.insert(greeting);
        return greeting;
    }

    @Override
    @Cacheable(value = "greeting", key = "#id")
    public Greeting findGreat(Long id) {
        Greeting greeting = greetingMapper.findOne(id);
        return greeting;
    }

    @Override
    public List<Greeting> findGreats(String content, Integer offset, Integer rows) {
        List<Greeting> greets = greetingMapper.find(content, offset, rows);

        return greets;
    }
}
