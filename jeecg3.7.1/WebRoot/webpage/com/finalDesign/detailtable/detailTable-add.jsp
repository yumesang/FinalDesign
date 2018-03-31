<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>detail_table</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="detailTableController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${detailTablePage.id }"/>
		<table style="width: 800px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							表格名称:
						</label>
					</td>
					<td class="value">
					     	<select id="listName" style="width: 150px;height: 30px;" onchange="onClickSelect(value)">
					     	<option selected="selected" value="">---请选择---</option>
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
							<iframe id="printfrm" src="" width="800px;" height="1000px;" ></iframe>
						</div>
						</td>
					</tr>						
			</table>			
		</t:formvalid>
		
 </body>
 <script type="text/javascript">
 function onClickSelect(value){
 	var webUrl = "baseTableController.do?printView&id="+value;
 	$.ajax({
 		url:webUrl,
 		contentType:'json',
 		async:false,		
 	});
 	 	$('#printfrm').attr('src', webUrl);
 }
 	
 </script>
  <script src = "webpage/com/finalDesign/detailtable/detailTable.js"></script>		
