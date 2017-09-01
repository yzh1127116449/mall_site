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
		var url = '${url}';
		var title = '${title}';
		if(url!=""&&title!=""){
			to_manager_index(url,title);
			
		}
	});
	//加载选项卡
	function to_manager_index(url,title){
		//判断选项卡是否存在
		var b = $('#index_spu').tabs('exists',title);
		if(!b){
			
			$.post(url,function(data){
				$('#index_spu').tabs('add',{    
				    title:title,    
				    content:data,    
				    closable:true    
				});
			});
		}else{
			$('#index_spu').tabs('select',title);
		}
		
	}
</script>
<title>Title</title>
</head>
<body class="easyui-layout" >

	<div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px">north region</div>
	<div data-options="region:'west',split:true,title:'West'" style="width:200px;padding:10px;">
	
		<ul class="easyui-tree">
		<li>
			<span>系统管理</span>
			<ul>
				<li>
					<span><a style="text-decoration:none;" href="javascript:to_manager_index('to_manager_spu.htm','spu信息');" >spu信息</a></span>
				</li>
				<li>
					<span><a style="text-decoration:none;" href="javascript:to_manager_index('to_manager_attr.htm','分类属性信息');" >分类属性信息</a></span>
				</li>
				<li>
					<span><a style="text-decoration:none;" href="javascript:to_manager_index('to_manager_sku.htm','库存信息');" >库存信息</a></span>
				</li>
				<li data-option="">
					<span>接口管理</span>
					<ul>
						<li>物流管理</li>
						<li>Java</li>
						<li>Microsoft Office</li>
						<li>Games</li>
					</ul>
				</li>
			</ul>
		<li>
			<span>缓存管理</span>
			<ul>
				<li>用户缓存管理</li>			
				<li>检索缓存管理</li>			
			</ul>
		</li>	
		</li>
	</ul>
	
	</div>
	<div data-options="region:'east',split:true,collapsed:true,title:'East'" style="width:100px;padding:10px;">east region</div>
	<div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">south region</div>
	<div data-options="region:'center',title:'Center',iconCls:'icon-ok'">
		<div id="index_spu" class="easyui-tabs" >
			
		</div>
		
	</div>


</body>
</html>