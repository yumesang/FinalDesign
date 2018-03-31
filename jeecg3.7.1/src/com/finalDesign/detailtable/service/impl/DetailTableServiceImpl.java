package com.finalDesign.detailtable.service.impl;
import com.finalDesign.detailtable.service.DetailTableServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.finalDesign.detailtable.entity.DetailTableEntity;
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

@Service("detailTableService")
@Transactional
public class DetailTableServiceImpl extends CommonServiceImpl implements DetailTableServiceI {

	
 	public void delete(DetailTableEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(DetailTableEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(DetailTableEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(DetailTableEntity t) throws Exception{
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
	private void doUpdateBus(DetailTableEntity t) throws Exception{
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
	private void doDelBus(DetailTableEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(DetailTableEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("list_name", t.getListName());
		map.put("list_type", t.getListType());
		map.put("oa_id", t.getOaId());
		map.put("name", t.getName());
		map.put("age", t.getAge());
		map.put("sex", t.getSex());
		map.put("profession", t.getProfession());
		map.put("depart_id", t.getDepartId());
		map.put("depart_name", t.getDepartName());
		map.put("memo", t.getMemo());
		map.put("self_string_name", t.getSelfStringName());
		map.put("self_string", t.getSelfString());
		map.put("check_status", t.getCheckStatus());
		map.put("create_date", t.getCreateDate());
		map.put("create_user_id", t.getCreateUserId());
		map.put("create_user_name", t.getCreateUserName());
		map.put("oa_name", t.getOaName());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,DetailTableEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{list_name}",String.valueOf(t.getListName()));
 		sql  = sql.replace("#{list_type}",String.valueOf(t.getListType()));
 		sql  = sql.replace("#{oa_id}",String.valueOf(t.getOaId()));
 		sql  = sql.replace("#{name}",String.valueOf(t.getName()));
 		sql  = sql.replace("#{age}",String.valueOf(t.getAge()));
 		sql  = sql.replace("#{sex}",String.valueOf(t.getSex()));
 		sql  = sql.replace("#{profession}",String.valueOf(t.getProfession()));
 		sql  = sql.replace("#{depart_id}",String.valueOf(t.getDepartId()));
 		sql  = sql.replace("#{depart_name}",String.valueOf(t.getDepartName()));
 		sql  = sql.replace("#{memo}",String.valueOf(t.getMemo()));
 		sql  = sql.replace("#{self_string_name}",String.valueOf(t.getSelfStringName()));
 		sql  = sql.replace("#{self_string}",String.valueOf(t.getSelfString()));
 		sql  = sql.replace("#{check_status}",String.valueOf(t.getCheckStatus()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{create_user_id}",String.valueOf(t.getCreateUserId()));
 		sql  = sql.replace("#{create_user_name}",String.valueOf(t.getCreateUserName()));
 		sql  = sql.replace("#{oa_name}",String.valueOf(t.getOaName()));
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
					javaInter.execute("detail_table",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}