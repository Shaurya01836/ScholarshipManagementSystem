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


@WebServlet("/UpdateRecord")
public class UpdateRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateRecord() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  String scholarshipId = request.getParameter("id");  // 'id' from hidden input
		    String name = request.getParameter("name");
		    String description = request.getParameter("description");
		    String eligibility = request.getParameter("eligibility");
		    String amountStr = request.getParameter("amount");

		    try {
		        double amount = Double.parseDouble(amountStr);

		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scholarship", "root", "Shaurya@123");

		        String query = "UPDATE scholarship SET scholarship_name = ?, description = ?, eligibility_criteria = ?, amount = ? WHERE scholarship_id = ?";
		        PreparedStatement ps = con.prepareStatement(query);
		        ps.setString(1, name);
		        ps.setString(2, description);
		        ps.setString(3, eligibility);
		        ps.setDouble(4, amount);
		        ps.setInt(5, Integer.parseInt(scholarshipId));

		        int rowsUpdated = ps.executeUpdate();

		        con.close();

		        if (rowsUpdated > 0) {
		            response.sendRedirect("ScholarshipRecordList");
		        } else {
		            response.getWriter().println("Failed to update scholarship.");
		        }

		    } catch (Exception e) {
		        e.printStackTrace();
		        response.getWriter().println("Error updating record: " + e.getMessage());
		    }

	}
}
