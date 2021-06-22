<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.kgc.pojo.News"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/common.jsp" %>
<html>
	<head>
		<link href="<%=request.getContextPath() %>/css/common.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=request.getContextPath() %>/ckeditor/ckeditor.js"> </script>
	</head>
<body>
<div class="main-content-right">
      
        <div class="main-text-box">
      		<div class="main-text-box-tbg">
                <div class="main-text-box-bbg">
                    <div class="article-box">
                    	<!--新闻的标题-->
                        <h1>标题</h1>
                        <div class="source-bar">发布者：XX 分类：新闻信息 更新时间：XX </div>
                        <div class="article-content">
                            <span class="article-summary"><b>摘要：XX</b></span>
                                 新闻图片及新闻内容
                         </div>
                    </div>
                </div>
            </div>
        </div>
        
    </div>
</body>
</html>