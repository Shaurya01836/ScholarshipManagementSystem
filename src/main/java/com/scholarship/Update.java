package com.scholarship;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scholarship.*;


@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Update() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scholarship", "root", "Shaurya@123");

			String query = "SELECT * FROM scholarship WHERE scholarship_id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(id));

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				ScholarshipRecord record = new ScholarshipRecord(rs.getInt("scholarship_id"), rs.getString("scholarship_name"),
						rs.getString("description"),rs.getString("eligibility_criteria"), rs.getDouble("amount"), rs.getString("status"));
				request.setAttribute("record", record);
			}

			con.close();
		}
			catch (Exception e) {
				e.printStackTrace();
			}
		
		RequestDispatcher rd = request.getRequestDispatcher("updateScholarship.jsp");
		rd.forward(request, response);
	}



}
