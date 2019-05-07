package com.yjkmust.yjmall.controller.portal;

import com.yjkmust.yjmall.common.ServerResponse;
import com.yjkmust.yjmall.pojo.User;
import com.yjkmust.yjmall.service.IUserService;
import com.yjkmust.yjmall.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "register", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse register(String phone, String userName, String password) {
        return iUserService.register(phone, userName, password);
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> login(String userName, String password) {
        ServerResponse<User> user = iUserService.login(userName, password);
        if (user.getData()!=null){
            String token = JwtUtil.sign(user.getData().getUsername(), user.getData().getPassword());//30天有效期
            user.getData().setToken(token);
        }
        return user;


    }
}
