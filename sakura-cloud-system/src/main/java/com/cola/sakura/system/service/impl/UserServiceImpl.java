package com.cola.sakura.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.cola.sakura.common.result.Result;
import com.cola.sakura.system.dao.SysUserMapper;
import com.cola.sakura.system.entity.SysUser;
import com.cola.sakura.system.query.UserQuery;
import com.cola.sakura.system.service.UserService;
import com.sun.java.swing.plaf.windows.WindowsTreeUI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: cola
 * @License: (C) Copyright 2019-2020, liangyx Corporation Limited.
 * @Contact: Email: cola_nsd@163.com
 * @Date: 2020/7/9 20:33
 * @Version: 1.0
 * @Description:
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public Result userLogin(UserQuery criteria) {
        List<SysUser> sysUsers = sysUserMapper.selectList(null);
        for (SysUser sysUser : sysUsers) {
            log.info(sysUser.toString());
        }
        return null;
    }
}
