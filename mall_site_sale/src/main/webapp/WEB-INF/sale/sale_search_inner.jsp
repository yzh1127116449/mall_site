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
	function search_details(skuId,spuId){
		window.location.href = "search_details.do?skuId="+skuId+"&spuId="+spuId;
	}
</script>
<title>硅谷电商系统</title>
</head>
<body>
	<div class="Sbox">
	
		<c:forEach items="${listProductInfo }" var="sku">
		<div class="list">
			<div class="img"><img alt="" src="upload/image/${sku.spu.shpTp }" width="200px" onclick="search_details(${sku.id },${sku.spu.id })"/></div>
			<div class="price">¥${sku.jg }</div>
			<div class="price">库存:${sku.kc }件</div>	
			<div class="title" onclick="search_details(${sku.id },${sku.spu.id })">${sku.spu.shpMch }</div>	
		</div>
		</c:forEach>
	</div>
	<br/>
</body>
</html>