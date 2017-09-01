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
	function sku_attr_show(attr_id,checked){
		
		if(checked){
			$("#attr_val_"+attr_id).show();
		}else{
			$("#attr_val_"+attr_id).hide();
		}
		
	}
</script>
<title>硅谷商城后台系统</title>
</head>
<body>
	
		<c:forEach items="${attr_value_class_2 }" var="attr" varStatus="index">
			<input type="checkbox" value="${attr.id }" name="listSku[${index.index }].shxmId" onclick="sku_attr_show(${attr.id},this.checked)"/>${attr.shxmMch }--
		</c:forEach>
		<hr>
		<c:forEach items="${attr_value_class_2 }" var="attr" varStatus="index">
			<div id="attr_val_${attr.id }" style="display: none;">
				<c:forEach items="${attr.list_value }" var="val">
						<input type="radio" value="${val.id }" name="listSku[${index.index }].shxzhId" />${val.shxzh }${val.shxzhMch }
				</c:forEach>
			</div>
			<br/>
		</c:forEach>
		库存名称：<input type="text" name="skuMch"/><br/>
		库存数量：<input type="text" name="kc"/><br/>
		库存价格：<input type="text" name="jg"/><br/>
		库存地址：<input type="text" name="kcdz"/><br/>
		<input type="submit" value="提交"/>
	
</body>
</html>