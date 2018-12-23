package com.jundagui.entity;

public enum Sex {

    MAIL(0),
    FEMAIL(1),
    ;

    private final int code;

    private Sex(int code) {
        this.code = code;
    }

    public static Sex getSexByCode(Integer code) {
        if (code < 0) {
            throw new IllegalArgumentException("illegal code: " + code);
        }
        switch (code) {
            case 0:
                return MAIL;
            case 1:
                return FEMAIL;
            default:
                throw new IllegalArgumentException("illegal code: " + code);
        }
    }

    public int getCode() {
        return code;
    }
}
