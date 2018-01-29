package com.finalDesign.basenews.service.impl;
import com.finalDesign.basenews.service.BaseNewsServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.finalDesign.basenews.entity.BaseNewsEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.io.Serializable;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;

@Service("baseNewsService")
@Transactional
public class BaseNewsServiceImpl extends CommonServiceImpl implements BaseNewsServiceI {

	
 	public void delete(BaseNewsEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(BaseNewsEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(BaseNewsEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(BaseNewsEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(BaseNewsEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 删除操作增强业务
	 * @param id
	 * @return
	 */
	private void doDelBus(BaseNewsEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(BaseNewsEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("introduction", t.getIntroduction());
		map.put("contents", t.getContents());
		map.put("keywords", t.getKeywords());
		map.put("check_status", t.getCheckStatus());
		map.put("read_count", t.getReadCount());
		map.put("enable", t.getEnable());
		map.put("sortcode", t.getSortcode());
		map.put("delete_mark", t.getDeleteMark());
		map.put("create_date", t.getCreateDate());
		map.put("create_user_id", t.getCreateUserId());
		map.put("create_user_name", t.getCreateUserName());
		map.put("modify_date", t.getModifyDate());
		map.put("modify_user_id", t.getModifyUserId());
		map.put("modify_user_name", t.getModifyUserName());
		map.put("news_type", t.getNewsType());
		map.put("depart_id", t.getDepartId());
		map.put("depart_name", t.getDepartName());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,BaseNewsEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{introduction}",String.valueOf(t.getIntroduction()));
 		sql  = sql.replace("#{contents}",String.valueOf(t.getContents()));
 		sql  = sql.replace("#{keywords}",String.valueOf(t.getKeywords()));
 		sql  = sql.replace("#{check_status}",String.valueOf(t.getCheckStatus()));
 		sql  = sql.replace("#{read_count}",String.valueOf(t.getReadCount()));
 		sql  = sql.replace("#{enable}",String.valueOf(t.getEnable()));
 		sql  = sql.replace("#{sortcode}",String.valueOf(t.getSortcode()));
 		sql  = sql.replace("#{delete_mark}",String.valueOf(t.getDeleteMark()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{create_user_id}",String.valueOf(t.getCreateUserId()));
 		sql  = sql.replace("#{create_user_name}",String.valueOf(t.getCreateUserName()));
 		sql  = sql.replace("#{modify_date}",String.valueOf(t.getModifyDate()));
 		sql  = sql.replace("#{modify_user_id}",String.valueOf(t.getModifyUserId()));
 		sql  = sql.replace("#{modify_user_name}",String.valueOf(t.getModifyUserName()));
 		sql  = sql.replace("#{news_type}",String.valueOf(t.getNewsType()));
 		sql  = sql.replace("#{depart_id}",String.valueOf(t.getDepartId()));
 		sql  = sql.replace("#{depart_name}",String.valueOf(t.getDepartName()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
 	
 	/**
	 * 执行JAVA增强
	 */
 	private void executeJavaExtend(String cgJavaType,String cgJavaValue,Map<String,Object> data) throws Exception {
 		if(StringUtil.isNotEmpty(cgJavaValue)){
			Object obj = null;
			try {
				if("class".equals(cgJavaType)){
					//因新增时已经校验了实例化是否可以成功，所以这块就不需要再做一次判断
					obj = MyClassLoader.getClassByScn(cgJavaValue).newInstance();
				}else if("spring".equals(cgJavaType)){
					obj = ApplicationContextUtil.getContext().getBean(cgJavaValue);
				}
				if(obj instanceof CgformEnhanceJavaInter){
					CgformEnhanceJavaInter javaInter = (CgformEnhanceJavaInter) obj;
					javaInter.execute("base_news",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}