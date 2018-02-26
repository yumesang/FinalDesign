package com.finalDesign.basetable.entity;

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
 * @Description: base_table
 * @author onlineGenerator
 * @date 2018-02-26 11:11:45
 * @version V1.0   
 *
 */
@Entity
@Table(name = "base_table", schema = "")
@SuppressWarnings("serial")
public class BaseTableEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**表格名称*/
	@Excel(name="表格名称",width=15)
	private java.lang.String listName;
	/**表格类型*/
	@Excel(name="表格类型",width=15)
	private java.lang.String listType;
	/**表格链接*/
	@Excel(name="表格链接",width=15)
	private java.lang.String listUrl;
	/**姓名*/
	@Excel(name="姓名",width=15)
	private java.lang.String name;
	/**年龄*/
	@Excel(name="年龄",width=15)
	private java.lang.String age;
	/**性别*/
	@Excel(name="性别",width=15)
	private java.lang.String sex;
	/**职称*/
	@Excel(name="职称",width=15)
	private java.lang.String profession;
	/**系别主键*/
	@Excel(name="系别主键",width=15)
	private java.lang.String departId;
	/**系别名称*/
	@Excel(name="系别名称",width=15)
	private java.lang.String departName;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String memo;
	/**自定义字段名*/
	@Excel(name="自定义字段名",width=15)
	private java.lang.String selfStringName;
	/**自定义字段*/
	@Excel(name="自定义字段",width=15)
	private java.lang.String selfString;
	/**被使用次数*/
	@Excel(name="被使用次数",width=15)
	private java.lang.Integer useCount;
	/**审核状态*/
	@Excel(name="审核状态",width=15)
	private java.lang.String checkStatus;
	/**创建日期*/
	@Excel(name="创建日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date createDate;
	/**创建人员主键*/
	@Excel(name="创建人员主键",width=15)
	private java.lang.String createUserId;
	/**创建人员名称*/
	@Excel(name="创建人员名称",width=15)
	private java.lang.String createUserName;
	/**修改日期*/
	@Excel(name="修改日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date modifyDate;
	/**修改人员主键*/
	@Excel(name="修改人员主键",width=15)
	private java.lang.String modifyUserId;
	/**修改人员名称*/
	@Excel(name="修改人员名称",width=15)
	private java.lang.String modifyUserName;
	/**是否启用*/
	@Excel(name="是否启用",width=15)
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
	 *@return: java.lang.String  表格名称
	 */

	@Column(name ="LIST_NAME",nullable=true,length=50)
	public java.lang.String getListName(){
		return this.listName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  表格名称
	 */
	public void setListName(java.lang.String listName){
		this.listName = listName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  表格类型
	 */

	@Column(name ="LIST_TYPE",nullable=true,length=50)
	public java.lang.String getListType(){
		return this.listType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  表格类型
	 */
	public void setListType(java.lang.String listType){
		this.listType = listType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  表格链接
	 */

	@Column(name ="LIST_URL",nullable=true,length=200)
	public java.lang.String getListUrl(){
		return this.listUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  表格链接
	 */
	public void setListUrl(java.lang.String listUrl){
		this.listUrl = listUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  姓名
	 */

	@Column(name ="NAME",nullable=true,length=50)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  姓名
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  年龄
	 */

	@Column(name ="AGE",nullable=true,length=50)
	public java.lang.String getAge(){
		return this.age;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  年龄
	 */
	public void setAge(java.lang.String age){
		this.age = age;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  性别
	 */

	@Column(name ="SEX",nullable=true,length=50)
	public java.lang.String getSex(){
		return this.sex;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  性别
	 */
	public void setSex(java.lang.String sex){
		this.sex = sex;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职称
	 */

	@Column(name ="PROFESSION",nullable=true,length=50)
	public java.lang.String getProfession(){
		return this.profession;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职称
	 */
	public void setProfession(java.lang.String profession){
		this.profession = profession;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  系别主键
	 */

	@Column(name ="DEPART_ID",nullable=true,length=50)
	public java.lang.String getDepartId(){
		return this.departId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  系别主键
	 */
	public void setDepartId(java.lang.String departId){
		this.departId = departId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  系别名称
	 */

	@Column(name ="DEPART_NAME",nullable=true,length=50)
	public java.lang.String getDepartName(){
		return this.departName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  系别名称
	 */
	public void setDepartName(java.lang.String departName){
		this.departName = departName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */

	@Column(name ="MEMO",nullable=true,length=200)
	public java.lang.String getMemo(){
		return this.memo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setMemo(java.lang.String memo){
		this.memo = memo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  自定义字段名
	 */

	@Column(name ="SELF_STRING_NAME",nullable=true,length=50)
	public java.lang.String getSelfStringName(){
		return this.selfStringName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  自定义字段名
	 */
	public void setSelfStringName(java.lang.String selfStringName){
		this.selfStringName = selfStringName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  自定义字段
	 */

	@Column(name ="SELF_STRING",nullable=true,length=50)
	public java.lang.String getSelfString(){
		return this.selfString;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  自定义字段
	 */
	public void setSelfString(java.lang.String selfString){
		this.selfString = selfString;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  被使用次数
	 */

	@Column(name ="USE_COUNT",nullable=true,length=10)
	public java.lang.Integer getUseCount(){
		return this.useCount;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  被使用次数
	 */
	public void setUseCount(java.lang.Integer useCount){
		this.useCount = useCount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核状态
	 */

	@Column(name ="CHECK_STATUS",nullable=true,length=50)
	public java.lang.String getCheckStatus(){
		return this.checkStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核状态
	 */
	public void setCheckStatus(java.lang.String checkStatus){
		this.checkStatus = checkStatus;
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
	 *@return: java.lang.String  创建人员主键
	 */

	@Column(name ="CREATE_USER_ID",nullable=true,length=50)
	public java.lang.String getCreateUserId(){
		return this.createUserId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人员主键
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  修改人员主键
	 */

	@Column(name ="MODIFY_USER_ID",nullable=true,length=50)
	public java.lang.String getModifyUserId(){
		return this.modifyUserId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  修改人员主键
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