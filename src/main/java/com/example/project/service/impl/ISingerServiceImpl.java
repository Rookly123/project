package com.example.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.project.dao.SingerDao;
import com.example.project.domain.Singer;
import com.example.project.service.ISinerService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//作用同@Mapper，都是把当前类注入到Spring容器中
@Service
public class ISingerServiceImpl extends ServiceImpl<SingerDao,Singer> implements ISinerService {
    @Autowired
    private SingerDao singerDao;


    @Override
    public IPage<Singer> getPage(int currentPage, int pageSize, Singer singer) {
        LambdaQueryWrapper<Singer> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //模糊查询
        lambdaQueryWrapper.like(Strings.isNotEmpty(singer.getSingerName()),Singer::getSingerName,singer.getSingerName());
        lambdaQueryWrapper.like(Strings.isNotEmpty(singer.getSingerType()),Singer::getSingerType,singer.getSingerType());
        lambdaQueryWrapper.like(Strings.isNotEmpty(singer.getSingerPortrait()),Singer::getSingerPortrait,singer.getSingerPortrait());
        IPage page = new Page(currentPage,pageSize);
        singerDao.selectPage(page,lambdaQueryWrapper);
        return page;
    }
}
