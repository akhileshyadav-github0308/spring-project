<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<c:if test="${ account!=null}">

Search Result :</br>

Account : ${account.accNo}</br>
Account Name: ${account.name}</br>
Balance : ${account.balance}</br>

Transcartion Deytails:

<table border="2" style="background-color: aqua; border-color: red blue gold teal;">
<tr><th>TxNo</th><th>Date & Time </th><th>Type</th><th>Amount</th></tr>

<c:forEach items="${account.transactions }" var="t">

<tr>
<td>${t.txnNo }</td>
<td>${t.dateAndTime }</td>
<td>${t.type }</td>
<td>${t.amoount }</td>

</tr>

</c:forEach>



</table>




</c:if>

</body>
</html>