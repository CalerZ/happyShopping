package com.jkq.jsqiang.mapper;

import com.jkq.jsqiang.entity.FoodSunSubscribe;
import com.jkq.jsqiang.entity.FoodSunSubscribeExample;
import com.jkq.jsqiang.entity.FoodSunSubscribeWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FoodSunSubscribeMapper {
    long countByExample(FoodSunSubscribeExample example);

    int deleteByExample(FoodSunSubscribeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FoodSunSubscribeWithBLOBs record);

    int insertSelective(FoodSunSubscribeWithBLOBs record);

    List<FoodSunSubscribeWithBLOBs> selectByExampleWithBLOBs(FoodSunSubscribeExample example);

    List<FoodSunSubscribe> selectByExample(FoodSunSubscribeExample example);

    FoodSunSubscribeWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FoodSunSubscribeWithBLOBs record, @Param("example") FoodSunSubscribeExample example);

    int updateByExampleWithBLOBs(@Param("record") FoodSunSubscribeWithBLOBs record, @Param("example") FoodSunSubscribeExample example);

    int updateByExample(@Param("record") FoodSunSubscribe record, @Param("example") FoodSunSubscribeExample example);

    int updateByPrimaryKeySelective(FoodSunSubscribeWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(FoodSunSubscribeWithBLOBs record);

    int updateByPrimaryKey(FoodSunSubscribe record);
}