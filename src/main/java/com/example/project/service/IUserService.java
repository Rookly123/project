package com.example.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.project.domain.User;

public interface IUserService extends IService<User> {
    IPage<User> getPage(int currentPage,int pageSize,User user);
}
