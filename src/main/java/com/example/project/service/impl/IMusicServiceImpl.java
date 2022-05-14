package com.example.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.project.dao.MusicDao;
import com.example.project.domain.Music;
import com.example.project.service.IMusicService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IMusicServiceImpl extends ServiceImpl<MusicDao,Music> implements IMusicService {
    @Autowired
    private MusicDao musicDao;
    @Override
    public IPage<Music> getPage(int currentPage, int pageSize, Music music) {
        LambdaQueryWrapper<Music> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Strings.isNotEmpty(music.getMusicName()),Music::getMusicName,music.getMusicName());
        lambdaQueryWrapper.like(Strings.isNotEmpty(music.getMusicType()),Music::getMusicType,music.getMusicType());
        IPage<Music> page = new Page(currentPage,pageSize);
        musicDao.selectPage(page, lambdaQueryWrapper);
        return page;
    }
}
