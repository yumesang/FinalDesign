package com.finalDesign.detailtable.controller;
import com.alibaba.druid.util.DaemonThreadFactory;
import com.finalDesign.detailtable.entity.DetailTableEntity;
import com.finalDesign.detailtable.service.DetailTableServiceI;
import com.finalDesign.flowtaskinfo.entity.FlowTaskInfoEntity;
import com.finalDesign.flowtaskinfo.service.FlowTaskInfoServiceI;
import com.finalDesign.selfoaservice.controller.SelfOaServiceController;
import com.finalDesign.selfoaservice.entity.SelfOaServiceEntity;
import com.finalDesign.selfoaservice.service.SelfOaServiceServiceI;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.common.TreeChildCount;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import java.io.OutputStream;

import org.jeecgframework.core.util.BrowserUtils;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.vo.TemplateExcelConstants;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jeecgframework.core.util.ResourceUtil;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Map;
import java.util.HashMap;

import org.jeecgframework.core.util.ExceptionUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.jeecgframework.core.beanvalidator.BeanValidators;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import java.net.URI;

import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;

/**   
 * @Title: Controller  
 * @Description: detail_table
 * @author onlineGenerator
 * @date 2018-03-31 17:17:21
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/detailTableController")
public class DetailTableController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DetailTableController.class);

	@Autowired
	private DetailTableServiceI detailTableService;
	@Autowired
	private SelfOaServiceServiceI selfOaServiceService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private FlowTaskInfoServiceI flowTaskInfoService;
	@Autowired
	private Validator validator;
	


	/**
	 * detail_table列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/finalDesign/detailtable/detailTableList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(DetailTableEntity detailTable,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DetailTableEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, detailTable, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.detailTableService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除detail_table
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DetailTableEntity detailTable, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		detailTable = systemService.getEntity(DetailTableEntity.class, detailTable.getId());
		message = "detail_table删除成功";
		try{
			systemService.executeSql("delete from flow_task_info where code='"+ detailTable.getId() +"'");
			detailTableService.delete(detailTable);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "detail_table删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除detail_table
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "detail_table删除成功";
		try{
			for(String id:ids.split(",")){
				DetailTableEntity detailTable = systemService.getEntity(DetailTableEntity.class, 
				id
				);
				detailTableService.delete(detailTable);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "detail_table删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加detail_table
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DetailTableEntity detailTable, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "detail_table添加成功";
		try{
			List<Object[]> baseList = systemService.findListbySql("select t.oa_id,t.list_type from base_table t where t.id = '"+ detailTable.getListName() +"'");
			detailTable.setOaId(baseList.get(0)[0].toString());
			detailTable.setCheckStatus("0");
			detailTable.setCreateUserId(ResourceUtil.getSessionUser().getId());
			detailTable.setCreateDate(new Date());
			detailTable.setListType(baseList.get(0)[1].toString());
			detailTable.setCreateUserName(ResourceUtil.getSessionUser().getRealName());
			detailTableService.save(detailTable);
			FlowTaskInfoEntity flowTaskInfo = new FlowTaskInfoEntity();
			flowTaskInfo.setCode(detailTable.getId());
			flowTaskInfo.setCeateUserId(detailTable.getCreateUserId());
			flowTaskInfo.setCheckStatus(0);//改变状态为未审核
			flowTaskInfo.setCreateDate(detailTable.getCreateDate());
			List<Object[]> list = systemService.findListbySql("select t.node_num ,t.oa_detail_id from self_oa_service t where t.id = '"+ detailTable.getOaId() +"'");
			flowTaskInfo.setNodeNum(Integer.parseInt(list.get(0)[0].toString()));
			flowTaskInfo.setCheckUserId(list.get(0)[1].toString().split("-")[flowTaskInfo.getCheckStatus()]);
			String listName = systemService.findListbySql("select t.list_name from base_table t where id = '"+detailTable.getListName()+"'").get(0).toString();
			flowTaskInfo.setTaskName("请您审核来自"+ detailTable.getCreateUserName() +"的《"+ listName +"》");
			flowTaskInfo.setUrl("baseTableController.do?printCheck&id="+detailTable.getListName()+"&detailId="+detailTable.getId()+"&check=check");
			systemService.saveOrUpdate(flowTaskInfo);
			
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "detail_table添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新detail_table
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DetailTableEntity detailTable, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "detail_table更新成功";
		DetailTableEntity t = detailTableService.get(DetailTableEntity.class, detailTable.getId());
		try {	
			MyBeanUtils.copyBeanNotNull2Bean(detailTable, t);
			detailTableService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "detail_table更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	
	/**
	 * 审核detail_table
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doCheck")
	@ResponseBody
	public AjaxJson doCheck(HttpServletRequest request, String id) {
		String message = null;
		AjaxJson j = new AjaxJson();
		String detailId = systemService.findListbySql("select t.id from detail_table t where t.list_name ='"+ id +"'").get(0).toString();
		DetailTableEntity t = detailTableService.get(DetailTableEntity.class, detailId);
		SelfOaServiceEntity selfOaService = selfOaServiceService.get(SelfOaServiceEntity.class, t.getOaId());
		String listName = systemService.findListbySql("select t.list_name from base_table t where id = '"+t.getListName()+"'").get(0).toString();
		if(Integer.parseInt(t.getCheckStatus()) < selfOaService.getNodeNum()-1){
			message = "审核通过，提交下一节点人员处理";
			t.setCheckStatus(String.valueOf((Integer.parseInt(t.getCheckStatus()) + 1)));
			String nodeId = selfOaService.getOaDetailId().split("-")[Integer.parseInt(t.getCheckStatus())].replace("-", ","); 
			systemService.executeSql("update flow_task_info set task_name='请您审核来自"+ t.getCreateUserName() +"的《"+ listName +"》',check_status = '"+ t.getCheckStatus() +"',check_user_id='"+ nodeId +"' where code = '"+ t.getId() +"'");			
		}else{
			message = "审核通过，当前申请已过审";
			t.setCheckStatus("5");
			t.setCreateDate(new Date());
			FlowTaskInfoEntity flowTaskInfo = systemService.findUniqueByProperty(FlowTaskInfoEntity.class, "code", t.getId());
			flowTaskInfo.setTaskName("您申请的《"+ listName +"》已通过审核!");
			flowTaskInfo.setCheckStatus(Integer.parseInt(t.getCheckStatus()));
			flowTaskInfo.setCeateUserId(t.getCreateUserId());
			flowTaskInfo.setUrl(flowTaskInfo.getUrl().substring(0,flowTaskInfo.getUrl().length()-12));
		}
		try {	
			detailTableService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "审核操作失败，请联系管理员处理";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 审核detail_table
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doNotCheck")
	@ResponseBody
	public AjaxJson doNotCheck(String id, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "驳回审核内容，将结果返回给用户";
		String detailId = systemService.findListbySql("select t.id from detail_table t where t.list_name ='"+ id +"'").get(0).toString();
		DetailTableEntity t = detailTableService.get(DetailTableEntity.class, detailId);
		t.setCheckStatus("6");
		t.setCreateDate(new Date());
		String listName = systemService.findListbySql("select t.list_name from base_table t where id = '"+t.getListName()+"'").get(0).toString();
		systemService.executeSql("update flow_task_info set task_name='您申请的《"+ listName +"》被驳回，请修改后重试!', check_status = '"+ t.getCheckStatus() +"',check_user_id='"+ t.getCreateUserId() +"' where code = '"+ t.getId() +"'");				
		try {	
			detailTableService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "审核操作失败，请联系管理员处理";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * detail_table新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DetailTableEntity detailTable, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(detailTable.getId())) {
			detailTable = detailTableService.getEntity(DetailTableEntity.class, detailTable.getId());
		}
		String listNameSql = "select t.id, t.list_name from base_table t where 1=1";
		String listName = "";
		List<Object[]> listNameList = systemService.findListbySql(listNameSql);
		for(Object[] obj:listNameList){
			listName += "<option value="+ obj[0] +">"+ obj[1] +"</option>";
		}		
		req.setAttribute("listName", listName);
		req.setAttribute("detailTablePage", detailTable);
		return new ModelAndView("com/finalDesign/detailtable/detailTable-add");
	}
	/**
	 * detail_table编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DetailTableEntity detailTable, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(detailTable.getId())) {
			detailTable = detailTableService.getEntity(DetailTableEntity.class, detailTable.getId());
			req.setAttribute("detailTablePage", detailTable);
		}
		return new ModelAndView("com/finalDesign/detailtable/detailTable-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","detailTableController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DetailTableEntity detailTable,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DetailTableEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, detailTable, request.getParameterMap());
		List<DetailTableEntity> detailTables = this.detailTableService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"detail_table");
		modelMap.put(NormalExcelConstants.CLASS,DetailTableEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("detail_table列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,detailTables);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DetailTableEntity detailTable,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"detail_table");
    	modelMap.put(NormalExcelConstants.CLASS,DetailTableEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("detail_table列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
    	"导出信息"));
    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<DetailTableEntity> listDetailTableEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DetailTableEntity.class,params);
				for (DetailTableEntity detailTable : listDetailTableEntitys) {
					detailTableService.save(detailTable);
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return j;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<DetailTableEntity> list() {
		List<DetailTableEntity> listDetailTables=detailTableService.getList(DetailTableEntity.class);
		return listDetailTables;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		DetailTableEntity task = detailTableService.get(DetailTableEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody DetailTableEntity detailTable, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DetailTableEntity>> failures = validator.validate(detailTable);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			detailTableService.save(detailTable);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = detailTable.getId();
		URI uri = uriBuilder.path("/rest/detailTableController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody DetailTableEntity detailTable) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DetailTableEntity>> failures = validator.validate(detailTable);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			detailTableService.saveOrUpdate(detailTable);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		detailTableService.deleteEntityById(DetailTableEntity.class, id);
	}
}
