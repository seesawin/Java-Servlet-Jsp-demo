<!-- JSP 指令
	1.page
	2.taglib
	3.include
	 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!-- JSTL標籤庫  ，標籤背後都有相對的Java程式在運作-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- 清除暫存 -->
<%
	response.setHeader("Pragma", "No-Cache");
	response.setHeader("Cache-Control", "No-Cache");
	response.setDateHeader("Expires", 0);
%>

<!-- 設定共用變數 -->
<c:set var="ctx" value='${pageContext.request.contextPath}' />

<!-- import some common package -->
<%@ page import="java.util.*"%>

<!-- other jsp -->
<%-- <%@ include file="xxx.jsp"%> --%>
