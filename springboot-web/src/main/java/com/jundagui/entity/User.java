package com.jundagui.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class User {

    private Integer id;
    private Long userId;
    private String name;
    private Sex sex;
    private Integer age;
    private String remark;
    private State state;

    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;

}
