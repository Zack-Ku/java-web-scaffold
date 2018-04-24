package com.zackku.service.helllo.mapper;

import com.zackku.service.helllo.domain.Greeting;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author Zack
 * @date 2018/4/21
 */
@Component
public interface GreetingMapper {
    @Results(
            id = "greeting",
            value = {
                    @Result(property = "id", column = "id", javaType = Long.class),
                    @Result(property = "content", column = "content")
            }
    )
    @Select("select * from greeting where id=#{id}")
    Greeting findOne(@Param("id") Long id);

    @Insert("insert into greeting (content) values(#{content})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    Long insert(Greeting greeting);
}
