package com.jkq.jsqiang.mapper;

import com.jkq.jsqiang.entity.Foods;
import com.jkq.jsqiang.entity.FoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FoodsMapper {
    long countByExample(FoodsExample example);

    int deleteByExample(FoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Foods record);

    int insertSelective(Foods record);

    List<Foods> selectByExample(FoodsExample example);

    Foods selectByPrimaryKey(int id);

    int updateByExampleSelective(@Param("record") Foods record, @Param("example") FoodsExample example);

    int updateByExample(@Param("record") Foods record, @Param("example") FoodsExample example);

    int updateByPrimaryKeySelective(Foods record);

    int updateByPrimaryKey(Foods record);
}