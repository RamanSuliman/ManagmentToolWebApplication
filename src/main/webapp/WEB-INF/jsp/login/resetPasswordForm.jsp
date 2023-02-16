<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Reset Password</title>
</head>
<body>
    <h1>Reset Password</h1>
    <c:if test="${not empty message}">
        <p style="color: red">${message}</p>
    </c:if>
    <form method="post" action="reset-password">
        <label>Email:</label>
        <input type="email" name="email" required/><br>
        <input type="submit" value="Reset Password"/>
    </form>
</body>
</html>
