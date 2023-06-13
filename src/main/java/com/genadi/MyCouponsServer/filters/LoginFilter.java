package com.genadi.MyCouponsServer.filters;

import com.genadi.MyCouponsServer.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginFilter implements Filter {
    @Autowired
    JwtUtils jwtUtils;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String methodType = request.getMethod().toLowerCase();
        // Options means it's part of the CORS request
        // No need to check anything
        if (methodType.equals("options")){
            // filterChain.doFilter = All good, u may go ahead
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        String token = request.getHeader("Authorization");

        String url = request.getRequestURI().toLowerCase();
        if (isRequestAWhitelisted(methodType, url)){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }


        // Questions -
        // 1. Performance ??
        // 2. Error object ??
        // 3. Hacking ??
        try {
            jwtUtils.validateToken(token);
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e) {
//            e.printStackTrace(); ???
            response.setStatus(401);
        }
    }

    private boolean isRequestAWhitelisted(String methodType, String url) {
        //login
        if (methodType.equals("post") && url.startsWith("/users/login")){
            return true;
        }
        //registration
        if (methodType.equals("post") && url.startsWith("/customers/register")){
            return true;
        }
        // Get coupons to not logged in users
        if (methodType.equals("get") && url.startsWith("/coupons")){
            return true;
        }

        return false;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {

    }
}
