<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<t:datagrid name="departList" title="common.department.list" actionUrl="departController.do?departgrid" treegrid="true" fit="true" queryMode="group"
            pagination="false" idField="id">
    <t:dgCol title="common.id" field="id" treefield="id" hidden="true"></t:dgCol>
    <t:dgCol title="common.department.name" width="120"  field="departname" treefield="text"></t:dgCol>
    <t:dgCol title="common.org.code" field="orgCode" width="81"  treefield="fieldMap.orgCode"></t:dgCol>
</t:datagrid>

