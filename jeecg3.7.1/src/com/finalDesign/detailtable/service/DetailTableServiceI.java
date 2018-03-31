package com.finalDesign.detailtable.service;
import com.finalDesign.detailtable.entity.DetailTableEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface DetailTableServiceI extends CommonService{
	
 	public void delete(DetailTableEntity entity) throws Exception;
 	
 	public Serializable save(DetailTableEntity entity) throws Exception;
 	
 	public void saveOrUpdate(DetailTableEntity entity) throws Exception;
 	
}
