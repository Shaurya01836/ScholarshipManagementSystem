<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.scholarship.*, java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Scholarship</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 min-h-screen flex items-center justify-center">

<%
    ScholarshipRecord record = (ScholarshipRecord) request.getAttribute("record");
    if (record != null) {
%>

<div class="bg-white p-8 rounded-2xl shadow-xl w-full max-w-lg">
    <h2 class="text-2xl font-bold mb-6 text-center text-blue-600">Update Scholarship Record</h2>
    <form action="UpdateRecord" method="post" class="space-y-4">
        <input type="hidden" name="id" value="<%= record.getId() %>" />

        <div>
            <label class="block text-gray-700 font-medium">Scholarship Name</label>
            <input type="text" name="name" value="<%= record.getScholarship_name()%>"
                   class="w-full mt-1 px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-400" required />
        </div>

        <div>
            <label class="block text-gray-700 font-medium">Amount</label>
            <input type="number" name="amount" value="<%= record.getAmount()%>"
                   class="w-full mt-1 px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-400" required />
        </div>

        <div>
            <label class="block text-gray-700 font-medium">Eligibility</label>
            <input type="text" name="eligibility" value="<%= record.getEligibility_criteria() %>"
                   class="w-full mt-1 px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-400" required />
        </div>

        <div>
            <label class="block text-gray-700 font-medium">Description</label>
            <textarea name="description" rows="3"
                      class="w-full mt-1 px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-400" required><%= record.getDescription() %></textarea>
        </div>

        <div class="text-center">
            <button type="submit"
                    class="bg-blue-500 text-white px-6 py-2 rounded-xl hover:bg-blue-600 transition duration-300">
                Update
            </button>
        </div>
    </form>
</div>

<%
    } else {
%>
    <div class="text-center text-red-600 text-xl font-semibold">
        No record found to update.
    </div>
<%
    }
%>

</body>
</html>
