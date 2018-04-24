package com.zackku.common.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * @author Zack
 * @date 2018/4/24
 */
public abstract class AbstractEntity<T extends AbstractEntity<T, ID>, ID extends Serializable> implements Entity<T, ID> {

    protected ID id;

    @Override
    public ID getId() {
        return id;
    }

    @Override
    public void setId(ID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
