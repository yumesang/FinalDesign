package com.finalDesign.notebook.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: notebook
 * @author onlineGenerator
 * @date 2018-03-26 16:14:36
 * @version V1.0   
 *
 */
@Entity
@Table(name = "notebook", schema = "")
@SuppressWarnings("serial")
public class NotebookEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**任务名称*/
	@Excel(name="任务名称",width=15)
	private java.lang.String taskName;
	/**任务内容*/
	@Excel(name="任务内容",width=15)
	private java.lang.String taskDetail;
	/**任务链接*/
	@Excel(name="任务链接",width=15)
	private java.lang.String taskUrl;
	/**预计完成时间*/
	@Excel(name="预计完成时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date targetDate;
	/**创建日期*/
	@Excel(name="创建日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date createDate;
	/**创建人id*/
	private java.lang.String createUserId;
	/**创建人名称*/
	private java.lang.String createUserName;
	/**修改日期*/
	@Excel(name="修改日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date modifyDate;
	/**是否完成*/
	private java.lang.Double enable;
	/**是否过期*/
	private java.lang.Double isPass;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")

	@Column(name ="ID",nullable=false,length=50)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  id
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  任务名称
	 */

	@Column(name ="TASK_NAME",nullable=true,length=50)
	public java.lang.String getTaskName(){
		return this.taskName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  任务名称
	 */
	public void setTaskName(java.lang.String taskName){
		this.taskName = taskName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  任务内容
	 */

	@Column(name ="TASK_DETAIL",nullable=true,length=200)
	public java.lang.String getTaskDetail(){
		return this.taskDetail;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  任务内容
	 */
	public void setTaskDetail(java.lang.String taskDetail){
		this.taskDetail = taskDetail;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  任务链接
	 */

	@Column(name ="TASK_URL",nullable=true,length=200)
	public java.lang.String getTaskUrl(){
		return this.taskUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  任务链接
	 */
	public void setTaskUrl(java.lang.String taskUrl){
		this.taskUrl = taskUrl;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  预计完成时间
	 */

	@Column(name ="TARGET_DATE",nullable=true)
	public java.util.Date getTargetDate(){
		return this.targetDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  预计完成时间
	 */
	public void setTargetDate(java.util.Date targetDate){
		this.targetDate = targetDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */

	@Column(name ="CREATE_DATE",nullable=true)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人id
	 */

	@Column(name ="CREATE_USER_ID",nullable=true,length=50)
	public java.lang.String getCreateUserId(){
		return this.createUserId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人id
	 */
	public void setCreateUserId(java.lang.String createUserId){
		this.createUserId = createUserId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人名称
	 */

	@Column(name ="CREATE_USER_NAME",nullable=true,length=50)
	public java.lang.String getCreateUserName(){
		return this.createUserName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人名称
	 */
	public void setCreateUserName(java.lang.String createUserName){
		this.createUserName = createUserName;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  修改日期
	 */

	@Column(name ="MODIFY_DATE",nullable=true)
	public java.util.Date getModifyDate(){
		return this.modifyDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  修改日期
	 */
	public void setModifyDate(java.util.Date modifyDate){
		this.modifyDate = modifyDate;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  是否完成
	 */

	@Column(name ="ENABLE",nullable=true,length=1)
	public java.lang.Double getEnable(){
		return this.enable;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  是否完成
	 */
	public void setEnable(java.lang.Double enable){
		this.enable = enable;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  是否过期
	 */

	@Column(name ="IS_PASS",nullable=true,length=1)
	public java.lang.Double getIsPass(){
		return this.isPass;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  是否过期
	 */
	public void setIsPass(java.lang.Double isPass){
		this.isPass = isPass;
	}
}
