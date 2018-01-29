package com.finalDesign.basenews.service;
import com.finalDesign.basenews.entity.BaseNewsEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface BaseNewsServiceI extends CommonService{
	
 	public void delete(BaseNewsEntity entity) throws Exception;
 	
 	public Serializable save(BaseNewsEntity entity) throws Exception;
 	
 	public void saveOrUpdate(BaseNewsEntity entity) throws Exception;
 	
}
