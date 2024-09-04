package com.zhw.free.zhwfreedemo.service;

import com.zhw.free.zhwfreedemo.eneity.UserInfo;

import java.util.List;

public interface UserInfoService {

    List<UserInfo> getUsers(Integer id);

    UserInfo getById(Integer id);
}
