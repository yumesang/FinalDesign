<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="detailTableList" checkbox="true" pagination="true" fitColumns="true" title="detail_table" actionUrl="detailTableController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" align="center" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="detailTableController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgFunOpt title="查看" funname="showDetail(id)" urlclass="ace_button"  urlfont="fa-search" />
   <t:dgCol title="表格名称"  field="listName" dictionary="base_table,id,list_name" align="center" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="表格类型"  field="listType"  queryMode="group" align="center" width="120"></t:dgCol>
   <t:dgCol title="OAID"  field="oaId" hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="姓名"  field="name" hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="年龄"  field="age" hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="性别"  field="sex" hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="职称"  field="profession" hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="系别主键"  field="departId" hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="系别名称"  field="departName" hidden="true" queryMode="group" width="120"></t:dgCol>
   <t:dgCol title="备注"  field="memo" hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="自定义字段名"  field="selfStringName" hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="自定义字段"  field="selfString" hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="审核状态"  field="checkStatus" align="center" replace="未审核_0,一级过审_1,二级过审_2,三级过审_3,四级过审_4,审核通过_5"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate" align="center" formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人员主键"  field="createUserId" hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人员名称"  field="createUserName" align="center" hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="OA名称"  field="oaName" hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgToolBar title="录入" icon="icon-add" url="#" funname="goAdd"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="detailTableController.do?goUpdate" funname="update"></t:dgToolBar>
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
 
function showDetail(id){
	var title = "查看内容";
	var url = "detailTableController.do?goUpdate&id="+id;
	openwindow(title,url,'dgList',1000,500);
	$.ajax({success:function(data){$("#detailTableList").datagrid('reload');}})
}  

function goAdd(){
	var title = "添加申请";
	var url = "detailTableController.do?goAdd";
	openwindow(title,url,'dgList',1000,500);
}
 
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