package com.zackku.service.helllo.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Zack
 * @date 2018/4/21
 */
@Data
public class Greeting implements Serializable {
    private Long id;

    private String content;
}
