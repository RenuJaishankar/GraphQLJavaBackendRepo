package com.example.graphqlproject;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//this component is needed for CORS purposes
    @Component
    public class CORSFilter implements Filter {

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            //We give CORS because backend and frontend are served at the same time.
            //3600 is the length of time that CORS code to resolve.

            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.setHeader("Access-Control-Allow-Origin", "http://localhost:8000");
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE, PATCH");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "Origin, Content-Type, Accept");
            response.setHeader("Access-Control-Allow-Credentials", "true");
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

