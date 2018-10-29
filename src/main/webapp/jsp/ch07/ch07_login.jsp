<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ include file="/common/include.jsp"%>
<html>
<head>
<%@ include file="/common/html_header.jsp"%>
<title>ch07_login</title>
</head>
<body>
<h3>Login</h3>
<form action="<c:out value='${ctx}'/>/ch07/login" method="POST">
	<input type="hidden" name="action" value="check">
	帳號:<input type="text" name="acct" value="${requestScope.acct}"><br>
	密碼:<input type="text" name="pwd" value="${requestScope.pwd}"><br><span style="color:red;">${requestScope.errMsg}</span>
	<input type="submit" value="confirm">
</form>
</body>
</html>