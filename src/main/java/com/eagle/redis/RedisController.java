package com.eagle.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
//import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

@RestController
@RequestMapping("redis")
@Slf4j
public class RedisController {
    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("/getset")
    public String redisSetGet(){
        redisTemplate.opsForValue().set("a", "1");
        String value = redisTemplate.opsForValue().get("a");
        log.info("Value of 'a' is: {}", value);
        return "ok";
    }

    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;

    @GetMapping("/setget2")
    public String redisSetGet2() {
        redisTemplate.opsForValue().set("aaaa", "1");
        System.out.println("jedisConnectionFactory.getHostName() " + jedisConnectionFactory.getHostName());
        System.out.println(jedisConnectionFactory);
        try (Jedis jedis = (Jedis) jedisConnectionFactory.getConnection().getNativeConnection()) {
            String value = jedis.get("aaaa");
            log.info("Value of 'aaaa' is: {}", value);
        } catch (Exception e) {
            log.error("Error when getting value from Redis using Jedis", e);
        }

        return "ok";
    }
}
