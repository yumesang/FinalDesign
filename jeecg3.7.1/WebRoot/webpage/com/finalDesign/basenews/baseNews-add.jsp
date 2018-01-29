<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>base_news</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="baseNewsController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${baseNewsPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							内容简介:
						</label>
					</td>
					<td class="value">
					     	 <input id="introduction" name="introduction" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">内容简介</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							关键字:
						</label>
					</td>
					<td class="value">
					     	 <input id="keywords" name="keywords" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">关键字</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							审核状态:
						</label>
					</td>
					<td class="value">
					     	 <input id="checkStatus" name="checkStatus" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">审核状态</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							被阅读次数:
						</label>
					</td>
					<td class="value">
					     	 <input id="readCount" name="readCount" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">被阅读次数</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							是否启用:
						</label>
					</td>
					<td class="value">
					     	 <input id="enable" name="enable" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否启用</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							排序码:
						</label>
					</td>
					<td class="value">
					     	 <input id="sortcode" name="sortcode" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">排序码</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							删除标记:
						</label>
					</td>
					<td class="value">
					     	 <input id="deleteMark" name="deleteMark" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">删除标记</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							创建时间:
						</label>
					</td>
					<td class="value">
							   <input id="createDate" name="createDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建时间</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							创建用户主键:
						</label>
					</td>
					<td class="value">
					     	 <input id="createUserId" name="createUserId" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建用户主键</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							创建用户名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="createUserName" name="createUserName" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建用户名称</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							修改时间:
						</label>
					</td>
					<td class="value">
							   <input id="modifyDate" name="modifyDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">修改时间</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							修改用户主键:
						</label>
					</td>
					<td class="value">
					     	 <input id="modifyUserId" name="modifyUserId" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">修改用户主键</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							修改用户名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="modifyUserName" name="modifyUserName" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">修改用户名称</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							公告类型:
						</label>
					</td>
					<td class="value">
					     	 <input id="newsType" name="newsType" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">公告类型</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							创建部门主键:
						</label>
					</td>
					<td class="value">
					     	 <input id="departId" name="departId" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建部门主键</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							创建部门名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="departName" name="departName" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建部门名称</label>
						</td>
					</tr>
				
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							文章内容:
						</label>
					</td>
					<td class="value"  colspan="3" >
								<script type="text/javascript"  charset="utf-8" src="plug-in/ueditor/ueditor.config.js"></script>
								<script type="text/javascript"  charset="utf-8" src="plug-in/ueditor/ueditor.all.min.js"></script>
						    	<textarea name="contents" id="contents" style="width: 650px;height:300px"></textarea>
							    <script type="text/javascript">
							        var contents_editor = UE.getEditor('contents');
							    </script>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">文章内容</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/finalDesign/basenews/baseNews.js"></script>		
