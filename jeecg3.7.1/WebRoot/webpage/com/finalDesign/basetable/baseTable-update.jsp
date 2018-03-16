<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>base_table</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  $(document).ready(function(){
  	if ("${baseTablePage.name}" != ""){$("#nameBox").attr("checked","checked");}
  	if ("${baseTablePage.age}" != ""){$("#ageBox").attr("checked","checked");}
  	if ("${baseTablePage.sex}" != ""){$("#sexBox").attr("checked","checked");}
  	if ("${baseTablePage.profession}" != ""){$("#professionBox").attr("checked","checked");}
  	if ("${baseTablePage.memo}" != ""){$("#memoBox").attr("checked","checked");}
  	if ("${baseTablePage.departName}" != ""){$("#departNameBox").attr("checked","checked");}
  	if("${baseTablePage.enable}" == "true"){
  		$("input[value=\"enable\"]").attr("checked","checked");
  		$("#selfStringNumBox").removeAttr("style");
  		$("tr[name=selfStringList]").remove();
  		for(var i=0;i<"${selfStringNum }";i++){
  			var str = "${selfStringList }".split(",");
  			var str2 = str[i].split(":");
  			var str3 = "${selfStringName }".split(",");
  			$("#lastRow").before("<tr name=\"selfStringList\"><td align=\"right\"><label class=\"Validform_label\">自定义字段"+ (i+1) +":</label></td><td class=\"value\"><input id=\"selfStringName"+(i+1)+"\" name=\"selfStringName\" type=\"text\" style=\"width: 150px\" value=\""+ str3[i] +"\" class=\"inputxt\"  ignore=\"ignore\" /><span class=\"Validform_checktip\"></span><label class=\"Validform_label\" style=\"display: none;\" >自定义字段名"+(i+1)+"</label></td><td align=\"center\"><input id=\"radioSelect"+(i+1)+"radio\" name=\"radioSelect"+(i+1)+"\" type=\"radio\" onclick=\"selectType(name)\"  value=\"radio\" />单选框   <input id=\"radioSelect"+(i+1)+"checkBox\" name=\"radioSelect"+(i+1)+"\" type=\"radio\" onclick=\"selectType(name)\" value=\"checkBox\" />复选框   <input id=\"radioSelect"+(i+1)+"input\" name=\"radioSelect"+(i+1)+"\" type=\"radio\" onclick=\"selectType(name)\" value=\"input\" />输入框      </td><td align=\"center\"><select id=\"sizeSelect"+ (i+1) +"\" name=\"sizeSelect"+ (i+1) +"\" hidden=\"hidden\" onchange=\"getSelfValue(name)\" ><option value=\"small\">20px</option><option value=\"normal\">50px</option><option value=\"big\">200px</option><option value=\"biggest\">500px</option></select><input id=\"addChoose"+ (i+1) +"\" name=\"addChooses"+ (i+1) +"\" type=\"text\" placeholder=\"输入选项以'-'隔开\" style=\"display:none;\" onchange=\"getSelfValue(name)\" /><input id=\"selfString"+ (i+1) +"\" name=\"selfString\" style=\"display:none\" type=\"text\" /></td></tr>");
			if(str2[0].trim() == "radio" || str2[0].trim() == "checkBox" ){
				var value = "#radioSelect"+ (i+1) +"radio";
				if(str2[0] == "radio"){			
					$(value).attr("checked","checked");
				}else{
					value = "#radioSelect"+ (i+1) +"checkBox";
					$(value).attr("checked","checked");
				}
				var str5 = "#selfString"+ (i+1); 
				var str4 = "#addChoose"+(i+1);
				$(str4).attr("value",str2[1]);
				$(str5).attr("value",str2[0].trim()+":"+str2[1]);
				$(str4).removeAttr("style");
			}else{
				var value = "#radioSelect"+ (i+1) +"input";
				$(value).attr("checked","checked");
				var str4 = "#sizeSelect"+ (i+1);
				var str5 = "option[value="+ str2[1]+"]";
				var str6 = "#selfString"+ (i+1); ;
				$(str4).children(str5).attr("selected","selected");
				$(str5).attr("value",str2[1]);
				$(str6).attr("value",str2[0].trim()+":"+str2[1]);
				$(str4).removeAttr("hidden");
			}	
  		}
  	}else{
  		$("input[value=\"disable\"]").attr("checked","checked");
  	}
  });
  	
  
  function goAddString(id){
  	var statue = document.getElementById(id);
  	var str = "#"+id;
  	var str2 = str.substring(0,str.length-3);
  	if(statue.checked){
  	  	if(id == "memoBox"){
  	  		$(str2).attr("value","normal");
  		}else{
  	  		$(str2).attr("value","small");
  		}
  	}
  };
  
  function addselfStringNumBox(){
  	var check = $("input[name='radio1']:checked").val();
  	if(check == "enable"){
  		$("#selfStringNumBox").removeAttr("style");
  		$("#radioTD").removeAttr("colspan");
  	}else{
  		$("tr[name=selfStringList]").remove();
  		$("#selfStringNumBox").attr("style","display:none");
  	} 
  };
  
  function selectType(name){
  	var str = name;
  	var str2 = "input[name='radioSelect"+ str.substring(11,str.length) +"']:checked";
  	var str3 = "#sizeSelect"+str.substring(11,str.length);  
  	var str4 = "#addChoose"+str.substring(11,str.length); 
/*   	var str5 = "#selfString"+str.substring(11,str.length);  */
  	var check = $(str2).val();  	
  	if(check == "radio" || check == "checkBox"){ 
  		$(str3).attr("hidden","hidden");
  		$(str3).removeAttr("value");
  		$(str4).removeAttr("style");	
/*   		$(str5).attr("value",check); */
  	}else{	
  		$(str4).attr("style","display:none;");
  		$(str4).removeAttr("value");
  		$(str3).removeAttr("hidden");	
/*   		$(str5).attr("value",check); */
  	}
  };

  function addSelfString(){
  	var str = $("input[id='selfStringNumBox']").val();
  	str = parseInt(str);
  	if(str >10 || str <=0){
  		alert("输入不符合规范,请输入1-10之间的数字。");
  	}else{
  		$("tr[name=selfStringList]").remove();
  		for(var i=0;i<str;i++){
  			$("#lastRow").before("<tr name=\"selfStringList\"><td align=\"right\"><label class=\"Validform_label\">自定义字段"+ (i+1) +":</label></td><td class=\"value\"><input id=\"selfStringName"+(i+1)+"\" name=\"selfStringName\" type=\"text\" style=\"width: 150px\" class=\"inputxt\"  ignore=\"ignore\" /><span class=\"Validform_checktip\"></span><label class=\"Validform_label\" style=\"display: none;\" >自定义字段名"+(i+1)+"</label></td><td align=\"center\"><input name=\"radioSelect"+(i+1)+"\" type=\"radio\" onclick=\"selectType(name)\"  value=\"radio\" />单选框   <input name=\"radioSelect"+(i+1)+"\" type=\"radio\" onclick=\"selectType(name)\" value=\"checkBox\" />复选框   <input name=\"radioSelect"+(i+1)+"\" type=\"radio\" onclick=\"selectType(name)\" value=\"input\" />输入框      </td><td align=\"center\"><select id=\"sizeSelect"+ (i+1) +"\" name=\"sizeSelect"+ (i+1) +"\" hidden=\"hidden\" onchange=\"getSelfValue(name)\" ><option value=\"0\" selected=\"selected\" disabled=\"disabled\">框体高度</option><option value=\"small\">20px</option><option value=\"normal\">50px</option><option value=\"big\">200px</option><option value=\"biggest\">500px</option></select><input id=\"addChoose"+ (i+1) +"\" name=\"addChooses"+ (i+1) +"\" type=\"text\" placeholder=\"输入选项以'-'隔开\" style=\"display:none;\" onchange=\"getSelfValue(name)\" /><input id=\"selfString"+ (i+1) +"\" name=\"selfString\" style=\"display:none\" type=\"text\" /></td></tr>");
  		}
  	}
 	};
 function getSelfValue(name){
 	var str = name;
 	var str1 = "input[name='radioSelect"+ str.substring(10,str.length) +"']:checked";
 	var str2 = "#selfString"+ str.substring(10,str.length);
 	var str3 = "#addChoose" + str.substring(10,str.length);
 	var str4 = "#sizeSelect" + str.substring(10,str.length);
 	var type = $(str1).val();
 	if(type == "radio" || type == "checkBox"){
		var value = type+":"+$(str3).val();
		$(str2).val(value);
 	}else{
 		var value = type+":"+$(str4).val();
 		$(str2).val(value);
 	}
 }
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="baseTableController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${baseTablePage.id }"/>
		<table style="width: 700px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							表格名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="listName" name="listName" type="text" style="width: 150px" class="inputxt" value="${baseTablePage.listName}" datatype="*" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">表格名称</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							表格类型:
						</label>
					</td>
					<td class="value">
							<t:dictSelect field="listType" type="list"  typeGroupCode="list_type"  defaultVal="${baseTablePage.listType}"  hasLabel="false" datatype="*"  title="表格类型" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">表格类型</label>
						</td>
					</tr>
				<tr style="height: 80px;">
					<td align="right">
							<label class="Validform_label">选择表格参数:</label>
					</td>
					<td colspan="3" align="center">
						<div style="float: left;width: 150px;height: 20px">
							<input id="nameBox" type="checkbox" onclick="goAddString(id)" />姓名						
						</div>
						<div style="float: left;width: 150px;height: 20px">
							<input id="ageBox" type="checkbox" onclick="goAddString(id)" />年龄						
						</div>
						<div style="float: left;width: 150px;height: 20px">
							<input id="sexBox" type="checkbox" onclick="goAddString(id)" />性别						
						</div>
						<div style="float: left; width: 150px;height: 20px">
							<input id="professionBox" type="checkbox" onclick="goAddString(id)" />职称						
						</div>
						<div style="float: left;width: 150px;height: 20px">
							<input id="memoBox" type="checkbox" onclick="goAddString(id)" />备注						
						</div>
						<div style="float: left;width: 150px;height: 20px">
							<input id="departNameBox" type="checkbox" onclick="goAddString(id)" />系别																																						
						</div>						
					</td>
				</tr>
					<tr style="height: 50px;">
					<td align="right">
						<label class="Validform_label">自定义:</label>
					</td>
					<td id="radioTD" align="center" >
						<input name="radio1" type="radio" onclick="addselfStringNumBox()" value="enable" />启用
						<input name="radio1" type="radio" onclick="addselfStringNumBox()" value="disable" />关闭
					</td>		
					<td align="center" colspan="2">								
						<input id="selfStringNumBox" type="text" style="display: none;" value="${selfStringNum }" onchange="addSelfString()" placeholder="自定义字段个数(1-10)"/>	
					</td>					
				</tr>
				<tr>
					<td align="right" id="mynameBox" hidden="hidden">
						<label class="Validform_label">
							姓名:
						</label>
					</td>
					<td class="value" id="mynameBox2" hidden="hidden">
					    <input id="name" name="name" type="text" style="width: 150px" value="${baseTablePage.name}" class="inputxt"  ignore="ignore" />
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">姓名</label>
					</td>	
					<td align="right" id="myageBox" hidden="hidden">
						<label class="Validform_label">
							年龄:
						</label>
					</td>
					<td class="value" id="myageBox2" hidden="hidden">
					     	 <input id="age" name="age" type="text" style="width: 150px" value="${baseTablePage.age}" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">年龄</label>
						</td>		
				</tr>
				<tr>
					
					<td align="right" id="mysexBox" hidden="hidden">
						<label class="Validform_label">
							性别:
						</label>
					</td>
					<td class="value" id="mysexBox2" hidden="hidden">
					     	 <input id="sex" name="sex" type="text" style="width: 150px" class="inputxt" value="${baseTablePage.sex}" ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">性别</label>
						</td>
						<td align="right" id="myprofessionBox" hidden="hidden">
						<label class="Validform_label">
							职称:
						</label>
					</td>
					<td class="value" id="myprofessionBox2" hidden="hidden">
					     	 <input id="profession" name="profession" type="text" style="width: 150px" value="${baseTablePage.profession}" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">职称</label>
						</td>
					</tr>
				<tr hidden="hidden">
					
					<td  align="right">
						<label class="Validform_label">
							系别主键:
						</label>
					</td>
						<td class="value">
					     	<input id="departId" name="departId" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
<!-- 							<input id="selfStringName" name="selfStringName"  type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<input id="selfString" name="selfString" type="text" style="width: 150px" class="inputxt"  ignore="ignore" /> -->
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">系别主键</label>
						</td>
					</tr>
				<tr id="lastRow">
					<td align="right" id="mydepartNameBox" hidden="hidden">
						<label class="Validform_label">
							系别名称:
						</label>
					</td>
					<td class="value" id="mydepartNameBox2" hidden="hidden">
					     	 <input id="departName" name="departName" type="text" style="width: 150px" value="${baseTablePage.departName}" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">系别名称</label>
						</td>
					<td align="right" id="mymemoBox" hidden="hidden">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value" id="mymemoBox2" hidden="hidden">
					     	 <input id="memo" name="memo" type="text" style="width: 150px" value="${baseTablePage.memo}" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>		
				<tr hidden="hidden">
					<td align="right">
						<label class="Validform_label">
							是否启用:
						</label>
					</td>
					<td class="value">
					     	 <input id="enable" name="enable" type="text" style="width: 150px" class="inputxt" value="${baseTablePage.enable}"   ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否启用</label>
						</td>
					</tr>		
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/finalDesign/basetable/baseTable.js"></script>		
