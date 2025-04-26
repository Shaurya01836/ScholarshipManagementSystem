package com.scholarship;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Application")
public class Application extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Application() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	 try {
             // Database connection
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scholarship", "root", "Shaurya@123");

             // Query to fetch scholarships
             PreparedStatement stmt = con.prepareStatement("SELECT scholarship_id, scholarship_name FROM scholarship");
             ResultSet rs = stmt.executeQuery();
             
             // Set the scholarships in the request scope
             request.setAttribute("scholarships", rs);

             // Forward to the JSP page
             request.getRequestDispatcher("applications.jsp").forward(request, response);

             rs.close();
             stmt.close();
             con.close();
         } catch (Exception e) {
             e.printStackTrace();
             response.getWriter().println("Error: " + e.getMessage());
         }
     }

   

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String studentName = request.getParameter("student_name");
        String dob = request.getParameter("dob");
        String phone = request.getParameter("phone_no");
        double income = Double.parseDouble(request.getParameter("income"));
        int scholarshipId = Integer.parseInt(request.getParameter("scholarship_id"));
        String doc_type = request.getParameter("doc_type");
        String doc_url = request.getParameter("doc_url");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scholarship", "root",
                    "Shaurya@123");

            int studentId = 0;

           
            PreparedStatement checkStmt = con.prepareStatement(
                    "SELECT student_id FROM student WHERE student_name = ? AND dob = ? AND phone_no = ?");
            checkStmt.setString(1, studentName);
            checkStmt.setString(2, dob);
            checkStmt.setString(3, phone);

            ResultSet checkResult = checkStmt.executeQuery();
            if (checkResult.next()) {
                studentId = checkResult.getInt("student_id");
            } else {
                
                PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO student (student_name, dob, phone_no, income) VALUES (?, ?, ?, ?)",
                        Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, studentName);
                ps.setString(2, dob);
                ps.setString(3, phone);
                ps.setDouble(4, income);
                ps.executeUpdate();

                ResultSet rs1 = ps.getGeneratedKeys();
                if (rs1.next()) {
                    studentId = rs1.getInt(1);
                }
                rs1.close();
                ps.close();
            }
            checkResult.close();
            checkStmt.close();

           
            PreparedStatement availCheck = con.prepareStatement(
                    "SELECT * FROM avail WHERE student_id = ? AND scholarship_id = ?");
            availCheck.setInt(1, studentId);
            availCheck.setInt(2, scholarshipId);
            ResultSet availResult = availCheck.executeQuery();

            if (availResult.next()) {
                response.getWriter().println("You have already applied for this scholarship.");
                availResult.close();
                availCheck.close();
                con.close();
                return;
            }
            availResult.close();
            availCheck.close();

           
            PreparedStatement ps2 = con.prepareStatement(
                    "INSERT INTO document(doc_type, doc_url) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps2.setString(1, doc_type);
            ps2.setString(2, doc_url);
            ps2.executeUpdate();

            int documentId = 0;
            ResultSet rs2 = ps2.getGeneratedKeys();
            if (rs2.next()) {
                documentId = rs2.getInt(1);
            }
            rs2.close();
            ps2.close();

           
            PreparedStatement ps3 = con.prepareStatement(
                    "INSERT INTO avail(student_id, scholarship_id, avail_date) VALUES (?, ?, ?)");
            ps3.setInt(1, studentId);
            ps3.setInt(2, scholarshipId);
            ps3.setDate(3, new java.sql.Date(System.currentTimeMillis()));
            ps3.executeUpdate();
            ps3.close();

            
            PreparedStatement ps4 = con.prepareStatement(
                    "INSERT INTO has(student_id, document_id) VALUES (?, ?)");
            ps4.setInt(1, studentId);
            ps4.setInt(2, documentId);
            ps4.executeUpdate();
            ps4.close();

            con.close();
            response.getWriter().println("✅ Application submitted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("❌ Error: " + e.getMessage());
        }
    }
}
