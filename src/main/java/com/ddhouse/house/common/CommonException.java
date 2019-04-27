package com.ddhouse.house.common;


import com.ddhouse.house.utils.JsonUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


//@ControllerAdvice和@ResponseBody
@ControllerAdvice
@ResponseBody
public class CommonException {

    @ExceptionHandler(Exception.class)
    public JsonBean permException(Exception e){

        return JsonUtils.createJsonBean(0, e.getMessage(),null);
    }

}
