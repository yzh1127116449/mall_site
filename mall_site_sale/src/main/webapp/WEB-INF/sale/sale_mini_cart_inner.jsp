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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">

	//请求迷你购物车页面
	function showCartInfo(){
		
		$("#miniCart").show();
		$.post("getMiniCart.do",function(data){
			$("#miniCart").html(data);
		});
	}
	function hiddenCartInfo(){
		$("#miniCart").hide();
	}
	function ToCart(){
		window.location.href = "cartIndex.htm";
	}
	function search_details(skuId,spuId){
		window.location.href = "search_details.do?skuId="+skuId+"&spuId="+spuId;
	}
</script>
<title>硅谷电商系统</title>
</head>
<body>
	<h5>最新加入的商品:</h5>
	
	<c:forEach items="${listCart }" var="product">
		
		<div class="one">
			<img alt="" src="upload/image/${product.shpTp }" height="60px" width="60px" onclick="search_details(${product.skuId },${product.shpId })">
			<span class="one_name" onclick="search_details(${product.skuId },${product.shpId })">
				${product.skuMch }
			</span>
			<span class="one_prece">
				<b>￥${product.skuJg }×${product.tjshl }</b><br />
				<b>小计:${product.hj }</b><br />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:deletefromcart(${product.skuId });">删除</a>
			</span>
		</div>
	</c:forEach>
	<div class="gobottom">
		共<span>${totalCount }</span>件商品&nbsp;&nbsp;&nbsp;&nbsp;
		共计￥<span>${totalPrice }</span>
	<button class="goprice" onclick="ToCart()">去购物车</button>
	</div>
</body>
</html>