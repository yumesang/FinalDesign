package com.finalDesign.selfoaservice.entity;

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
 * @Description: self_oa_service
 * @author onlineGenerator
 * @date 2018-03-29 09:36:44
 * @version V1.0   
 *
 */
@Entity
@Table(name = "self_oa_service", schema = "")
@SuppressWarnings("serial")
public class SelfOaServiceEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**流程名称*/
	@Excel(name="流程名称",width=15)
	private java.lang.String oaName;
	/**各节点审核人员id*/
	private java.lang.String oaDetailId;
	/**各节点审核人员姓名*/
	@Excel(name="各节点审核人员姓名",width=15)
	private java.lang.String oaDetailName;
	/**各节点审核备注*/
	@Excel(name="各节点审核备注",width=15)
	private java.lang.String nodeMemo;
	/**节点数量*/
	@Excel(name="节点数量",width=15)
	private java.lang.Integer nodeNum;
	/**流程等级*/
	@Excel(name="流程等级",width=15)
	private java.lang.Integer oaLevel;
	/**创建人员id*/
	@Excel(name="创建人员id",width=15)
	private java.lang.String createUserId;
	/**创建人员名称*/
	@Excel(name="创建人员名称",width=15)
	private java.lang.String createUserName;
	/**修改人员id*/
	@Excel(name="修改人员id",width=15)
	private java.lang.String modifyUserId;
	/**修改人员名称*/
	@Excel(name="修改人员名称",width=15)
	private java.lang.String modifyUserName;
	/**创建日期*/
	@Excel(name="创建日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date createDate;
	/**修改日期*/
	@Excel(name="修改日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date modifyDate;
	/**各节点检查状态*/
	private java.lang.Integer checkStatus;
	/**是否启用*/
	private java.lang.Double enable;
	
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
	 *@return: java.lang.String  流程名称
	 */

	@Column(name ="OA_NAME",nullable=true,length=50)
	public java.lang.String getOaName(){
		return this.oaName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流程名称
	 */
	public void setOaName(java.lang.String oaName){
		this.oaName = oaName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  各节点审核人员
	 */

	@Column(name ="OA_DETAIL_ID",nullable=true,length=200)
	public java.lang.String getOaDetailId(){
		return this.oaDetailId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  各节点审核人员
	 */
	public void setOaDetailId(java.lang.String oaDetailId){
		this.oaDetailId = oaDetailId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  各节点审核人员
	 */

	@Column(name ="OA_DETAIL_NAME",nullable=true,length=200)
	public java.lang.String getOaDetailName(){
		return this.oaDetailName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  各节点审核人员
	 */
	public void setOaDetailName(java.lang.String oaDetailName){
		this.oaDetailName = oaDetailName;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  各节点审核备注
	 */

	@Column(name ="NODE_MEMO",nullable=true,length=200)
	public java.lang.String getNodeMemo(){
		return this.nodeMemo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  各节点审核备注
	 */
	public void setNodeMemo(java.lang.String nodeMemo){
		this.nodeMemo = nodeMemo;
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  流程等级
	 */

	@Column(name ="OA_LEVEL",nullable=true,length=10)
	public java.lang.Integer getOaLevel(){
		return this.oaLevel;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  流程等级
	 */
	public void setOaLevel(java.lang.Integer oaLevel){
		this.oaLevel = oaLevel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人员id
	 */

	@Column(name ="CREATE_USER_ID",nullable=true,length=50)
	public java.lang.String getCreateUserId(){
		return this.createUserId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人员id
	 */
	public void setCreateUserId(java.lang.String createUserId){
		this.createUserId = createUserId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人员名称
	 */

	@Column(name ="CREATE_USER_NAME",nullable=true,length=50)
	public java.lang.String getCreateUserName(){
		return this.createUserName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人员名称
	 */
	public void setCreateUserName(java.lang.String createUserName){
		this.createUserName = createUserName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  修改人员id
	 */

	@Column(name ="MODIFY_USER_ID",nullable=true,length=50)
	public java.lang.String getModifyUserId(){
		return this.modifyUserId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  修改人员id
	 */
	public void setModifyUserId(java.lang.String modifyUserId){
		this.modifyUserId = modifyUserId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  修改人员名称
	 */

	@Column(name ="MODIFY_USER_NAME",nullable=true,length=50)
	public java.lang.String getModifyUserName(){
		return this.modifyUserName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  修改人员名称
	 */
	public void setModifyUserName(java.lang.String modifyUserName){
		this.modifyUserName = modifyUserName;
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  各节点检查状态
	 */

	@Column(name ="CHECK_STATUS",nullable=true,length=10)
	public java.lang.Integer getCheckStatus(){
		return this.checkStatus;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  各节点检查状态
	 */
	public void setCheckStatus(java.lang.Integer checkStatus){
		this.checkStatus = checkStatus;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  是否启用
	 */

	@Column(name ="ENABLE",nullable=true,length=1)
	public java.lang.Double getEnable(){
		return this.enable;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  是否启用
	 */
	public void setEnable(java.lang.Double enable){
		this.enable = enable;
	}
}
