package com.zhw.free.zhwfreedemo.service.impl;

import com.zhw.free.zhwfreedemo.eneity.DeptInfo;
import com.zhw.free.zhwfreedemo.service.DeptService;
import com.zhw.free.zhwfreedemo.service.StudentService;
import com.zhw.free.zhwfreedemo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private DeptService deptService;

    @Transactional
    @Override
    public void insertUserAndDept(DeptInfo deptInfo, Integer id, String userName) {
        deptService.insertDept(deptInfo, id);
        try {
            userInfoService.addUserException(userName);
        } catch (Exception e) {
            System.out.println("发生异常：" + e.getMessage());
        }
    }
}
