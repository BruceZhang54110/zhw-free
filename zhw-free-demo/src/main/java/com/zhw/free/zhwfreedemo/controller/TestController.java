package com.zhw.free.zhwfreedemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhw.free.zhwfreedemo.eneity.UserInfo;
import com.zhw.free.zhwfreedemo.mapper.UserInfoMapper;
import com.zhw.free.zhwfreedemo.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RefreshScope
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserInfoService userInfoService;


    @ResponseBody
    @RequestMapping("/test1")
    public String test() {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<UserInfo>();
        List<UserInfo> UserInfos = userInfoMapper.selectList(wrapper);
        return "success";
    }


    @PostMapping("/users")
    public String getUser() {
        userInfoService.getUsers(4);
        return "success";
    }
}
