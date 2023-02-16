<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New Password</title>
</head>
<body>
    <h1>New Password</h1>
    <form method="post" action="setNewUserPassword">
        <c:if test="${not empty user}">
            <input type="hidden" name="id" value="${user.id}"/>
            <label>Username:</label>
            <input type="text" name="username" value="${user.username}" readonly/><br>
            <label>Email:</label>
            <input type="email" name="email" value="${user.email}" readonly/><br>
            <label>New Password:</label>
            <input type="password" name="newPassword" required/><br>
            <input type="submit" value="Save New Password"/>
        </c:if>
   </form>
</body>
</html>