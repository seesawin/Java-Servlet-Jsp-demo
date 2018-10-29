<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ include file="/common/include.jsp"%>
<html>
<head>
<%@ include file="/common/html_header.jsp"%>
<title>CH07-index</title>
</head>
<body> 
<ol>
	<li><a href="<c:out value='${ctx}'/>/jsp/ch07/ch07_01.jsp">基本觀念</a></li>
	<li><a href="<c:out value='${ctx}'/>/ch07/login?action=init">Session應用(login)</a></li>
</ol>
</body>
</html>
