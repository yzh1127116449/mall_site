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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	$(function(){
		var userName = get_cookie_value("loginUser");
		
		$("#userName").after(userName);
	});
	
	function get_cookie_value(key){
		var val="";
		var cookie = document.cookie;
		cookies = decodeURIComponent(cookie);
		cookies = cookies.replace(/\s/,"");
		
		var cookie_array = cookie.split(";");
		$.each(cookie_array,function(i,cookie){
			var cookie_kv = cookie.split("=");
			if(cookie_kv[0]==key){
				val = cookie_kv[1];
			}
		})
		return val;
	}
</script>
<title>硅谷电商系统</title>
</head>
<body>
	
	<div class="top">
		<div class="top_text">
			<c:if test="${not empty loginUser }">
				<a href="javascript:;" style="text-decoration:none;">我的订单 &nbsp&nbsp</a>
				<a href="logout.do" style="text-decoration:none;">注销</a>
				<a href="javascript:;" style="text-decoration:none;">${loginUser.yhMch } &nbsp&nbsp</a>
				<a href="javascript:;" style="text-decoration:none;">欢迎</a>
			</c:if>
	
			<c:if test="${empty loginUser }">
				<a href="register.htm" id="userName" style="text-decoration:none;">注册&nbsp&nbsp</a> ${loginUser.yhMch } &nbsp&nbsp<a href="userLogin.do">登录</a>
			</c:if>
		</div>
	</div>
	
</body>
</html>