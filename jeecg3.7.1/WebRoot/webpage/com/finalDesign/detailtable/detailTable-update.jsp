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
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="detailTableController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${detailTablePage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								表格名称:
							</label>
						</td>
						<td class="value">
						     	 <input id="listName" name="listName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${detailTablePage.listName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">表格名称</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								表格类型:
							</label>
						</td>
						<td class="value">
						     	 <input id="listType" name="listType" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${detailTablePage.listType}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">表格类型</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								OAID:
							</label>
						</td>
						<td class="value">
						     	 <input id="oaId" name="oaId" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${detailTablePage.oaId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">OAID</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								姓名:
							</label>
						</td>
						<td class="value">
						     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${detailTablePage.name}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">姓名</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								年龄:
							</label>
						</td>
						<td class="value">
						     	 <input id="age" name="age" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${detailTablePage.age}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">年龄</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								性别:
							</label>
						</td>
						<td class="value">
						     	 <input id="sex" name="sex" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${detailTablePage.sex}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">性别</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								职称:
							</label>
						</td>
						<td class="value">
						     	 <input id="profession" name="profession" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${detailTablePage.profession}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">职称</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								系别主键:
							</label>
						</td>
						<td class="value">
						     	 <input id="departId" name="departId" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${detailTablePage.departId}'/>
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
						     	 <input id="departName" name="departName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${detailTablePage.departName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">系别名称</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value">
						     	 <input id="memo" name="memo" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${detailTablePage.memo}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								自定义字段名:
							</label>
						</td>
						<td class="value">
						     	 <input id="selfStringName" name="selfStringName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${detailTablePage.selfStringName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">自定义字段名</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								自定义字段:
							</label>
						</td>
						<td class="value">
						     	 <input id="selfString" name="selfString" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${detailTablePage.selfString}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">自定义字段</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								创建日期:
							</label>
						</td>
						<td class="value">
									  <input id="createDate" name="createDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${detailTablePage.createDate}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建日期</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								创建人员主键:
							</label>
						</td>
						<td class="value">
						     	 <input id="createUserId" name="createUserId" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${detailTablePage.createUserId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建人员主键</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								创建人员名称:
							</label>
						</td>
						<td class="value">
						     	 <input id="createUserName" name="createUserName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${detailTablePage.createUserName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建人员名称</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								OA名称:
							</label>
						</td>
						<td class="value">
						     	 <input id="oaName" name="oaName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${detailTablePage.oaName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">OA名称</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/finalDesign/detailtable/detailTable.js"></script>		
