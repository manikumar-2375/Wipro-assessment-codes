<!DOCTYPE html>
<html>
<head>
    <title>Bank Account Entry</title>
</head>
<body>
    <h2>Enter Bank Account Details</h2>
    <form action="display5.jsp" method="post">
        Account No: <input type="text" name="accountNo" /><br><br>
        Name: <input type="text" name="name" /><br><br>
        Balance: <input type="text" name="balance" /><br><br>
        Account Type: 
        <select name="type">
            <option value="Savings">Savings</option>
            <option value="Current">Current</option>
        </select><br><br>
        <input type="submit" value="Submit" />
    </form>
</body>
</html>
