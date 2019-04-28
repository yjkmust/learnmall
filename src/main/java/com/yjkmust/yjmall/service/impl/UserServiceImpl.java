package com.yjkmust.yjmall.service.impl;

import com.yjkmust.yjmall.common.Const;
import com.yjkmust.yjmall.common.ServerResponse;
import com.yjkmust.yjmall.dao.UserMapper;
import com.yjkmust.yjmall.pojo.User;
import com.yjkmust.yjmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("iUserService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse register(String phone, String userName, String password) {
        User user = new User();
        user.setPhone(phone);
        user.setUsername(userName);
        user.setPassword(password);
        user.setRole(Const.Role.ROLE_ADMIN);
        int insert = userMapper.insert(user);
        if (insert > 0) {
            return ServerResponse.createBySuccessMessage("注册成功！");
        } else {
            return ServerResponse.createByErrorMessage("注册失败");
        }
    }
}
