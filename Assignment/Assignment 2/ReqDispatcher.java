package com.cts.training.assignment2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ReqDispatcher extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String un=req.getParameter("un");
		String pw=req.getParameter("pw");
		if(un.equals("vijay") && pw.equals("123")) {
			out.println(un);
			RequestDispatcher rd=req.getRequestDispatcher("home.html");
			rd.forward(req, res);
		}
		else {
			
			out.println("Wrong Username of Password");
			RequestDispatcher rd=req.getRequestDispatcher("index.html");
			rd.include(req, res);
		}
	}
}