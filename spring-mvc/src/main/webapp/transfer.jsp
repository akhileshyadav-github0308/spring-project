<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Do Transfer</h1>
<form action="transfer">

From Account : 
<select name="acc1">
  <option value="101">101</option>
  <option value="102">102</option>
  <option value="103">103</option>
</select></br></br>
To Account : 
<select name="acc2">
  <option value="101">101</option>
  <option value="102">102</option>
  <option value="103">103</option>
</select></br></br>

Amount : <input name="amount" placeholder="5000"/></br>
<button type="submit">Transfer</button>

</form>

</body>
</html>