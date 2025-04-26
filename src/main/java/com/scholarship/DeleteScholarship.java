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


@WebServlet("/DeleteScholarship")
public class DeleteScholarship extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public DeleteScholarship() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String idParam = request.getParameter("id");
	        int id = Integer.parseInt(idParam);

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scholarship", "root", "Shaurya@123");
	                 PreparedStatement ps = con.prepareStatement("DELETE FROM scholarship WHERE scholarship_id = ?")) {

	                ps.setInt(1, id);
	                ps.executeUpdate();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        response.sendRedirect("ScholarshipRecordList"); 
	}

}
