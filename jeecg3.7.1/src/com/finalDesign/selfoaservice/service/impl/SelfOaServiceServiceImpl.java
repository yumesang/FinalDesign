package com.finalDesign.selfoaservice.service.impl;
import com.finalDesign.selfoaservice.service.SelfOaServiceServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.finalDesign.selfoaservice.entity.SelfOaServiceEntity;
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

@Service("selfOaServiceService")
@Transactional
public class SelfOaServiceServiceImpl extends CommonServiceImpl implements SelfOaServiceServiceI {

	
 	public void delete(SelfOaServiceEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(SelfOaServiceEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(SelfOaServiceEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(SelfOaServiceEntity t) throws Exception{
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
	private void doUpdateBus(SelfOaServiceEntity t) throws Exception{
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
	private void doDelBus(SelfOaServiceEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(SelfOaServiceEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("oa_name", t.getOaName());
		map.put("oa_detail_id", t.getOaDetailId());
		map.put("oa_detail_name", t.getOaDetailName());
		map.put("node_memo", t.getNodeMemo());
		map.put("node_num", t.getNodeNum());
		map.put("oa_level", t.getOaLevel());
		map.put("create_user_id", t.getCreateUserId());
		map.put("create_user_name", t.getCreateUserName());
		map.put("modify_user_id", t.getModifyUserId());
		map.put("modify_user_name", t.getModifyUserName());
		map.put("create_date", t.getCreateDate());
		map.put("modify_date", t.getModifyDate());
		map.put("check_status", t.getCheckStatus());
		map.put("enable", t.getEnable());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,SelfOaServiceEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{oa_name}",String.valueOf(t.getOaName()));
 		sql  = sql.replace("#{oa_detail_id}",String.valueOf(t.getOaDetailId()));
 		sql  = sql.replace("#{oa_detail_name}",String.valueOf(t.getOaDetailName()));
 		sql  = sql.replace("#{node_memo}",String.valueOf(t.getNodeMemo()));
 		sql  = sql.replace("#{node_num}",String.valueOf(t.getNodeNum()));
 		sql  = sql.replace("#{oa_level}",String.valueOf(t.getOaLevel()));
 		sql  = sql.replace("#{create_user_id}",String.valueOf(t.getCreateUserId()));
 		sql  = sql.replace("#{create_user_name}",String.valueOf(t.getCreateUserName()));
 		sql  = sql.replace("#{modify_user_id}",String.valueOf(t.getModifyUserId()));
 		sql  = sql.replace("#{modify_user_name}",String.valueOf(t.getModifyUserName()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{modify_date}",String.valueOf(t.getModifyDate()));
 		sql  = sql.replace("#{check_status}",String.valueOf(t.getCheckStatus()));
 		sql  = sql.replace("#{enable}",String.valueOf(t.getEnable()));
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
					javaInter.execute("self_oa_service",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}