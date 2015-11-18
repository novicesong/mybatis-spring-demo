package com.cn.hnust.service;

import com.cn.hnust.pojo.Person;
import com.cn.hnust.pojo.User;

public interface IUserService {
    User getUserById(int userId);

    int insert(User person);

    int insertSelective(User person);
}
