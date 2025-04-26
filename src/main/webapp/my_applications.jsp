<%@page import="com.scholarship.Stu_Application"%>
<%@page import="java.util.List"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>My Applications</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-50 text-gray-800">
    <div class="max-w-4xl mx-auto mt-10 bg-white p-8 rounded-lg shadow">
        <h2 class="text-2xl font-bold mb-6 text-center text-indigo-600">My Scholarship Applications</h2>

        <table class="min-w-full bg-white border border-gray-300 rounded-lg">
            <thead>
                <tr>
                    <th class="px-4 py-2 border-b text-left">Scholarship Name</th>
                    <th class="px-4 py-2 border-b text-left">Amount</th>
                    <th class="px-4 py-2 border-b text-left">Status</th>
                </tr>
            </thead>
            <tbody>
              <%
    List<Stu_Application> applications = (List<Stu_Application>) request.getAttribute("applications");
    if (applications != null) {
        for (Stu_Application app : applications) {
%><tr class="hover:bg-gray-100">
    <td class="px-4 py-2 border-b"><%= app.getScholarshipName() %></td>
    <td class="px-4 py-2 border-b"><%= app.getAmount() %></td>
    <td class="px-4 py-2 border-b"><%= app.getStatus() %></td>
</tr>
<%
        }
    }
%>
            </tbody>
        </table>
    </div>
</body>
</html>
