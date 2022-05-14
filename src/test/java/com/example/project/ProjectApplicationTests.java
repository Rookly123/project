package com.example.project;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.project.dao.MusicDao;
import com.example.project.dao.SingerDao;
import com.example.project.domain.Music;
import com.example.project.domain.Singer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjectApplicationTests {
    //
    @Autowired
    private MusicDao musicDao;
    @Test
    void contextLoads() {
        QueryWrapper<Music> queryWrapper = new QueryWrapper<>();
        musicDao.selectList(queryWrapper);
    }

}
