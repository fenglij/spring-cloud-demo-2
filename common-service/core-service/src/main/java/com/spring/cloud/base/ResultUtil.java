package com.spring.cloud.base;

import com.spring.cloud.enums.ResultEnum;

public class ResultUtil<T> {

    public static Result success(){
        return result(ResultEnum.SUCCESS);
    }

    public static Result success(Object object){
        return result(ResultEnum.SUCCESS, object);
    }

    public static Result failure(){
        return result(ResultEnum.FAILUIRE);
    }

    public static Result failure(Object object){
        return result(ResultEnum.FAILUIRE, object);
    }

    public static Result result(ResultEnum resultEnum){
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        return result;
    }

    public static Result result(ResultEnum resultEnum, Object object){
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        result.setData(object);
        return result;
    }

    public static Result result(Integer code, String msg, Object object){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(object);
        return result;
    }
}
