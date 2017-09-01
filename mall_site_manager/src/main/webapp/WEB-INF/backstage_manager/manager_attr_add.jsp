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
				if($("#attr_class_1_selected").val()==null){
					$("#attr_class_1_selected").append("<option value="+json.id+">--请选择--</option>");
					
				}else{
					
					$("#attr_class_1_selected").append("<option value="+json.id+">"+json.flmch1+"</option>");
				}
			});
			//显示二级分类
			var $id = $("#attr_class_1_selected").val();
		
			//attr_class_1_change(1);
			 
		});
		
	});
	
	 function attr_class_1_change(class_1_selected_id){
		//var $id = $("#attr_class_1_selected").val();
		//alert(class_1_selected_id);
		
		//显示二级分类
		$("#attr_class_2_selected").empty();
		$.getJSON("js/json/class_2_"+class_1_selected_id+".js",function(data){
			$(data).each(function(n,json2){
				if($("#attr_class_2_selected").val()==null){
					$("#attr_class_2_selected").append("<option value="+json2.id+">--请选择--</option>");
				}else{
					
					$("#attr_class_2_selected").append("<option value="+json2.id+">"+json2.flmch2+"</option>");
				}
			});
			
		});
		
	}
	//该边二级分类的名称发送异步请求
	function attr_class_2_change(class_2_id){
		var class_2_name = $("#attr_class_2_selected option:selected").text();
		$.post("to_attr_list_inner.do",{class_2_id:class_2_id,class_2_name:class_2_name},function(data){
			$("#attr_list_inner").html(data);
		});
	}
	var index_attr=0;
	function add_attr_table(){
		
		var content="";
		content+='<table border="1" width="500px" id="attr_table_'+(index_attr+1)+'">';
		content+='<tr>';
		content+='<td>属性名：<input type="text" name="list_attr['+(index_attr+1)+'].shxmMch"></td>';
		content+='<td><a href="javaScript:;" onclick="add_attr_value('+(index_attr+1)+')">添加属性值</a></td>';
		content+='</tr>';
		content+='<tr>';
		content+='<td>属性值：<input type="text" name="list_attr['+(index_attr+1)+'].list_value[0].shxzh"></td>';
		content+='<td >单位：<input type="text" name="list_attr['+(index_attr+1)+'].list_value[0].shxzhMch"><a href="javascript:;" onclick="">删除</a></td>';
		content+='</tr>';
		content+='<tr>';
		content+='<td>属性值：<input type="text" name="list_attr['+(index_attr+1)+'].list_value[1].shxzh"></td>';
		content+='<td>单位：<input type="text" name="list_attr['+(index_attr+1)+'].list_value[1].shxzhMch"><a href="javascript:;" onclick="">删除</a></td>';		
		content+='</tr>';
		content+='</table>';
		$("#attr_table_"+index_attr).after(content);
		index_attr++;
		
	}
	function add_attr_value(index){
		
		var tr_index=$("#attr_table_"+index+" tr").length-1;
		var content="";
			content+='<tr>';
			content+='<td>属性值：<input type="text" name="list_attr['+index+'].list_value['+tr_index+'].shxzh"></td>';
			content+='<td>单位：<input type="text" name="list_attr['+index+'].list_value['+tr_index+'].shxzhMch"><a href="javascript:;" onclick="attr_value_delete()">删除</a></td>';		
			content+='</tr>';
		
		//$(this).parent("table").append(content);
			$("#attr_table_"+index).append(content);
	}
	
	function attr_value_delete(){
		alert(1111);
		$(this).parent("table").empty();
	}
</script>
<title>硅谷商城后台系统-添加属性</title>
</head>
<body>
	${class_2_name }添加页面
	<br>
	添加结果：<h3>${success }</h3>
	<a href="javaScript:;" onclick="add_attr_table()">添加属性</a>
	<form action="save_attr.do" method="post">
		<input type="hidden" name="class_2_id" value="${class_2_id }" />
		<input type="hidden" name="class_2_name" value="${class_2_name }" />
		<div id="attr_table_div">
		
			<table border="1" width="500px" id="attr_table_0">
				<tr>
					<td>属性名：<input type="text" name="list_attr[0].shxmMch"></td>
					<td><a href="javascript:;" onclick="add_attr_value(0)">添加属性值</a></td>
					
				</tr>
				<tr>
					<td>属性值：<input type="text" name="list_attr[0].list_value[0].shxzh"></td>
					<td colspan="2">单位：<input type="text" name="list_attr[0].list_value[0].shxzhMch"><a href="javascript:;" onclick="attr_value_delete()">删除</a></td>
					
				</tr>
				<tr>
					<td>属性值：<input type="text" name="list_attr[0].list_value[1].shxzh"></td>
					<td>单位：<input type="text" name="list_attr[0].list_value[1].shxzhMch"><a href="javascript:;" onclick="attr_value_delete()">删除</a></td>
					
				</tr>
				</table>
				<br><br>
		</div>
		<input type="submit" value="提交"/>
	</form>
</body>
</html>