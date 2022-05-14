package com.example.project.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.project.controller.utils.R;
import com.example.project.domain.Music;
import com.example.project.domain.Singer;
import com.example.project.service.IMusicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/music")
@Slf4j
public class MusicController {
    @Autowired
    private IMusicService iMusicService;
    @GetMapping
    public R getAll()
    {
        return new R(true,iMusicService.list());
    }
    @PostMapping
    public R save(@RequestBody Music music)
    {
        boolean save = iMusicService.save(music);
        return new R(save,save?"添加成功":"添加失败");
    }
    @PutMapping
    public R update(@RequestBody Music music)
    {
        return new R(iMusicService.updateById(music));
    }
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id)
    {
        return new R(iMusicService.removeById(id));
    }
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id)
    {
        return new R(true,iMusicService.getById(id));
    }
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,Music music)
    {
        IPage<Music> page = iMusicService.getPage(currentPage, pageSize, music);
        if(currentPage > page.getPages())
        {
            page = iMusicService.getPage((int)page.getPages(),pageSize,music);
        }
        return new R(true,page);
    }
}
