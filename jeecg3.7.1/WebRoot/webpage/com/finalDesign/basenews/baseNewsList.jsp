<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="baseNewsList" checkbox="true" pagination="true" fitColumns="true" title="base_news" actionUrl="baseNewsController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="内容简介"  field="introduction"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="文章内容"  field="contents"  queryMode="group"  width="500"></t:dgCol>
   <t:dgCol title="关键字"  field="keywords"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="审核状态"  field="checkStatus"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="被阅读次数"  field="readCount"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="是否启用"  field="enable"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="排序码"  field="sortcode"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="删除标记"  field="deleteMark"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建时间"  field="createDate"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建用户主键"  field="createUserId"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建用户名称"  field="createUserName"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="修改时间"  field="modifyDate"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="修改用户主键"  field="modifyUserId"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="修改用户名称"  field="modifyUserName"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="公告类型"  field="newsType"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建部门主键"  field="departId"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建部门名称"  field="departName"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="baseNewsController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
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