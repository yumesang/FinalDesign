<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<html>
<title>查看</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<style>

body{
	margin:0px auto;
	text-align:center;
} 

body{
	margin:0px auto;
	text-align:center;
} 
  .pcd_left_td_normal{
 	border:0px solid #000000;
	width:104px;
	height:36px;
	line-height:0.485cm;
	padding:0px 0px 0px 0px;
	font-size:13px;
 }
</style>
</head>

<body> 


<div id="pcd_main" style="width:100%;height: 100%;">
		</br>
	   <span  style="font:'宋体'; font-size: 26px;text-align: center;font-weight: bolder;">${introduction }</span>
	   </br></br>
		<table style="width:80%;">
      		<tbody> 
				<tr >  
					<td  align="left" class='pcd_left_td_normal' >${contents }</td>
				</tr>				
	    	</tbody>
	  	</table>
	  </div> 
      </div>
</body>
</html>

