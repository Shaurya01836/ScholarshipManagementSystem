package com.scholarship;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scholarship.*;


@SuppressWarnings("unused")
@WebServlet("/ScholarshipRecordList")
public class ScholarshipRecordList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ScholarshipRecordList() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ScholarshipRecord> records = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scholarship", "root", "Shaurya@123");
				 PreparedStatement ps = con.prepareStatement("SELECT * FROM scholarship");
				 ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					int id = rs.getInt("scholarship_id");
					String scholarship_name = rs.getString("scholarship_name");
					String description = rs.getString("description");
					String eligibility_criteria = rs.getString("eligibility_criteria");
					Double amount = rs.getDouble("amount");
					String status = rs.getString("status");
					ScholarshipRecord record = new ScholarshipRecord(id, scholarship_name, description, eligibility_criteria, amount, status);
					records.add(record);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("recordList", records);
		  // 🔑 Check role from session
	    String role = (String) request.getSession().getAttribute("userRole");

	    String destinationPage = "apply_scholarship.jsp";

	    if ("admin".equalsIgnoreCase(role)) {
	        destinationPage = "manage_scholarship.jsp";	    }

	    RequestDispatcher rd = request.getRequestDispatcher(destinationPage);
	    rd.forward(request, response);
	}

	

}
