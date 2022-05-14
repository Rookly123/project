package com.example.project.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.project.domain.Singer;
import org.apache.ibatis.annotations.Mapper;

//使用Dao层进行CRUD
@Mapper
public interface SingerDao extends BaseMapper<Singer> {
}
