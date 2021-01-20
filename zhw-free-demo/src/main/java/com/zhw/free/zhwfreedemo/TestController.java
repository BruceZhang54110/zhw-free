package com.zhw.free.zhwfreedemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhw.free.zhwfreedemo.eneity.TOrder;
import com.zhw.free.zhwfreedemo.eneity.User;
import com.zhw.free.zhwfreedemo.mapper.TOrderMapper;
import com.zhw.free.zhwfreedemo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
public class TestController {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TOrderMapper tOrderMapper;


    @RequestMapping("test")
    public String test() {
        // redisTemplate.opsForValue().set("testaaa", "test zhw");
        // log.info((String) redisTemplate.opsForValue().get("testaaa"));
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        List<User> users = userMapper.selectList(wrapper);
        for (User o : users) {
            log.info(o.getEmail());
        }
        QueryWrapper<TOrder> queryWrapper = new QueryWrapper<TOrder>();
        tOrderMapper.selectList(queryWrapper);
        return "success";
    }
}
