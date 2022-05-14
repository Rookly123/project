package com.example.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.project.domain.Singer;

//使用Service层进行CRUD

public interface ISinerService extends IService<Singer> {
    IPage<Singer> getPage(int currentPage, int pageSize , Singer singer);
}
