<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'registerSuccess.jsp' starting page</title>
    
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
       恭喜你注册成功！你的信息如下：<br/>
       用户名：${student.stuName }<br/>
       密码：${student.stuPwd }<br/>
       出生日期：<fmt:formatDate value="${student.stuDate }" pattern="yyyy年MM月dd日"/> <br/>
      照片：<a href="download.action?fileName=${student.stuPhoto }">
        <img  src="photoes/${student.stuPhoto }" width="300" height="400">
      </a>
      <br/>    
  </body>
</html>
