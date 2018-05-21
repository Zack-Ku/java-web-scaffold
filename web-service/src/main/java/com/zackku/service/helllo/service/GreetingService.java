package com.zackku.service.helllo.service;

import com.zackku.service.helllo.domain.Greeting;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * @author Zack
 * @date 2018/5/21
 */
public interface GreetingService {
    @CachePut(cacheNames = "greeting", key = "#result.id")
    Greeting createGreet(String name);

    @Cacheable(value = "greeting", key = "#id")
    Greeting findGreat(Long id);

    List<Greeting> findGreats(String content, Integer offset, Integer rows);
}
