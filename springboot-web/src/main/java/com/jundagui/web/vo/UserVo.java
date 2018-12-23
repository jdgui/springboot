package com.jundagui.web.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jundagui.entity.Sex;
import com.jundagui.entity.User;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class UserVo {

    //private static final ThreadLocal<DateFormat> LOCAL_DATE_FORMAT = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    private Long userId;
    private String name;
    private Integer sex;
    private Integer age;
    private String remark;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public UserVo() {
    }

    public UserVo(User user) {
        this.userId = user.getUserId();
        this.name = user.getName();
        this.sex = user.getSex().getCode();
        this.age = user.getAge();
        this.remark = user.getRemark();
        this.createTime = user.getCreateTime();
        this.updateTime = user.getUpdateTime();
//        this.createTime = LOCAL_DATE_FORMAT.get().format(user.getCreateTime());
//        this.updateTime = LOCAL_DATE_FORMAT.get().format(user.getUpdateTime());
    }

    public User toUser() {
        User user = new User();
        user.setUserId(this.userId);
        user.setName(this.name);
        user.setSex(Sex.getSexByCode(this.sex));
        user.setAge(this.age);
        user.setRemark(this.remark);
        return user;
    }
}
