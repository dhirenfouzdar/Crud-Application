package com.struts2.op.entity;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="PersonEntity")
@Entity
public class PersonEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	private String name;
	private String emailId;
	private String mobile;
	private Date createdDate;
	private Date modifiedDate;
	
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id=id;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	
	public String getEmailId(){
		return emailId;
	}
	public void setEmailId(String emailId){
		this.emailId=emailId;
	}
	
	public String getMobile(){
		return mobile;
		
	}
	public void setMobile(String mobile){
		this.mobile=mobile;
	}
	
	public Date getCreatedDate(){
		return createdDate;
	}
	public void setCreatedDate(Date createdDate){
		this.createdDate=createdDate;
	}
	
	public Date getModifiedDate(){
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate){
		this.modifiedDate=modifiedDate;
	}
	
	
}
