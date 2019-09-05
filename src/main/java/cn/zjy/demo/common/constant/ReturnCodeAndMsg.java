package cn.zjy.demo.common.constant;

import lombok.Getter;

public enum ReturnCodeAndMsg {

    SUCCESS(200, "success"),
    FAIL(500, "fail");

    @Getter
    private int code;
    @Getter
    private String msg;

    ReturnCodeAndMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
