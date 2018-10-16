<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/include.jsp"%>
<html>
<head>
<%@ include file="/common/html_header.jsp"%>
<title>CH05-EL calulation</title>
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
<body style='text-align: center;'>
	<h1>Arithmetic Operations in EL</h1>
	<table>
		<tr>
			<td WIDTH='300'>\${10 + 5}</td>
			<td WIDTH='100'>${10 + 5}</td>
		</tr>
		<tr>
			<td WIDTH='300'>\${10 * 5}</td>
			<td WIDTH='100'>${10 * 5}</td>
		</tr>
		<tr>
			<td WIDTH='300'>\${10 / 5}</td>
			<td WIDTH='100'>${10 / 5}</td>
		</tr>
		<tr>
			<td WIDTH='300'>\${10 mod 5}</td>
			<td WIDTH='100'>${10 mod 5}</td>
		</tr>
		<tr>
			<td WIDTH='300'>\${10 + 2 * 5}</td>
			<td WIDTH='100'>${10 + 2 * 5}</td>
		</tr>
		<tr>
			<td WIDTH='300'>\${(10 + 2) * 5}</td>
			<td WIDTH='100'>${(10 + 2) * 5}</td>
		</tr>
	</table>
	<p />
	<hr>
	<div style='text-align: left;'>
		客戶端電腦的IP為:<font color='red'>${pageContext.request.remoteHost}</font><br>
		客戶端使用的http方法為:<font color='red'>${pageContext.request.method}</font><br>
		客戶端的瀏覽器為:<font color='red'>${header['user-agent']}</font><br>
		客戶端的瀏覽器送出的請求標頭有:<br>
		<c:forEach var='entry' items='${headerValues}'>
	     	${entry.key} ==> 
	     	<c:forEach items="${entry.value}" varStatus="vs">
				<font color='red'>[${vs.index}]: ${entry.value[vs.index]}</font>
			</c:forEach>
			<br>
		</c:forEach>
		<p />
	</div>
</body>
</html>