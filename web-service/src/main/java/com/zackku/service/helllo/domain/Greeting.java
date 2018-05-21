package com.zackku.service.helllo.domain;

import com.zackku.common.domain.AbstractAuditableEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Zack
 * @date 2018/4/21
 */
@Data
public class Greeting extends AbstractAuditableEntity<Greeting, Long> {
    private String content;
}
