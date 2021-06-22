<%@page import="com.kgc.pojo.News"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@include file="../common/common.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'doAdd.jsp' starting page</title>
    
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
  	//接收增加的新闻信息，并调用后台方法，将新闻信息插入数据库
	request.setCharacterEncoding("utf-8");
	int categoryId=Integer.parseInt(request.getParameter("categoryId"));  //新闻类别
	String title=request.getParameter("title");   //新闻标题
	String author=request.getParameter("author"); //新闻作者
	String summary=request.getParameter("summary"); //新闻摘要
	String content=request.getParameter("newscontent"); //新闻内容
	
	//将新闻信息封装为一个新闻对象
	News news =new News();
	news.setCategoryId(categoryId);
	news.setTitle(title);
	news.setAuthor(author);
	news.setSummary(summary);
	news.setContent(content);
	news.setCreateDate(new Date());
	
	//调用后台方法，将新闻信息插入数据库
	boolean flag=newsService.add(news);
	if(flag){
%>
<jsp:forward page="newsDetailList.jsp"/>
<%
		//request.getRequestDispatcher("newsDetailList.jsp").forward(request, response);
	}
%>
  </body>
</html>
