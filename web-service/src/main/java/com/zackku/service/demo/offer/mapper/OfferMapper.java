package com.zackku.service.demo.offer.mapper;

import java.util.List;

import com.zackku.common.core.MapperInterface;
import com.zackku.service.demo.offer.domain.Offer;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface OfferMapper extends MapperInterface {
    @Delete({
            "delete from offer",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
            "insert into offer (total_amount, rest_amount)",
            "values (#{totalAmount,jdbcType=INTEGER}, #{restAmount,jdbcType=INTEGER})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    int insert(Offer record);

    @Select({
            "select",
            "id, total_amount, rest_amount",
            "from offer",
            "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "total_amount", property = "totalAmount", jdbcType = JdbcType.INTEGER),
            @Result(column = "rest_amount", property = "restAmount", jdbcType = JdbcType.INTEGER)
    })
    Offer selectByPrimaryKey(Long id);

    @Select({
            "select",
            "id, total_amount, rest_amount",
            "from offer"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "total_amount", property = "totalAmount", jdbcType = JdbcType.INTEGER),
            @Result(column = "rest_amount", property = "restAmount", jdbcType = JdbcType.INTEGER)
    })
    List<Offer> selectAll();

    @Update({
            "update offer",
            "set total_amount = #{totalAmount,jdbcType=INTEGER},",
            "rest_amount = #{restAmount,jdbcType=INTEGER}",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Offer record);
}