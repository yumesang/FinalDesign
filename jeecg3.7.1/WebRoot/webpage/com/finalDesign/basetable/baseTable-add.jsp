<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>base_table</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
    function goAddString(id){
  	var statue = document.getElementById(id);
  	var str = "#"+id;
  	if(statue.checked){
  		alert(str);
  	}else{
  		$(str).attr("hide");
  	}
  }
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="baseTableController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${baseTablePage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							表格名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="listName" name="listName" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">表格名称</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							表格类型:
						</label>
					</td>
					<td class="value">
							<t:dictSelect field="listType" type="list"  typeGroupCode="list_type"  defaultVal="${baseTablePage.listType}" hasLabel="false"  title="表格类型" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">表格类型</label>
						</td>
					</tr>
				<tr style="height: 100px;">
					<td align="right">
							<label class="Validform_label">选择表格参数:</label>
					</td>
					<td colspan="3" align="center">
						<div style="float: left;width: 150px;height: 20px">
							<input id="nameBox" type="checkbox" onclick="goAddString(id)" />姓名						
						</div>
						<div style="float: left;width: 150px;height: 20px">
							<input id="ageBox" type="checkbox" />年龄						
						</div>
						<div style="float: left;width: 150px;height: 20px">
							<input id="sexBox" type="checkbox" />性别						
						</div>
						<div style="float: left; width: 150px;height: 20px">
							<input id="professionBox" type="checkbox" />职称						
						</div>
						<div style="float: left;width: 150px;height: 20px">
							<input id="memoBox" type="checkbox" />备注						
						</div>
						<div style="float: left;width: 150px;height: 20px">
							<input id="selfStringBox" type="checkbox" />自定			
						</div>			
					</td>
				</tr>
				<tr>
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
				</tr>
				<tr>
					
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
					</tr>
				<tr hidden="hidden">
					
					<td  align="right">
						<label class="Validform_label">
							系别主键:
						</label>
					</td>
						<td class="value">
					     	<input id="departId" name="departId" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<input id="selfStringName" name="selfStringName"  type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<input id="selfString" name="selfString" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">系别主键</label>
						</td>
					</tr>
				<tr>
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
				<tr id="selftd">
					<td align="right">
						<label class="Validform_label">
							自定义字段名1:
						</label>
					</td>
					<td class="value">
					     	 <input id="selfStringName1" name="selfStringName1" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">自定义字段名1</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							自定义字段1:
						</label>
					</td>
					<td class="value">
					     	 <input id="selfString1" name="selfString1" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">自定义字段1</label>
						</td>
					</tr>
					<tr>
						<td align="right">
						<label class="Validform_label">
							自定义字段名2:
						</label>
					</td>
					<td class="value">
					     	 <input id="selfStringName2" name="selfStringName2" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">自定义字段名2</label>
						</td>
						<td align="right">
						<label class="Validform_label">
							自定义字段2:
						</label>
					</td>
					<td class="value">
					     	 <input id="selfString2" name="selfString2" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">自定义字段2</label>
						</td>
						</tr>
						<tr>
						<td align="right">
						<label class="Validform_label">
							自定义字段名3:
						</label>
					</td>
					<td class="value">
					     	 <input id="selfStringName3" name="selfStringName3" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">自定义字段名3</label>
						</td>
						<td align="right">
						<label class="Validform_label">
							自定义字段3:
						</label>
					</td>
					<td class="value">
					     	 <input id="selfString3" name="selfString3" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">自定义字段3</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							是否启用:
						</label>
					</td>
					<td class="value">
					     	 <input id="enable" name="enable" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否启用</label>
						</td>
				<td align="right">
					<label class="Validform_label">
					</label>
				</td>
				<td class="value">
				</td>
					</tr>		
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/finalDesign/basetable/baseTable.js"></script>		
