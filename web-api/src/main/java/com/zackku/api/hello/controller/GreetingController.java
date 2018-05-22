package com.zackku.api.hello.controller;

import com.zackku.service.hello.domain.Greeting;
import com.zackku.service.hello.service.GreetingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Zack
 * @date 2018/4/21
 */
@RestController
@RequestMapping("/greeting")
public class GreetingController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingController.class);
    private GreetingService greetingService;

    @Autowired
    public GreetingController(GreetingService greetService) {
        this.greetingService = greetService;
    }

    @RequestMapping("")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        Greeting greeting = greetingService.createGreet(name);
        return greeting;
    }

    @RequestMapping("/find")
    public Greeting findOne(@RequestParam(value = "id") Long id) {
        Greeting greeting = greetingService.findGreat(id);
        return greeting;
    }

    @RequestMapping("/findList")
    public List<Greeting> find(@RequestParam(value = "content") String content,
                               @RequestParam(value = "offset", defaultValue = "0") Integer offset,
                               @RequestParam(value = "rows", defaultValue = "2") Integer rows) {
        List<Greeting> greets = greetingService.findGreats(content, offset, rows);
        return greets;
    }

}
