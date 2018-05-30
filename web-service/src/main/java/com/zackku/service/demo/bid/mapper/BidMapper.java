package com.zackku.service.demo.bid.mapper;

import java.util.List;

import com.zackku.common.core.MapperInterface;
import com.zackku.service.demo.bid.domain.Bid;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface BidMapper extends MapperInterface{
    @Delete({
        "delete from bid",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into bid (total_amount, rest_amount, ",
        "portfolio_id)",
        "values (#{totalAmount,jdbcType=INTEGER}, #{restAmount,jdbcType=INTEGER}, ",
        "#{portfolioId,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(Bid record);

    @Select({
        "select",
        "id, total_amount, rest_amount, portfolio_id",
        "from bid",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="total_amount", property="totalAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="rest_amount", property="restAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="portfolio_id", property="portfolioId", jdbcType=JdbcType.INTEGER)
    })
    Bid selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, total_amount, rest_amount, portfolio_id",
        "from bid"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="total_amount", property="totalAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="rest_amount", property="restAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="portfolio_id", property="portfolioId", jdbcType=JdbcType.INTEGER)
    })
    List<Bid> selectAll();

    @Update({
        "update bid",
        "set total_amount = #{totalAmount,jdbcType=INTEGER},",
          "rest_amount = #{restAmount,jdbcType=INTEGER},",
          "portfolio_id = #{portfolioId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Bid record);
}