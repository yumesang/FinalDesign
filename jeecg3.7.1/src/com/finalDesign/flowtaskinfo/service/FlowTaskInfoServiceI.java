package com.finalDesign.flowtaskinfo.service;
import com.finalDesign.flowtaskinfo.entity.FlowTaskInfoEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface FlowTaskInfoServiceI extends CommonService{
	
 	public void delete(FlowTaskInfoEntity entity) throws Exception;
 	
 	public Serializable save(FlowTaskInfoEntity entity) throws Exception;
 	
 	public void saveOrUpdate(FlowTaskInfoEntity entity) throws Exception;
 	
}
