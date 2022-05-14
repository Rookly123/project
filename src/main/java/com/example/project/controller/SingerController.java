package com.example.project.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.project.controller.utils.R;
import com.example.project.domain.Singer;
import com.example.project.service.ISinerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//将当前修饰的类加入SpringBoot IoC容器，使得从该类所在的项目跑起来后这个类就被实例化;并且该类所有方法的返回数据被定为json字符串的形式返回给客户端
@RestController
//在Spring MVC 中使用 @RequestMapping 来映射请求
@RequestMapping("/singers")
@Slf4j
public class SingerController {

    @Autowired
    private ISinerService iSinerService;
    //@GetMapping表示查询
    @GetMapping
    public R getAll(){
        return new R(true,iSinerService.list());
    }
    //@RequestBody 接受来自客户端的数据，@PostMapping表示增加
    @PostMapping
    public R save(@RequestBody Singer singer)
    {
        boolean flag = iSinerService.save(singer);
        return new R(flag,flag?"添加成功":"添加失败");
    }
    @PutMapping
    public R update(@RequestBody Singer singer)
    {
        return new R(iSinerService.updateById(singer));
    }
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id)
    {
        return new R(iSinerService.removeById(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id)
    {
        return new R(true,iSinerService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,Singer singer)
    {
        IPage<Singer> page = iSinerService.getPage(currentPage, pageSize, singer);
        if(currentPage > page.getPages())
        {
            page = iSinerService.getPage((int)page.getPages(),pageSize,singer);
        }
        return new R(true,page);
    }
}
