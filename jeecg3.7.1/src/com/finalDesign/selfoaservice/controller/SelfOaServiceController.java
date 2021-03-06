package com.finalDesign.selfoaservice.controller;
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
 * @Description: self_oa_service
 * @author onlineGenerator
 * @date 2018-03-29 09:36:44
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/selfOaServiceController")
public class SelfOaServiceController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(SelfOaServiceController.class);

	@Autowired
	private SelfOaServiceServiceI selfOaServiceService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * self_oa_service列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/finalDesign/selfoaservice/selfOaServiceList");
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
	public void datagrid(SelfOaServiceEntity selfOaService,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(SelfOaServiceEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, selfOaService, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.selfOaServiceService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除self_oa_service
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(SelfOaServiceEntity selfOaService, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		selfOaService = systemService.getEntity(SelfOaServiceEntity.class, selfOaService.getId());
		message = "self_oa_service删除成功";
		try{
			selfOaServiceService.delete(selfOaService);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "self_oa_service删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除self_oa_service
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "self_oa_service删除成功";
		try{
			for(String id:ids.split(",")){
				SelfOaServiceEntity selfOaService = systemService.getEntity(SelfOaServiceEntity.class, 
				id
				);
				selfOaServiceService.delete(selfOaService);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "self_oa_service删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加self_oa_service
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(SelfOaServiceEntity selfOaService, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "self_oa_service添加成功";
		try{
			Date date = new Date();
			selfOaService.setCreateDate(date);
			selfOaService.setCreateUserId(ResourceUtil.getSessionUser().getId());
			selfOaService.setCreateUserName(ResourceUtil.getSessionUser().getRealName());
			selfOaService.setEnable(1.0);
			selfOaServiceService.save(selfOaService);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "self_oa_service添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新self_oa_service
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(SelfOaServiceEntity selfOaService, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "self_oa_service更新成功";
		SelfOaServiceEntity t = selfOaServiceService.get(SelfOaServiceEntity.class, selfOaService.getId());
		try {
			Date date = new Date();
			selfOaService.setModifyDate(date);
			selfOaService.setModifyUserId(ResourceUtil.getSessionUser().getId());
			selfOaService.setModifyUserName(ResourceUtil.getSessionUser().getRealName());
			MyBeanUtils.copyBeanNotNull2Bean(selfOaService, t);
			selfOaServiceService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "self_oa_service更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * self_oa_service新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(SelfOaServiceEntity selfOaService, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(selfOaService.getId())) {
			selfOaService = selfOaServiceService.getEntity(SelfOaServiceEntity.class, selfOaService.getId());
			req.setAttribute("selfOaServicePage", selfOaService);
		}
		return new ModelAndView("com/finalDesign/selfoaservice/selfOaService-add");
	}
	/**
	 * self_oa_service编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(SelfOaServiceEntity selfOaService, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(selfOaService.getId())) {
			selfOaService = selfOaServiceService.getEntity(SelfOaServiceEntity.class, selfOaService.getId());
			String roleId = selfOaService.getOaDetailId().toString();
			String roleName = selfOaService.getOaDetailName().toString();
			for(int i=0;i<(5-selfOaService.getNodeNum());i++){
				roleId += "-";
				roleName += "-";
			}
			req.setAttribute("roleIdList", roleId.split("-"));
			req.setAttribute("roleNameList", roleName.split("-"));
			req.setAttribute("selfOaServicePage", selfOaService);
		}
		return new ModelAndView("com/finalDesign/selfoaservice/selfOaService-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","selfOaServiceController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(SelfOaServiceEntity selfOaService,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(SelfOaServiceEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, selfOaService, request.getParameterMap());
		List<SelfOaServiceEntity> selfOaServices = this.selfOaServiceService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"self_oa_service");
		modelMap.put(NormalExcelConstants.CLASS,SelfOaServiceEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("self_oa_service列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,selfOaServices);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(SelfOaServiceEntity selfOaService,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"self_oa_service");
    	modelMap.put(NormalExcelConstants.CLASS,SelfOaServiceEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("self_oa_service列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<SelfOaServiceEntity> listSelfOaServiceEntitys = ExcelImportUtil.importExcel(file.getInputStream(),SelfOaServiceEntity.class,params);
				for (SelfOaServiceEntity selfOaService : listSelfOaServiceEntitys) {
					selfOaServiceService.save(selfOaService);
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
	public List<SelfOaServiceEntity> list() {
		List<SelfOaServiceEntity> listSelfOaServices=selfOaServiceService.getList(SelfOaServiceEntity.class);
		return listSelfOaServices;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		SelfOaServiceEntity task = selfOaServiceService.get(SelfOaServiceEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody SelfOaServiceEntity selfOaService, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<SelfOaServiceEntity>> failures = validator.validate(selfOaService);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			selfOaServiceService.save(selfOaService);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = selfOaService.getId();
		URI uri = uriBuilder.path("/rest/selfOaServiceController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody SelfOaServiceEntity selfOaService) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<SelfOaServiceEntity>> failures = validator.validate(selfOaService);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			selfOaServiceService.saveOrUpdate(selfOaService);
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
		selfOaServiceService.deleteEntityById(SelfOaServiceEntity.class, id);
	}
}
