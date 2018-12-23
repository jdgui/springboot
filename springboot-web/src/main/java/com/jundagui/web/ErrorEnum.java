package com.jundagui.web;

public enum ErrorEnum {

    SYSTEM_ERROR(1001,""),
    ILLEGAL_ARGUMENT(1002,""),
    LIST_USER_ERROR(1003, "用户列表获取失败"),
    DELETE_USER_ERROR(1004, "用户删除失败"),
    ADD_USER_ERROR(1005, "用户添加失败"),
    UPDATE_NO_CURRENT_USER_ERROR(1006, "用户更新的id错误"),
    UPDATE_USER_ERROR(1007, "用户更新失败"),
    FIND_USER_ERROR(1008, "用户查询失败")
    ;

    public final int status;
    public final String desc;

    ErrorEnum(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}