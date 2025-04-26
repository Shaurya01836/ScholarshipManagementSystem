package com.scholarship;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

@WebServlet("/MyApplication")
public class MyApplication extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MyApplication() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("userEmail") == null) {
            response.sendRedirect("login.jsp");
            return;
        }


        String email = (String) session.getAttribute("userEmail");
        List<Stu_Application> applications = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/scholarship", "root", "Shaurya@123")) {
                String idQuery = "SELECT student_id FROM student WHERE email = ?";
                int studentId = -1;
                try (PreparedStatement ps1 = conn.prepareStatement(idQuery)) {
                    ps1.setString(1, email);
                    try (ResultSet rs = ps1.executeQuery()) {
                        if (rs.next()) {
                            studentId = rs.getInt("student_id");
                           // System.out.println(studentId);
                        } else {
                            request.setAttribute("error", "No student found with email: " + email);
                            request.getRequestDispatcher("my_applications.jsp").forward(request, response);
                            return;
                        }
                    }
                }
                // Fetch applications
                String query = "SELECT s.scholarship_id, s.scholarship_name, s.amount, s.status " +
                        "FROM avail a JOIN scholarship s ON a.scholarship_id = s.scholarship_id " +
                        "WHERE a.student_id = ?";


                try (PreparedStatement ps2 = conn.prepareStatement(query)) {
                    ps2.setInt(1, studentId);
                    try (ResultSet rs = ps2.executeQuery()) {
                        while (rs.next()) {
                            applications.add(new Stu_Application(
                                rs.getInt("scholarship_id"),
                                rs.getString("scholarship_name"),
                                rs.getInt("amount"),
                                rs.getString("status")
                            ));
                        }
                    }
                }
            }
        } catch (Exception e) {
        	 e.printStackTrace();
             request.setAttribute("error", "Error fetching applications: " + e.getMessage());
        }

        request.setAttribute("applications", applications);
        RequestDispatcher dispatcher = request.getRequestDispatcher("my_applications.jsp");
        dispatcher.forward(request, response);
    }
}
