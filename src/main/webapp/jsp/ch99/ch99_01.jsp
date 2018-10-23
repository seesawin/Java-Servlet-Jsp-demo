<!-- 導入共用標籤 -->
<%@ include file="/common/include.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<!-- 導入共用設定 -->
<%@ include file="/common/html_header.jsp"%>
<title>CH06-01</title>
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
	<h3>範圍-SCOPE</h3>
	<br>
	<table>
		<thead>
			<tr>
				<th>Scope</th>
				<th>Value</th>
				<th>Remarks</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>applicationScope</td>
				<td>${applicationScope.userName}</td>
				<td>${applicationScope.remarks}</td>
			</tr>
			<tr>
				<td>sessionScope</td>
				<td>${sessionScope.userName}</td>
				<td>${sessionScope.remarks}</td>
			</tr>
			<tr>
				<td>requestScope</td>
				<td>${requestScope.userName}</td>
				<td>${requestScope.remarks}</td>
			</tr>
			<tr>
				<%
					pageContext.setAttribute("userName", "Denny");
					pageContext.setAttribute("remarks", "此變量只在\"當前的JSP\"有效");
				%>
				<td>pageScope</td>
				<td>${pageScope.userName}</td>
				<td>${pageScope.remarks}</td>
			</tr>
		</tbody>
	</table>
</body>
</html>
