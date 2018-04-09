package com.finalDesign.flowtaskinfo.entity;

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
 * @Description: flow_task_info
 * @author onlineGenerator
 * @date 2018-04-08 11:35:39
 * @version V1.0   
 *
 */
@Entity
@Table(name = "flow_task_info", schema = "")
@SuppressWarnings("serial")
public class FlowTaskInfoEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**任务名称*/
	@Excel(name="任务名称",width=15)
	private java.lang.String taskName;
	/**任务链接*/
	@Excel(name="任务链接",width=15)
	private java.lang.String url;
	@Excel(name="任务id",width=15)
	private java.lang.String code;
	/**检查状态*/
	@Excel(name="检查状态",width=15)
	private java.lang.Integer checkStatus;
	/**节点数量*/
	@Excel(name="节点数量",width=15)
	private java.lang.Integer nodeNum;
	/**节点备注*/
	@Excel(name="节点备注",width=15)
	private java.lang.String nodeMemo;
	/**创建日期*/
	@Excel(name="创建日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date createDate;
	/**审核人员id*/
	@Excel(name="审核人员id",width=15)
	private java.lang.String checkUserId;
	/**审核通过日期*/
	@Excel(name="审核通过日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date passDate;
	/**创建人员id*/
	@Excel(name="创建人员id",width=15)
	private java.lang.String ceateUserId;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
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
	 *@param: java.lang.String  主键
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
	 *@return: java.lang.String  任务链接
	 */

	@Column(name ="URL",nullable=true,length=200)
	public java.lang.String getUrl(){
		return this.url;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  任务链接
	 */
	public void setUrl(java.lang.String url){
		this.url = url;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  检查状态
	 */

	@Column(name ="CHECK_STATUS",nullable=true,length=10)
	public java.lang.Integer getCheckStatus(){
		return this.checkStatus;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  检查状态
	 */
	public void setCheckStatus(java.lang.Integer checkStatus){
		this.checkStatus = checkStatus;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  节点数量
	 */

	@Column(name ="NODE_NUM",nullable=true,length=10)
	public java.lang.Integer getNodeNum(){
		return this.nodeNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  节点数量
	 */
	public void setNodeNum(java.lang.Integer nodeNum){
		this.nodeNum = nodeNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  节点备注
	 */

	@Column(name ="NODE_MEMO",nullable=true,length=200)
	public java.lang.String getNodeMemo(){
		return this.nodeMemo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  节点备注
	 */
	public void setNodeMemo(java.lang.String nodeMemo){
		this.nodeMemo = nodeMemo;
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
	 *@return: java.lang.String  审核人员id
	 */

	@Column(name ="CHECK_USER_ID",nullable=true,length=200)
	public java.lang.String getCheckUserId(){
		return this.checkUserId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核人员id
	 */
	public void setCheckUserId(java.lang.String checkUserId){
		this.checkUserId = checkUserId;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  审核通过日期
	 */

	@Column(name ="PASS_DATE",nullable=true)
	public java.util.Date getPassDate(){
		return this.passDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  审核通过日期
	 */
	public void setPassDate(java.util.Date passDate){
		this.passDate = passDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人员id
	 */

	@Column(name ="CEATE_USER_ID",nullable=true,length=50)
	public java.lang.String getCeateUserId(){
		return this.ceateUserId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人员id
	 */
	public void setCeateUserId(java.lang.String ceateUserId){
		this.ceateUserId = ceateUserId;
	}
	
	@Column(name ="code",nullable=true,length=50)
	public java.lang.String getCode(){
		return this.code;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人员id
	 */
	public void setCode(java.lang.String code){
		this.code = code;
	}
}
