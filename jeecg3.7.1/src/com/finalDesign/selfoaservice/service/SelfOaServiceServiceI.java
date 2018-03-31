package com.finalDesign.selfoaservice.service;
import com.finalDesign.selfoaservice.entity.SelfOaServiceEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface SelfOaServiceServiceI extends CommonService{
	
 	public void delete(SelfOaServiceEntity entity) throws Exception;
 	
 	public Serializable save(SelfOaServiceEntity entity) throws Exception;
 	
 	public void saveOrUpdate(SelfOaServiceEntity entity) throws Exception;
 	
}
