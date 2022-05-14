package com.example.project.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.project.controller.utils.R;
import com.example.project.domain.User;
import com.example.project.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping
    public R getAll()
    {
        return new R(true,iUserService.list());
    }

    @PostMapping
    public R save(@RequestBody User user)
    {
        return new R(iUserService.save(user));
    }

    @PutMapping
    public R update(@RequestBody User user)
    {
        return new R(iUserService.updateById(user));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id)
    {
        return new R(iUserService.removeById(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id)
    {
        return new R(true,iUserService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,User user)
    {
        IPage<User> page = iUserService.getPage(currentPage,pageSize,user);
        if(currentPage > pageSize)
        {
            page = iUserService.getPage((int)page.getSize(),pageSize,user);
        }
        return new R (true,page);
    }

}
