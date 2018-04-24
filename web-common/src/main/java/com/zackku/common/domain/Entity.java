package com.zackku.common.domain;

import java.io.Serializable;

/**
 * @author Zack
 * @date 2018/4/24
 */
public interface Entity<T extends Entity<T, ID>, ID extends Serializable> extends Serializable {
    ID getId();

    void setId(ID id);
}
