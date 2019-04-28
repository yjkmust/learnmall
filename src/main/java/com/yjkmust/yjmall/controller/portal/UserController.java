package com.yjkmust.yjmall.controller.portal;

import com.yjkmust.yjmall.common.ServerResponse;
import com.yjkmust.yjmall.service.IUserService;

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
}
