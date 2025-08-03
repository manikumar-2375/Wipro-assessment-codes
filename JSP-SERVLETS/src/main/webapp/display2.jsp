<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Display User Info</title>
</head>
<body>
    <h2 style="text-align:center;">Submitted User Info</h2>
    <table align="center" border="1" cellpadding="5">
        <tr><td>User Name</td><td>${param.username}</td></tr>
        <tr><td>Password</td><td>${param.password}</td></tr>
        <tr><td>Address</td><td>${param.address}</td></tr>
        <tr><td>Subscribed</td><td>${param.subscribe}</td></tr>
        <tr><td>Gender</td><td>${param.gender}</td></tr>
        <tr><td>Favorite Number</td><td>${param.favnumb}</td></tr>
        <tr>
            <td>Favorite Frameworks</td>
            <td>
                <c:forEach var="fw" items="${paramValues.frameworks}">
                    ${fw} <br/>
                </c:forEach>
            </td>
        </tr>
    </table>
</body>
</html>
