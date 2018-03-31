<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="selfOaServiceList" checkbox="true" pagination="true" fitColumns="true" title="self_oa_service" actionUrl="selfOaServiceController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="流程名称"  field="oaName"  queryMode="group" align="center"  width="120"></t:dgCol>
   <t:dgCol title="各节点审核人员"  field="oaDetailId" hidden="true" align="center" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="各节点审核人员"  field="oaDetailName" hidden="true" align="center" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="各节点审核备注"  field="nodeMemo" hidden="true" align="center" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="节点数量"  field="nodeNum"  queryMode="group" align="center" width="120"></t:dgCol>
   <t:dgCol title="流程等级"  field="oaLevel" hidden="true" queryMode="group" align="center" width="120"></t:dgCol>
   <t:dgCol title="创建人员id"  field="createUserId" hidden="true" align="center" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人员"  field="createUserName" hidden="true" queryMode="group" align="center" width="120"></t:dgCol>
   <t:dgCol title="修改人员id"  field="modifyUserId" hidden="true" align="center" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="修改人员"  field="modifyUserName" hidden="true" align="center" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd" align="center" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="修改日期"  field="modifyDate"   formatter="yyyy-MM-dd" align="center" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="各节点检查状态"  field="checkStatus"  hidden="true" align="center" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="是否启用"  field="enable"  hidden="true" align="center" queryMode="group"  width="120"></t:dgCol>

   <t:dgToolBar title="新增" icon="icon-add" url="selfOaServiceController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="selfOaServiceController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="删除"  icon="icon-remove" url="selfOaServiceController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="selfOaServiceController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/finalDesign/selfoaservice/selfOaServiceList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'selfOaServiceController.do?upload', "selfOaServiceList");
}

//导出
function ExportXls() {
	JeecgExcelExport("selfOaServiceController.do?exportXls","selfOaServiceList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("selfOaServiceController.do?exportXlsByT","selfOaServiceList");
}

 </script>