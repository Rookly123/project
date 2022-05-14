package com.example.project.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.project.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<User> {
}
