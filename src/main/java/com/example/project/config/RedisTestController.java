package com.example.project.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/redisTest")
public class RedisTestController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/testLock")
    public void testLock(){
        Boolean lock = redisTemplate.opsForValue().setIfAbsent("lock","111");
        if(lock)
        {
            Object value = redisTemplate.opsForValue().getAndSet("num","0");
            if(StringUtils.isEmpty(value))
            {
                return;
            }
            int num = Integer.parseInt(value+"");
            redisTemplate.opsForValue().set("num",++num);
            redisTemplate.delete("lock");
        }
        else {
            System.out.println("back");
        }
    }
}
