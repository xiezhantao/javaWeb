<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
	<%@include file="/pages/common/Head.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">我的订单</span>
		<%@include file="/pages/common/login_success_menu.jsp"%>
	</div>
	
	<div id="main">
		
		<table>
			<c:forEach items="${requestScope.myOrders}" var="order">
			<tr>
				<td>日期</td>
				<td>金额</td>
				<td>状态</td>
				<td>详情</td>
				<c:if test="${order.status == 1}">
					<td>收货</td>
				</c:if>
			</tr>
			<tr>
				<td>${order.createTime}</td>
				<td>${order.price}</td>
				<c:if test="${order.status == 0}">
					<td>未发货</td>
				</c:if>
				<c:if test="${order.status == 1}">
					<td>已发货</td>
				</c:if>
				<c:if test="${order.status == 2}">
					<td>已完成</td>
				</c:if>
				<td><a href="orderServlet?action=showOrderDetail&orderId=${order.orderId}">查看详情</a></td>
				<c:if test="${order.status == 1}">
					<td><a href="orderServlet?action=receiver&orderId=${order.orderId}">点击收货</a></td>
				</c:if>
			</tr>
			</c:forEach>
		</table>
		
	
	</div>

	<%@include file="/pages/common/foot.jsp"%>
</body>
</html>