<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ include file="/common/include.jsp"%>
<html>
<head>
<%@ include file="/common/html_header.jsp"%>
<title>ch07_result</title>
</head>
<body>
<h3>Login</h3>
Hi:${sessionScope.acct}
<div><a href="<c:out value='${ctx}'/>/jsp/ch07/ch07_index.jsp">回首頁</a></div>
</body>
</html>