<!-- 導入共用標籤 -->
<%@ include file="/common/include.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<!-- 導入共用設定 -->
<%@ include file="/common/html_header.jsp"%>
<title>CH04-02</title>
</head>
<body>
	<h3>JSP網頁內指令</h3>
	<br>
	<ol>
		<li>page</li>
		<li>include</li>
		<li>taglib</li>
	</ol>
	
	<!-- include 靜態包含網頁，不可傳參數 -->
	<div>
		<%@ include file="/jsp/ch04/ch04_01.jsp"%>
	</div>
	
	<!-- jsp:include 動態包含網頁，可傳參數 -->
	<div>
		<jsp:include page="ch04_01.jsp">
			<jsp:param name="name" value="Joe" />
			<jsp:param name="product" value="iWatch" />
			<jsp:param name="count" value="3" />
		</jsp:include>
	</div>
	
	<!-- c:import 動態包含網頁，可傳參數，可訪問其他網站 -->
	<div>
		<c:import url="ch04_01.jsp?name=Paul&product=iBike&count=2"></c:import>
	</div>
	<hr>
	<div>
		<c:import url="https://www.google.com.tw"></c:import>
	</div>
</body>
</html>
