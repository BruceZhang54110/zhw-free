package com.zhw.free.zhwfreedemo.controller;


import com.zhw.free.zhwfreedemo.eneity.DeptInfo;
import com.zhw.free.zhwfreedemo.eneity.UserInfo;
import com.zhw.free.zhwfreedemo.service.DeptService;
import com.zhw.free.zhwfreedemo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private DeptService deptService;


    @PostMapping("/select/{id}")
    public UserInfo selectUser(@PathVariable("id") Integer id) {
        List<UserInfo> users = userInfoService.getUsers(id);
        if (users != null && !users.isEmpty()) {
            return users.get(0);
        } else {
            return new UserInfo();
        }
    }

    @PostMapping("/dept/{id}")
    public DeptInfo addDept(@PathVariable("id") Integer id) {
        DeptInfo deptInfo = new DeptInfo();
        deptInfo.setDeptName("deptName1");
        deptInfo.setCreateTime(new Date());
        int deptId = deptService.insertDept(deptInfo, id);
        return deptService.getById(deptId);
    }
}
