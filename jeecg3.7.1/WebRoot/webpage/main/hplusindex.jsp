<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<!DOCTYPE html>
<html>
<style>
	.tableList{
		text-align:center;
		margin: 20px;
	};
</style>
<head>
    <!--360浏览器优先以webkit内核解析-->
    <title></title>
    <link rel="shortcut icon" href="images/favicon.ico">
    <link href="plug-in-ui/hplus/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="plug-in-ui/hplus/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="plug-in-ui/hplus/css/animate.css" rel="stylesheet">
    <link href="plug-in-ui/hplus/css/style.css?v=4.1.0" rel="stylesheet">
</head>
<body class="gray-bg">

<!-- Mirrored from www.zi-han.net/theme/hplus/index_v2.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:18:30 GMT -->
            <div class="col-sm-9">
                <div class="ibox float-e-margins" >
                    <div class="ibox-title">
                        <h5 style="font-size: 20px;">待办事宜 </h5>                        
                        <small class="pull-right text-right"><a onclick="readMore()" href="#">&nbsp&nbsp&nbsp查看更多</a></small>
                        <span class="label label-primary"></span>
                    </div>
                    <div class="ibox-content">
                        <div>                           
                            ${printTask }
                        </div>                                                                                                                              
                    </div>                                       
                </div>             
                <div class="ibox float-e-margins">
                    <div class="ibox-title" style="height: 60px;">
                        <h5 style="font-size: 20px;">常用表格</h5>                      
                        	<select id="selectList" class="pull-right text-right" style="width: auto;height: auto;" onchange="selecteList()">
                        		<option value="null">选择表格类别</option>
                        		<option value="default">查看全部</option>  
                        		<option value="approval">审批类</option>
                        		<option value="engineering">学工类</option>
                        		<option value="asset">资产类</option>
                        		<option value="personnel">人事类</option>
                        		<option value="educational">教务类</option>
                        		<option value="administration">行政类</option>
                        		<option value="apply">申请类</option>
                        		<option value="affairs">党务类</option>
                        		<option value="finance">财务类</option>
                        		<option value="scientific">科研类</option>
                        		<option value="support">后勤类</option>                        		
                        		<option value="other">其他类</option>                      		                       		
                        	</select>                     
                    </div>
                    <div class="ibox-content no-padding">
                        <ul class="list-group">
                         <li id="default" class="list-group-item" style="overflow: hidden; display: none;"></li>
                            <li id="approval" class="list-group-item" style="overflow: hidden; display: none;">
                            	<table>                            		
                            			<tr style="height: 50px;">
                            				<td><Strong style="font-size: 15px;">审批类</Strong></td>                            				
                            			</tr>
                            			<tr>
                            				<td><p><a class="tableList" onclick="oilApply()" href="#">申请表</a></p></td>
                            				<td><p><a class="tableList" onclick="oilType0()" href="#">申请表</a></p></td>     
                                			<td><p><a class="tableList" onclick="oilType1()" href="#">申请表</a></p></td>
                                			<td><p><a class="tableList" onclick="oilType2()" href="#">申请表</a></p></td>   
                                			<td><p><a class="tableList" onclick="moneyInsert()" href="#">申请表</a></p></td>
                                			<td><p><a class="tableList" onclick="moneyConsume()" href="#">申请表</a></p></td>       
                                		</tr>                                		
                            	</table>                                      
                            </li>
                             <li id="engineering" class="list-group-item" style="overflow: hidden; display: none;">
                            	<table>                            		
                            			<tr style="height: 50px;">
                            				<td><Strong style="font-size: 15px;">学工类</Strong></td>                            				
                            			</tr>
                            			<tr>
                            				<td><p><a class="tableList" onclick="oilApply()" href="#">申请表</a></p></td>
                            				<td><p><a class="tableList" onclick="oilType0()" href="#">申请表</a></p></td>     
                                			<td><p><a class="tableList" onclick="oilType1()" href="#">申请表</a></p></td>
                                			<td><p><a class="tableList" onclick="oilType2()" href="#">申请表</a></p></td>   
                                			<td><p><a class="tableList" onclick="moneyInsert()" href="#">申请表</a></p></td>
                                			<td><p><a class="tableList" onclick="moneyConsume()" href="#">申请表</a></p></td>       
                                		</tr>                                		
                            	</table>                                      
                            </li> 
                            <li id="asset" class="list-group-item" style="overflow: hidden; display: none;">
                            	<table>                            		
                            			<tr style="height: 50px;">
                            				<td><Strong style="font-size: 15px;">资产类</Strong></td>                            				
                            			</tr>
                            			<tr>
                            				<td><p><a class="tableList" onclick="oilApply()" href="#">申请表</a></p></td>
                            				<td><p><a class="tableList" onclick="oilType0()" href="#">申请表</a></p></td>     
                                			<td><p><a class="tableList" onclick="oilType1()" href="#">申请表</a></p></td>
                                			<td><p><a class="tableList" onclick="oilType2()" href="#">申请表</a></p></td>   
                                			<td><p><a class="tableList" onclick="moneyInsert()" href="#">申请表</a></p></td>
                                			<td><p><a class="tableList" onclick="moneyConsume()" href="#">申请表</a></p></td>       
                                		</tr>                                		
                            	</table>                                      
                            </li>
                            <li id="personnel" class="list-group-item" style="overflow: hidden; display: none;">
                            	<table>                            		
                            			<tr style="height: 50px;">
                            				<td><Strong style="font-size: 15px;">人事类</Strong></td>                            				
                            			</tr>
                            			<tr>
                            				<td><p><a class="tableList" onclick="oilApply()" href="#">申请表</a></p></td>
                            				<td><p><a class="tableList" onclick="oilType0()" href="#">申请表</a></p></td>     
                                			<td><p><a class="tableList" onclick="oilType1()" href="#">申请表</a></p></td>
                                			<td><p><a class="tableList" onclick="oilType2()" href="#">申请表</a></p></td>   
                                			<td><p><a class="tableList" onclick="moneyInsert()" href="#">申请表</a></p></td>
                                			<td><p><a class="tableList" onclick="moneyConsume()" href="#">申请表</a></p></td>       
                                		</tr>                                		
                            	</table>                                      
                            </li>    
                            <li id="educational" class="list-group-item" style="overflow: hidden; display: none;">
                            	<table>                            		
                            			<tr style="height: 50px;">
                            				<td><Strong style="font-size: 15px;">教务类</Strong></td>                            				
                            			</tr>
                            			<tr>
                            				<td><p><a class="tableList" onclick="oilApply()" href="#">申请表</a></p></td>
                            				<td><p><a class="tableList" onclick="oilType0()" href="#">申请表</a></p></td>     
                                			<td><p><a class="tableList" onclick="oilType1()" href="#">申请表</a></p></td>
                                			<td><p><a class="tableList" onclick="oilType2()" href="#">申请表</a></p></td>   
                                			<td><p><a class="tableList" onclick="moneyInsert()" href="#">申请表</a></p></td>
                                			<td><p><a class="tableList" onclick="moneyConsume()" href="#">申请表</a></p></td>       
                                		</tr>                                		
                            	</table>                                      
                            </li> 
                            <li id="administration" class="list-group-item" style="overflow: hidden; display: none;">
                            	<table>                            		
                            			<tr style="height: 50px;">
                            				<td><Strong style="font-size: 15px;">行政类</Strong></td>                            				
                            			</tr>
                            			<tr>
                            				<td><p><a class="tableList" onclick="oilApply()" href="#">申请表</a></p></td>
                            				<td><p><a class="tableList" onclick="oilType0()" href="#">申请表</a></p></td>     
                                			<td><p><a class="tableList" onclick="oilType1()" href="#">申请表</a></p></td>
                                			<td><p><a class="tableList" onclick="oilType2()" href="#">申请表</a></p></td>   
                                			<td><p><a class="tableList" onclick="moneyInsert()" href="#">申请表</a></p></td>
                                			<td><p><a class="tableList" onclick="moneyConsume()" href="#">申请表</a></p></td>       
                                		</tr>                                		
                            	</table>                                      
                            </li> 
                            <li id="apply" class="list-group-item" style="overflow: hidden; display: none;">
                            	<table>                            		
                            			<tr style="height: 50px;">
                            				<td><Strong style="font-size: 15px;">申请类</Strong></td>                            				
                            			</tr>
                            			<tr>
                            				<td><p><a class="tableList" onclick="oilApply()" href="#">申请表</a></p></td>
                            				<td><p><a class="tableList" onclick="oilType0()" href="#">申请表</a></p></td>     
                                			<td><p><a class="tableList" onclick="oilType1()" href="#">申请表</a></p></td>
                                			<td><p><a class="tableList" onclick="oilType2()" href="#">申请表</a></p></td>   
                                			<td><p><a class="tableList" onclick="moneyInsert()" href="#">申请表</a></p></td>
                                			<td><p><a class="tableList" onclick="moneyConsume()" href="#">申请表</a></p></td>       
                                		</tr>                                		
                            	</table>                                      
                            </li> 
                            <li id="affairs" class="list-group-item" style="overflow: hidden; display: none;">
                            	<table>                            		
                            			<tr style="height: 50px;">
                            				<td><Strong style="font-size: 15px;">党务类</Strong></td>                            				
                            			</tr>
                            			<tr>
                            				<td><p><a class="tableList" onclick="oilApply()" href="#">申请表</a></p></td>
                            				<td><p><a class="tableList" onclick="oilType0()" href="#">申请表</a></p></td>     
                                			<td><p><a class="tableList" onclick="oilType1()" href="#">申请表</a></p></td>
                                			<td><p><a class="tableList" onclick="oilType2()" href="#">申请表</a></p></td>   
                                			<td><p><a class="tableList" onclick="moneyInsert()" href="#">申请表</a></p></td>
                                			<td><p><a class="tableList" onclick="moneyConsume()" href="#">申请表</a></p></td>       
                                		</tr>                                		
                            	</table>                                      
                            </li> 
                            <li id="finance" class="list-group-item" style="overflow: hidden; display: none;">
                            	<table>                            		
                            			<tr style="height: 50px;">
                            				<td><Strong style="font-size: 15px;">财务类</Strong></td>                            				
                            			</tr>
                            			<tr>
                            				<td><p><a class="tableList" onclick="oilApply()" href="#">申请表</a></p></td>
                            				<td><p><a class="tableList" onclick="oilType0()" href="#">申请表</a></p></td>     
                                			<td><p><a class="tableList" onclick="oilType1()" href="#">申请表</a></p></td>
                                			<td><p><a class="tableList" onclick="oilType2()" href="#">申请表</a></p></td>   
                                			<td><p><a class="tableList" onclick="moneyInsert()" href="#">申请表</a></p></td>
                                			<td><p><a class="tableList" onclick="moneyConsume()" href="#">申请表</a></p></td>       
                                		</tr>                                		
                            	</table>                                      
                            </li> 
                            <li id="scientific" class="list-group-item" style="overflow: hidden; display: none;">
                            	<table>                            		
                            			<tr style="height: 50px;">
                            				<td><Strong style="font-size: 15px;">科研类</Strong></td>                            				
                            			</tr>
                            			<tr>
                            				<td><p><a class="tableList" onclick="oilApply()" href="#">申请表</a></p></td>
                            				<td><p><a class="tableList" onclick="oilType0()" href="#">申请表</a></p></td>     
                                			<td><p><a class="tableList" onclick="oilType1()" href="#">申请表</a></p></td>
                                			<td><p><a class="tableList" onclick="oilType2()" href="#">申请表</a></p></td>   
                                			<td><p><a class="tableList" onclick="moneyInsert()" href="#">申请表</a></p></td>
                                			<td><p><a class="tableList" onclick="moneyConsume()" href="#">申请表</a></p></td>       
                                		</tr>                                		
                            	</table>                                      
                            </li> 
                            <li id="support" class="list-group-item" style="overflow: hidden; display: none;">
                            	<table>                            		
                            			<tr style="height: 50px;">
                            				<td><Strong style="font-size: 15px;">后勤类</Strong></td>                            				
                            			</tr>
                            			<tr>
                            				<td><p><a class="tableList" onclick="oilApply()" href="#">申请表</a></p></td>
                            				<td><p><a class="tableList" onclick="oilType0()" href="#">申请表</a></p></td>     
                                			<td><p><a class="tableList" onclick="oilType1()" href="#">申请表</a></p></td>
                                			<td><p><a class="tableList" onclick="oilType2()" href="#">申请表</a></p></td>   
                                			<td><p><a class="tableList" onclick="moneyInsert()" href="#">申请表</a></p></td>
                                			<td><p><a class="tableList" onclick="moneyConsume()" href="#">申请表</a></p></td>       
                                		</tr>                                		
                            	</table>                                      
                            </li> 
                            <li id="other" class="list-group-item" style="overflow: hidden; display: none;">
                            	<table>                            		
                            			<tr style="height: 50px;">
                            				<td><Strong style="font-size: 15px;">其他类</Strong></td>                            				
                            			</tr>
                            			<tr>
                            				<td><p><a class="tableList" onclick="oilApply()" href="#">申请表</a></p></td>
                            				<td><p><a class="tableList" onclick="oilType0()" href="#">申请表</a></p></td>     
                                			<td><p><a class="tableList" onclick="oilType1()" href="#">申请表</a></p></td>
                                			<td><p><a class="tableList" onclick="oilType2()" href="#">申请表</a></p></td>   
                                			<td><p><a class="tableList" onclick="moneyInsert()" href="#">申请表</a></p></td>
                                			<td><p><a class="tableList" onclick="moneyConsume()" href="#">申请表</a></p></td>       
                                		</tr>                                		
                            	</table>                                      
                            </li>                                                  
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5 style="font-size: 20px;">通知公告</h5>
                        <small class="pull-right text-right"><a onclick="baseNews()" href="#">&nbsp&nbsp&nbsp更多</a></small>
                    </div>                    
                    <div class="ibox-content timeline">                                              
                        <div class="timeline-item">
                            <div class="row">
                            ${printWord }
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5 style="font-size: 20px;">作品说明</h5>
                    </div>                    
                    <div class="ibox-content timeline">                                              
                        <div class="timeline-item">
                            <div class="row">
                            	<p><a class="row" onclick="jumpToHplusHome()" href="#">1、作品说明手册</a></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
                        <!-- <div class="col-sm-3">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>最新文件</h5>
                    </div>                    
                    <div class="ibox-content timeline">                                              
                        <div class="timeline-item">
                            <div class="row">
                            </div>
                        </div>
                    </div>
                </div>
            </div> -->
 <script type="text/javascript">
 	var selected = null;
 	function selecteList(){	
 		var checkValue=$("#selectList").val();		
 		var str = "#"+checkValue;
/*  		if(selected == null){
 			$(str).show(500);
 		}else{
 		 	$(selected).hide(500).ready(function(){
 				$(str).show(500);
 			});
 		} */
 		if(str == "#default"){
 			$(str).siblings().show(500);
 		}else{
 			$(str).siblings().hide(500);
 			$(str).show(500);
 		}

 		
		selected = str;
 	}
 	
 	function oilApply(){
 		var title = "油料申请表";
 		addOneTab(title, "");
 	}
 	 function oilType0(){
 	  	var title = "油料入库登记";
 		addOneTab(title, "");
 	}
 	 function oilType1(){
 	 	var title = "油料出库登记";
 		addOneTab(title, "");
 	} 	
 	 function oilType2(){
 	 	var title = "油料消耗登记";
 		addOneTab(title, "");
 	}  
 	function moneyInsert(){
 	 	var title = "经费收入登记";
 		addOneTab(title, "");
 	} 	 
 	function moneyConsume(){
 	 	var title = "经费支出登记";
 		addOneTab(title, "");
 	}
 	function baseNews(){ 		
 		var title = "通知公告";
 		addOneTab(title, "");
 	}
 	function readMore(){
 		var title = "待办事宜";
 		addOneTab(title, "");
/*  		var title = "待办事宜";
 		addOneTab(title, "Controller.do?list"); */
 	}
 	function jumpToHplusHome(){
 		var title = "作品说明手册";
 		addOneTab(title, "loginController.do?hplushome2");
 	}
 	
 	function showDetail(id,introduction){
  	var title = "查看";
	var url = "baseNewsController.do?previewList&id="+id+"&introduction="+introduction;
	openwindow(title, url,"dgList",1230,550);
	$.ajax({success:function(data){$('#informList').datagrid('reload');}})  
} 

	function review(url){
		var title = "查看";
		openwindow(title, url,"dgList",1300,550);
		$.ajax({success:function(data){$('#informList').datagrid('reload');}})  
	}
 	
 </script>
</body>


<!-- Mirrored from www.zi-han.net/theme/hplus/index_v2.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:18:46 GMT -->
</html>
</body>

</html>
