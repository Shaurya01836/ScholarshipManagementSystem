package com.scholarship;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Login() {
        super();  
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String role = request.getParameter("role");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scholarship","root", "Shaurya@123");
			String query = "select * from users where email = ? AND password = ? AND role = ?";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, email);
			ps.setString(2, password);
			ps.setString(3, role);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
			    HttpSession session = request.getSession();
			    session.setAttribute("userRole", role); 
			    session.setAttribute("userEmail", email);
			    
			    int linkedId = rs.getInt("linked_id");

			    if (role.equals("student")) {
			        response.sendRedirect("student_dashboard.jsp");  
			    } else if (role.equals("admin")) {
			        response.sendRedirect("admin_dashboard.jsp");
			    } else if (role.equals("officer")) {
			        response.sendRedirect("officer_dashboard.jsp");
			    }
			}
			else {
			    response.getWriter().println("Login Failed");
			}

			ps.close();
			con.close();

		} catch (Exception e) {
			
		}
	}

}
