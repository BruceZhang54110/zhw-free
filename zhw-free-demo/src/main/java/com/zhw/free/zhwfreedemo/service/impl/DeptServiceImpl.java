package com.zhw.free.zhwfreedemo.service.impl;

import com.zhw.free.zhwfreedemo.eneity.DeptInfo;
import com.zhw.free.zhwfreedemo.mapper.DeptInfoMapper;
import com.zhw.free.zhwfreedemo.service.DeptService;
import com.zhw.free.zhwfreedemo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private DeptInfoMapper deptInfoMapper;


    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public int insertDept(DeptInfo deptInfo, Integer id) {
        deptInfoMapper.insert(deptInfo);
        userInfoService.addUser("name-A");
        if (id == 0) {
            throw new IllegalArgumentException("发生异常");
        }
        userInfoService.addUser("name-B");
        return deptInfo.getId();
    }

    @Override
    public DeptInfo getById(Integer id) {
        return deptInfoMapper.selectById(id);
    }
}
