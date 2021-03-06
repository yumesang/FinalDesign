package com.finalDesign.notebook.controller;
import com.finalDesign.notebook.entity.NotebookEntity;
import com.finalDesign.notebook.service.NotebookServiceI;

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
import org.apache.tools.ant.taskdefs.Parallel.TaskList;
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
 * @Description: notebook
 * @author onlineGenerator
 * @date 2018-03-26 16:14:36
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/notebookController")
public class NotebookController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(NotebookController.class);

	@Autowired
	private NotebookServiceI notebookService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * notebook列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		request.setAttribute("userId", ResourceUtil.getSessionUser().getId());
		return new ModelAndView("com/finalDesign/notebook/notebookList");
	}
	
	/**
	 * notebook列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "finishList")
	public ModelAndView finishList(HttpServletRequest request) {
		return new ModelAndView("com/finalDesign/notebook/notebookList-finish");
	}
	
	/**
	 * notebook列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "isPassList")
	public ModelAndView isPassList(HttpServletRequest request) {
		return new ModelAndView("com/finalDesign/notebook/notebookList-isPass");
	}
	
	@RequestMapping(params = "previewList")
	public ModelAndView previewList(HttpServletRequest request,String id) {
		List<Object[]> taskList = systemService.findListbySql("select t.task_name, t.task_detail from notebook t where id = '"+ id +"'");
		request.setAttribute("taskName", taskList.get(0)[0].toString());
		request.setAttribute("taskDetail",taskList.get(0)[1].toString());
		return new ModelAndView("com/finalDesign/notebook/previewList");
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
	public void datagrid(NotebookEntity notebook,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(NotebookEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, notebook, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.notebookService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除notebook
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(NotebookEntity notebook, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		notebook = systemService.getEntity(NotebookEntity.class, notebook.getId());
		message = "notebook删除成功";
		try{
			notebookService.delete(notebook);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "notebook删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除notebook
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "notebook删除成功";
		try{
			for(String id:ids.split(",")){
				NotebookEntity notebook = systemService.getEntity(NotebookEntity.class, 
				id
				);
				notebookService.delete(notebook);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "notebook删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加notebook
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(NotebookEntity notebook, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "notebook添加成功";
		try{
			Date date = new Date();
			notebook.setCreateDate(date);
			notebook.setEnable(0.0);
			notebook.setCreateUserId(ResourceUtil.getSessionUser().getId());
			notebook.setCreateUserName(ResourceUtil.getSessionUser().getRealName());
			notebook.setIsPass(0.0);
			notebookService.save(notebook);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "notebook添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新notebook
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(NotebookEntity notebook, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "notebook更新成功";
		NotebookEntity t = notebookService.get(NotebookEntity.class, notebook.getId());
		try {
			//判断修改后的日期饰扣超过达成时间
			Date date  = new Date();
			notebook.setModifyDate(date);
			SimpleDateFormat format =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );  
			if(format.parse(notebook.getTargetDate().toString()).getTime() <= format.parse(date.toString()).getTime()){
				notebook.setIsPass(0.0);
			}else{
				notebook.setIsPass(1.0);
			}
			MyBeanUtils.copyBeanNotNull2Bean(notebook, t);
			notebookService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "notebook更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 更新notebook
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "docheck")
	@ResponseBody
	public AjaxJson docheck(NotebookEntity notebook, HttpServletRequest request,String id, String reduce) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "notebook更新成功";
		NotebookEntity t = notebookService.get(NotebookEntity.class, id);
		try {
			//判断修改后的日期饰扣超过达成时间
			if(reduce == null){
				notebook.setEnable(1.0);
			}else{
				notebook.setEnable(0.0);
			}
			
			MyBeanUtils.copyBeanNotNull2Bean(notebook, t);
			notebookService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "notebook更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
		
	
	/**
	 * notebook新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(NotebookEntity notebook, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(notebook.getId())) {
			notebook = notebookService.getEntity(NotebookEntity.class, notebook.getId());
			req.setAttribute("notebookPage", notebook);
		}
		return new ModelAndView("com/finalDesign/notebook/notebook-add");
	}
	/**
	 * notebook编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(NotebookEntity notebook, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(notebook.getId())) {
			notebook = notebookService.getEntity(NotebookEntity.class, notebook.getId());
			req.setAttribute("notebookPage", notebook);
		}
		return new ModelAndView("com/finalDesign/notebook/notebook-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","notebookController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(NotebookEntity notebook,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(NotebookEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, notebook, request.getParameterMap());
		List<NotebookEntity> notebooks = this.notebookService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"notebook");
		modelMap.put(NormalExcelConstants.CLASS,NotebookEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("notebook列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,notebooks);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(NotebookEntity notebook,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"notebook");
    	modelMap.put(NormalExcelConstants.CLASS,NotebookEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("notebook列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<NotebookEntity> listNotebookEntitys = ExcelImportUtil.importExcel(file.getInputStream(),NotebookEntity.class,params);
				for (NotebookEntity notebook : listNotebookEntitys) {
					notebookService.save(notebook);
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
	public List<NotebookEntity> list() {
		List<NotebookEntity> listNotebooks=notebookService.getList(NotebookEntity.class);
		return listNotebooks;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		NotebookEntity task = notebookService.get(NotebookEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody NotebookEntity notebook, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<NotebookEntity>> failures = validator.validate(notebook);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			notebookService.save(notebook);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = notebook.getId();
		URI uri = uriBuilder.path("/rest/notebookController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody NotebookEntity notebook) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<NotebookEntity>> failures = validator.validate(notebook);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			notebookService.saveOrUpdate(notebook);
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
		notebookService.deleteEntityById(NotebookEntity.class, id);
	}
}
