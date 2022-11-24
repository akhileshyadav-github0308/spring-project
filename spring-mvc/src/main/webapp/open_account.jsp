<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Create Account</h1>
<form action="openAccount">
Enter Your Name : <input type="text" name="name"/></br>
Account Type: 
<select name="type">
  <option value="saving">Saving</option>
  <option value="current">Current</option>
</select></br>
Initial Balance : <input name="balance" placeholder="5000"/></br>
<button type="submit">Open Account</button>

</form>

</body>
</html>