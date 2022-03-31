package com.codereview.msg.controller;

import com.codereview.msg.exception.ErrorCode;
import com.codereview.msg.exception.ServiceException;
import com.codereview.msg.responses.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseController {
    protected ResponseEntity<?> buildResponse(Object data, HttpStatus httpStatus){
        return new ResponseEntity<>(data , httpStatus);
    }

    protected ResponseEntity<?> buildResponse(HttpStatus httpStatus){
        return new ResponseEntity<>(httpStatus);
    }

    protected ErrorResponse buildErrorResponse(ServiceException serviceException){
        return ErrorResponse.builder()
                .code(serviceException.getCode())
                .message(serviceException.getMessage())
                .build();
    }
}
