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
	//选中筛选条件
	function selected_attr_up(shxm_id,shxzh_id,shxzhmch){
	
		$("#search_attr_"+shxm_id).hide();
		var content = '<div id="search_attr_val_'+shxm_id+'"><a href="javascript:selected_attr_down('+shxm_id+')" style="text-decoration:none;">'+shxzhmch+'</a>';
		content +="<input type='hidden' value='{\"shxm_id\":"+shxm_id+",\"shxzh_id\":"+shxzh_id+"}' name='search_attr_id_arry'></div>";
		$("#search_attr_selected").append(content);
		queryProductByCondition();
	}
	//取消筛选条件
	function selected_attr_down(attr_val_id){
		$("#search_attr_val_"+attr_val_id).remove();
		$("#search_attr_"+attr_val_id).show();
		queryProductByCondition();
	}
	//根据选中的筛选的条件发送异步请求，查询数据
	function queryProductByCondition(){
		 var list = $("input[name='search_attr_id_arry']");
		 var list_val = "";
		 $.each(list,function(i,json){
			var json_obj = $.parseJSON(json.value); 
			//alert(JSON.stringify(json_obj));
			list_val += "listSku["+i+"].shxmId="+json_obj.shxm_id+"&listSku["+i+"].shxzhId="+json_obj.shxzh_id+"&";
		 });
		 
		 var class_2_id = ${class_2_id};
		 var order = $("#search_order_show").val();
		 list_val += "class_2_id="+class_2_id+"&order="+order;
		
		 $.ajax({
			type:"post",
			url:'queryProductByCondition.do',
			data:list_val,
			success:function(data){
				$("#search_inner").html(data);
			}
		 });
	}
	//按价格，销量，上架时间，评论数排序
	function search_change_order(new_order){
		var old_order = $("#search_order_show").val();
		if(new_order==old_order){
			new_order += "desc";
		}
		$("#search_order_show").val(new_order);
		queryProductByCondition();
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
		<img src="./images/top_img.jpg" alt="">
	</div>
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
		<br>
	
	
			<div class="Sscreen">
		<div class="title">
			平板电视 商品筛选 共1205个商品
		</div>
		<div id="search_attr_selected">
		筛选列表:
		</div>
		<input type="hidden" id="search_order_show" value=" order by jg "/>
		<hr/>
		<c:forEach items="${attrList }" var="attr">
			<div class="list">
				<div id="search_attr_${attr.id}">
					<span>${attr.shxmMch }:</span>
					<c:forEach items="${attr.list_value }" var="attr_val">
						<a  href="javascript:selected_attr_up('${attr.id}','${attr_val.id}','${attr_val.shxzh }${attr_val.shxzhMch }')" style="text-decoration:none;">${attr_val.shxzh } ${attr_val.shxzhMch }</a>
					</c:forEach>
				</div>
			
			</div>
		</c:forEach>
		<div class="list">
			<span class="list_span" onclick="search_change_order(' order by sku_xl ')">销量</span>
			<span class="list_span" onclick="search_change_order(' order by jg ')">价格</span>
			<span class="list_span" onlick="search_change_order(' order by plsh ')">评论数</span>
			<span class="list_span" onclick="search_change_order(' order by sku.chjshj ')">上架时间</span>
		</div>
	</div>
	
	<div id="search_inner">
		<jsp:include page="sale_search_inner.jsp"></jsp:include>
	</div>
	<br/>

	<div class="footer">
		<div class="top"></div>
		<div class="bottom"><img src="images/buttom.jpg" alt=""></div>
		<div class="bottom"><img src="images/foot.jpg" alt=""></div>
	</div>
	
</body>
</html>