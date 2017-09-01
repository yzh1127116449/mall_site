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
		/* $.getJSON("js/json/class_1.js",function(data){
			$(data).each(function(i,json){
				$("#spu_class_1_selected").append("<option value="+json.id+">"+json.flmch1+"</option>");
			});
			//显示二级分类
			var $id = $("#spu_class_1_selected").val();
			spu_class_1_change($id);
		
		}); */
		$('#spu_class_1_selected').combobox({    
		    url:'js/json/class_1.js',    
		    valueField:'id',    
		    textField:'flmch1',
		    value:'---->请选择<----',
		    onSelect:function spu_class_2_change(){
		    	var class_1_id = $(this).combobox('getValue');
		    	$("#spu_class_2_selected").combobox({	
		    		url:'js/json/class_2_'+class_1_id+'.js',
		    		valueField:'id',
		    		textField:'flmch2',
		    		value:'---->请选择<----',
		    		onSelect:function spu_tm_change(){	
		    			$("#spu_tm_selected").combobox({
				    		url:'js/json/tm_class_1_'+class_1_id+'.js',
				    		valueField:'id',
				    		textField:'ppmch',
				    		value:'---->请选择<----'
		    			
		    			});
		    		
		   			 }
				});  
			}
		});
	})
	 /* function spu_class_1_change(class_1_selected_id){
		//var $id = $("#spu_class_1_selected").val();
		//alert(class_1_selected_id);
		//显示二级分类
		$("#spu_class_2_selected").empty();
		$.getJSON("js/json/class_2_"+class_1_selected_id+".js",function(data){
			$(data).each(function(n,json2){
				
				$("#spu_class_2_selected").append("<option value="+json2.id+">"+json2.flmch2+"</option>");
			});
			
			//显示品牌分类
			$("#spu_tm_selected").empty();
			$.getJSON("js/json/tm_class_1_"+class_1_selected_id+".js",function(data){
				$(data).each(function(n,json3){
					
					$("#spu_tm_selected").append("<option value="+json3.id+">"+json3.ppmch+"</option>");
				});
			});
		});
	} */
	
	/* function spu_class_2_selected(){
		var $id = $("#spu_class_1_selected").val();
		//alert(class_1_selected_id);
		//显示二级分类
		$("#spu_tm_selected").empty();
		$.getJSON("js/json/tm_class_1_"+$id+".js",function(data){
			$(data).each(function(n,json3){
				
				$("#spu_tm_selected").append("<option value="+json3.id+">"+json3.ppmch+"</option>");
			});
		});
	}  */
	//点击input
	function spu_image_onclick(index){
		$("#file_"+index).click();
	}
	//显示上传图片的缩略图
	function spu_add_image(index){
		
		//将图片转换为二进制数据
		var files = $("#file_"+index)[0].files[0];

		//将二进制数据转换为url
		var url = window.URL.createObjectURL(files);
		//将img标签的src替换为url
		$("#spu_image_"+index).attr("src",url);
		
		if(index<5&&(index+1)>$("#spu_image img").length){
			var img='<img id="spu_image_'+(index+1)+'" onclick="spu_image_onclick('+(index+1)+')" alt="点击添加图片" src="image/upload_hover.png" style="cursor:pointer;" height="120" width="120">';
			var input='<input id="file_'+(index+1)+'" onChange="spu_add_image('+(index+1)+')" style="display: none;" type="file" name="files"/>';
			
			$("#spu_image").append(img+input);
		}
		
	}
</script>
<title>spu添加页面</title>
</head>
<body>

	<form action="save_spu_info.do" method="post" enctype="multipart/form-data">
		<div class="easyui-layout" data-options="fit:true" style="height:700px">
			<div data-options="region:'north',split:true" style="height:120px">
				<h3>SPU信息管理页面</h3>
				分类名称1：<select style="width:150px;" class="easyui-combobox" name="flbh1" id="spu_class_1_selected" onChange="spu_class_1_change(this.value)"></select>
				分类名称2：<select style="width:150px;" class="easyui-combobox" name="flbh2" id="spu_class_2_selected" ></select>
				品牌：<select style="width:150px;" class="easyui-combobox" name="ppId" id="spu_tm_selected"></select><br/><br/>
			</div>
			<div data-options="region:'west',split:true" style="width:200px">
				<br/><br/>
				spu名称：<input type="text" name="shpMch"/><br/><br/>
				spu描述：<textarea name="shpMsh" rows="10" cols="20"></textarea><br/><br/>
			</div>
			<div data-options="region:'center'">
				添加spu图片：
				<br/><br/>
				<div id="spu_image">
					<img id="spu_image_1" onclick="spu_image_onclick(1)" alt="点击添加图片" src="image/upload_hover.png" style="cursor:pointer;" height="120" width="120">
				
					<input id="file_1" onChange="spu_add_image(1)" style="display: none;" type="file" name="files"/>
				</div>
				<br/><br/>
			<input type="submit" value="提交">
			</div>
		</div>
		
		<br/>
			
	</form>
</body>
</html>