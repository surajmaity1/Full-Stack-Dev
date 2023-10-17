package com.surajmaity1.springbootrestapi.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> responseBuilder(
            String message,
            HttpStatus httpStatus,
            Object responseObj
    ) {
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("message", message);
        responseMap.put("httpStatus", httpStatus);
        responseMap.put("responseObj", responseObj);

        return new ResponseEntity<>(responseMap, httpStatus);
    }

}
