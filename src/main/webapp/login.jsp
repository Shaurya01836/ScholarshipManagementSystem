<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 flex items-center justify-center h-screen">

    <div class="bg-white p-8 rounded-xl shadow-md w-full max-w-md">
        <h2 class="text-2xl font-bold text-center text-gray-800 mb-6">Login</h2>

        <form action="Login" method="post" class="space-y-4">

            <div>
                <label class="block text-gray-700 font-semibold mb-1">Email</label>
                <input type="email" name="email" required
                       class="w-full px-4 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500">
            </div>

            <div>
                <label class="block text-gray-700 font-semibold mb-1">Password</label>
                <input type="password" name="password" required
                       class="w-full px-4 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500">
            </div>

            <div>
                <label class="block text-gray-700 font-semibold mb-1">Role</label>
                <select name="role" required
                        class="w-full px-4 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500">
                    <option value="student">Student</option>
					<option value="admin">Admin</option>
                </select>
            </div>

            <div class="text-center">
                <input type="submit" value="Login"
                       class="w-full bg-blue-600 text-white py-2 rounded-md font-semibold hover:bg-blue-700 transition duration-200">
            </div>

        </form>
    </div>

</body>
</html>
