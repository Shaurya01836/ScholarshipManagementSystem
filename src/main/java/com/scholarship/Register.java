package com.scholarship;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
    public Register() {
       super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phone_no = request.getParameter("phone_no");
		String role = request.getParameter("role");
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scholarship","root", "Shaurya@123");
		String query = "insert into users (email,password,phone_no,role) values (?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		
		ps.setString(1, email);
		ps.setString(2, password);
		ps.setString(3, phone_no);
		ps.setString(4, role);
		ps.executeUpdate();

		response.sendRedirect("login.jsp");  


		ps.close();
		con.close();

		
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

}
