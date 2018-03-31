<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="detailTableList" checkbox="true" pagination="true" fitColumns="true" title="detail_table" actionUrl="detailTableController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="表格名称"  field="listName"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="表格类型"  field="listType"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="OAID"  field="oaId"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="姓名"  field="name"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="年龄"  field="age"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="性别"  field="sex"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="职称"  field="profession"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="系别主键"  field="departId"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="系别名称"  field="departName"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="memo"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="自定义字段名"  field="selfStringName"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="自定义字段"  field="selfString"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="审核状态"  field="checkStatus"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人员主键"  field="createUserId"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人员名称"  field="createUserName"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="OA名称"  field="oaName"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="detailTableController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="detailTableController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="detailTableController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="detailTableController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="detailTableController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/finalDesign/detailtable/detailTableList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'detailTableController.do?upload', "detailTableList");
}

//导出
function ExportXls() {
	JeecgExcelExport("detailTableController.do?exportXls","detailTableList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("detailTableController.do?exportXlsByT","detailTableList");
}

 </script>