<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	
	//请求迷你购物车页面
	function showCartInfo(){
		
		$("#miniCart").show();
		$.post("getMiniCart.do",function(data){
			$("#miniCart").html(data);
			
		});
	}
	function showCartInner(){
			
			$("#miniCart").show();
			
		}
	function hiddenCartInfo(){
		$("#miniCart").hide();
	}
</script>
<title>硅谷电商系统</title>
</head>
<body>

	<div class="card">
		<a href="cartIndex.htm" target="_blank"  onmouseover="showCartInfo()" onmouseout="hiddenCartInfo()">购物车
			<div class="num" id="cart_num">0</div>
		</a>

		<!--购物车商品-->
		<div class="cart_pro" id="miniCart" style="display: none;" onmouseover="showCartInner()" onmouseout="hiddenCartInfo()"></div>
	</div>

</body>
</html>