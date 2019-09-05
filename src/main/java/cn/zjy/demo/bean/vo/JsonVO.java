package cn.zjy.demo.bean.vo;

import cn.zjy.demo.common.constant.ReturnCodeAndMsg;
import lombok.Getter;

import java.io.Serializable;

public class JsonVO<T> implements Serializable {
    private static final long serialVersionUID = -992701817359658832L;

    @Getter
    private int code;

    @Getter
    private String msg;

    @Getter
    private T data;

    public JsonVO(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JsonVO(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public JsonVO(ReturnCodeAndMsg returnCodeAndMsg) {
        this(returnCodeAndMsg.getCode(), returnCodeAndMsg.getMsg());
    }

    public JsonVO(ReturnCodeAndMsg returnCodeAndMsg, T data) {
        this(returnCodeAndMsg.getCode(), returnCodeAndMsg.getMsg(), data);
    }
}
