package com.zackku.service.hello.domain;

import com.zackku.common.domain.AbstractAuditableEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zack
 * @date 2018/4/21
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Greeting extends AbstractAuditableEntity<Greeting, Long> {
    private String content;
}
