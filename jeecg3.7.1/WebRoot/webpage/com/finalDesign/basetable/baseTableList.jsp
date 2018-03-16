<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="baseTableList" checkbox="true" pagination="true" fitColumns="true" title="base_table" actionUrl="baseTableController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" align="center" width="120"></t:dgCol>
   <t:dgDelOpt title="删除" url="baseTableController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgFunOpt title="查看" funname="printData(id)" urlclass="ace_button"  urlfont="fa-trash-o" />
   <t:dgCol title="表格名称"  field="listName"  queryMode="group"  width="230"></t:dgCol>
   <t:dgCol title="表格类型"  field="listType" dictionary="list_type"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="被使用次数"  field="useCount"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="修改日期"  field="modifyDate"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="审核状态"  field="checkStatus"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="是否启用"  field="enable" replace="启用_true,禁用_false"  queryMode="group"  width="120"></t:dgCol>
   <t:dgToolBar title="新建" icon="icon-add" url="baseTableController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="baseTableController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="baseTableController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
<%--    <t:dgToolBar title="查看" icon="icon-search" url="baseTableController.do?jump" funname="detail"></t:dgToolBar> --%>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/finalDesign/basetable/baseTableList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });  
 
 function printData(id){
	openwindow("表格预览",'baseTableController.do?jump&id='+id,"dgList",1000,550);
}
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'baseTableController.do?upload', "baseTableList");
}

//导出
function ExportXls() {
	JeecgExcelExport("baseTableController.do?exportXls","baseTableList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("baseTableController.do?exportXlsByT","baseTableList");
}

 </script>