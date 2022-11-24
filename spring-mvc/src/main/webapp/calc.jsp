<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="calculate">
		Enter Number 1 : <input name="no1" value="${no1}" /><br> Enter
		Number 2 : <input name="no2" value="${no2}" /><br>
		<c:choose>

			<c:when test="${result!=null}">
				<button type="submit" disabled="disabled">Add</button>
			</c:when>
			<c:otherwise>
				<button type="submit">Add</button>
			</c:otherwise>

		</c:choose>


	</form>
	${result}
</body>
</html>