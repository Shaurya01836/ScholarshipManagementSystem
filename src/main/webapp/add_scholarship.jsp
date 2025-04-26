<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Scholarship</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 min-h-screen flex items-center justify-center">
    <div class="bg-white shadow-lg rounded-lg p-8 w-full max-w-xl">
        <h2 class="text-2xl font-bold mb-6 text-center text-indigo-600">Add New Scholarship</h2>
        <form action="AddScholarship" method="post" class="space-y-4">
            
            <div>
                <label class="block text-gray-700 font-medium mb-1">Scholarship Name</label>
                <input type="text" name="scholarship_name" required
                    class="w-full border border-gray-300 rounded px-4 py-2 focus:outline-none focus:ring-2 focus:ring-indigo-500">
            </div>

            <div>
                <label class="block text-gray-700 font-medium mb-1">Description</label>
                <textarea name="description" rows="4" required
                    class="w-full border border-gray-300 rounded px-4 py-2 focus:outline-none focus:ring-2 focus:ring-indigo-500"></textarea>
            </div>

            <div>
                <label class="block text-gray-700 font-medium mb-1">Eligibility Criteria</label>
                <textarea name="eligibility_criteria" rows="4" required
                    class="w-full border border-gray-300 rounded px-4 py-2 focus:outline-none focus:ring-2 focus:ring-indigo-500"></textarea>
            </div>

            <div>
                <label class="block text-gray-700 font-medium mb-1">Amount</label>
                <input type="number" name="amount" required
                    class="w-full border border-gray-300 rounded px-4 py-2 focus:outline-none focus:ring-2 focus:ring-indigo-500">
            </div>

            <div>
                <label class="block text-gray-700 font-medium mb-1">Status</label>
                <select name="status" required
                    class="w-full border border-gray-300 rounded px-4 py-2 focus:outline-none focus:ring-2 focus:ring-indigo-500">
                    <option value="active">Active</option>
                    <option value="inactive">Inactive</option>
                </select>
            </div>

            <div class="text-center">
                <button type="submit"
                    class="bg-indigo-600 text-white px-6 py-2 rounded hover:bg-indigo-700 transition duration-200">
                    Add Scholarship
                </button>
            </div>
        </form>
    </div>
</body>
</html>
