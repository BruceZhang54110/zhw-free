package com.zhw.free.zhwfreedemo.service;

import com.zhw.free.zhwfreedemo.eneity.DeptInfo;

public interface DeptService {

    int insertDept(DeptInfo deptInfo, Integer id);

    DeptInfo getById(Integer id);
}
