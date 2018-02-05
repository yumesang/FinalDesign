<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="informList" checkbox="true" pagination="true" fitColumns="true" title="发布公告" actionUrl="baseNewsController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" align="center" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="baseNewsController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgFunOpt title="查看" funname="showDetail(id,introduction)" urlclass="ace_button"  urlfont="fa-trash-o" />
   <t:dgCol title="被阅读次数"  field="readCount" align="center" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="关键字"  field="keywords" align="center" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="内容简介"  field="introduction" align="center" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="文章内容"  field="contents" hidden="true" queryMode="group"  width="500"></t:dgCol> 
   <t:dgCol title="审核状态"  field="checkStatus" hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="是否启用"  field="enable" hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建时间"  field="createDate" hidden="true"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建用户主键"  field="createUserId" hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建用户名称"  field="createUserName" hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="修改时间"  field="modifyDate" hidden="true"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="修改用户主键"  field="modifyUserId" hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="修改用户名称"  field="modifyUserName" hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="公告类型"  field="newsType" hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建部门主键"  field="departId" hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建部门名称"  field="departName" hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgToolBar title="录入" icon="icon-add" url="baseNewsController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="baseNewsController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="baseNewsController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="baseNewsController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/finalDesign/basenews/baseNewsList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
function showDetail(id,introduction){
	var title = "查看公告";
	var url = "baseNewsController.do?previewList&id="+id+"&introduction="+introduction;
	openwindow(title,url,'dgList',1000,500);
	$.ajax({success:function(data){$("#informList").datagrid('reload');}})
}   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'baseNewsController.do?upload', "baseNewsList");
}

//导出
function ExportXls() {
	JeecgExcelExport("baseNewsController.do?exportXls","baseNewsList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("baseNewsController.do?exportXlsByT","baseNewsList");
}

 </script>