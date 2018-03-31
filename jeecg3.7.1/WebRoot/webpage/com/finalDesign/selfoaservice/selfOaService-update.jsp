<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>self_oa_service</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
  <style type="text/css">
  	.subBtn{
  	border:none;
	outline:none;
    -moz-border-radius: 5px;
    -webkit-border-radius: 5px;
    border-radius: 5px;
    color: #ffffff;
    display: block;
    cursor:pointer;
    margin: 10px 5px;
    float:center;
    padding: 7px 17px;
    text-shadow: 0 1px 1px #777;
    font-weight:bold;
    font-family:"Century Gothic", Helvetica, sans-serif;
    -moz-box-shadow:0px 0px 3px #aaa;
    -webkit-box-shadow:0px 0px 3px #aaa;
    box-shadow:0px 0px 3px #aaa;
    background:#18a689;
    width: 50px;
    height: 20px;
    text-align: center;
}
	.clickedSubBtn{
  	border:none;
	outline:none;
    -moz-border-radius: 5px;
    -webkit-border-radius: 5px;
    border-radius: 5px;
    color: #ffffff;
    display: block;
    cursor:pointer;
    margin: 10px 5px;
    float:center;
    padding: 7px 17px;
    text-shadow: 0 1px 1px #777;
    font-weight:bold;
    font-family:"Century Gothic", Helvetica, sans-serif;
    -moz-box-shadow:0px 0px 3px #aaa;
    -webkit-box-shadow:0px 0px 3px #aaa;
    box-shadow:0px 0px 3px #aaa;
    background:gray;
    width: 50px;
    height: 20px;
    text-align: center;
}
	
  </style>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="selfOaServiceController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${selfOaServicePage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							流程名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="oaName" name="oaName" type="text" style="width: 150px" class="inputxt" value="${selfOaServicePage.oaName }"  datatype="*" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">流程名称</label>
						</td>
						<td align="right">
						<label class="Validform_label">
							节点数量:
						</label>
					</td>
					<td class="value">
					     	 <input placeholder="请输入1-5之间的数字" id="nodeNum" name="nodeNum" type="text" style="width: 150px" class="inputxt" value="${selfOaServicePage.nodeNum }" datatype="n" onchange="setNode(value)" ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">节点数量</label>
						</td>					
					</tr>
				<tr hidden="hidden" style="height: 80px;" id="node1" align="center" >
					<td>
						<label class="Validform_label">
							第一节点:
						</label>
					</td>
					 <td colspan="3">
					 	<input id="roleid1" name="roleid1" type="hidden" value="${roleIdList[0] }" />
                		<input name="roleName1" id="roleName1" class="inputxt" value="${roleNameList[0] }" readonly="readonly" />
                		<t:choose hiddenName="roleid1" hiddenid="id" textname="roleName"  inputTextname="roleName1" url="userController.do?roles" name="roleList" icon="icon-search" title="common.role.list"  isInit="true"></t:choose>                		
					 </td>
				</tr>
				<tr hidden="hidden" style="height: 80px;" id="node2" align="center" >
					<td>
						<label class="Validform_label">
							第二节点:
						</label>
					</td>
					 <td colspan="3">
					 	<input id="roleid2" name="roleid2" type="hidden" value="${roleIdList[1] }"/>
                		<input name="roleName2" id="roleName2" class="inputxt" value="${roleNameList[1] }" readonly="readonly"  />
                		<t:choose hiddenName="roleid2" hiddenid="id" textname="roleName" inputTextname="roleName2" url="userController.do?roles" name="roleList" icon="icon-search" title="common.role.list"  isInit="true"></t:choose>
                	</td>
				</tr>
				<tr hidden="hidden" style="height: 80px;" id="node3" align="center" >
					<td>
						<label class="Validform_label">
							第三节点:
						</label>
					</td>
					 <td colspan="3">
					 	<input id="roleid3" name="roleid3" type="hidden" value="${roleIdList[2] }"/>
                		<input name="roleName3" id="roleName3" class="inputxt" value="${roleNameList[2] }" readonly="readonly"  />
                		<t:choose hiddenName="roleid3" hiddenid="id" textname="roleName" inputTextname="roleName3" url="userController.do?roles" name="roleList" icon="icon-search" title="common.role.list"  isInit="true"></t:choose>
                	</td>
				</tr>
				<tr hidden="hidden" style="height: 80px;" id="node4" align="center" >
					<td>
						<label class="Validform_label">
							第四节点:
						</label>
					</td>
					 <td colspan="3">
					 	<input id="roleid4" name="roleid4" type="hidden" value="${roleIdList[3] }"/>
                		<input name="roleName4" id="roleName4" class="inputxt" value="${roleNameList[3] }" readonly="readonly"  />
                		<t:choose hiddenName="roleid4" hiddenid="id" textname="roleName" inputTextname="roleName4" url="userController.do?roles" name="roleList" icon="icon-search" title="common.role.list"  isInit="true"></t:choose>
                	</td>
				</tr>
				<tr hidden="hidden" style="height: 80px;" id="node5" align="center" >
					<td>
						<label class="Validform_label">
							第五节点:
						</label>
					</td>
					 <td colspan="3">
					 	<input id="roleid5" name="roleid5" type="hidden" value="${roleIdList[4] }"/>
                		<input name="roleName5" id="roleName5" class="inputxt" value="${roleNameList[4] }" readonly="readonly"  />
                		<t:choose hiddenName="roleid5" hiddenid="id" textname="roleName" inputTextname="roleName5" url="userController.do?roles" name="roleList" icon="icon-search" title="common.role.list"  isInit="true"></t:choose>
                	</td>
				</tr>
				<tr id="lock" align="center" hidden="hidden" >
					<td colspan="4">
						<input id="lockBtn" class="subBtn"  onclick="addtext(id)" value="锁定" readonly="readonly" />
					</td>
				</tr>
				<input id="oaDateilId"  name="oaDetailId" type="text" style="width: 200px;display:none;" value="${selfOaServicePage.oaDetailId }" datatype="*" />
				<input id="oaDateilName"  name="oaDetailName" type="text" style="width: 200px;display:none;" value="${selfOaServicePage.oaDetailName }" datatype="*" />
				<!-- <tr>
					<td align="right">
						<label class="Validform_label">
							流程等级:
						</label>
					</td>
					<td class="value">
					     	 <input id="oaLevel" name="oaLevel" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">流程等级</label>
						</td>				
					</tr>	 -->					
			</table>
		</t:formvalid>
 </body>
 <script type="text/javascript">
 $(document).ready(function(){
 	if("${selfOaServicePage.nodeNum }" != null){
 		var num = ${selfOaServicePage.nodeNum };
 		setNode(num);
 	}
 });
 	function setNode(value){
 		$("tr[align=center]").attr("hidden","hidden");
 		$(".easyui-combotree").removeAttr("datatype");
 		for(var i=1;i<=value;i++){
 			var str = "#node"+i;
 			var roleid = "#roleid"+i;
 			var roleName = "#roleName"+i;
 			$(str).removeAttr("hidden");
 			$(roleid).attr("datatype","*");
 			$(roleName).attr("datatype","*");
 		}
 		$("#lock").removeAttr("hidden");
 	}
 	
 	function addtext(id){
 		var str = "#"+id;
 		$("span[class='l-btn-left']").prop("style","display:none;");
 		$("input[class='inputxt']").prop({"style":"background-color:#EDEDED","readonly":"readonly"});
 		addOADetail($("#nodeNum").val());
 		$(str).prop("class","clickedSubBtn");
 		$(str).prop("value","已锁定");
 	}
 	
 	function addOADetail(nodeNum){
 		for(var i=1;i<=nodeNum;i++){
 			var roleid = "#roleid"+i;
 			var roleName = "#roleName"+i;
 			if(i == 1){
 				$("#oaDateilId").val($(roleid).val());
 				$("#oaDateilName").val($(roleName).val());
 			}else{
 				$("#oaDateilId").val($("#oaDateilId").val() +"-"+ $(roleid).val());
 				$("#oaDateilName").val($("#oaDateilName").val() +"-"+ $(roleName).val());	
 			}	
 		}
 	}
 </script>
  <script src = "webpage/com/finalDesign/selfoaservice/selfOaService.js"></script>		
