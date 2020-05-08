package com.wookim.loginservice.response;

import org.springframework.http.HttpStatus;

/**
 * response data 
 * @author wookim
 * @since 2020.05.08
 * @param httpCode http상태코드
 * @param msg 전달할 메세지
 * @param data json 데이터
 * @apiNote <br/>데이터를 response객체에 담아 리턴을 할 때 공통으로 사용할 객체<br/>
 */

public class JsonResponse<T> {
    private HttpStatus httpCode;
    private String msg;
    private T data;

    public JsonResponse(){

    }
    public JsonResponse(HttpStatus httpCode, String msg, T data){
        this.httpCode = httpCode;
        this.msg = msg;
        this.data = data;
    }
    
    public void setHttpCode(HttpStatus ok){
        this.httpCode = ok;
    }
    public HttpStatus getHttpCode(){
        return this.httpCode;
    }
    public void setMsg(String msg){
        this.msg = msg;
    }
    public String getMsg(){
        return this.msg;
    }
    public void setData(T data){
        this.data = data;
    }
    public T getData(){
        return this.data;
    }
}