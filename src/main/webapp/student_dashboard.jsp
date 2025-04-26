<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Dashboard</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gradient-to-br from-blue-50 to-gray-100 min-h-screen font-sans">

    <!-- Navbar -->
    <nav class="bg-blue-700 text-white py-4 shadow-lg">
        <div class="max-w-7xl mx-auto px-6 flex justify-between items-center">
            <h1 class="text-3xl font-bold tracking-wide">🎓 Student Dashboard</h1>
            <div class="flex items-center space-x-4">
                <span class="text-lg">Welcome, <%= session.getAttribute("studentName") != null ? session.getAttribute("studentName") : "Student" %></span>
            </div>
        </div>
    </nav>

    <!-- Main Content -->
    <main class="max-w-7xl mx-auto px-6 py-12">
        <div class="grid grid-cols-1 md:grid-cols-3 gap-8">

            <!-- Apply Scholarship -->
            <div class="bg-white rounded-2xl shadow-md p-8 text-center hover:shadow-2xl transition duration-300">
                <div class="text-blue-500 text-4xl mb-4">📄</div>
                <h2 class="text-2xl font-semibold mb-2">Apply for Scholarship</h2>
                <p class="text-gray-600 mb-6">Explore scholarships and apply easily from here.</p>
                <a href="ScholarshipRecordList" class="inline-block bg-blue-600 text-white px-6 py-2 rounded-lg hover:bg-blue-700 transition">Apply Now</a>
            </div>

            <!-- View Applications -->
            <div class="bg-white rounded-2xl shadow-md p-8 text-center hover:shadow-2xl transition duration-300">
                <div class="text-green-500 text-4xl mb-4">📋</div>
                <h2 class="text-2xl font-semibold mb-2">My Applications</h2>
                <p class="text-gray-600 mb-6">Track the status of your scholarship submissions.</p>
                <a href="MyApplication" class="inline-block bg-green-600 text-white px-6 py-2 rounded-lg hover:bg-green-700 transition">View</a>
            </div>

            <!-- Upload Documents (Optional) -->
            <%-- 
            <div class="bg-white rounded-2xl shadow-md p-8 text-center hover:shadow-2xl transition duration-300">
                <div class="text-yellow-500 text-4xl mb-4">📁</div>
                <h2 class="text-2xl font-semibold mb-2">Documents</h2>
                <p class="text-gray-600 mb-6">Upload and manage your documents here.</p>
                <a href="upload_documents.jsp" class="inline-block bg-yellow-500 text-white px-6 py-2 rounded-lg hover:bg-yellow-600 transition">Upload</a>
            </div>
            --%>

        </div>
        
    </main>
    

</body>
</html>
