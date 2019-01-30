package com.hzh.demo.mapper;

import com.hzh.demo.model.Rvi;
import com.hzh.demo.model.RviExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RviMapper {
    long countByExample(RviExample example);

    int deleteByExample(RviExample example);

    int deleteByPrimaryKey(String userid);

    int insert(Rvi record);

    int insertSelective(Rvi record);

    List<Rvi> selectByExample(RviExample example);

    Rvi selectByPrimaryKey(String userid);

    int updateByExampleSelective(@Param("record") Rvi record, @Param("example") RviExample example);

    int updateByExample(@Param("record") Rvi record, @Param("example") RviExample example);

    int updateByPrimaryKeySelective(Rvi record);

    int updateByPrimaryKey(Rvi record);
}