<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showStudentList.jsp' starting page</title>
    
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
      <center>
          <table width="80%">
              <tr>
                  <td>学号</td><td>姓名</td><td>密码</td><td>出生日期</td><td>照片</td><td>操作</td>
              </tr>
              <c:forEach items="${stuList}" var="stu">
                  <tr>
                      <td>${stu.stuId }</td>
                      <td>${stu.stuName }</td>
                      <td>${stu.stuPwd }</td>
                      <td>${stu.stuDate }</td>
                      <td><img src="photoes/${stu.stuPhoto }" width="80" height="80"/></td>
                      <td>
                          <a href="removeStu.action?stuId=${stu.stuId }">删除</a>
                          <a href="modifyStu.action?stuId=${stu.stuId }">修改</a>
                      </td>
                  </tr>
              </c:forEach>
              <tr>
                  <td colspan="6" align="right">
                      <a href="showStudentList.action?pageId=${pageId-1 < 1 ? 1 : pageId - 1}">上一页</a>
                      <a href="showStudentList.action?pageId=${pageId + 1 }">下一页</a>
                  </td>
              </tr>
          </table>
      </center>
  </body>
</html>
