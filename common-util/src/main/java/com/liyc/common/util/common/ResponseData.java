package com.liyc.common.util.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class ResponseData<T> implements Serializable {

    private static final long serialVersionUID = 6489896160623559218L;

    private int status;
    private String msg;
    private T data;

    private ResponseData(int status){
        this.status = status;
    }
    private ResponseData(int status,T data){
        this.status = status;
        this.data = data;
    }

    private ResponseData(int status, String msg, T data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    private ResponseData(int status, String msg){
        this.status = status;
        this.msg = msg;
    }

    @JsonIgnore
    //使之不在json序列化结果当中
    public boolean isSuccess(){
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    public int getStatus(){
        return status;
    }
    public T getData(){
        return data;
    }
    public String getMsg(){
        return msg;
    }


    public static <T> ResponseData<T> createBySuccess(){
        return new ResponseData<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ResponseData<T> createBySuccessMessage(String msg){
        return new ResponseData<T>(ResponseCode.SUCCESS.getCode(),msg);
    }

    public static <T> ResponseData<T> createBySuccess(T data){
        return new ResponseData<T>(ResponseCode.SUCCESS.getCode(),data);
    }

    public static <T> ResponseData<T> createBySuccess(String msg, T data){
        return new ResponseData<T>(ResponseCode.SUCCESS.getCode(),msg,data);
    }


    public static <T> ResponseData<T> createByError(){
        return new ResponseData<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }


    public static <T> ResponseData<T> createByErrorMessage(String errorMessage){
        return new ResponseData<T>(ResponseCode.ERROR.getCode(),errorMessage);
    }

    public static <T> ResponseData<T> createByErrorCodeMessage(int errorCode, String errorMessage){
        return new ResponseData<T>(errorCode,errorMessage);
    }

    public static <T> ResponseData<T> createByErrorMessageData(String errorMessage, T data){
        return new ResponseData<T>(ResponseCode.ERROR.getCode(),errorMessage,data);
    }
}
