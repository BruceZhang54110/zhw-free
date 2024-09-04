package com.zhw.free.zhwfreedemo.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zhw.free.zhwfreedemo.eneity.UserInfo;
import com.zhw.free.zhwfreedemo.mapper.UserInfoMapper;
import com.zhw.free.zhwfreedemo.service.UserInfoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class UserInfoServiceImpl implements UserInfoService {


    private UserInfoMapper userInfoMapper;


    @Transactional
    @Override
    public List<UserInfo> getUsers(Integer id) {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("wh");
        userInfoMapper.insert(userInfo);
        this.getById(id);
        return userInfoMapper.selectList(Wrappers.emptyWrapper());
    }

    @Override
    public UserInfo getById(Integer id) {
        //int a = 10/0;
        return userInfoMapper.selectById(id);
    }
}
