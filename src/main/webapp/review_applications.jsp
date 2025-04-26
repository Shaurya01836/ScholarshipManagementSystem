<%@ page import="java.util.List" %>
<%@ page import="com.scholarship.*" %> <!-- Ensure this is your correct package -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Review Applications</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>

<body class="bg-gray-100">
    <div class="max-w-7xl mx-auto py-10">
        <h1 class="text-3xl font-bold mb-6">Review Applications</h1>

        <div class="bg-white shadow overflow-hidden sm:rounded-lg">
            <table class="min-w-full divide-y divide-gray-200">
                <thead class="bg-gray-50">
                    <tr>
                        <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Student Email</th>
                        <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Scholarship</th>
                        <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Amount</th>
                        <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Status</th>
                        <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Actions</th>
                    </tr>
                </thead>
                <tbody class="bg-white divide-y divide-gray-200">
                    <%
                        List<ApplicationRecord> applications = (List<ApplicationRecord>) request.getAttribute("applications");
                        if (applications != null) {
                            for (ApplicationRecord app : applications) {
                    %>
                        <tr>
                            <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900"><%= app.getStudentName()%></td>
                            <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500"><%= app.getScholarshipName() %></td>
                            <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500"><%= app.getAmount() %></td>
                            <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500"><%= app.getStatus() %></td>
                            <td class="px-6 py-4 whitespace-nowrap text-sm font-medium">
<a href="approve_application.jsp?id=" class="text-green-600 hover:text-green-900 mr-4">Approve</a>
                                <a href="reject_application.jsp?id=" class="text-red-600 hover:text-red-900">Reject</a>
                            </td>
                        </tr>
                    <%
                            }
                        } else {
                    %>
                        <tr>
                            <td colspan="5" class="px-6 py-4 text-center text-sm text-gray-500">No applications found.</td>
                        </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </div>
</body>

</html>
