package com.zackku.service.hello.service;

import com.zackku.service.hello.domain.Greeting;

import java.util.List;

/**
 * @author Zack
 * @date 2018/5/21
 */
public interface GreetingService {
    Greeting createGreet(String name);

    Greeting findGreat(Long id);

    List<Greeting> findGreats(String content, Integer offset, Integer rows);
}
