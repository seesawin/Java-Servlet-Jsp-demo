<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ include file="/common/include.jsp"%>
<html>
<head>
<%@ include file="/common/html_header.jsp"%>
<title>CH09-XSRF</title>
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
<h3>XSRF test</h3>
Online:${applicationScope.numSessions}
<form action="<c:out value='${ctx}'/>/ch09/xsrf" method="POST">
	<input type="hidden" name="action" value="check">
	<input type="text" name="acct" value="${requestScope.acct}"><br>
	<input type="text" name="pwd" value="${requestScope.pwd}"><br>
	<input type="submit" value="confirm"><span style="color:red;">${requestScope.errMsg}</span>
</form>

<c:if test="${requestScope.errors ne null && fn:length(requestScope.errors) ne 0}">
<table>
	<thead>
		<tr>
			<th>message</th>
			<th>logMessage</th>
		</tr>
	</thead>
	<c:forEach var="item" items="${requestScope.errors}">
	<tbody>
	    <tr>
	        <td><c:out value="${item.message}"/></td>
	        <td><c:out value="${item.logMessage}"/></td>
	    </tr>
	</tbody>
	</c:forEach>
</table>
</c:if>
</body>
</html>