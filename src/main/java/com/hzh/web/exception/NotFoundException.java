package com.hzh.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Page.NoFound")
public class NotFoundException extends RuntimeException {
    //DispatcherServlet
}
