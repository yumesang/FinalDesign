<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>base_table</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="baseTableController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${baseTablePage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								表格名称:
							</label>
						</td>
						<td class="value">
						     	 <input id="listName" name="listName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${baseTablePage.listName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">表格名称</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								表格类型:
							</label>
						</td>
						<td class="value">
						     	 <input id="listType" name="listType" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${baseTablePage.listType}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">表格类型</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								表格链接:
							</label>
						</td>
						<td class="value">
						     	 <input id="listUrl" name="listUrl" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${baseTablePage.listUrl}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">表格链接</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								姓名:
							</label>
						</td>
						<td class="value">
						     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${baseTablePage.name}'/>
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
						     	 <input id="age" name="age" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${baseTablePage.age}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">年龄</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								性别:
							</label>
						</td>
						<td class="value">
						     	 <input id="sex" name="sex" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${baseTablePage.sex}'/>
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
						     	 <input id="profession" name="profession" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${baseTablePage.profession}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">职称</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								系别主键:
							</label>
						</td>
						<td class="value">
						     	 <input id="departId" name="departId" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${baseTablePage.departId}'/>
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
						     	 <input id="departName" name="departName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${baseTablePage.departName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">系别名称</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value">
						     	 <input id="memo" name="memo" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${baseTablePage.memo}'/>
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
						     	 <input id="selfStringName" name="selfStringName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${baseTablePage.selfStringName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">自定义字段名</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								自定义字段:
							</label>
						</td>
						<td class="value">
						     	 <input id="selfString" name="selfString" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${baseTablePage.selfString}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">自定义字段</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								被使用次数:
							</label>
						</td>
						<td class="value">
						     	 <input id="useCount" name="useCount" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${baseTablePage.useCount}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">被使用次数</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								审核状态:
							</label>
						</td>
						<td class="value">
						     	 <input id="checkStatus" name="checkStatus" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${baseTablePage.checkStatus}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">审核状态</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								创建日期:
							</label>
						</td>
						<td class="value">
									  <input id="createDate" name="createDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${baseTablePage.createDate}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建日期</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								创建人员主键:
							</label>
						</td>
						<td class="value">
						     	 <input id="createUserId" name="createUserId" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${baseTablePage.createUserId}'/>
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
						     	 <input id="createUserName" name="createUserName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${baseTablePage.createUserName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建人员名称</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								修改日期:
							</label>
						</td>
						<td class="value">
									  <input id="modifyDate" name="modifyDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${baseTablePage.modifyDate}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">修改日期</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								修改人员主键:
							</label>
						</td>
						<td class="value">
						     	 <input id="modifyUserId" name="modifyUserId" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${baseTablePage.modifyUserId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">修改人员主键</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								修改人员名称:
							</label>
						</td>
						<td class="value">
						     	 <input id="modifyUserName" name="modifyUserName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${baseTablePage.modifyUserName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">修改人员名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								是否启用:
							</label>
						</td>
						<td class="value">
						     	 <input id="enable" name="enable" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${baseTablePage.enable}'/>
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
