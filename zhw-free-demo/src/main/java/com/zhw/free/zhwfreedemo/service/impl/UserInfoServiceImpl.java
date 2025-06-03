package com.zhw.free.zhwfreedemo.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zhw.free.zhwfreedemo.eneity.UserInfo;
import com.zhw.free.zhwfreedemo.mapper.UserInfoMapper;
import com.zhw.free.zhwfreedemo.service.UserInfoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class UserInfoServiceImpl implements UserInfoService {


    private UserInfoMapper userInfoMapper;


    //@Transactional
    @Override
    public List<UserInfo> getUsers(Integer id) {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("wh");
        userInfo.setCreateTime(new Date());
        userInfoMapper.insert(userInfo);
        if (id == 1) {
            int a = 1/0;
        }
        return userInfoMapper.selectList(Wrappers.emptyWrapper());
    }

    @Override
    public UserInfo getById(Integer id) {
        //int a = 10/0;
        return userInfoMapper.selectById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public int addUser(String name) {
        UserInfo userInfo = new UserInfo();
        userInfo.setCreateTime(new Date());
        userInfo.setName(name);
        return userInfoMapper.insert(userInfo);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addUserException(String name) {
        UserInfo userInfo = new UserInfo();
        userInfo.setCreateTime(new Date());
        userInfo.setName(name);
        int insert = userInfoMapper.insert(userInfo);
        throw new RuntimeException("addUserException, name:" + name);

    }
}
