<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>detail_table</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
   <style type="text/css">
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
	
  </style>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="detailTableController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${detailTablePage.id }"/>
		<table style="width: 980px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							表格名称:
						</label>
					</td>
					<td class="value">
					     	<select id="listName" name="listName" style="width: 150px;height: 30px;" onchange="onClickSelect(value)">
					     	<option selected="selected"  value="">---请选择---</option>
					     		${listName }
					     	</select>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">表格名称</label>
						</td>	
					<td align="right" hidden="hidden">
						<label class="Validform_label">
							OAID:
						</label>
					</td>
					<td class="value" hidden="hidden">
					     	 <input id="oaId" name="oaId" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">OAID</label>
						</td>					
					<td align="right">
						<label class="Validform_label">
							OA名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="oaName" name="oaName" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">OA名称</label>
						</td>			
					</tr>		
					<tr>
						<td colspan="4" style="height: auto;">
							<div style="width:100%;height:95%">
								<iframe id="printfrm" src="" width="980px;" height="350px;" ></iframe>
							</div>
						</td>
					</tr>
					<tr hidden="hidden">						
						<td align="right">
							<label class="Validform_label">
								姓名:
							</label>
						</td>
						<td class="value">
						     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">姓名</label>
						</td>
						<td align="right" hidden="hidden">
							<label class="Validform_label">OAID:</label>
						</td>
						<td class="value" hidden="hidden">
					     	<input id="oaId" name="oaId" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">OAID</label>
						</td>					
					</tr>
					<tr hidden="hidden">
						<td align="right">
							<label class="Validform_label">
								年龄:
							</label>
						</td>
						<td class="value">
						     	 <input id="age" name="age" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">年龄</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								性别:
							</label>
						</td>
						<td class="value">
						     	 <input id="sex" name="sex" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">性别</label>
						</td>
					</tr>
					<tr hidden="hidden">
						<td align="right">
							<label class="Validform_label">
								职称:
							</label>
						</td>
						<td class="value">
						     	 <input id="profession" name="profession" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">职称</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								系别主键:
							</label>
						</td>
						<td class="value">
						     	 <input id="departId" name="departId" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">系别主键</label>
						</td>
					</tr>
					<tr hidden="hidden">
						<td align="right">
							<label class="Validform_label">
								系别名称:
							</label>
						</td>
						<td class="value">
						     	 <input id="departName" name="departName" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">系别名称</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value">
						     	 <input id="memo" name="memo" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
					<tr hidden="hidden">
						<td align="right">
							<label class="Validform_label">
								自定义字段名:
							</label>
						</td>
						<td class="value">
						     	 <input id="selfStringName" name="selfStringName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value=""/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">自定义字段名</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								自定义字段:
							</label>
						</td>
						<td class="value">
						     	 <input id="selfString" name="selfString" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value="" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">自定义字段</label>
						</td>
					</tr>
					<tr align="center">
						<td colspan="4">
							<input id="lockBtn" style="display: none;" class="subBtn"  onclick="addtext(id)" value="锁定" readonly="readonly" />
							<button id="goAddBtn" style="display: none;" class="subBtn" onclick="refresh()">提交</button>
						</td>
					</tr>						
			</table>			
		</t:formvalid>
		
 </body>
 <script type="text/javascript">
 function addtext(id){
 	var buttonId = "#"+id;
 	var listValue = $("#printfrm").contents().find("input[class='inputxt']"); 
 	var selfStringNameValue = $("#printfrm").contents().find("[name='selfStringName']"); 
 	var selfStringValue = $("#printfrm").contents().find("[name='selfString']");
 	var selfRadioName = $("#printfrm").contents().find("[name='radioName']");
 	var selfRadioValue = $("#printfrm").contents().find("[type='radio']");
 	var selfCheckBoxName = $("#printfrm").contents().find("[name='checkBoxName']");
 	var selfCheckBoxValue = $("#printfrm").contents().find("[type='checkBox']");
 	var selfStringName = "";
 	var selfString = "";
 	var lastName = "";
 	console.log(selfCheckBoxValue);
 	//基础自定义字段
 	for(var i=0;i<selfStringNameValue.length;i++){
 		if(selfStringName == ""){
 			selfStringName += selfStringNameValue[i].innerHTML;
 			selfString += "textarea:"+selfStringValue[i].value;
 		}else{
 		 	selfStringName += ","+selfStringNameValue[i].innerHTML;
 		 	selfString += ",textarea:"+selfStringValue[i].value;
 		}
 	}
 	
	//单选框自定义字段
 	for(var j=0;j<selfRadioValue.length;j++){
 		if(selfString == ""){
 			if(selfRadioValue[j].checked == true)
 			selfString += "radio:"+selfRadioValue[j].value;		
 		}else{
 			if(selfRadioValue[j].checked == true)
 			selfString += ",radio:"+selfRadioValue[j].value;		
 		}
 	}	
  	for(var i=0;i<selfRadioName.length;i++){	
 		if(selfStringName == ""){
 			selfStringName += selfRadioName[i].innerHTML;
 		}else{
 			selfStringName += ","+selfRadioName[i].innerHTML;
 		}
 	}
 	
 	//多选框自定义字段
 	for(var i=0;i<selfCheckBoxName.length;i++){			
 		if(selfString == ""){		
 			selfStringName += selfCheckBoxName[i].innerHTML;				
 		}else{			
 		 	selfStringName += ","+selfCheckBoxName[i].innerHTML;		
 		}
 	}
 	
 	for(var j=0;j<selfCheckBoxValue.length;j++){
		 alert(lastName);
 		if(selfString == ""){
 			if(selfCheckBoxValue[j].checked == true){
 				selfString += "checkBox:"+selfCheckBoxValue[j].value;		
 				lastName = selfCheckBoxValue[j].name;	
 			}		 			
 		}else{
 			if(selfCheckBoxValue[j].checked == true && selfCheckBoxValue[j].name == lastName){
 				selfString += "-"+selfCheckBoxValue[j].value;					
 			}else if(selfCheckBoxValue[j].checked == true && selfCheckBoxValue[j].name != lastName){
 				selfString += ",checkBox:"+selfCheckBoxValue[j].value;	
 				lastName = selfCheckBoxValue[j].name;
 			}						
 		}
 	}
 	
 	$("#selfString").prop("value",selfString); 
 	$("#selfStringName").prop("value",selfStringName);
 	for(var i = 0; i < listValue.length;i++){
 		var str = "#"+listValue[i].name;
 		$(str).val(listValue[i].value);
 		$("#printfrm").contents().find("input[class='inputxt']").prop({"style":"background-color:#EDEDED","readonly":"readonly"});
 		$("#printfrm").contents().find("#selfString").prop({"style":"background-color:#EDEDED","readonly":"readonly"}); 
 	}
 	$("[name=memo]").prop("value",$("#printfrm").contents().find("#memo").val());
 	$(buttonId).prop("style","display:none;");
 	$("#goAddBtn").prop("style","height:33px;width: 85px;");
 	
 };
 
 function onClickSelect(value){
 	if(value=="")return;
 	var webUrl = "baseTableController.do?printView&id="+value;
 	$.ajax({
 		url:webUrl,
 		contentType:'json',
 		async:false,		
 	});
 	 	$('#printfrm').attr('src', webUrl);
 	 	$('#lockBtn').removeProp("style");
 };
 
 function refresh(){
 	$("#detailTableList").datagrid('reload');
 }
 	
 </script>
  <script src = "webpage/com/finalDesign/detailtable/detailTable.js"></script>		
