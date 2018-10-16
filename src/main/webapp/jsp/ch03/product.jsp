<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CH03-product(MVC)</title>
<style type="text/css">
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}

th {
	background-color: #4CAF50;
	color: white;
}
</style>
</head>
<body>
	<form action="/Java-Servlet-Jsp-demo/ch03/01" method="POST">
		Name:<input type="text" name="name" value="${name}">
		<input type="submit" value="confirm">
	</form>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Dscr</th>
				<th>Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${products}" var="item">
				<tr>
					<td><c:out value="${item.name}" /></td>
					<td><c:out value="${item.dscr}" /></td>
					<td><c:out value="${item.price}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
