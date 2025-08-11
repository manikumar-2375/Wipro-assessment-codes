package com.example.transaction;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class TransactionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String amount = request.getParameter("amount");
        if (amount == null) amount = "0";

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3 style='color:green;'>Transaction of Rs." + amount + " processed successfully.</h3>");
    }
}
