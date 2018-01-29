package com.finalDesign.basenews.entity;

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
 * @Description: base_news
 * @author onlineGenerator
 * @date 2018-01-29 16:35:05
 * @version V1.0   
 *
 */
@Entity
@Table(name = "base_news", schema = "")
@SuppressWarnings("serial")
public class BaseNewsEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**内容简介*/
	@Excel(name="内容简介",width=15)
	private java.lang.String introduction;
	/**文章内容*/
	@Excel(name="文章内容",width=15)
	private java.lang.String contents;
	/**关键字*/
	@Excel(name="关键字",width=15)
	private java.lang.String keywords;
	/**审核状态*/
	@Excel(name="审核状态",width=15)
	private java.lang.String checkStatus;
	/**被阅读次数*/
	@Excel(name="被阅读次数",width=15)
	private java.lang.Integer readCount;
	/**是否启用*/
	@Excel(name="是否启用",width=15)
	private java.lang.Integer enable;
	/**排序码*/
	@Excel(name="排序码",width=15)
	private java.lang.Integer sortcode;
	/**删除标记*/
	@Excel(name="删除标记",width=15)
	private java.lang.Integer deleteMark;
	/**创建时间*/
	@Excel(name="创建时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date createDate;
	/**创建用户主键*/
	@Excel(name="创建用户主键",width=15)
	private java.lang.String createUserId;
	/**创建用户名称*/
	@Excel(name="创建用户名称",width=15)
	private java.lang.String createUserName;
	/**修改时间*/
	@Excel(name="修改时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date modifyDate;
	/**修改用户主键*/
	@Excel(name="修改用户主键",width=15)
	private java.lang.String modifyUserId;
	/**修改用户名称*/
	@Excel(name="修改用户名称",width=15)
	private java.lang.String modifyUserName;
	/**公告类型*/
	@Excel(name="公告类型",width=15)
	private java.lang.Integer newsType;
	/**创建部门主键*/
	@Excel(name="创建部门主键",width=15)
	private java.lang.String departId;
	/**创建部门名称*/
	@Excel(name="创建部门名称",width=15)
	private java.lang.String departName;
	
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
	 *@return: java.lang.String  内容简介
	 */

	@Column(name ="INTRODUCTION",nullable=true,length=200)
	public java.lang.String getIntroduction(){
		return this.introduction;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  内容简介
	 */
	public void setIntroduction(java.lang.String introduction){
		this.introduction = introduction;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  文章内容
	 */

	@Column(name ="CONTENTS",nullable=true)
	public java.lang.String getContents(){
		return this.contents;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  文章内容
	 */
	public void setContents(java.lang.String contents){
		this.contents = contents;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  关键字
	 */

	@Column(name ="KEYWORDS",nullable=true,length=200)
	public java.lang.String getKeywords(){
		return this.keywords;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  关键字
	 */
	public void setKeywords(java.lang.String keywords){
		this.keywords = keywords;
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  被阅读次数
	 */

	@Column(name ="READ_COUNT",nullable=true,length=10)
	public java.lang.Integer getReadCount(){
		return this.readCount;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  被阅读次数
	 */
	public void setReadCount(java.lang.Integer readCount){
		this.readCount = readCount;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否启用
	 */

	@Column(name ="ENABLE",nullable=true,length=10)
	public java.lang.Integer getEnable(){
		return this.enable;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否启用
	 */
	public void setEnable(java.lang.Integer enable){
		this.enable = enable;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  排序码
	 */

	@Column(name ="SORTCODE",nullable=true,length=10)
	public java.lang.Integer getSortcode(){
		return this.sortcode;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  排序码
	 */
	public void setSortcode(java.lang.Integer sortcode){
		this.sortcode = sortcode;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  删除标记
	 */

	@Column(name ="DELETE_MARK",nullable=true,length=10)
	public java.lang.Integer getDeleteMark(){
		return this.deleteMark;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  删除标记
	 */
	public void setDeleteMark(java.lang.Integer deleteMark){
		this.deleteMark = deleteMark;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */

	@Column(name ="CREATE_DATE",nullable=true)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建用户主键
	 */

	@Column(name ="CREATE_USER_ID",nullable=true,length=50)
	public java.lang.String getCreateUserId(){
		return this.createUserId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建用户主键
	 */
	public void setCreateUserId(java.lang.String createUserId){
		this.createUserId = createUserId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建用户名称
	 */

	@Column(name ="CREATE_USER_NAME",nullable=true,length=50)
	public java.lang.String getCreateUserName(){
		return this.createUserName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建用户名称
	 */
	public void setCreateUserName(java.lang.String createUserName){
		this.createUserName = createUserName;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  修改时间
	 */

	@Column(name ="MODIFY_DATE",nullable=true)
	public java.util.Date getModifyDate(){
		return this.modifyDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  修改时间
	 */
	public void setModifyDate(java.util.Date modifyDate){
		this.modifyDate = modifyDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  修改用户主键
	 */

	@Column(name ="MODIFY_USER_ID",nullable=true,length=50)
	public java.lang.String getModifyUserId(){
		return this.modifyUserId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  修改用户主键
	 */
	public void setModifyUserId(java.lang.String modifyUserId){
		this.modifyUserId = modifyUserId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  修改用户名称
	 */

	@Column(name ="MODIFY_USER_NAME",nullable=true,length=50)
	public java.lang.String getModifyUserName(){
		return this.modifyUserName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  修改用户名称
	 */
	public void setModifyUserName(java.lang.String modifyUserName){
		this.modifyUserName = modifyUserName;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  公告类型
	 */

	@Column(name ="NEWS_TYPE",nullable=true,length=10)
	public java.lang.Integer getNewsType(){
		return this.newsType;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  公告类型
	 */
	public void setNewsType(java.lang.Integer newsType){
		this.newsType = newsType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建部门主键
	 */

	@Column(name ="DEPART_ID",nullable=true,length=100)
	public java.lang.String getDepartId(){
		return this.departId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建部门主键
	 */
	public void setDepartId(java.lang.String departId){
		this.departId = departId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建部门名称
	 */

	@Column(name ="DEPART_NAME",nullable=true,length=100)
	public java.lang.String getDepartName(){
		return this.departName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建部门名称
	 */
	public void setDepartName(java.lang.String departName){
		this.departName = departName;
	}
}
