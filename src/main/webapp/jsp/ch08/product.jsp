<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/include.jsp"%>
<html>
<head>
<%@ include file="/common/html_header.jsp"%>
<title>CH08-product(MVC)</title>
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
	<div>
		Hi:${sessionScope.user.acct}
		<form action="${ctx}/ch08/login" >
			<input type="hidden" name="action" method="POST" value="logOut">
			<input type="submit" value="登出">
		</form>
	</div>
	<form action="${ctx}/ch08/product" method="POST">
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
	<div><a href="<c:out value='${ctx}'/>/jsp/ch08/ch08_index.jsp">回首頁</a></div>
</body>
</html>
