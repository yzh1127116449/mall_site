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

	$(function(){
		$.getJSON("js/json/class_1.js",function(data){
			$(data).each(function(i,json){
				$("#saleIndex_class_1_selected").append("<li onmouseover='saleIndex_class_1_change(this.value)' value="+json.id+"><a href='javascript:;'>"+json.flmch1+"</a></li>");
			});
			//显示二级分类
			//var $id = $("#saleIndex_class_1_selected").val();
			//saleIndex_class_1_change($id);
		
		});
		
	})
	
	function saleIndex_class_1_change(class_1_selected_id){
		//var $id = $("#saleIndex_class_1_selected").val();
		//alert(class_1_selected_id);
		//显示二级分类
		$("#saleIndex_class_2_selected").empty();
		$.getJSON("js/json/class_2_"+class_1_selected_id+".js",function(data){
			$(data).each(function(n,json2){
				
				$("#saleIndex_class_2_selected").append("<li value="+json2.id+"><a style='text-decoration:none;' target='_blank' href='search_product.do?class_2_id="+json2.id+"'>"+json2.flmch2+"</a></li>");
			});
			$("#saleIndex_class_2_selected").show();
		/* 	//显示品牌分类
			$("#saleIndex_tm_selected").empty();
			$.getJSON("js/json/tm_class_1_"+class_1_selected_id+".js",function(data){
				$(data).each(function(n,json3){
					
					$("#saleIndex_tm_selected").append("<li value="+json3.id+"><a href='javascript:;'>"+json3.ppmch+"</a></li>");
				});
			}); */
			
		});
	}
	
	function showCartInfo(){
		$("#miniCart").show();
	}
	function hiddenCartInfo(){
		$("#miniCart").hide();
	}
</script>
<title>硅谷电商系统</title>
</head>
<body>
		<jsp:include page="sale_header.jsp"></jsp:include>
		<div class="top_img">
			<img src="images/top_img.jpg" alt="">
		</div>
		
		<!-- 分类名称1：<ul style="width:150px;"  name="flbh1" id="saleIndex_class_1_selected" ></ul> -->
		<!-- 分类名称2：<ul style="width:150px;" name="flbh2" id="saleIndex_class_2_selected" ></ul> -->
		<!-- 品牌：<ul style="width:150px;"  name="ppId" id="saleIndex_tm_selected"></ul><br/><br/> -->
		<div class="search">
		<div class="logo"><img src="./images/logo.jpg" alt=""></div>
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
					<div class="nav_mini">
						<ul id="saleIndex_class_1_selected">
							<li>
								<div class="two_nav" id="saleIndex_class_2_selected">
									
								</div>
							</li>
							
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
	<div class="banner">
		<div class="ban">
			<img src="images/banner.jpg" width="980" height="380" alt="">
		</div>
	</div>
		

</body>
</html>