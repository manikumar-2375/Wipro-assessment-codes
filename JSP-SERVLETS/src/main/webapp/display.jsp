<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Result</title>
</head>
<body>
    <h2 style="text-align: center;">User Registration Details</h2>
    <table border="1" cellpadding="8" style="margin: auto;">
        <tr><td>Full Name:</td><td>${fullname}</td></tr>
        <tr><td>Email:</td><td>${email}</td></tr>
        <tr><td>Password:</td><td>${password}</td></tr>
        <tr><td>Birthday:</td><td>${birthday}</td></tr>
        <tr><td>Gender:</td><td>${gender}</td></tr>
        <tr><td>Profession:</td><td>${profession}</td></tr>
        <tr><td>Married:</td><td>${married}</td></tr>
        <tr><td>Note:</td><td>${note}</td></tr>
    </table>
</body>
</html>
