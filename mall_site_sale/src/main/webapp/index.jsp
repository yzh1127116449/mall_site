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
<script type="text/javascript" src="js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.3.5/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.3.5/themes/icon.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">

	$(function(){
		$.getJSON("js/json/class_1.js",function(data){
			$(data).each(function(i,json){
				$("#saleIndex_class_1_selected").append("<li onmouseover='saleIndex_class_1_change(this.value)' value="+json.id+">"+json.flmch1+"</li>");
			});
			//显示二级分类
			var $id = $("#saleIndex_class_1_selected").val();
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
				
				$("#saleIndex_class_2_selected").append("<li value="+json2.id+">"+json2.flmch2+"</li>");
			});
			
			//显示品牌分类
			$("#saleIndex_tm_selected").empty();
			$.getJSON("js/json/tm_class_1_"+class_1_selected_id+".js",function(data){
				$(data).each(function(n,json3){
					
					$("#saleIndex_tm_selected").append("<li value="+json3.id+">"+json3.ppmch+"</li>");
				});
			});
		});
	}
</script>
<title>Title</title>
</head>
<body>
		<jsp:forward page="saleIndex.htm"></jsp:forward>
</body>
</html>