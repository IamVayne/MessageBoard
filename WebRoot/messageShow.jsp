<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'messageShow.jsp' starting page</title>
    
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
  	<a href="/MessageBoard/wantSend.jsp">I want to send message</a><br/>
  	<table border="1">
  	<tr><td>sender</td><td>message</td><td>getter</td><td>when?</td></tr>
  	<c:forEach items="${messlist }" var="message">
  	<tr><td>${message.sender }</td><td>${message.content }</td><td>${message.getter }</td><td>${message.sendTime }</td></tr>
  	
  	</c:forEach>
  	</table>
  	
  	学生操作：
  	<a href="/MessageBoard/addStu.jsp">添加</a><br>
  	<a href="/MessageBoard/deleteStu.jsp">删除</a><br>
  	<a href="/MessageBoard/changeStu.jsp">修改</a><br>
  	<a href="/MessageBoard/findStu.jsp">查询</a><br>
  </body>
</html>
