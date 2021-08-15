package com.stock.cn.util;

public class Result<T> {

    //是否成功
    private Boolean success;

    //返回码
    private Integer code;

    //返回消息
    private String message;

    //返回数据
    private T data;

    private Result() {
    }

    public static Result ok() {
        Result r = new Result();
        r.setCode(ResultCodeEnum.SUCCESS.getCode());
        r.setSuccess(ResultCodeEnum.SUCCESS.getStatus());
        r.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return r;
    }

    public static Result ok(Object data) {
        Result r = new Result();
        r.setCode(ResultCodeEnum.SUCCESS.getCode());
        r.setSuccess(ResultCodeEnum.SUCCESS.getStatus());
        r.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        r.setData(data);
        return r;
    }

    public static Result ok(String message, Object data) {
        Result r = new Result();
        r.setCode(ResultCodeEnum.SUCCESS.getCode());
        r.setSuccess(ResultCodeEnum.SUCCESS.getStatus());
        r.setMessage(message);
        r.setData(data);
        return r;
    }

    public static Result ok(Integer code, String message) {
        Result r = new Result();
        r.setCode(code);
        r.setSuccess(ResultCodeEnum.SUCCESS.getStatus());
        r.setMessage(message);
        return r;
    }

    public static Result ok(Integer code, String message, Object data) {
        Result r = new Result();
        r.setCode(code);
        r.setSuccess(ResultCodeEnum.SUCCESS.getStatus());
        r.setMessage(message);
        r.setData(data);
        return r;
    }

    public static Result error() {
        Result r = new Result();
        r.setCode(ResultCodeEnum.ERROR.getCode());
        r.setSuccess(ResultCodeEnum.ERROR.getStatus());
        r.setMessage(ResultCodeEnum.ERROR.getMessage());
        return r;
    }

    public static Result error(Integer code) {
        Result r = new Result();
        r.setCode(code);
        r.setSuccess(ResultCodeEnum.ERROR.getStatus());
        r.setMessage(ResultCodeEnum.ERROR.getMessage());
        return r;
    }

    public static Result error(Integer code, String message) {
        Result r = new Result();
        r.setCode(code);
        r.setSuccess(ResultCodeEnum.ERROR.getStatus());
        r.setMessage(message);
        return r;
    }

    public static Result error(Integer code, String message, Object data) {
        Result r = new Result();
        r.setCode(code);
        r.setSuccess(ResultCodeEnum.ERROR.getStatus());
        r.setMessage(message);
        r.setData(data);
        return r;
    }

    public static Result ok(ResultCodeEnum codeEnum) {
        Result r = new Result();
        r.setCode(codeEnum.getCode());
        r.setSuccess(codeEnum.getStatus());
        r.setMessage(codeEnum.getMessage());
        return r;
    }

    public static Result error(ResultCodeEnum codeEnum) {
        Result r = new Result();
        r.setCode(codeEnum.getCode());
        r.setSuccess(codeEnum.getStatus());
        r.setMessage(codeEnum.getMessage());
        return r;
    }

    public Result message(String message) {
        this.setMessage(message);
        return this;
    }

    public Result code(Integer code) {
        this.setCode(code);
        return this;
    }

    public Result success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
