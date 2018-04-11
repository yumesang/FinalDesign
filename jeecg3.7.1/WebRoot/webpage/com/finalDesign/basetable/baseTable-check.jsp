<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<html>
<title>带权教务系统</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
 <t:base type="jquery,easyui,tools,DatePicker"></t:base>
<style>
  	.subBtn{
  	border:none;
	outline:none;
    -moz-border-radius: 5px;
    -webkit-border-radius: 5px;
    border-radius: 5px;
    color: #ffffff;
    display: block;
    cursor:pointer;
    margin: 10px 5px;
    float:center;
    padding: 7px 17px;
    text-shadow: 0 1px 1px #777;
    font-weight:bold;
    font-family:"Century Gothic", Helvetica, sans-serif;
    -moz-box-shadow:0px 0px 3px #aaa;
    -webkit-box-shadow:0px 0px 3px #aaa;
    box-shadow:0px 0px 3px #aaa;
    background:#18a689;
    width: 50px;
    height: 20px;
    text-align: center;
}
	.clickedSubBtn{
  	border:none;
	outline:none;
    -moz-border-radius: 5px;
    -webkit-border-radius: 5px;
    border-radius: 5px;
    color: #ffffff;
    display: block;
    cursor:pointer;
    margin: 10px 5px;
    float:center;
    padding: 7px 17px;
    text-shadow: 0 1px 1px #777;
    font-weight:bold;
    font-family:"Century Gothic", Helvetica, sans-serif;
    -moz-box-shadow:0px 0px 3px #aaa;
    -webkit-box-shadow:0px 0px 3px #aaa;
    box-shadow:0px 0px 3px #aaa;
    background:gray;
    width: 50px;
    height: 20px;
    text-align: center;
}

body{
	margin:0px auto;
	text-align:center;
} 

body{
	margin:0px auto;
	text-align:center;
} 

#pcd_main{
	width:670px;
	height:500px;
	text-align:center; 
	font-size:14px;
	margin-top:0px; 
	padding:0px;
		
}
#pcd_header{
	width:670px;
	height:16px;
	font-family:Verdana, Arial, Helvetica, sans-serif;
	font-size:14px;
	text-align:center; 
	vertical-align:bottom;
	margin:0px;
	
}
#pcd_header h3{  
	
}

#pcd_nav{
	width:670px;
	padding-top:5px;
	 
}

.pcd_nav_left{
	float:left;	

}

.pcd_nav_right{
	float:right;
	margin-right:15px;

}

#pcd_content{
	width:670px;  
	font-size:14px;
	margin-bottom: 0px;
}

.pcd_content_tb{
		width:670px;
		height:200px;
		font-size:14px;
		border:1px solid #000000;
		border-collapse:collapse;

}


.pcd_vertical_word{
	padding-top:20px;
	layout-flow:vertical-ideographic;
	border:1px solid #000000;
	width:30px;
	
}

.pcd_tb_right{
	border:1px solid #000000;
	width:638px;

}

.pcd_sub_right_content{
	 
	width:638px;
	text-align:left;
}

.pcd_sub_right_content .pcd_sub_right_tb{
	width:638px;
	text-align:left; 
	font-size:14px;
}
 
 .pcd_left_title{
 	width:120px; 
 	height:24px;
	text-align:right;
	white-space:nowrap;
	font-size:14px;
 }
 .pcd_right_text{
 	width:260px;
 	height:24px;
    border-bottom:1px solid #000000; 
	 
 }
 .pcd_right_text_noline{
 	width:260px; 
 	height:24px;
 }
 
 
 

 #pcd_normal_div{
 	width:670px;
 	margin-top:0px;
 }
 
 #pcd_normal_title2{
 	margin-top:0px;
	 font-size:16px;
	font-weight:bold;
	 
 }
.pcd_normal_tb{
 	width:670px;
	border:1px solid #000000;
	border-collapse:collapse;
     text-align: center;
 }
  .pcd_left_td_normal{
 	border:1px solid #000000;
	width:104px;
	height:36px;
	line-height:0.485cm;
	padding:0px 0px 0px 0px;
	font-size:13px;
	text-align: center;
 }
 
 
  .pcd_right_td_normal{
		border:1px solid #000000;
		width:119px;
		line-height:50px;
		padding:0px 0px 0px 0px;
		font-size:13px;
 }
.pcd_div_bottom{
 	width:621px; 
 	height:50px; 
 }
 .pcd_normal_top_td{
 	border:1px solid #000000;
		width:80px;
		line-height:50px;
		padding:0px 0px 0px 0px;
 }
 .pcd_normal_top_td2{
 	    border:1px solid #000000;
		width:180px;
		line-height:50px;
		padding:0px 0px 0px 0px;
 }
 
 .pcd_normal_title{
 	width:670px; 
 	margin-top:0px;
 	fonst-size:12px;
     text-align: left;
 }
  .pcd_normal_title2{
 	width:670px; 
 	margin-top:0px;
 	fonst-size:12px;
     text-align: center;
 }
 .pcd_bottom_normal{
 	width:670px; 
 	margin-top:0px;
 	fonst-size:12px;
     text-align: center;
 }

.pcd_span_right2{
 		width:110px;
 		line-height:50px;
 		border-bottom: 1px solid #000000;
 }
 .pcd_normal_tb_foot{
 	width:670px;
    padding-right:0px;
    text-align: right;
    font-size: 15px;
    margin-top: 0px;
 }
</style>
    <script type="text/javascript">
	function printpreview1(){  //打印预览 (使用IE自带控件)
		//先设置IE的页边距
		//pageSetup_IE(header,footer,topMargin,bottomMargin,leftMargin,rightMargin);
		
		var obj=parent.document.getElementById("pcd_main");
       	obj.style.overflow="visible";
     	//if($.browser.msie&&$.browser.version=="8.0"&&$("html")[0].scrollHeight>$("html").height()){
		//		$("html").css("overflow","visible");
		//	}
		document.all.wb.execwb(7,1);
		//setTimeout("function(){window.wb.execwb(45,1);//关闭}",5000);//5秒后关闭打印预览页面
		var obj=parent.document.getElementById("pcd_main");
       	obj.style.overflow="scroll";
		
	}
	function previewArea()    //打印(使用IE自带控件)
	{
		window.print();
	}
	</script>
     <script type="text/javascript">
        function saveNoteInfo() {
        	previewArea();
           // $('#btn_sub').click();
        }
        //重写了回调,然后自己控制关闭以及刷新
        function noteSubmitCallback(data) {
            var win = frameElement.api.opener;
            if (data.success == true) {
                $.dialog.confirm(data.msg+',是否关闭界面', function(){
                    frameElement.api.close();
                    win.reloadTable();
                });
            } else {
                $.dialog.tip(data.msg);
            }
        }

    </script>
<style>
@media print{
	.noPrintTab{display:none;}
}
</style>
</head>

<body> 

<!-- <div style="text-align: right;margin-top:0px;margin-right:5px;">
   <input name="doBtn" id="doBtn" type="button" width="50" class="noPrintTab" onClick="printpreview1()" value="打印预览"/>
	
    <input name="doBtn" id="doBtn" type="button" width="50" class="noPrintTab" onClick="previewArea()" value="打 印"/>
</div> -->

<!--startprint1-->
<!-- new派车单开始-->
<div id="pcd_main" style="width:100%;height: 100%;">
	<!--startprint2-->
 	
 	<%--遍历开始--%>
 		<div id="div_print" style="width:100%;height:14.85cm">   
          <br/><br/><br/>
	   <span  style="font: '宋体';font-size: 26px;text-align: center;font-weight: bolder;">${title }</span>
	    <br/><br/>
	    
	     	<tr>
		 	<td>		 
		 		<div style="margin-left: 350px;">
		 			<input type=button class="subBtn" style="width: 80px;height: 30px;float:left;" value="通过" onclick="doCheck()" />
		 			<input type=button class="subBtn" style="width: 80px;height: 30px;float:left;" value="驳回" onclick="doNotCheck()" />
		 			<input type=button class="subBtn" style="width: 80px;height: 30px;float:left;" value="关闭" onclick="frameElement.api.close();" />
		 		</div>	
		 	</td>
		 </tr>
	    <table style="width:85%;">
		  	 	<tr class="pcd_normal_title">	
<%-- 		  	 	    <td align="left" width="25%">申请人：${createPerson }</td>	 --%>	  
		  	 		<td align="right" width="25%">制表时间：${createDate }</td>		  	 			  	 		
		  	 	</tr>
		    </table>
	     <div id="pcd_normal_div" style="width:98%;">
		<table class="pcd_normal_tb" style="width:98%;" align="center">
      		<tbody> 				
      			<c:if test="${smallStr.length() !=0 }">${smallStr }</c:if>
      			<c:if test="${normalStr.length() !=0 }">${normalStr }</c:if>
      			<c:if test="${bigStr.length() !=0 }">${bigStr }</c:if>
      			<c:if test="${biggestStr.length() !=0 }">${biggestStr }</c:if>
		 </tbody>
		 </table>		 		
	  </div> 
      </div>
     </div>
 	<!--endprint2-->
 	<%-- 遍历结束 --%>
</body>
</html>
<script type="text/javascript">
function doCheck(){
	var id = "${id }";
	alert(id);
	$.ajax({   
		url:'detailTableController.do?doCheck&id='+id,
		dataType:'json',
		success:function(data){
			alert(data.msg);
			self.opener.location.reload();
			frameElement.api.close();
		}		
	});  	
};

function doNotCheck(){
	var id = "${id }";
	alert(id);
	$.ajax({   
		url:'detailTableController.do?doNotCheck&id='+id,
		dataType:'json',
		success:function(data){
			alert(data.msg);
			self.opener.location.reload();
			frameElement.api.close();
		}		
	});  
};

</script>

