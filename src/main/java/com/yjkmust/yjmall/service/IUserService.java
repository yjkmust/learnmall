package com.yjkmust.yjmall.service;

import com.yjkmust.yjmall.common.ServerResponse;
import com.yjkmust.yjmall.pojo.User;

public interface IUserService {
    ServerResponse register(String phone, String userName, String password);
    ServerResponse<User> login(String userName, String password);
}
