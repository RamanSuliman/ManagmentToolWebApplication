<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Registration</title>
</head>
<body>
    <h1>User Registration</h1>
    <form method="post" action="register">
        <label>Username:</label>
        <input type="text" name="username" required/><br>
        <label>Password:</label>
        <input type="password" name="password" required/><br>
        <label>Email:</label>
        <input type="email" name="email" required/><br>
        <input type="submit" value="Register"/>
    </form>
</body>
</html>
