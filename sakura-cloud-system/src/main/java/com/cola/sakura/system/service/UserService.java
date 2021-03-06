package com.cola.sakura.system.service;

import com.cola.sakura.common.result.Result;
import com.cola.sakura.system.query.UserQuery;

/**
 * @Author: cola
 * @License: (C) Copyright 2019-2020, liangyx Corporation Limited.
 * @Contact: Email: cola_nsd@163.com
 * @Date: 2020/7/9 20:33
 * @Version: 1.0
 * @Description:
 */

public interface UserService {
    /**
     * @Description 用户登录
     * @Author cola
     * @Date 2020/7/16 17:18
     **/
    Result userLogin(UserQuery criteria);
}
