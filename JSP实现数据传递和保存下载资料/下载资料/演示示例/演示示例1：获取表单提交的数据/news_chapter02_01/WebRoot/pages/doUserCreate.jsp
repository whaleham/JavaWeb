<%@page import="java.net.URLEncoder"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'doUserCreate.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<%
	String username = request.getParameter("username");
	String pwd = request.getParameter("password");
	String email = request.getParameter("email");
	String[] hobbys = request.getParameterValues("hobby");
 %>
 用户名：
 <%
 	if(username!=null && !username.equals("")){
 %><%=username %>
 <%}else{
 	out.println("用户名未填写！");
 } %>
 <br/>
密码：<%=pwd %><br/>
Email:<%=email %><br/>
爱好：<br>
<%
	if(hobbys!=null && hobbys.length!=0){
		for(String hobby:hobbys){
			out.println(hobby+"<br/>");
		}
	}else{
		out.println("您没有兴趣爱好！");
	}
%>

  </body>
</html>
