package com.example.project.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.project.domain.Music;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MusicDao extends BaseMapper<Music> {
}
