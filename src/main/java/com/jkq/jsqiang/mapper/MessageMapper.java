package com.jkq.jsqiang.mapper;

import com.jkq.jsqiang.entity.Message;
import com.jkq.jsqiang.entity.MessageExample;
import com.jkq.jsqiang.entity.MessageWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageMapper {
    long countByExample(MessageExample example);

    int deleteByExample(MessageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MessageWithBLOBs record);

    int insertSelective(MessageWithBLOBs record);

    List<MessageWithBLOBs> selectByExampleWithBLOBs(MessageExample example);

    List<Message> selectByExample(MessageExample example);

    MessageWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MessageWithBLOBs record, @Param("example") MessageExample example);

    int updateByExampleWithBLOBs(@Param("record") MessageWithBLOBs record, @Param("example") MessageExample example);

    int updateByExample(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByPrimaryKeySelective(MessageWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(MessageWithBLOBs record);

    int updateByPrimaryKey(Message record);
}