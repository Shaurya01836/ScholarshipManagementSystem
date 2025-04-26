<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, com.scholarship.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin - Manage Scholarships</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 font-sans">

    <div class="max-w-7xl mx-auto px-6 py-10">
        <h1 class="text-3xl font-bold text-gray-800 mb-6">🛠️ Manage Scholarships (Admin)</h1>
        <a href="add_scholarship.jsp">Add another Scholarship</a>

        <div class="overflow-x-auto bg-white shadow-lg rounded-lg">
            <table class="min-w-full divide-y divide-gray-200">
                <thead class="bg-red-600 text-white">
                    <tr>
                        <th class="px-6 py-3 text-left text-sm font-medium">ID</th>
                        <th class="px-6 py-3 text-left text-sm font-medium">Name</th>
                        <th class="px-6 py-3 text-left text-sm font-medium">Description</th>
                        <th class="px-6 py-3 text-left text-sm font-medium">Eligibility</th>
                        <th class="px-6 py-3 text-left text-sm font-medium">Amount</th>
                        <th class="px-6 py-3 text-left text-sm font-medium">Status</th>
                        <th class="px-6 py-3 text-center text-sm font-medium">Edit</th>
                        <th class="px-6 py-3 text-center text-sm font-medium">Delete</th>
                        
                    </tr>
                </thead>
                <tbody class="bg-white divide-y divide-gray-200 text-gray-700">
                <%
                    List<ScholarshipRecord> records = (List<ScholarshipRecord>) request.getAttribute("recordList");
                    if (records != null && !records.isEmpty()) {
                        for (ScholarshipRecord r : records) {
                %>
                    <tr>
                        <td class="px-6 py-4"><%= r.getId() %></td>
                        <td class="px-6 py-4"><%= r.getScholarship_name() %></td>
                        <td class="px-6 py-4"><%= r.getDescription() %></td>
                        <td class="px-6 py-4"><%= r.getEligibility_criteria() %></td>
                        <td class="px-6 py-4">₹<%= r.getAmount() %></td>
                        <td class="px-6 py-4">
                            <span class="px-3 py-1 rounded-full text-xs font-semibold
                                <%= "active".equalsIgnoreCase(r.getStatus()) ? "bg-green-100 text-green-800" : "bg-red-100 text-red-800" %>">
                                <%= r.getStatus() %>
                            </span>
                        </td>
                         	<td><a class="px-6 py-4 text-center" href="Update?id=<%= r.getId() %>">Edit</a></td>
                        <td class="px-6 py-4 text-center">
                            <form action="DeleteScholarship" method="post" onsubmit="return confirm('Are you sure you want to delete this scholarship?');">
                                <input type="hidden" name="id" value="<%= r.getId() %>">
                                <button type="submit" class="bg-red-500 text-white px-4 py-2 rounded hover:bg-red-600 transition">
                                    Delete
                                </button>
                            </form>
                        </td>
                    </tr>
                <%
                        }
                    } else {
                %>
                    <tr>
                        <td colspan="7" class="text-center px-6 py-4 text-gray-500">No scholarships found.</td>
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
