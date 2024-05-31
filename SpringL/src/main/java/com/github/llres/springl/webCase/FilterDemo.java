package com.github.llres.springl.webCase;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FilterDemo implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter begin");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("filter end");
    }
}
