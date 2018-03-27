<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title><span>task_detail</span></title>
    
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
  	<div>
  		<table style="width: 400px;">
    		<tr>
    			<td><strong><span style="font-size: 15px;">${taskName }:</span></strong></td>
    		</tr>
    		<tr>
				<td><span style="font-size: 15px;" readonly="readonly">&nbsp&nbsp&nbsp&nbsp${taskDetail }</span></td>
    		</tr>
    	</table>
  	</div>
    	
  </body>
</html>
