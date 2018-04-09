package com.finalDesign.basetable.controller;
import com.finalDesign.basetable.entity.BaseTableEntity;
import com.finalDesign.basetable.service.BaseTableServiceI;
import com.finalDesign.detailtable.entity.DetailTableEntity;
import com.sun.corba.se.spi.oa.OADefault;

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
 * @Description: base_table
 * @author onlineGenerator
 * @date 2018-02-26 11:11:45
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/baseTableController")
public class BaseTableController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(BaseTableController.class);

	@Autowired
	private BaseTableServiceI baseTableService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * base_table列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/finalDesign/basetable/baseTableList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	/**
	 * 充值卡消耗明细  打印 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "jump")
	public Object jump(HttpServletRequest req, String id ) {//keyWords 包含字段名与值	
			req.setAttribute("url", "baseTableController.do?printView&id="+id);		
		return "forward:/context/qtPrintSheetFrm.jsp";
	}
	
	/**
	 *   打印 页面
	 * 
	 * @return
	 */
	@RequestMapping(params = "printView")
	public ModelAndView printData(HttpServletRequest request ,String id ,String useToken) {
		String sql="select list_name,list_type,name,age,sex,profession,depart_name,memo,self_string_name,self_string from base_table t where t.id = '"+ id +"'";
		String stringId = "";
		List<Map<String, Object>> resultList=systemService.findForJdbc(sql);
		List<Map<String, Object>> smallList = new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> normalList = new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> bigList = new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> biggestList = new ArrayList<Map<String,Object>>();
		//表单生成逻辑
		for(Map<String,Object> map:resultList){
			Map<String,Object> smallMap = new HashMap<String,Object>();		
			Map<String,Object> normalMap = new HashMap<String,Object>();	
			Map<String,Object> bigMap = new HashMap<String,Object>();	
			Map<String,Object> biggestMap = new HashMap<String,Object>();	
			//基础按键判断
			int smallNum = 0,normalNum = 0,bigNum = 0,biggestNum = 0;
			if(!map.get("name").equals("")){smallMap.put(String.valueOf(smallNum), "姓名");smallNum++;}
			if(!map.get("age").equals("")){smallMap.put(String.valueOf(smallNum), "年龄");smallNum++;}
			if(!map.get("sex").equals("")){smallMap.put(String.valueOf(smallNum), "性别");smallNum++;}
			if(!map.get("profession").equals("")){smallMap.put(String.valueOf(smallNum), "职称");smallNum++;}
			if(!map.get("depart_name").equals("")){smallMap.put(String.valueOf(smallNum), "系别");smallNum++;}
			if(!map.get("memo").equals("")){normalMap.put(String.valueOf(normalNum), "备注");normalNum++;}
			//自定义字段判断
			String[] selfStrName = String.valueOf(map.get("self_string_name")).split(",");
			String[] selfStr = String.valueOf(map.get("self_string")).split(",");
			for(int i=0;i<selfStr.length;i++){
				if(selfStr[i].split(":")[0].equals("input") && !selfStr.equals(":")){
					if(selfStr[i].split(":")[1].equals("small")){smallMap.put(String.valueOf(smallNum), selfStrName[i]);smallNum++;}
					if(selfStr[i].split(":")[1].equals("normal")){normalMap.put(String.valueOf(normalNum), selfStrName[i]);normalNum++;}
					if(selfStr[i].split(":")[1].equals("big")){bigMap.put(String.valueOf(bigNum), selfStrName[i]);bigNum++;}
					if(selfStr[i].split(":")[1].equals("biggest")){biggestMap.put(String.valueOf(biggestNum), selfStrName[i]);biggestNum++;}
				}else{
					smallMap.put(String.valueOf(smallNum), selfStrName[i]+":"+selfStr[i]);
					smallNum++;
				}
			}
			smallList.add(smallMap);
			normalList.add(normalMap);
			bigList.add(bigMap);
			biggestList.add(biggestMap);
		}
		String smallStr="",normalStr="",bigStr="",biggestStr="";int trNum=0;	
		//基础20px方格搭建
		if(smallList.get(0).size() < 0){
			smallStr = "<tr>";
		}
		for(int i=0;i<smallList.get(0).size();i++){	
			String[] str = smallList.get(0).get(String.valueOf(i)).toString().split(":");	
			if(str[0].equals("姓名")){stringId = "name";}
			else if(str[0].equals("年龄")){stringId = "age";}
			else if(str[0].equals("性别")){stringId = "sex";}
			else if(str[0].equals("职称")){stringId = "profession";}
			else if(str[0].equals("系别")){stringId = "departName";}
			else if(str[0].equals("备注")){stringId = "memo";}
			else if(!str[0].equals("")){stringId = "selfString";}
			if(str==null || (str != null && str.length == 0)){
				smallStr += "<td class='pcd_left_td_normal' style='width:50px;heigth:20px'></td><td class='pcd_left_td_normal' style='heigth:20px'>";												
			}else{
			if(str.length < 2 && str.length!=0){					
				smallStr += "<td class='pcd_left_td_normal' style='width:50px;heigth:20px'><strong name='"+ stringId +"Name'>"+ str[0] +"</strong></td><td class='pcd_left_td_normal' style='heigth:60px;'><input class='inputxt' name="+ stringId +" value='' />";								
			}else if(str[0].equals("") && trNum != 0 && str.length!=0 || str[0].equals("null")){
				smallStr += "<td class='pcd_left_td_normal' style='width:50px;heigth:20px'></td><td>";
			}else{
				if(str[2].split("-").length >= 5){
					for(int colNum=0;colNum<3-trNum;colNum++){
						if(trNum != 0)
						smallStr+= "<td class='pcd_left_td_normal' style='width:50px;heigth:20px'></td><td class='pcd_left_td_normal' style='heigth:20px'>";
					}
					if(str[1].equals("checkBox")){
						smallStr += "</tr><tr><td class='pcd_left_td_normal' style='heigth:20px'><strong name='checkBoxName'>"+ str[0] +"</strong></td><td class='pcd_left_td_normal' colspan='5' style='heigth:20px'>";								
					}else{
						smallStr += "</tr><tr><td class='pcd_left_td_normal' style='heigth:20px'><strong name='radioName'>"+ str[0] +"</strong></td><td class='pcd_left_td_normal' colspan='5' style='heigth:20px'>";								
					}
					trNum = 3;
					for(int selectNum=0;selectNum<str[2].split("-").length;selectNum++){
						smallStr += "<div style='float:left;margin-left:20px;'><input name='"+ str[1]+i +"' type='"+ str[1] +"' value='"+ str[2].split("-")[selectNum] +"'/>"+ str[2].split("-")[selectNum] +"</div>";
					}
				}else{
					smallStr += "<td class='pcd_left_td_normal' style='heigth:20px'><strong name='radioName'>"+ str[0] +"</strong></td><td class='pcd_left_td_normal' style='heigth:20px'>";			
					for(int selectNum=0;selectNum<str[2].split("-").length;selectNum++){
						smallStr += "<div style='float:left;margin-left:3px;'><input name='"+ str[1]+i +"' type='"+ str[1] +"' value='"+ str[2].split("-")[selectNum] +"'/>"+ str[2].split("-")[selectNum] +"</div>";
					}
				}	
			}
			}
			smallStr += "</td>";
			trNum++;
			if(trNum >=3){
				smallStr += "</tr><tr>";
				trNum = 0;
			}
		}
		if(trNum<3 && trNum > 0){
			for(int colNum=0;colNum<3-trNum;colNum++){
				smallStr += "<td class='pcd_left_td_normal' style='width:50px;heigth:20px'></td><td class='pcd_left_td_normal' style='heigth:20px'></td>";
			}		
		}	
		smallStr += "</tr>";
		//基础50px方格搭建
		for(int i=0;i<normalList.get(0).size();i++){
			String[] str = normalList.get(0).get(String.valueOf(i)).toString().split(":");
			if(str.length <= 1){
				if(str[0].equals("备注")){
					stringId = "memo";
				}else{
					stringId = "selfString";
				}
				normalStr += "<tr><td class='pcd_left_td_normal' style='width:50px;height:50px;'><strong name='"+ stringId +"Name'>"+ str[0] +"</strong></td><td class='pcd_left_td_normal' colspan='5' style='height:50px'><textarea name='"+ stringId +"' rows='1' cols='10' style='font-size:15px;margin: 0px; width: 840px; height: 90px;'></textarea></td></tr>";
			}
		}
		//基础200px方格搭建
		for(int i=0;i<bigList.get(0).size();i++){
			stringId = "selfString";
			String[] str = bigList.get(0).get(String.valueOf(i)).toString().split(":");
			if(str.length <= 1){
				bigStr += "<tr><td class='pcd_left_td_normal' style='width:50px;height:200px;'><strong name='"+ stringId +"Name'>"+ str[0] +"</strong></td><td class='pcd_left_td_normal' colspan='5' style='height:200px'><textarea name='"+ stringId +"' rows='1' cols='10' style='font-size:15px;margin: 0px; width: 840px; height: 200px;'></textarea></td></tr>";
			}
		}
		//基础500px方格搭建
		for(int i=0;i<biggestList.get(0).size();i++){
			stringId = "selfString";
			String[] str = biggestList.get(0).get(String.valueOf(i)).toString().split(":");
			if(str.length <= 1){
				biggestStr += "<tr><td class='pcd_left_td_normal' style='width:50px;height:500px;'><strong name='"+ stringId +"Name'>"+ str[0] +"</strong></td><td class='pcd_left_td_normal' colspan='5' style='height:500px'><textarea name='"+ stringId +"' rows='1' cols='10' style='font-size:15px;margin: 0px; width: 840px; height: 500px;'></textarea></td></tr>";
			}
		}
		//传回jsp
		request.setAttribute("title", resultList.get(0).get("list_name"));
		request.setAttribute("smallStr", smallStr);
		request.setAttribute("normalStr", normalStr);
		request.setAttribute("bigStr", bigStr);
		request.setAttribute("biggestStr", biggestStr);
		request.setAttribute("listType", resultList.get(0).get("list_type"));
		request.setAttribute("createPerson", ResourceUtil.getSessionUser().getRealName());
		request.setAttribute("createDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		return new ModelAndView("com/finalDesign/basetable/printSelfTablePreview");		
	}
	
	@RequestMapping(params = "datagrid")
	public void datagrid(BaseTableEntity baseTable,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(BaseTableEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, baseTable, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.baseTableService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	
	/**
	 * 充值卡消耗明细  打印 页面
	 * 
	 * @return
	 */
	@RequestMapping(params = "printCheck")
	public ModelAndView printCheck(HttpServletRequest request ,String id ,String detailId, String useToken, String check) {
		DetailTableEntity detailTableEntity = systemService.getEntity(DetailTableEntity.class, detailId);
		if(StringUtil.isNotEmpty(detailTableEntity.getId())){
		//将自定义变量分类并且存放于不同的列表中以便显示
		String sql="select list_name,list_type,name,age,sex,profession,depart_name,memo,self_string_name,self_string from base_table t where t.id = '"+ id +"'";
		String stringId = "";
		String stringName = "";
		String[] selfStrList = detailTableEntity.getSelfString().split(",");
		//input类型自定义变量
		List<String> stringNameList = new ArrayList<>();
		Integer stringNameNum = 0;
		Integer mostStringNameNum = 0;
		for(String selfStr:selfStrList){
			if(selfStr.split(":")[0].equals("textarea"))
				stringNameList.add(selfStr.split(":")[1]);
		}
		mostStringNameNum = stringNameList.size();
		
		//radio类型自定义变量
		List<List<String>> radioNameList = new ArrayList<List<String>>();
		Integer radioNameNum = 0;
		Integer mostRadioNameNum = 0;
		for(String radioStr:selfStrList){
			List<String> list = new ArrayList<String>(); 
			if(radioStr.split(":")[0].equals("radio")){
				String[] str = radioStr.split(":")[1].split("-");
				for(int i=0;i<str.length;i++){
					list.add(str[i]);
				}
				mostRadioNameNum++;
				radioNameList.add(list);
			}
		}
		
		//checkBox类型自定义变量
		List<List<String>> checkBoxNameList = new ArrayList<List<String>>();
		Integer checkBoxNameNum = 0;
		Integer mostCheckBoxNameNum = 0;
		for(String checkBoxStr:selfStrList){
			List<String> list = new ArrayList<String>(); 
			if(checkBoxStr.split(":")[0].equals("checkBox")){
				String[] str = checkBoxStr.split(":")[1].split("-");
				for(int i=0;i<str.length;i++){
					list.add(str[i]);
				}
				mostCheckBoxNameNum++;
				checkBoxNameList.add(list);
			}
			
		}
		
		List<Map<String, Object>> resultList=systemService.findForJdbc(sql);
		List<Map<String, Object>> smallList = new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> normalList = new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> bigList = new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> biggestList = new ArrayList<Map<String,Object>>();
		//表单生成逻辑
		for(Map<String,Object> map:resultList){
			Map<String,Object> smallMap = new HashMap<String,Object>();		
			Map<String,Object> normalMap = new HashMap<String,Object>();	
			Map<String,Object> bigMap = new HashMap<String,Object>();	
			Map<String,Object> biggestMap = new HashMap<String,Object>();	
			//基础按键判断
			int smallNum = 0,normalNum = 0,bigNum = 0,biggestNum = 0;
			if(!map.get("name").equals("")){smallMap.put(String.valueOf(smallNum), "姓名");smallNum++;}
			if(!map.get("age").equals("")){smallMap.put(String.valueOf(smallNum), "年龄");smallNum++;}
			if(!map.get("sex").equals("")){smallMap.put(String.valueOf(smallNum), "性别");smallNum++;}
			if(!map.get("profession").equals("")){smallMap.put(String.valueOf(smallNum), "职称");smallNum++;}
			if(!map.get("depart_name").equals("")){smallMap.put(String.valueOf(smallNum), "系别");smallNum++;}
			if(!map.get("memo").equals("")){normalMap.put(String.valueOf(normalNum), "备注");normalNum++;}
			//自定义字段判断
			String[] selfStrName = String.valueOf(map.get("self_string_name")).split(",");
			String[] selfStr = String.valueOf(map.get("self_string")).split(",");
			for(int i=0;i<selfStr.length;i++){
				if(selfStr[i].split(":")[0].equals("input") && !selfStr.equals(":")){
					if(selfStr[i].split(":")[1].equals("small")){smallMap.put(String.valueOf(smallNum), selfStrName[i]);smallNum++;}
					if(selfStr[i].split(":")[1].equals("normal")){normalMap.put(String.valueOf(normalNum), selfStrName[i]);normalNum++;}
					if(selfStr[i].split(":")[1].equals("big")){bigMap.put(String.valueOf(bigNum), selfStrName[i]);bigNum++;}
					if(selfStr[i].split(":")[1].equals("biggest")){biggestMap.put(String.valueOf(biggestNum), selfStrName[i]);biggestNum++;}
				}else{
					smallMap.put(String.valueOf(smallNum), selfStrName[i]+":"+selfStr[i]);
					smallNum++;
				}
			}
			smallList.add(smallMap);
			normalList.add(normalMap);
			bigList.add(bigMap);
			biggestList.add(biggestMap);
		}
		String smallStr="",normalStr="",bigStr="",biggestStr="";int trNum=0;	
		//基础20px方格搭建
		if(smallList.get(0).size() < 0){
			smallStr = "<tr>";
		}
		for(int i=0;i<smallList.get(0).size();i++){	
			String[] str = smallList.get(0).get(String.valueOf(i)).toString().split(":");	
			if(str[0].equals("姓名")){stringId = "name";stringName = detailTableEntity.getName();}
			else if(str[0].equals("年龄")){stringId = "age";stringName = detailTableEntity.getAge();}
			else if(str[0].equals("性别")){stringId = "sex";stringName = detailTableEntity.getSex();}
			else if(str[0].equals("职称")){stringId = "profession";stringName = detailTableEntity.getProfession();}
			else if(str[0].equals("系别")){stringId = "departName";stringName = detailTableEntity.getDepartName();}
			else if(str[1].equals("textarea")){
				stringId = "selfString";
				if(stringNameNum < mostStringNameNum){
					stringName = stringNameList.get(stringNameNum);
					stringNameNum++;
				}				
			}
			if(str==null || (str != null && str.length == 0)){
				smallStr += "<td class='pcd_left_td_normal' style='width:50px;heigth:20px'></td><td class='pcd_left_td_normal' style='heigth:20px'>";												
			}else{
			if(str.length < 2 && str.length!=0){					
				smallStr += "<td class='pcd_left_td_normal' style='width:50px;heigth:20px'><strong name='"+ stringId +"Name'>"+ str[0] +"</strong></td><td class='pcd_left_td_normal' style='heigth:60px;'><input class='inputxt' name="+ stringId +" value="+ stringName +" />";								
			}else if(str[0].equals("") && trNum != 0 && str.length!=0 || str[0].equals("null")){
				smallStr += "<td class='pcd_left_td_normal' style='width:50px;heigth:20px'></td><td>";
			}else{
				if(str[2].split("-").length >= 5){
					for(int colNum=0;colNum<3-trNum;colNum++){
						if(trNum != 0)
						smallStr+= "<td class='pcd_left_td_normal' style='width:50px;heigth:20px'></td><td class='pcd_left_td_normal' style='heigth:20px'>";
					}
					if(str[1].equals("checkBox")){
						smallStr += "</tr><tr><td class='pcd_left_td_normal' style='heigth:20px'><strong name='checkBoxName'>"+ str[0] +"</strong></td><td class='pcd_left_td_normal' colspan='5' style='heigth:20px'>";								
					}else{
						smallStr += "</tr><tr><td class='pcd_left_td_normal' style='heigth:20px'><strong name='radioName'>"+ str[0] +"</strong></td><td class='pcd_left_td_normal' colspan='5' style='heigth:20px'>";								
					}
					trNum = 3;
					if(str[1].equals("checkBox")){
						for(int selectNum=0;selectNum<str[2].split("-").length;selectNum++){	
							boolean checkValue = false;
							if(checkBoxNameNum < mostCheckBoxNameNum){
								List<String> myCheckBoxList = checkBoxNameList.get(checkBoxNameNum);
								String myStr = str[2].split("-")[selectNum];
								for(String checkBoxStr:myCheckBoxList){
									if(myStr.equals(checkBoxStr)){
										checkValue = true;		
									}
								}	
							}
							if(checkValue == true){
								smallStr += "<div style='float:left;margin-left:3px;'><input name='"+ str[1]+i +"' type='"+ str[1] +"' checked='checked' value='"+ str[2].split("-")[selectNum] +"'/>"+ str[2].split("-")[selectNum] +"</div>";
							}else{
								smallStr += "<div style='float:left;margin-left:3px;'><input name='"+ str[1]+i +"' type='"+ str[1] +"' value='"+ str[2].split("-")[selectNum] +"'/>"+ str[2].split("-")[selectNum] +"</div>";
							}			
						}
						radioNameNum++;
					}else{
						for(int selectNum=0;selectNum<str[2].split("-").length;selectNum++){	
							boolean checkValue = false;
							if(radioNameNum < mostRadioNameNum){
								List<String> myRadioList = radioNameList.get(radioNameNum);
								String myStr = str[2].split("-")[selectNum];
								for(String radioStr:myRadioList){
									if(myStr.equals(radioStr)){
										checkValue = true;		
									}
								}	
							}
							if(checkValue == true){
								smallStr += "<div style='float:left;margin-left:3px;'><input name='"+ str[1]+i +"' type='"+ str[1] +"' checked='checked' value='"+ str[2].split("-")[selectNum] +"'/>"+ str[2].split("-")[selectNum] +"</div>";
							}else{
								smallStr += "<div style='float:left;margin-left:3px;'><input name='"+ str[1]+i +"' type='"+ str[1] +"' value='"+ str[2].split("-")[selectNum] +"'/>"+ str[2].split("-")[selectNum] +"</div>";
							}			
						}
						radioNameNum++;
					}
				}else{
					if(str[1].equals("checkBox")){
						smallStr += "<td class='pcd_left_td_normal' style='heigth:20px'><strong name='checkBoxName'>"+ str[0] +"</strong></td><td class='pcd_left_td_normal' style='heigth:20px'>";			
					}else{
						smallStr += "<td class='pcd_left_td_normal' style='heigth:20px'><strong name='radioName'>"+ str[0] +"</strong></td><td class='pcd_left_td_normal' style='heigth:20px'>";									
					}
					if(str[1].equals("checkBox")){
						for(int selectNum=0;selectNum<str[2].split("-").length;selectNum++){	
							boolean checkValue = false;
							if(checkBoxNameNum < mostCheckBoxNameNum){
								List<String> myCheckBoxList = checkBoxNameList.get(checkBoxNameNum);
								String myStr = str[2].split("-")[selectNum];
								for(String checkBoxStr:myCheckBoxList){
									if(myStr.equals(checkBoxStr)){
										checkValue = true;		
									}
								}	
							}
							if(checkValue == true){
								smallStr += "<div style='float:left;margin-left:3px;'><input name='"+ str[1]+i +"' type='"+ str[1] +"' checked='checked' value='"+ str[2].split("-")[selectNum] +"'/>"+ str[2].split("-")[selectNum] +"</div>";
							}else{
								smallStr += "<div style='float:left;margin-left:3px;'><input name='"+ str[1]+i +"' type='"+ str[1] +"' value='"+ str[2].split("-")[selectNum] +"'/>"+ str[2].split("-")[selectNum] +"</div>";
							}			
						}
						checkBoxNameNum++;
					}else{
						for(int selectNum=0;selectNum<str[2].split("-").length;selectNum++){	
							boolean checkValue = false;
							if(radioNameNum < mostRadioNameNum){
								List<String> myRadioList = radioNameList.get(radioNameNum);
								String myStr = str[2].split("-")[selectNum];
								for(String radioStr:myRadioList){
									if(myStr.equals(radioStr)){
										checkValue = true;		
									}
								}	
							}
							if(checkValue == true){
								smallStr += "<div style='float:left;margin-left:3px;'><input name='"+ str[1]+i +"' type='"+ str[1] +"' checked='checked' value='"+ str[2].split("-")[selectNum] +"'/>"+ str[2].split("-")[selectNum] +"</div>";
							}else{
								smallStr += "<div style='float:left;margin-left:3px;'><input name='"+ str[1]+i +"' type='"+ str[1] +"' value='"+ str[2].split("-")[selectNum] +"'/>"+ str[2].split("-")[selectNum] +"</div>";
							}			
						}
						checkBoxNameNum++;
					}
				}	
			}
			}
			smallStr += "</td>";
			trNum++;
			if(trNum >=3){
				smallStr += "</tr><tr>";
				trNum = 0;
			}
		}
		if(trNum<3 && trNum > 0){
			for(int colNum=0;colNum<3-trNum;colNum++){
				smallStr += "<td class='pcd_left_td_normal' style='width:50px;heigth:20px'></td><td class='pcd_left_td_normal' style='heigth:20px'></td>";
			}		
		}	
		smallStr += "</tr>";
		//基础50px方格搭建
		for(int i=0;i<normalList.get(0).size();i++){
			String[] str = normalList.get(0).get(String.valueOf(i)).toString().split(":");
			if(str.length <= 1){
				if(str[0].equals("备注")){
					stringId = "memo";stringName = detailTableEntity.getMemo();
				}else{
					stringId = "selfString";
					if(stringNameNum < mostStringNameNum){
						stringName = stringNameList.get(stringNameNum);
						stringNameNum++;
					}	
				}
				normalStr += "<tr><td class='pcd_left_td_normal' style='width:50px;height:50px;'><strong name='"+ stringId +"Name'>"+ str[0] +"</strong></td><td class='pcd_left_td_normal' colspan='5' style='height:50px'><textarea name='"+ stringId +"' rows='1' cols='10' style='font-size:15px;margin: 0px; width: 840px; height: 90px;'>"+ stringName +"</textarea></td></tr>";
			}
		}
		//基础200px方格搭建
		for(int i=0;i<bigList.get(0).size();i++){
			stringId = "selfString";
			if(stringNameNum < mostStringNameNum){
				stringName = stringNameList.get(stringNameNum);
				stringNameNum++;
			}	
			String[] str = bigList.get(0).get(String.valueOf(i)).toString().split(":");
			if(str.length <= 1){
				bigStr += "<tr><td class='pcd_left_td_normal' style='width:50px;height:200px;'><strong name='"+ stringId +"Name'>"+ str[0] +"</strong></td><td class='pcd_left_td_normal' colspan='5' style='height:200px'><textarea name='"+ stringId +"' rows='1' cols='10' style='font-size:15px;margin: 0px; width: 840px; height: 200px;'>"+ stringName +"</textarea></td></tr>";
			}
		}
		//基础500px方格搭建
		for(int i=0;i<biggestList.get(0).size();i++){
			stringId = "selfString";
			if(stringNameNum < mostStringNameNum){
				stringName = stringNameList.get(stringNameNum);
				stringNameNum++;
			}	
			String[] str = biggestList.get(0).get(String.valueOf(i)).toString().split(":");
			if(str.length <= 1){
				biggestStr += "<tr><td class='pcd_left_td_normal' style='width:50px;height:500px;'><strong name='"+ stringId +"Name'>"+ str[0] +"</strong></td><td class='pcd_left_td_normal' colspan='5' style='height:500px'><textarea name='"+ stringId +"' rows='1' cols='10' style='font-size:15px;margin: 0px; width: 840px; height: 500px;'>"+ stringName +"</textarea></td></tr>";
			}
		}
		//传回jsp
		request.setAttribute("id", id);
		request.setAttribute("title", resultList.get(0).get("list_name"));
		request.setAttribute("smallStr", smallStr);
		request.setAttribute("normalStr", normalStr);
		request.setAttribute("bigStr", bigStr);
		request.setAttribute("biggestStr", biggestStr);
		request.setAttribute("listType", resultList.get(0).get("list_type"));
		request.setAttribute("createPerson", ResourceUtil.getSessionUser().getRealName());
		request.setAttribute("createDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		}
		if(check != null){
			return new ModelAndView("com/finalDesign/basetable/baseTable-check");		
		}else{
			return new ModelAndView("com/finalDesign/basetable/printSelfTablePreview");	
		}
	}
	
	/**
	 * 删除base_table
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(BaseTableEntity baseTable, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		baseTable = systemService.getEntity(BaseTableEntity.class, baseTable.getId());
		message = "base_table删除成功";
		try{
			baseTableService.delete(baseTable);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "base_table删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除base_table
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "base_table删除成功";
		try{
			for(String id:ids.split(",")){
				BaseTableEntity baseTable = systemService.getEntity(BaseTableEntity.class, 
				id
				);
				baseTableService.delete(baseTable);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "base_table删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加base_table
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(BaseTableEntity baseTable, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "base_table添加成功";
		try{
			if(baseTable.getSelfStringName() != ""){
				baseTable.setEnable(true);
			}
			baseTable.setUseCount(0);
			baseTable.setCreateUserId(ResourceUtil.getSessionUser().getId());
			baseTable.setCreateUserName(ResourceUtil.getSessionUser().getUpdateBy());
			baseTableService.save(baseTable);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "base_table添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新base_table
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(BaseTableEntity baseTable, HttpServletRequest request) {
		String message = null;
		Date date = new Date();
		AjaxJson j = new AjaxJson();
		message = "base_table更新成功";
		BaseTableEntity t = baseTableService.get(BaseTableEntity.class, baseTable.getId());
		try {			
			baseTable.setModifyDate(date);
			baseTable.setModifyUserId(ResourceUtil.getSessionUser().getId());
			baseTable.setModifyUserName(ResourceUtil.getSessionUser().getUpdateBy());
			MyBeanUtils.copyBeanNotNull2Bean(baseTable, t);
			baseTableService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "base_table更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * base_table新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(BaseTableEntity baseTable, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(baseTable.getId())) {
			baseTable = baseTableService.getEntity(BaseTableEntity.class, baseTable.getId());
			req.setAttribute("baseTablePage", baseTable);			
			}
		String oaList = "";
		List<Object[]> myOaList = systemService.findListbySql("select t.oa_name, t.id from self_oa_service t where 1=1");
		for(Object[] obj : myOaList){
			oaList += "<option value="+ obj[1] +">"+ obj[0] +"</option>";			
		}
		req.setAttribute("oaList", oaList);
		return new ModelAndView("com/finalDesign/basetable/baseTable-add");
	}
	/**
	 * base_table编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(BaseTableEntity baseTable, HttpServletRequest req, DetailTableEntity detailTableEntity) {
		if (StringUtil.isNotEmpty(baseTable.getId())) {
			baseTable = baseTableService.getEntity(BaseTableEntity.class, baseTable.getId());
			if(baseTable.getSelfString()!=null){						
			String[] selfStringNum = baseTable.getSelfString().split(",");	
			String selfStringName = baseTable.getSelfStringName();
			List<String> selfStringList = new ArrayList<String>();
			for(String str:selfStringNum){
				selfStringList.add(str);
			}
			String myselfStringList = String.valueOf(selfStringList).replace("[", "");
			myselfStringList = String.valueOf(myselfStringList).replace("]", "");		
			req.setAttribute("selfStringNum", selfStringNum.length);
			req.setAttribute("selfStringList", myselfStringList);
			req.setAttribute("selfStringName", selfStringName);
			}
			String oaList = "";
			List<Object[]> myOaList = systemService.findListbySql("select t.oa_name, t.id from self_oa_service t where 1=1");
			for(Object[] obj : myOaList){
				if(obj[1].equals(baseTable.getOaId())){
					oaList += "<option selected='selected' value="+ obj[1] +">"+ obj[0] +"</option>";						
				}else{
					oaList += "<option value="+ obj[1] +">"+ obj[0] +"</option>";						
				}
		
			}
			req.setAttribute("oaList", oaList);
			req.setAttribute("baseTablePage", baseTable);
		}
		return new ModelAndView("com/finalDesign/basetable/baseTable-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","baseTableController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(BaseTableEntity baseTable,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(BaseTableEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, baseTable, request.getParameterMap());
		List<BaseTableEntity> baseTables = this.baseTableService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"base_table");
		modelMap.put(NormalExcelConstants.CLASS,BaseTableEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("base_table列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,baseTables);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(BaseTableEntity baseTable,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"base_table");
    	modelMap.put(NormalExcelConstants.CLASS,BaseTableEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("base_table列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<BaseTableEntity> listBaseTableEntitys = ExcelImportUtil.importExcel(file.getInputStream(),BaseTableEntity.class,params);
				for (BaseTableEntity baseTable : listBaseTableEntitys) {
					baseTableService.save(baseTable);
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
	public List<BaseTableEntity> list() {
		List<BaseTableEntity> listBaseTables=baseTableService.getList(BaseTableEntity.class);
		return listBaseTables;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		BaseTableEntity task = baseTableService.get(BaseTableEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody BaseTableEntity baseTable, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<BaseTableEntity>> failures = validator.validate(baseTable);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			baseTableService.save(baseTable);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = baseTable.getId();
		URI uri = uriBuilder.path("/rest/baseTableController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody BaseTableEntity baseTable) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<BaseTableEntity>> failures = validator.validate(baseTable);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			baseTableService.saveOrUpdate(baseTable);
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
		baseTableService.deleteEntityById(BaseTableEntity.class, id);
	}
}
