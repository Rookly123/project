package com.example.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.project.domain.Music;
import org.springframework.stereotype.Service;

public interface IMusicService extends IService<Music> {
    IPage<Music> getPage(int currentPage,int pageSize,Music music);
}
