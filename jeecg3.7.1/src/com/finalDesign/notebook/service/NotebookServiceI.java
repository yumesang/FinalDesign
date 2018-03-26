package com.finalDesign.notebook.service;
import com.finalDesign.notebook.entity.NotebookEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface NotebookServiceI extends CommonService{
	
 	public void delete(NotebookEntity entity) throws Exception;
 	
 	public Serializable save(NotebookEntity entity) throws Exception;
 	
 	public void saveOrUpdate(NotebookEntity entity) throws Exception;
 	
}
