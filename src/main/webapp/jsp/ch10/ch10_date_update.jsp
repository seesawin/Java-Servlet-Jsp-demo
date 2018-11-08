<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ include file="/common/include.jsp"%>
<html>
<head>
<%@ include file="/common/html_header.jsp"%>
<title>CH10-DATE-UPDATEX</title>
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
	<form action="${ctx}/ch10/date" method="POST">
		<table>
			<thead>
				<tr>
					<th>title</th>
					<th>time</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>dYear4</td>
					<td><input type="date" name="dYear4" value="${bean.dYear4}"></td>
					
				</tr>
				<tr>
					<td>dDate</td>
					<td><input type="date" name="dDate" value="${bean.dDate}"></td>
				</tr>
			</tbody>
		</table>
		<input type="hidden" name="action" value="update">
		<input type="hidden" name="updateAction" value="updateData">
		<input type="submit" value="confirm">
		<span style="color:red">${errMsg}</span>
	</form>
	<a href="<c:out value='${ctx}'/>/ch10/date?action=init">回Date example</a>
</body>
</html>
