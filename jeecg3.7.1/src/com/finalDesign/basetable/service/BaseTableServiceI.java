package com.finalDesign.basetable.service;
import com.finalDesign.basetable.entity.BaseTableEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface BaseTableServiceI extends CommonService{
	
 	public void delete(BaseTableEntity entity) throws Exception;
 	
 	public Serializable save(BaseTableEntity entity) throws Exception;
 	
 	public void saveOrUpdate(BaseTableEntity entity) throws Exception;
 	
}
