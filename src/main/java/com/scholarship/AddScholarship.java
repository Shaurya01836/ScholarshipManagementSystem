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


@WebServlet("/AddScholarship")
public class AddScholarship extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AddScholarship() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		
			String scholarship_name = request.getParameter("scholarship_name");
			String description = request.getParameter("description");
			String eligibility_criteria = request.getParameter("eligibility_criteria");
		    double amount = Double.parseDouble(request.getParameter("amount")); 
			String status = request.getParameter("status");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scholarship","root", "Shaurya@123");
			String query = "insert into scholarship (scholarship_name,description,eligibility_criteria,amount,status) values (?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, scholarship_name);
			ps.setString(2, description);
			ps.setString(3, eligibility_criteria);
			ps.setDouble(4, amount);
			ps.setString(5, status);
			ps.executeUpdate();

			response.sendRedirect("ScholarshipRecordList");  

			ps.close();
			con.close();

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
