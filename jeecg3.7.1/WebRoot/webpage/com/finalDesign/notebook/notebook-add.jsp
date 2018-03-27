<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>notebook</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
 <div align="center">
 	 <span style="font-size: 20px;font: '宋体'">
 	 	添加备忘录
 	 </span>
 </div>

  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="notebookController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${notebookPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							任务名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="taskName" name="taskName" type="text" style="width: 150px" class="inputxt"  datatype="*" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">任务名称</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							任务内容:
						</label>
					</td>
					<td class="value">
					     	 <input id="taskDetail" name="taskDetail" type="text" style="width: 150px" class="inputxt"  datatype="*" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">任务内容</label>
						</td>
				</tr>
				<tr style="display: none;">
					<td align="right">
						<label class="Validform_label">
							任务链接:
						</label>
					</td>
					<td class="value">
					     	 <input id="taskUrl" name="taskUrl" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">任务链接</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							预计完成时间:
						</label>
					</td>
					<td class="value">
							   <input id="targetDate" name="targetDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  datatype="*" />
								
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">预计完成时间</label>
						</td>
				</tr>
				<tr style="display: none;">
					<td align="right">
						<label class="Validform_label">
							创建日期:
						</label>
					</td>
					<td class="value">
							   <input id="createDate" name="createDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建日期</label>
						</td>
				</tr>
				<tr style="display: none;">
					<td align="right">
						<label class="Validform_label">
							修改日期:
						</label>
					</td>
					<td class="value">
							   <input id="modifyDate" name="modifyDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">修改日期</label>
						</td>
				</tr>								
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/finalDesign/notebook/notebook.js"></script>		
