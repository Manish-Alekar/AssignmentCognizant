package com.Validation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeForm
 */

public class EmployeeForm extends HttpServlet {
	
	String user,password,url,driver;
	Connection con;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		
		
		
		user= config.getInitParameter("userName");
		password= config.getInitParameter("password");
		url= config.getInitParameter("url");
		driver= config.getInitParameter("driver");
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
			System.out.println(con);
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//resp.setContentType("Form.html");
		PrintWriter out = resp.getWriter();  
	 
		//int eid=Integer.parseInt(req.getParameter("eid"));
		String name=req.getParameter("username");
		String email=req.getParameter("email");
		int age=Integer.parseInt(req.getParameter("age"));
		String desig=req.getParameter("desig");
	
	
		String query="insert into empdata"+"(name,email,age,designation)"+" values(?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
			//ps.setInt(1, eid);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setInt(3, age);
			ps.setString(4, desig);
		
			ps.executeUpdate();
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	System.out.println("Data inserted successfully");
	}
}
