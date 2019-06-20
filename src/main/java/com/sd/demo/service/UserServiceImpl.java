package com.sd.demo.service;

import com.sd.demo.entity.UserBean;
import com.sd.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames="users")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Cacheable(key="'userCache'")
    @Override
    public UserBean getUserById(int i) {
        System.out.println("执行这里，说明缓存中读取不到数据，直接读取数据库....");
        return userMapper.findOne(i);
    }

    @CachePut(key="'userCache'")
    @Override
    public UserBean update(UserBean user) {
        System.out.println("执行这里，更新数据库，更新缓存....");
        return userMapper.save(user);
    }

    @CacheEvict(key="'userCache'")
    @Override
    public String del(int id) {
        userMapper.delete(id);
        return "删除成功！！！！";
    }



}