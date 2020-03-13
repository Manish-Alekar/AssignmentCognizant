package com.cts;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	resp.setContentType("text/html");  
        PrintWriter out=resp.getWriter();  
          
        String name=req.getParameter("name");  
        String password=req.getParameter("password");  
          
        Login login=new Login();  
        login.setName(name);  
        login.setPassword(password);  
        req.setAttribute("login",login);  
          
        boolean status=login.validate();  
          
        if(status){  
            RequestDispatcher rd=req.getRequestDispatcher("login-success.jsp");  
            rd.forward(req, resp);  
        }  
        else{  
            RequestDispatcher rd=req.getRequestDispatcher("login-error.jsp");  
            rd.forward(req, resp);  
        }  
    	}

}
