<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ include file="/common/include.jsp"%>
<html>
<head>
<%@ include file="/common/html_header.jsp"%>
<title>CH07-index</title>
</head>
<body> 
<ol>
	<li><a href="<c:out value='${ctx}'/>/ch10/date?action=selectAll">查詢全部</a></li>
	<li><a href="<c:out value='${ctx}'/>/ch10/date?action=selectOne">單筆查詢</a></li>
	<li><a href="<c:out value='${ctx}'/>/jsp/ch10/ch10_date_insert.jsp">新增</a></li>
</ol>
</body>
</html>
