<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="flowTaskInfoList" checkbox="true" pagination="true" fitColumns="true" title="flow_task_info" actionUrl="flowTaskInfoController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="任务名称"  field="taskName"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="任务链接"  field="url"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="检查状态"  field="checkStatus"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="节点数量"  field="nodeNum"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="节点备注"  field="nodeMemo"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="审核人员id"  field="checkUserId"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="审核通过日期"  field="passDate"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人员id"  field="ceateUserId"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="flowTaskInfoController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="flowTaskInfoController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="flowTaskInfoController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="flowTaskInfoController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="flowTaskInfoController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/finalDesign/flowtaskinfo/flowTaskInfoList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'flowTaskInfoController.do?upload', "flowTaskInfoList");
}

//导出
function ExportXls() {
	JeecgExcelExport("flowTaskInfoController.do?exportXls","flowTaskInfoList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("flowTaskInfoController.do?exportXlsByT","flowTaskInfoList");
}

 </script>