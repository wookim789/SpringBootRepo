package com.wookim.loginservice.controller;

import java.util.HashMap;
import java.util.Map;

import com.wookim.loginservice.response.JsonResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * LoginContoller
 * 
 * @author wookim
 * @since 2020.05.08
 */
@RestController
@RequestMapping("/wookim/login")
public class LoginContoller<T> {

    /**
     * GetMapping example
     * 
     * @author wookim
     * @since 2020.05.08
     * @apiNote <br/>
     *          request url ex:
     *          http://localhost:port/wookim/login/example/get/param?param=val
     *          주로 데이터 단순 조회 시 사용
     */
    @GetMapping(value = "/example/get/{param}")
    public String getMethodName(@RequestParam(value = "param") String param) {
        return param;
    }

    /**
     * PostMapping example
     * 
     * @author wookim
     * @since 2020.05.08
     * @apiNote 데이터가 url에 표시되지 않고 httpRequest 객체의 body에 저장되어 back으로 전달할때 사용 주로 수정
     *          작업에 사용됨.
     *          request url ex:
     *          http://localhost:port/wookim/login/example/post
     *          postman을 이용해 데이터를 전달하고 받아보길 권장
     */
    @PostMapping(value = "/example/post")
    public @ResponseBody Map<String, Object> postMethodName(@RequestBody String data) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data is", data);
        return map;
    }

    /**
     * PutMapping example
     * 
     * @author wookim
     * @since 2020.05.08
     * @param data
     * @return
     * @apiNote 데이터를 저장할때 주로 사용
     */
    @PutMapping(value = "/example/put")
    public @ResponseBody Map<T, T> putMethod(@RequestBody String data) {
        return null;
    }

    /**
     * @author wookim
     * @since 2020.05.08
     * @param data
     * @return
     * @apiNote 데이터를 삭제할때 주로 사용
     */
    @DeleteMapping(value = "/example/delete")
    public @ResponseBody Map<T, T> deleteMethod(@RequestBody String data) {
        return null;
    }

    /**
     * @author wookim
     * @since 2020.05.08
     * @param data
     * @return
     * @apiNote RequestMapping은 위의 mapping 방식보다 상위 개념
     *          value: url path를 의미
     *          method: 요청 방식을 설정할 수 있다. get, post, put, delete, head...
     *          consumes: 요청지점에서 데이터를 보낼때, 지정한 형식을 강제
     *          produces: 데이터를 요청한 지점에 보낼 때, 지정한 형식으로 강제
     *          @ResponseBody 데이터를 map이나 vo 객체로 return 시 json형태로 변환하여 전달
     */
    @RequestMapping(value = "/example/requestMapping", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody Map<String, Object> requestEx(T data){
        return null;
    }

    /**
     * @author wookim
     * @since 2020.05.08
     * @param data json으로 받을 데이터
     * @apiNote respone객체를 공통으로 다루는 JsonResponse 클래스로 리턴
     */
    @RequestMapping(value = "/example/responseClass", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody JsonResponse<Map<String, Object>> reponseEx(@RequestBody String data){
        Map<String, Object> jsonData = new HashMap<String, Object>();
        jsonData.put("data", data);
        
        // response를 보낼 떄 공통 json response 클래스로 전달
        JsonResponse <Map<String, Object>> response = new JsonResponse<Map<String, Object>>();
        response.setData(jsonData);
        response.setMsg("success");
        response.setHttpCode(HttpStatus.OK);

        return response;
    }
}