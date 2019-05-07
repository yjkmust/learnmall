package com.yjkmust.yjmall.service.impl;

import com.yjkmust.yjmall.common.Const;
import com.yjkmust.yjmall.common.ServerResponse;
import com.yjkmust.yjmall.dao.UserMapper;
import com.yjkmust.yjmall.pojo.User;
import com.yjkmust.yjmall.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.yjkmust.yjmall.common.ServerResponse.createByErrorMessage;

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
            return createByErrorMessage("注册失败");
        }
    }
    @Override
    public ServerResponse<User> login(String userName, String password) {
        int count = userMapper.checkUserName(userName);
        if (count == 0) {
            return ServerResponse.createByErrorMessage("用户名不存在");
        }
        User user = userMapper.selectLogin(userName, password);
        if (user == null) {
            return createByErrorMessage("密码错误");
        }
        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess("登陆成功", user);
    }
}
