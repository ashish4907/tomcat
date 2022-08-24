package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;

public class WelcomeController extends GenericServlet {

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

        

        response.setContentType("text/html");
        String outPutScreen = "<html> <body>Welcome to first Servlet Pages</body>   </html>";

        PrintWriter pw = response.getWriter();
        pw.println(outPutScreen);
        
//        RequestDispatcher view = request.getRequestDispatcher("index.html");
//        view.forward(request, response);

        pw.flush();
        pw.close();

    }

}
