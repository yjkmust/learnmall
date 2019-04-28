package com.yjkmust.yjmall.service;

import com.yjkmust.yjmall.common.ServerResponse;

public interface IUserService {
    ServerResponse register(String phone, String userName, String password);
}
