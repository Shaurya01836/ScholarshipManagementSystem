<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Panel</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gradient-to-br from-gray-50 to-blue-100 min-h-screen font-sans flex flex-col">

    <!-- Navbar -->
    <nav class="bg-gray-800 text-white py-4 shadow-lg">
        <div class="max-w-7xl mx-auto px-6 flex justify-between items-center">
            <h1 class="text-3xl font-bold tracking-wide">🛠 Admin Panel</h1>
            <div class="flex items-center space-x-4">
                <span class="text-lg">Hello, <%= session.getAttribute("officerName") != null ? session.getAttribute("officerName") : "Admin" %></span>

            </div>
        </div>
    </nav>

    <!-- Main Content -->
    <main class="flex-grow max-w-7xl mx-auto px-6 py-12">
        <div class="grid grid-cols-1 md:grid-cols-3 gap-8">

            <!-- Manage Scholarships -->
            <div class="bg-white rounded-2xl shadow-md p-8 text-center hover:shadow-2xl transition duration-300">
                <div class="text-blue-500 text-4xl mb-4">💼</div>
                <h2 class="text-2xl font-semibold mb-2">Manage Scholarships</h2>
                <p class="text-gray-600 mb-6">Add, edit, or remove scholarships.</p>
                <a href="ScholarshipRecordList" class="inline-block bg-blue-600 text-white px-6 py-2 rounded-lg hover:bg-blue-700 transition">Go</a>
            </div>

            <!-- Review Applications -->
            <div class="bg-white rounded-2xl shadow-md p-8 text-center hover:shadow-2xl transition duration-300">
                <div class="text-green-500 text-4xl mb-4">📝</div>
                <h2 class="text-2xl font-semibold mb-2">Review Applications</h2>
                <p class="text-gray-600 mb-6">Approve or reject student applications.</p>
                <a href="ReviewApplications" class="inline-block bg-green-600 text-white px-6 py-2 rounded-lg hover:bg-green-700 transition">Go</a>
            </div>

            <!-- Verify Documents (Optional) -->
            <%-- 
            <div class="bg-white rounded-2xl shadow-md p-8 text-center hover:shadow-2xl transition duration-300">
                <div class="text-yellow-500 text-4xl mb-4">📂</div>
                <h2 class="text-2xl font-semibold mb-2">Verify Documents</h2>
                <p class="text-gray-600 mb-6">Check uploaded student documents.</p>
                <a href="verify_documents.jsp" class="inline-block bg-yellow-500 text-white px-6 py-2 rounded-lg hover:bg-yellow-600 transition">Go</a>
            </div>
            --%>

        </div>
    </main>

    <!-- Sticky Footer -->
    <footer class="bg-gray-800 text-white text-center py-4 shadow-inner">
        &copy; <%= java.time.Year.now() %> Scholarship Portal | All rights reserved.
    </footer>

</body>
</html>
