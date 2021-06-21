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
	//表单post方式提交，中文乱码处理
	request.setCharacterEncoding("utf-8");
	//response.setCharacterEncoding("utf-8");
	String username = request.getParameter("username");
	//表单提交get方式，中文乱码处理方式一
	//username = new String(username.getBytes("ISO-8859-1"),"utf-8");
	//表单提交get方式，中文乱码处理方式二：修改server.xml
	String pwd = request.getParameter("password");
	String email = request.getParameter("email");
	String[] hobbys = request.getParameterValues("hobby");
 %>
 用户名：
 <%
 	if(username!=null && !username.equals("")){
 		if(username.equals("admin")){
			//不允许注册，注册失败
			request.setAttribute("mess", "注册失败，请更换其他用户名");
			request.getRequestDispatcher("userCreate.jsp").forward(request, response);
		}else{
			//允许注册，注册成功
			//request.setAttribute("mess", "注册成功");  //换作用域保存，或者如下写法
			//response.sendRedirect(request.getContextPath()+"/index.jsp?info=success");
			//以上如果传递中文提示：
			String info = "注册成功！";
			info = URLEncoder.encode(info,"utf-8");
			response.sendRedirect(request.getContextPath()+"/index.jsp?info="+info);
		}
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
