<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Apply for Scholarship</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 font-sans leading-normal tracking-normal">

    <div class="max-w-2xl mx-auto mt-10 bg-white p-8 rounded-xl shadow-md">
        <h2 class="text-2xl font-semibold text-center mb-6 text-indigo-600">Scholarship Application Form</h2>

        <form action="Application" method="post" class="space-y-5">
            <!-- Student Name -->
            <div>
                <label class="block text-sm font-medium text-gray-700">Full Name</label>
                <input type="text" name="student_name" required
                    class="mt-1 block w-full border border-gray-300 rounded-lg px-4 py-2 shadow-sm focus:ring-indigo-500 focus:border-indigo-500">
            </div>

            <!-- DOB -->
            <div>
                <label class="block text-sm font-medium text-gray-700">Date of Birth</label>
                <input type="date" name="dob"
                    class="mt-1 block w-full border border-gray-300 rounded-lg px-4 py-2 shadow-sm focus:ring-indigo-500 focus:border-indigo-500">
            </div>
            
             <!-- email -->
            <div>
                <label class="block text-sm font-medium text-gray-700">Email</label>
                <input type="text" name="email"
                    class="mt-1 block w-full border border-gray-300 rounded-lg px-4 py-2 shadow-sm focus:ring-indigo-500 focus:border-indigo-500">
            </div>

            <!-- Phone Number -->
            <div>
                <label class="block text-sm font-medium text-gray-700">Phone Number</label>
                <input type="text" name="phone_no" maxlength="10"
                    class="mt-1 block w-full border border-gray-300 rounded-lg px-4 py-2 shadow-sm focus:ring-indigo-500 focus:border-indigo-500">
            </div>

            <!-- Income -->
            <div>
                <label class="block text-sm font-medium text-gray-700">Annual Income (INR)</label>
                <input type="number" name="income" step="0.01" required
                    class="mt-1 block w-full border border-gray-300 rounded-lg px-4 py-2 shadow-sm focus:ring-indigo-500 focus:border-indigo-500">
            </div>

            <!-- Document type -->
            <div>
                <label class="block text-sm font-medium text-gray-700">Document Type (PDF)</label>
                <select name="doc_type" required
                        class="mt-1 block w-full border border-gray-300 rounded-lg px-4 py-2 shadow-sm focus:ring-indigo-500 focus:border-indigo-500">
                    <option value="pdf">Pdf</option>
                </select>
            </div>

            <!-- Document Url -->
            <div>
                <label class="block text-sm font-medium text-gray-700">Document Url</label>
                <input type="text" name="doc_url" step="0.01" required
                    class="mt-1 block w-full border border-gray-300 rounded-lg px-4 py-2 shadow-sm focus:ring-indigo-500 focus:border-indigo-500">
            </div>

            <!-- Dynamic Scholarship ID Dropdown -->
            <div>
                <label class="block text-sm font-medium text-gray-700">Select Scholarship</label>
                <select name="scholarship_id" required
                        class="mt-1 block w-full border border-gray-300 rounded-lg px-4 py-2 shadow-sm focus:ring-indigo-500 focus:border-indigo-500">
                    <%
                        ResultSet scholarships = (ResultSet) request.getAttribute("scholarships");
                        while (scholarships.next()) {
                            int scholarshipId = scholarships.getInt("scholarship_id");
                            String scholarshipName = scholarships.getString("scholarship_name");
                    %>
                            <option value="<%= scholarshipId %>"><%= scholarshipName %></option>
                    <% } %>
                </select>
            </div>

            <!-- Submit Button -->
            <div class="text-center">
                <button type="submit"
                    class="bg-indigo-600 text-white px-6 py-2 rounded-lg hover:bg-indigo-700 transition">Apply Now</button>
            </div>
        </form>
    </div>

</body>
</html>
