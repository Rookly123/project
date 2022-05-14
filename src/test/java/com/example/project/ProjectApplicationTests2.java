package com.example.project;

import com.example.project.domain.Music;
import com.example.project.domain.Singer;
import com.example.project.service.IMusicService;
import com.example.project.service.ISinerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProjectApplicationTests2 {
    @Autowired
    private ISinerService iSinerService;
    @Autowired
    private IMusicService iMusicService;
    @Test
    void tes()
    {
        List<Singer> list = iSinerService.list();
    }
    @Test
    void tes2()
    {
        List<Music> list = iMusicService.list();
    }
}
