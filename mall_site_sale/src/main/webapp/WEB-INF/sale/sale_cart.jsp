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
<link rel="stylesheet" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">

</script>
<style type="text/css">
td{vertical-align: middle !important;}
.form-group{padding: 5px 0;}
</style>
<title>硅谷电商系统</title>
</head>
<body>
	
	<div class="top">
		<div class="top_text">
			<a href="">用户登录</a>
			<a href="">用户注册</a>
			<a href="">供应商登录</a>
			<a href="">供应商注册</a>
		</div>
	</div>
	<div class="top_img">
		<img src="./images/top_img.jpg" alt="">
	</div>
	<div class="search">
		<div class="logo"><img src="./images/logo.jpg" alt=""></div>
		<div class="search_on">
			<div class="se">
				<input type="text" name="search" class="lf">
				<input type="submit" class="clik" value="搜索" style="height: 32px;">
			</div>
			<div class="se">
				<a href="">取暖神奇</a>
				<a href="">1元秒杀</a>
				<a href="">吹风机</a>
				<a href="">玉兰油</a>
			</div>
		</div>
		<!-- 迷你购物车 -->
		<jsp:include page="sale_mini_cart.jsp"></jsp:include>
	</div>
	
	<div class="Cbox">
		<table class="table table-striped table-bordered table-hover">
		   <thead>
		     <tr>
		       <th width="60px">选择</th>
		       <th>商品图片</th>
		       <th>商品名称</th>
		       <th>商品属性</th>
		       <th>商品价格</th>
		       <th>商品数量</th>
		       <th>操作</th>
		     </tr>
		   </thead>
		  
			 <tbody>
			    <c:forEach items="${listCart }" var="product">
			     <tr>
			       <td><input type="checkbox" /></td>
			       <td><img alt="" src="upload/image/${product.shpTp }" height="60px" width="60px"></td>
			       <td>${product.skuMch }</td>
			       <td>
			       		颜色：<span style='color:#ccc'>白色</span><br>
			       		尺码：<span style='color:#ccc'>L</span>
			       </td>
			       <td>${product.skuJg }</td>
			       <td><input type="text" name="min" value="${product.tjshl }" style="width:50px;text-align:center"></td>
			       <td><a href="javascript:;" style="text-decoration: none;">删除</a></td>
			     </tr>
			     
			      </c:forEach>
			   </tbody>
		  
	 	</table>
	</div>
	<div class="Cprice">
		<div class="price">总价：199.00</div>
		<div class="jiesuan"><a href="payIndex.do" style="text-decoration: none;" target="_blank">结算</a></div>
	</div>
	<div class="footer">
		<div class="top"></div>
		<div class="bottom"><img src="images/foot.jpg" alt=""></div>
	</div>


<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>