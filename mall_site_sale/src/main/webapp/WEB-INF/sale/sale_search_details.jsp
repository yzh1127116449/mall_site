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
	function addToCart(){
		$("#cartForm").submit();
	}
	
</script>
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
		<img src="images/top_img.jpg" alt="">
	</div>
	<div class="search searchBac">
		<div class="logo"><img src="./images/logo.png" alt=""></div>
		<div class="search_on">
			<div class="se">
				<input type="text" name="search" class="lf">
				<input type="submit" class="clik" value="搜索">
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
	<div class="menu">
		<div class="nav">
			<div class="navs">
				<div class="left_nav">
					全部商品分类
					<div class="nav_mini" style="display:none">
						<ul>
							<li>
								<a href="">家用电器</a>
								<div class="two_nav">
									<a href="">11111</a>
									<a href="">11111</a>
									<a href="">11111</a>
									<a href="">11111</a>
									<a href="">11111</a>
									<a href="">11111</a>
									<a href="">11111</a>
									<a href="">11111</a>
									<a href="">11111</a>
									<a href="">11111</a>
									<a href="">11111</a>
								</div>
							</li>
							<li><a href="">手机、数码、通信</a></li>
							<li><a href="">电脑、办公</a></li>
							<li><a href="">家具、家居、家装</a></li>
							<li><a href="">男装、女装、内衣</a></li>
							<li><a href="">个户化妆</a></li>
							<li><a href="">鞋靴</a></li>
							<li><a href="">户外运动</a></li>
							<li><a href="">汽车</a></li>
							<li><a href="">母婴</a></li>
							<li><a href="">食品</a></li>
							<li><a href="">营养保健</a></li>
							<li><a href="">图书</a></li>
							<li><a href="">彩票</a></li>
							<li><a href="">理财</a></li>
						</ul>
					</div>
				</div>
				<ul>
					<li><a href="">服装城</a></li>
					<li><a href="">美妆馆</a></li>
					<li><a href="">超市</a></li>
					<li><a href="">全球购</a></li>
					<li><a href="">闪购</a></li>
					<li><a href="">团购</a></li>
					<li><a href="">拍卖</a></li>
					<li><a href="">金融</a></li>
					<li><a href="">智能</a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<div class="Dbox">
		<div class="box">
			<div class="left">
				<div class="timg"><img src="upload/image/${skuDetails.spu.shpTp }" alt=""></div>
				<div class="timg2">
					<div class="lf"><img src="images/lf.jpg" alt=""></div>
					<div class="center">
						<c:forEach items="${skuDetails.list_image }" var="productImage">
							<span><img src="upload/image/${productImage.url }" alt="" height="60px" width="60px"></span>
						</c:forEach>
						
					</div>
					<div class="rg"><img src="images/rg.jpg" alt=""></div>
				</div>
				<div class="goods"><img src="images/img_6.jpg" alt=""></div>
			</div>
			<div class="cent">
				<div class="title">${skuDetails.spu.shpMch }</div>
				<div class="bg">
					<p>市场价：<strong>￥${skuDetails.jg }</strong></p>
					<p>促销价：<strong>￥${skuDetails.jg - 20 }</strong></p>
				</div>
				<div class="clear">
					<div class="min_t">选择版本：</div>
					<c:forEach items="${skuDetails.list_av_name}" var ="av_name">
						<div class="min_mx" onclick=func($(this),'0')><a href="#" style="text-decoration:none;">[${av_name.shxmMch }:${av_name.shxzhMch }]</a></div>
					</c:forEach>
				</div>
				<div class="clear">
					<div class="min_t" onclick=func($(this),'1')>服务：</div>
					<div class="min_mx" onclick=func($(this),'1')>服务1号1</div>
					<div class="min_mx" onclick=func($(this),'1')>服务二号1112</div>
					<div class="min_mx" onclick=func($(this),'1')>55英服务二号1111寸活动中3</div>
					<div class="min_mx" onclick=func($(this),'1')>4</div>
					<div class="min_mx" onclick=func($(this),'1')>呃呃呃5</div>
					<div class="min_mx" onclick=func($(this),'1')>55英寸活动中6</div>
				</div>
				<div class="clear" style="margin-top:20px;">
					<div class="min_t" style="line-height:36px">数量：</div>
					<div class="num_box">
						<input type="text" name="num" value="1" style="width:40px;height:32px;text-align:center;float:left">
						<div class="rg">
							<img src="images/jia.jpg" id='jia' alt="">
							<img src="images/jian.jpg" id='jian' alt="">
						</div>
					</div>
				</div>
		<form id="cartForm" action="addProductToCart.do" method="post">
			<input type="hidden" name="skuMch" value="${skuDetails.skuMch }" />
			<input type="hidden" name="skuJg" value="${skuDetails.jg  }" />
			<input type="hidden" name="tjshl" value="1" />
			<input type="hidden" name="hj" value="${skuDetails.jg*1 }" />
			<input type="hidden" name="shpId" value="${skuDetails.shpId }" />
			<input type="hidden" name="skuId" value="${skuDetails.id }" />
			<input type="hidden" name="shpTp" value="${skuDetails.spu.shpTp }" />
			<input type="hidden" name="shfxz" value="1" />
			<input type="hidden" name="kcdz" value="${skuDetails.kcdz }" />
		</form>
				<div class="clear" style="margin-top:20px;">
					<img src="images/mai.jpg" alt="立即购买">
					<img src="images/shop.jpg" alt="添加到购物车" onclick="addToCart()">
				</div>
			</div>
		</div>
	</div>
	<div class="Dbox1">
		<div class="boxbottom">
			<div class="top">
				<span>商品详情</span>
				<span>评价</span>
			</div>
			<div class="btm">
			${skuDetails.spu.shpMsh }
			</div>
		</div>
	</div>
	<div class="footer">
		<div class="top"></div>
		<div class="bottom"><img src="images/foot.jpg" alt=""></div>
	</div>

</body>
</html>