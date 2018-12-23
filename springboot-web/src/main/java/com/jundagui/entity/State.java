package com.jundagui.entity;

public enum State {

    ACTIVATE(0),
    DELETED(1),
    ;
    private final int code;

    private State(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static State getSexByCode(Integer code) {
        if (code < 0) {
            throw new IllegalArgumentException("illegal code: " + code);
        }
        switch (code) {
            case 0:
                return ACTIVATE;
            case 1:
                return DELETED;
            default:
                throw new IllegalArgumentException("illegal code: " + code);
        }
    }
}
