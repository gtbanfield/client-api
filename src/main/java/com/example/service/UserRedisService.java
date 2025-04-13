package com.example.service;


import com.example.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.data.redis.core.RedisTemplate;

@Service
public class UserRedisService {
    private final RedisTemplate<String, User> redisTemplate;

    public UserRedisService(RedisTemplate<String, User> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void saveUser(User user) {
        redisTemplate.opsForValue().set(user.getId(), user);
    }

    public User getUser(String userId) {
        return redisTemplate.opsForValue().get(userId);
    }
}
