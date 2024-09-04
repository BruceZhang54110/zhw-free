package com.zhw.free.zhwfreedemo.eneity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName(value = "dept_info")
public class DeptInfo implements Serializable {
    private Integer id;

    private String deptName;

    private Date createTime;


}
