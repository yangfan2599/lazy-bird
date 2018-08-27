package com.lb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lb.model.RoleResource;
import com.lb.model.RoleResourceKey;

public interface RoleResourceMapper {
	
    int deleteByPrimaryKey(RoleResourceKey key);

    int deleteByRid(Long rid);

    int insert(RoleResource record);
    
    int insertBatch(@Param("rrs") List<RoleResource> rrs);

    int insertSelective(RoleResource record);

    RoleResource selectByPrimaryKey(RoleResourceKey key);

    int updateByPrimaryKeySelective(RoleResource record);

    int updateByPrimaryKey(RoleResource record);
}