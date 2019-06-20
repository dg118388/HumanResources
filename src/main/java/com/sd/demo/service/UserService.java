package com.sd.demo.service;

import com.sd.demo.entity.UserBean;

public interface UserService {

    UserBean getUserById(int i);

    UserBean update(UserBean user);

    String del(int id);

}