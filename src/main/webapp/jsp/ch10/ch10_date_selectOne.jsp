<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ include file="/common/include.jsp"%>
<html>
<head>
<%@ include file="/common/html_header.jsp"%>
<title>CH07-index</title>
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
		dYear4:<input type="text" name="dYear4" value="${dYear4}">
		<input type="hidden" name="action" value="selectOne">
		<input type="submit" value="confirm">
		<span style="color:red">${errMsg}</span>
	</form>
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
				<td><c:out value="${bean.dYear4}" /></td>
			</tr>
			<tr>
				<td>dDate</td>
				<td><c:out value="${bean.dDate}" /></td>
			</tr>
			<tr>
				<td>dTime</td>
				<td><c:out value="${bean.dTime}" /></td>
			</tr>
			<tr>
				<td>dDatetime</td>
				<td><c:out value="${bean.dDatetime}" /></td>
			</tr>
			<tr>
				<td>dTimestamp</td>
				<td><c:out value="${bean.dTimestamp}" /></td>
			</tr>
		</tbody>
	</table>
	<c:if test="${not empty bean.dYear4}">
	<div align="center">
		<div align="left">
	        <form action="${ctx}/ch10/date" method="POST">
				<input type="hidden" name="action" value="update">
				<input type="hidden" name="updateAction" value="updateInit">
				<input type="hidden" name="dYear4" value="${bean.dYear4}">
				<input type="submit" value="Update">
			</form>
	    </div>
	    <div align="right">
	        <form action="${ctx}/ch10/date" method="POST">
				<input type="hidden" name="action" value="delete">
				<input type="hidden" name="dYear4" value="${bean.dYear4}">
				<input type="submit" value="Delete">
			</form>
	    </div>
    </div>
	</c:if>
	<a href="<c:out value='${ctx}'/>/ch10/date?action=init">回Date example</a>
</body>
</html>
