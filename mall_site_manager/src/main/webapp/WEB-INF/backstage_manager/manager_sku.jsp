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

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	$(function(){
		//显示一级分类
		$.getJSON("js/json/class_1.js",function(data){
			$(data).each(function(i,json){
				$("#sku_class_1_selected").append("<option value="+json.id+">"+json.flmch1+"</option>");
			});
			//显示二级分类
			var $id = $("#sku_class_1_selected").val();
			sku_class_1_change($id);
		
		});
		
	});
	
	 function sku_class_1_change(class_1_selected_id){
		//var $id = $("#sku_class_1_selected").val();
		//alert(class_1_selected_id);
		//显示二级分类
		$("#sku_class_2_selected").empty();
		$.getJSON("js/json/class_2_"+class_1_selected_id+".js",function(data){
			$(data).each(function(n,json2){
				
				$("#sku_class_2_selected").append("<option value="+json2.id+">"+json2.flmch2+"</option>");
			});
			
			//显示品牌分类
			$("#sku_tm_selected").empty();
			$.getJSON("js/json/tm_class_1_"+class_1_selected_id+".js",function(data){
				$(data).each(function(n,json3){
					
					$("#sku_tm_selected").append("<option value="+json3.id+">"+json3.ppmch+"</option>");
				});
			});
		});
	}
	//改变二级分类名称是发送ajax请求，查询分类的属性值
	function sku_spu_change(pp_id){
		var $class_1_id = $("#sku_class_1_selected").val();
		var $class_2_id = $("#sku_class_2_selected").val();
		$("#sku_spu_selected").empty();
		$.post("querySkuByPP_id.do",{class_1_id:$class_1_id,class_2_id:$class_2_id,pp_id:pp_id},function(data){
			$(data).each(function(i,json){
				//alert(JSON.stringify(json));
				
				$("#sku_spu_selected").append("<option value="+json.id+">"+json.shpMch+"</option>");
			});
		});
		
	}
	//发送异步请求查询属性值
	function sku_class_2_change(class_2_id){
		//alert(class_2_id);
		$.post("query_attr_inner.do",{class_2_id:class_2_id},function(data){
			
			$("#sku_attr_inner").html(data);
		});
	}
</script>
<title>sku库存信息</title>
</head>
<body>
	<h3>sku库存页面</h3><br/>
		<form action="save_sku_attr.do" method="post">
			分类名称1：<select name="flbh1" id="sku_class_1_selected" onChange="sku_class_1_change(this.value)"></select>
			分类名称2：<select name="flbh2" id="sku_class_2_selected" onChange="sku_class_2_change(this.value)"></select>
			品牌：<select name="ppId" id="sku_tm_selected" onChange="sku_spu_change(this.value)" ></select>
			商品名称：<select name="spuId" id="sku_spu_selected" ></select><br/><br/>
			
		<h3>属性信息：</h3>
		<div id="sku_attr_inner"></div>
		</form>
		<hr>
		

</body>
</html>