package com.example.service;

import com.example.entity.Student;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final RedisTemplate<String, Object> redisTemplate;

    public StudentService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void saveStudent(Student student) {
        redisTemplate.opsForValue().set(student.getId(), student);
    }

    public Student getStudent(String id) {
        return (Student) redisTemplate.opsForValue().get(id);
    }

    public void deleteStudent(String id) {
        redisTemplate.delete(id);
    }
}
