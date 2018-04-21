package com.zackku.service.helllo.service;

import com.zackku.service.helllo.domain.Greeting;
import com.zackku.service.helllo.mapper.GreetingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Zack
 * @date 2018/4/21
 */
@Service
public class GreetingService {
    private static final String TEMPLATE = "this is %s!";
    private final AtomicLong counter = new AtomicLong();

    private GreetingMapper greetingMapper;

    @Autowired
    public GreetingService(GreetingMapper greetingMapper) {
        this.greetingMapper = greetingMapper;
    }

    public Greeting createGreet(String name) {
        Greeting greeting = new Greeting();
        greeting.setId(counter.incrementAndGet());
        greeting.setContent(String.format(TEMPLATE, name));
        greetingMapper.insert(greeting);
        return greeting;
    }
}
