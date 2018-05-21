package com.zackku.service.helllo.mapper;

import com.zackku.service.helllo.domain.Greeting;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

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
                    @Result(property = "content", column = "content"),
                    @Result(property = "createdBy", column = "created_by"),
                    @Result(property = "createdDate", column = "created_date"),
                    @Result(property = "lastModifiedBy", column = "last_modified_by"),
                    @Result(property = "lastModifiedDate", column = "last_modified_date")
            }
    )
    @Select("select * from greeting where id=#{id}")
    Greeting findOne(@Param("id") Long id);

    @Insert("insert into greeting (content,created_by,created_date,last_modified_by,last_modified_date) " +
            "values(#{content},'system',now(),'system',now())")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    Long insert(Greeting greeting);

    @Select("select * from greeting where content=#{content} limit #{offset},#{rows}")
    @ResultMap("greeting")
    List<Greeting> find(@Param("content") String content, @Param("offset") Integer offset, @Param("rows") Integer rows);
}
