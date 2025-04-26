package com.scholarship;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReviewApplications")
public class ReviewApplications extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ReviewApplications() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scholarship", "root", "Shaurya@123");

            String query = "SELECT s.email AS student_name, sc.scholarship_name, sc.amount, sc.status, s.student_id " +
                    "FROM avail a " +
                    "JOIN student s ON a.student_id = s.student_id " +
                    "JOIN scholarship sc ON a.scholarship_id = sc.scholarship_id";

            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();

            List<ApplicationRecord> applications = new ArrayList<>();

            while (rs.next()) {
            	  String studentName = rs.getString("student_name");
            	    String scholarshipName = rs.getString("scholarship_name");
            	    double amount = rs.getDouble("amount");
            	    String status = rs.getString("status");
            	    int studentId = rs.getInt("student_id");

            	    ApplicationRecord app = new ApplicationRecord(studentName, scholarshipName, amount, status, studentId);
            	    applications.add(app);
            }

            request.setAttribute("applications", applications);
            request.getRequestDispatcher("/review_applications.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
