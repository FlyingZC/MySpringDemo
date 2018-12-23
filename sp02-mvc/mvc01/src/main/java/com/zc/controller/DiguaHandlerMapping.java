package com.zc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;

public class DiguaHandlerMapping implements HandlerMapping
{

    public HandlerExecutionChain getHandler(HttpServletRequest request) throws Exception
    {
        String url = request.getRequestURI().toString();
        String method = request.getMethod();
        if (url.startsWith("/tudou")) {
            if (method.equalsIgnoreCase("GET")) {
                // return xxxHandler;
            } else if (method.equalsIgnoreCase("POST")) {
                // return yyyHandler;
            }
        }
        return null;
    }

}
