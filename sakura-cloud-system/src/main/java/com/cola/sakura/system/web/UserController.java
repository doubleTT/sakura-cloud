package com.cola.sakura.system.web;


import com.cola.sakura.common.result.Result;
import com.cola.sakura.system.query.UserQuery;
import com.cola.sakura.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: cola
 * @License: (C) Copyright 2019-2020, liangyx Corporation Limited.
 * @Contact: Email: cola_nsd@163.com
 * @Date: 2020/7/9 20:33
 * @Version: 1.0
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param criteria
     * @throws Exception
     */
    @RequestMapping("/userLogin")
    public Result userLogin(UserQuery criteria)  {
        return userService.userLogin(criteria);
    }


}
