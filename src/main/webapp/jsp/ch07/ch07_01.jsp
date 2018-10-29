<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ include file="/common/include.jsp"%>
<html>
<head>
<%@ include file="/common/html_header.jsp"%>
<title>ch07_01</title>
</head>
<body>
	<h3>Session</h3>
	<ul>
		<li>HTTP為一種"乏態(stateless)的通訊協定"，由於此協定沒有足夠的資訊來區分請求，因此無法由<span style="color:red;">請求(request)</span>來分辨客戶</li>
		<ul>
			<li>無法區分甲、乙、丙...不同客戶間的多次請求</li>
			<li>無法持訊追蹤(紀錄)同一個客戶在多個網頁下留下來的選擇</li>
			<li><span style="color:red;">Solution:</span>同一個使用者在某段時間內，對同一個網站所提出的所有請求形成一個Session</li>
		</ul>
		<li>如果程式提出要求，<span style="color:red;">容器(Tomcat)會準備一個HttpSession物件</span></li>
		<ul>
			<li><span style="color:red;">含有唯一的sessionId，預設使用Cookie來儲存</span></li>
			<li>可以存放同一使用者每次請求的資訊</li>
				<ul>
					<li><span style="color:red;">session.setAttribute(Key,Value)</span></li>
				</ul>
			<li>可以存放同一使用者先前請求時所存放的資訊</li>
				<ul>
					<li><span style="color:red;">Object obj = session.getAttribute(Key)</span></li>
				</ul>
		</ul>
		<li><span style="color:red;">SessionId必須在每次瀏覽器請求、伺服器回應之間來回傳送，不能中斷任何一次，容器才能依據SessionId來找到對應客戶的HttpSession物件</span></li>
		<li>由於伺服器記憶體有限，容器無法長時間保存Session物件，因此必須控制session的數量避免資源消耗</li>
		<li><span style="color:red;">Session的有效範圍能和跨多次請求，此種範圍稱Session scope</span></li>
	</ul>
	
	<h3>Cookie</h3>
	<ul>
		<li>包含在HTTP請求與回應內的文字資料，目的是儲存使用者的瀏覽資訊。如果客戶接受Cookie，瀏覽器會將收到的Cookie儲存在硬碟(生命週期至未來某個時間點)或主記憶體內(生命週期至瀏覽器關閉前)</li>
		<li>儲存位置如：C:\Users\jay\AppData\Local\Google\Chrome\User Data\Default\Cookies</li>
	</ul>
</body>
</html>