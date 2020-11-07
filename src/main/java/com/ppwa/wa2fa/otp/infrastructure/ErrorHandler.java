package com.ppwa.wa2fa.otp.infrastructure;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.util.HashMap;
import java.util.Map;

@Component
public class ErrorHandler extends DefaultErrorAttributes {

    private static final Map<Class<? extends Exception>, HttpStatus> STATUS_CODES = new HashMap();

    ErrorHandler() {
    }

    public Map<String, Object> getErrorAttributes(ServerRequest request, ErrorAttributeOptions options) {
        Map<String, Object> map = super.getErrorAttributes(request, options);
        Throwable ex = this.getError(request);
        HttpStatus httpStatus = STATUS_CODES.getOrDefault(ex.getClass(), HttpStatus.INTERNAL_SERVER_ERROR);
        map.put("status", httpStatus.value());
        map.put("error", httpStatus.getReasonPhrase());
        if (ex instanceof CodeNotValidException) {
            map.put("message", ex.getMessage());
        } else {
            map.put("message", httpStatus == HttpStatus.INTERNAL_SERVER_ERROR ? "Internal server error." : ex.getMessage());
        }

        return map;
    }

    static {
        STATUS_CODES.put(CodeNotValidException.class, HttpStatus.FORBIDDEN);
    }

}
