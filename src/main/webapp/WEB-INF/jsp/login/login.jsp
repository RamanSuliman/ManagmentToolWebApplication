<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Login</title>
</head>
<body>
    <h1>User Login</h1>
    <c:if test="${not empty message}">
        <p style="color: red">${message}</p>
    </c:if>
    <form method="post" action="login">
        <label>Username:</label>
        <input type="text" name="username" required/><br>
        <label>Password:</label>
        <input type="password" name="password" required/><br>
        <input type="submit" value="Login"/>
    </form>
</body>
</html>
