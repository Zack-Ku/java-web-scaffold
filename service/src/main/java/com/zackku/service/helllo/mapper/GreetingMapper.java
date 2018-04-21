package com.zackku.service.helllo.mapper;

import com.zackku.service.helllo.domain.Greeting;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Component;

/**
 * @author Zack
 * @date 2018/4/21
 */
@Component
public interface GreetingMapper {
    @Insert("insert into greeting (content) values(#{content})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    Long insert(Greeting greeting);
}
