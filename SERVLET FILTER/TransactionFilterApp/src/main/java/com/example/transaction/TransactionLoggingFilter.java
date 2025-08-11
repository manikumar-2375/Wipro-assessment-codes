package com.example.transaction;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionLoggingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // No initialization required
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        // Log timestamp, IP, and amount
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String clientIP = req.getRemoteAddr();
        String amount = req.getParameter("amount");
        if (amount == null) amount = "0";

        System.out.printf("[%s] Transaction Request from IP: %s | Amount: Rs.%s%n",
                timestamp, clientIP, amount);

        // Continue the request
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // No cleanup required
    }
}
