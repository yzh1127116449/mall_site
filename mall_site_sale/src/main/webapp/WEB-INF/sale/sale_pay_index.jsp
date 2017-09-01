<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>">
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/css.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">

</script>
<title>订单支付</title>
</head>
<body>

	订单确认页面<br>
	<form action="saveOrder.do" method="post">
	用户地址列表：
	<input type="radio" name="address_id" value="1"/>北京市昌平区北七家镇郑平路
		<c:forEach items="${userAddress}" var="address">
			
		</c:forEach>
		<hr>
		
		${order.jdh} ￥：${order.zje}<br>
		<c:forEach items="${order.listOrder}" var="flow">
		库存地址：${flow.ckdz}<br/>
			${flow.psfsh}<br>${flow.mqdd}
			<div style="border:red 1px solid;">
				<c:forEach items="${flow.listOrderInfo}" var="info">
					<img src="upload/image/${info.shpTp}" width="70px"/>
					${info.skuMch} ￥：${info.skuJg}<br>
				</c:forEach>
			</div>
		</c:forEach>
		<br>
		<input type="submit" value="提交订单"/>
	</form>
</body>
</html>