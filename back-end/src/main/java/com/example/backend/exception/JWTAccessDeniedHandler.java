package com.example.backend.exception;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.ThreadContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
@Component
public class JWTAccessDeniedHandler  implements AccessDeniedHandler{


    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        System.out.println("access denied luon");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        ApiErrorResponse  apiError = ApiErrorResponseBuilder.getInstance()
                .withStatus(HttpStatus.UNAUTHORIZED.value())
                .build();
        OutputStream os = response.getOutputStream();
        ObjectMapper om = new ObjectMapper();
        om.writeValue(os, apiError);
        os.flush();
    }

}
