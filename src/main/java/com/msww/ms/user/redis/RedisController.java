package com.msww.ms.user.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msww.ms.utils.MSWWJsonResult;


@RestController
@RequestMapping(value = "redis")
public class RedisController {
    @Autowired
    private StringRedisTemplate strRedisTemplate;

    @RequestMapping(value = "test")
    public MSWWJsonResult redis() {
        strRedisTemplate.opsForValue().set("andy", "Hello Andy");
        return MSWWJsonResult.ok(strRedisTemplate.opsForValue().get("andy"));
    }
}
