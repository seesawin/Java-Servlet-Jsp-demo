<%@ page language="java" contentType="text/html; charset=UTF-8"  %>

<!-- meta -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="description" content="my project" />

<%!
	// 強制更新js,css檔案
    private static final String JSVERSION = new java.text.SimpleDateFormat("yyyyMMddhhss").format(new java.util.Date());
%>

<!-- js -->
<script type="text/javascript" src="<c:url value='/js/jsfile1.js'/>?ver=<%= JSVERSION %>"></script>

<!-- css -->
<link href="<c:out value='${pageContext.request.contextPath}'/>/styles/style2.css>?ver=<%= JSVERSION %>" rel='stylesheet'>
<link href="<c:out value='${ctx}'/>/styles/style1.css>?ver=<%= JSVERSION %>" rel='stylesheet'>
