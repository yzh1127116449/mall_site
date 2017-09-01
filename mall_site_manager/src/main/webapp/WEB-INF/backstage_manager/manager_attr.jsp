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
<script type="text/javascript" src="js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.3.5/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.3.5/themes/icon.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	$(function(){
		
		$('#attr_class_1_selected').combobox({    
		    url:'js/json/class_1.js',    
		    valueField:'id',    
		    textField:'flmch1',
		    value:'---->请选择<----',
		    onSelect:function attr_class_1_change(){
		    	var class_1_id = $(this).combobox('getValue');
		    	$("#attr_class_2_selected").combobox({	
		    		url:'js/json/class_2_'+class_1_id+'.js',
		    		valueField:'id',
		    		textField:'flmch2',
		    		value:'---->请选择<----',
		    		onSelect:function (){
		    			var class_2_id = $(this).combobox('getValue');
		    			var class_2_name = $(this).combobox('getText');
		    			
		    			attr_class_2_change(class_2_id,class_2_name);
		    			
		    			//$("#attr_list_inner").after('<a href="javascript:;" onclick="add_attr_val_tabs()">添加分类属性值</a>');
		    		}
				});  
			}
		});
		
	})
	//添加分类属性值时重新打开一个选项卡
	function add_attr_val_tabs(){
		
		var class_2_id = $('#attr_class_2_selected').combobox('getValue');
		var class_2_name = $('#attr_class_2_selected').combobox('getText');
		
		$.post("to_attr_add.do",{class_2_id:class_2_id,class_2_name:class_2_name},function (data){
			
			$('#index_spu').tabs('add',{    
			    title:'添加属性值',    
			    content:data,
			    closable:true
			}); 
		});
	}
	//改变时二级分类的名称发送异步请求
	function attr_class_2_change(class_2_id,class_2_name){
		/* var class_2_name = $("#attr_class_2_selected option:selected").text();
		$.post("to_attr_list_inner.do",{class_2_id:class_2_id,class_2_name:class_2_name},function(data){
			$("#attr_list_inner").html(data);
		}); */
		
		$('#attr_list_inner').datagrid({    
		    url:'to_attr_list_inner_json.do',
		    queryParams: {class_2_id:class_2_id,class_2_name:class_2_name},
		    columns:[[    
		        {field:'shxmMch',title:'属性名称',width:100},    
		        {field:'shfqy',title:'是否启用',width:100},    
		        {field:'chjshj',title:'创建时间',width:200,
		        	formatter: function(value,row,index){
						var dateTime = new Date(value);
						var date = dateTime.toLocaleString();
						return date; 
					}	
		        },
		        {field:'list_value',title:'属性值',width:600,align:'left',
		        	formatter: function(value,row,index){
		        		var val = "";
						$.each(value,function(i,json){
							val+=" "+json.shxzhMch+json.shxzh;
						})
						
						return val; 
					}	
		        }
		    ]]    
		});
	}
		
	
</script>
<title>硅谷商城后台系统</title>
</head>
<body>


	<div class="easyui-layout" style="width:1000px;height:550px;">
		<div data-options="region:'north'" style="height:100px">
			<h3>属性分类信息</h3>
			<div>
				分类名称1：<select name="flbh1" id="attr_class_1_selected" style="width:150px;" class="easyui-combobox" onChange="attr_class_1_change(this.value)"></select>
				分类名称2：<select name="flbh2" id="attr_class_2_selected" style="width:150px;" class="easyui-combobox" onChange="attr_class_2_change(this.value)"></select>
			</div>
		</div>
		<div data-options="region:'south',split:true" style="height:50px;">
			
		</div>
		
		<div data-options="region:'center',title:'属性值信息',iconCls:'icon-ok',href:''" style="padding:10px">
			<div id="attr_list_inner" class="esayui-datagrid">
				
			</div>
			<a href="javascript:;" onclick="add_attr_val_tabs()">添加分类属性值</a>
		</div>
	</div>
	
	
	
</body>
</html>