<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="notebookList" checkbox="true" pagination="true" fitColumns="true" title="notebook" actionUrl="notebookController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="任务名称"  field="taskName"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="任务内容"  field="taskDetail"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="任务链接"  field="taskUrl"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="预计完成时间"  field="targetDate"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人id"  field="createUserId"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createUserName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="修改日期"  field="modifyDate"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="是否完成"  field="enable"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="是否过期"  field="isPass"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="notebookController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="notebookController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="notebookController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="notebookController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="notebookController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/finalDesign/notebook/notebookList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'notebookController.do?upload', "notebookList");
}

//导出
function ExportXls() {
	JeecgExcelExport("notebookController.do?exportXls","notebookList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("notebookController.do?exportXlsByT","notebookList");
}

 </script>