<%@ page import="com.jsp.AccountBean5" %>
<jsp:useBean id="account" class="com.jsp.AccountBean5" scope="request" />
<jsp:setProperty name="account" property="*" />

<%
    // Store account type in session
    String type = request.getParameter("type");
    session.setAttribute("type", type);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Account Details</title>
</head>
<body>
    <h2>Bank Account Information (Using EL)</h2>
    <p><strong>Account No:</strong> ${account.accountNo}</p>
    <p><strong>Name:</strong> ${account.name}</p>
    <p><strong>Balance:</strong> ${account.balance}</p>
    <p><strong>Account Type:</strong> ${sessionScope.type}</p>

    <h3>
        Balance Status:
        <c:choose>
            <c:when test="${account.balance >= 1000}">
                ✅ Sufficient
            </c:when>
            <c:otherwise>
                ❌ Insufficient
            </c:otherwise>
        </c:choose>
    </h3>
</body>
</html>
