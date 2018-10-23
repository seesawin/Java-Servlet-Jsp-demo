<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/include.jsp"%>
<%@ page import="com.seesawin.demo.ch05.model.*"%>
<html>
<head>
<%@ include file="/common/html_header.jsp"%>
<title>CH05-EL basic</title>
</head>
<body>
	<h3>屬性物件是字串物件==>透過 EL 來取用，\${識別字串}</h3>
	<font><b>傳統動態網頁取值寫法 ，最複雜</b></font><br>
	<%
		String product = (String) request.getAttribute("Case1");
	%>
	<font Color='pink'>
		<% out.println(product); %>
	</font><br><br>
	
	<font><b>運算標籤取值，稍微簡化複雜度</b></font><br>
	<font Color='blue'>
		<%=product%>
	</font><br><br>
	
	<font><b>EL取值，最簡潔有力</b></font><br>
	<font Color='darkblue'>
		${Case1} 
	</font><br>
	<hr>
	
	
	<h3>Case2 屬性物件是JavaBean物件==>透過 EL 來取用，\${識別字串.JavaBean的性質}</h3>
	<font><b>運算標籤取JavaBeam</b></font><br>
	<font><b>EL取JavaBeam</b></font><br>
	<font Color='red'> 訂單編號：${Case2.orderNo} <br>
		訂單日期：${Case2.orderDate} <br> 
		客戶編號：${Case2.customerID} <br>
		訂單金額：${Case2.amount} <br>
	</font>
	<hr>
	
	
	<h3>Case3 屬性物件是Map物件==>透過EL來取用，\${識別字串.鍵值}就可取得對應的value，<br>
	如果value為JavaBean則\${識別字串.鍵值.Bean的性質名稱}就可以取得對應的性質</h3>
	
	<font><b>運算標籤取Map再取JavaBeam</b></font><br>
	<%
		Map<String, Object> case3Map = (Map<String, Object>) request.getAttribute("Case3");
		String str_a = (String) case3Map.get("mapkey1");
		OrderBean ob_b = (OrderBean) case3Map.get("mapkey2");
	%>
	<font Color='pink'> mapkey1對應字串物件：<%=str_a%> <br>
		訂單編號：<%=ob_b.getOrderNo()%> <br>
		訂單日期：<%=ob_b.getOrderDate()%> <br>
		客戶編號：<%=ob_b.getCustomerID()%> <br>
		訂單金額：<%=ob_b.getAmount()%> <br>
	</font><br>
	
	<font><b>EL取Map中的JavaBeam</b></font><br>
	<font Color='blue'> mapkey1對應字串物件：${Case3.mapkey1} <br>
		訂單編號：${Case3.mapkey2.orderNo} <br>
		訂單日期：${Case3.mapkey2.orderDate} <br>
		客戶編號：${Case3.mapkey2.customerID} <br>
		訂單金額：${Case3.mapkey2.amount} <br>
	</font>
	<hr>
	
	
	<h3>Case4 屬性物件是元素是JavaBean物件的陣列==>搭配JSTL的＜c:forEach＞ 與 EL 來取用</h3>
	<font><b>運算標籤取Array再取陣列中的物件</b></font><br>
	<%
		OrderBean[] obArr = (OrderBean[]) request.getAttribute("Case4");
		for(int i = 0; i < obArr.length; i ++) {
			%>
			訂單編號：<%=obArr[i].getOrderNo()%> <br>
			訂單日期：<%=obArr[i].getOrderDate()%> <br>
			客戶編號：<%=obArr[i].getCustomerID()%> <br>
			訂單金額：<%=obArr[i].getAmount()%> <br>
			------------------------------------------<br>
			<%
		}
	%>
	<br>
	<font><b>EL取Array再取陣列中的物件</b></font><br>
	<font Color='brown'> 
		<c:forEach var="aVar" items="${Case4}">
			訂單編號：${aVar.orderNo} <br>
			訂單日期：${aVar.orderDate} <br>
			客戶編號：${aVar.customerID} <br>
			訂單金額：${aVar.amount} <br>
			------------------------------------------<br>
		</c:forEach>
	</font>
	<hr>
	
	
	<h3>Case5 屬性物件是元素是JavaBean物件的Collection==>搭配JSTL的＜c:forEach＞與EL 來取用</h3>
	<font><b>運算標籤取Collection再取其中的物件</b></font><br>
	<font Color='pink'> 
	<%
		Collection<OrderBean> collectionObs = (Collection<OrderBean>) request.getAttribute("Case5_1");
	
		for (Iterator<OrderBean> iterator = collectionObs.iterator(); iterator.hasNext();) {
			OrderBean ob_c = (OrderBean) iterator.next();  
			%>
			訂單編號：<%=ob_c.getOrderNo()%> <br>
			訂單日期：<%=ob_c.getOrderDate()%> <br>
			客戶編號：<%=ob_c.getCustomerID()%> <br>
			訂單金額：<%=ob_c.getAmount()%> <br>
			------------------------------------------<br>
			<%
		}
	%>
	</font>
	<hr>
	<font><b>運算標籤取Collection再取其中的物件，使用語法糖</b></font><br>
	<font>
	<%
		for (OrderBean beam : collectionObs) {
			%>
			訂單編號：<%=beam.getOrderNo()%> <br>
			訂單日期：<%=beam.getOrderDate()%> <br>
			客戶編號：<%=beam.getCustomerID()%> <br>
			訂單金額：<%=beam.getAmount()%> <br>
			------------------------------------------<br>
			<%
		}
	%>
	</font>
	<br>
	<font><b>運算標籤取List再取其中的物件</b></font><br>
	<font Color='blue'> 
	<%
		List<OrderBean> obList = (List<OrderBean>) request.getAttribute("Case5_2");
		for (int i = 0; i < obList.size(); i++) {
			OrderBean ob_d = obList.get(i);  
			%>
			訂單編號：<%=ob_d.getOrderNo()%> <br>
			訂單日期：<%=ob_d.getOrderDate()%> <br>
			客戶編號：<%=ob_d.getCustomerID()%> <br>
			訂單金額：<%=ob_d.getAmount()%> <br>
			------------------------------------------<br>
			<%
		}
	%>
	</font>
	<hr>
	<font><b>運算標籤取List再取其中的物件，使用語法糖</b></font><br>
	<font>
	<%
		for (OrderBean beam : obList) {
			%>
			訂單編號：<%=beam.getOrderNo()%> <br>
			訂單日期：<%=beam.getOrderDate()%> <br>
			客戶編號：<%=beam.getCustomerID()%> <br>
			訂單金額：<%=beam.getAmount()%> <br>
			------------------------------------------<br>
			<%
		}
	%>
	</font>
	<br>
	<font><b>EL取Collection再取其中的物件</b></font><br>
	<font Color='purple'> 
		<c:forEach var="aVar" items="${Case5_1}">
			訂單編號：${aVar.orderNo} <br>
			訂單日期：${aVar.orderDate} <br>
			客戶編號：${aVar.customerID} <br>
			訂單金額：${aVar.amount} <br>
			------------------------------------------<br>
		</c:forEach>
	</font>
	<br>
	<hr>
	<font><b>EL取List再取其中的物件</b></font><br>
	<font Color='purple'> 
		<c:forEach var="aVar" items="${Case5_2}">
			訂單編號：${aVar.orderNo} <br>
			訂單日期：${aVar.orderDate} <br>
			客戶編號：${aVar.customerID} <br>
			訂單金額：${aVar.amount} <br>
			------------------------------------------<br>
		</c:forEach>
	</font>
	<hr>
	
	
	<h3>Case6 屬性物件是元素是JavaBean物件的Map==>搭配JSTL的＜c:forEach＞與EL 來取用</h3>
	<font><b>自行處理Map中的物件</b></font><br>
	<font Color='green'> 
	<%
		Map<String, Object> case6Map = (Map<String, Object>) request.getAttribute("Case6");
		OrderBean mapkey1 = (OrderBean) case6Map.get("obmKey1");
		OrderBean mapkey2 = (OrderBean) case6Map.get("obmKey2");
		OrderBean mapkey3 = (OrderBean) case6Map.get("obmKey3");
		%>
			Map的Key：mapkey1 <br>
			訂單編號：<%=mapkey1.getOrderNo()%> <br>
			訂單日期：<%=mapkey1.getOrderDate()%> <br>
			客戶編號：<%=mapkey1.getCustomerID()%> <br>
			訂單金額：<%=mapkey1.getAmount()%> <br>
			------------------------------------------<br>
			Map的Key：mapkey2 <br>
			訂單編號：<%=mapkey2.getOrderNo()%> <br>
			訂單日期：<%=mapkey2.getOrderDate()%> <br>
			客戶編號：<%=mapkey2.getCustomerID()%> <br>
			訂單金額：<%=mapkey2.getAmount()%> <br>
			------------------------------------------<br>
			Map的Key：mapkey3 <br>
			訂單編號：<%=mapkey3.getOrderNo()%> <br>
			訂單日期：<%=mapkey3.getOrderDate()%> <br>
			客戶編號：<%=mapkey3.getCustomerID()%> <br>
			訂單金額：<%=mapkey3.getAmount()%> <br>
			------------------------------------------<br>
		<%
	%>
	</font>
	<br>
	<font><b>EL標籤取Map中的物件</b></font><br>
	<font Color='red'> 
		<c:forEach var="anEnter" items="${Case6}">
			Map的Key：${anEnter.key} <br>
			訂單編號：${anEnter.value.orderNo} <br>
			訂單日期：${anEnter.value.orderDate} <br>
			客戶編號：${anEnter.value.customerID} <br>
			訂單金額：${anEnter.value.amount} <br>
			------------------------------------------<br>
		</c:forEach>
	</font>
</body>
</html>