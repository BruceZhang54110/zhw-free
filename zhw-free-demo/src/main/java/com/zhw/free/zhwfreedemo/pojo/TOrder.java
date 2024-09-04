package com.zhw.free.zhwfreedemo.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class TOrder implements Serializable {
    private int id;

    private String name;

    private String messageId; // 存储消息的唯一标识

}
