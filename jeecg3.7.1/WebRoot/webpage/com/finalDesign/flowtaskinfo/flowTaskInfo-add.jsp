<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>flow_task_info</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="flowTaskInfoController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${flowTaskInfoPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							任务名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="taskName" name="taskName" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">任务名称</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							任务链接:
						</label>
					</td>
					<td class="value">
					     	 <input id="url" name="url" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">任务链接</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							检查状态:
						</label>
					</td>
					<td class="value">
					     	 <input id="checkStatus" name="checkStatus" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">检查状态</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							节点数量:
						</label>
					</td>
					<td class="value">
					     	 <input id="nodeNum" name="nodeNum" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">节点数量</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							节点备注:
						</label>
					</td>
					<td class="value">
					     	 <input id="nodeMemo" name="nodeMemo" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">节点备注</label>
						</td>
				</tr>
				<tr>
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
				<tr>
					<td align="right">
						<label class="Validform_label">
							审核人员id:
						</label>
					</td>
					<td class="value">
					     	 <input id="checkUserId" name="checkUserId" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">审核人员id</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							审核通过日期:
						</label>
					</td>
					<td class="value">
							   <input id="passDate" name="passDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">审核通过日期</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							创建人员id:
						</label>
					</td>
					<td class="value">
					     	 <input id="ceateUserId" name="ceateUserId" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建人员id</label>
						</td>
				</tr>
				
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/finalDesign/flowtaskinfo/flowTaskInfo.js"></script>		
