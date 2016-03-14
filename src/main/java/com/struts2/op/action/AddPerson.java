package com.struts2.op.action;

import java.util.ArrayList;
import java.util.Date;




import java.util.List;

import com.struts2.op.service.dao.Struts2OpService;
import com.struts2.op.service.dao.SeviceImpl.Struts2OpServiceImpl;
import com.struts2.op.constants.CrudConstants;
import com.struts2.op.entity.PersonEntity;
import com.struts2.op.constants.CrudConstants;
import com.opensymphony.xwork2.ActionSupport;

public class AddPerson extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String emailId;
	private String mobile;
	private String oper;
	

	Struts2OpService struts2opService;
	List<PersonEntity> persondetailsList = new ArrayList<PersonEntity>();
	
	
	public AddPerson(){
		struts2opService = new Struts2OpServiceImpl();
	}
	
	/*public String execute(){
		return "success";
	}*/
	
	public String addPersonDetails(){
		
		
		System.out.println("person namae ="+ getName());
		System.out.println("email id==>"+getEmailId());
		System.out.println("mobile==>"+getMobile());
		System.out.println("id ====="+getId());
		
		/*
		if (struts2opService.isPersonIdExists(personId)){
			addActionMessage("person already exists !");
			return "error";
		}
		*/
		if(name != null){
		//System.out.println("Category:::::"+getCategory());
		PersonEntity personEntity = new PersonEntity();
		personEntity.setName(name);
		personEntity.setEmailId(emailId);
		personEntity.setMobile(mobile);
		personEntity.setCreatedDate(new Date());
		personEntity.setModifiedDate(new Date());
		struts2opService.addPersonDetails(personEntity);
		persondetailsList = struts2opService.getAllPersonDetails();
		this.addActionMessage("person Details added successfully");
		return "success";
		}else{
			persondetailsList = struts2opService.getAllPersonDetails();
			return "error";
		}
	}

	public String updatePersonDetail(){
		
		System.out.println("operation ====="+getOper());
		System.out.println("updating person name-----"+getName());
		System.out.println("updatin person id ----"+getId());
		System.out.println("updatin person mobile-----"+getMobile());
		System.out.println("updatin person emailss-----"+getEmailId());
		try {
			if (oper.equalsIgnoreCase(CrudConstants.GRID_EDIT)) {
				PersonEntity perEntity=new PersonEntity();
				
				
				perEntity.setId(id);
				perEntity.setName(name);
				perEntity.setEmailId(emailId);
				perEntity.setMobile(mobile);
		//		personEntity.setCreatedDate(createdDate);
				//perEntity.setModifiedDate(new Date());
				
				System.out.println("parameter value **** id***"+ perEntity.getId());
				//System.out.println("normal id ======"+ id);
				
				struts2opService.updatePersonDetails(perEntity);
				
				
				System.out.println("person updated successfully");
				persondetailsList = struts2opService.getAllPersonDetails();
				//return "success";
				
				
			/*}else {
				System.out.println("error while updating person");
				persondetailsList = struts2opService.getAllPersonDetails();
				//return "error";
*/			
				}
			else if(oper.equalsIgnoreCase(CrudConstants.GRID_DELETE)){
				struts2opService.deletePersonById(id);
				this.addActionMessage("person deleted successfully");
				System.out.println("person deleted succes");
			}
			} catch (Exception e) {
				LOG.error("Error while editing branch details ::" + e);
			}
		return "success";
		}
		
		
		
	
	/*
	public String deletePerson(){
		try{
		PersonEntity person=new PersonEntity();
		
		System.out.println("name ====="+ getId());
		
		struts2opService.deletePersonById(id);
		this.addActionMessage("person deleted successfully");
		System.out.println("person deleted succes");
		persondetailsList = struts2opService.getAllPersonDetails();
		return "success";
	}catch(Exception e){
		persondetailsList = struts2opService.getAllPersonDetails();
		System.out.println("deletion fail");
		return "error";
	}
	}*/
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name){
		this.name=name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public Struts2OpService getStruts2opService() {
		return struts2opService;
	}

	public void setStruts2opService(Struts2OpService struts2opService) {
		this.struts2opService = struts2opService;
	}

	public List<PersonEntity> getPersondetailsList() {
		return persondetailsList;
	}

	public void setPersondetailsList(List<PersonEntity> persondetailsList) {
		this.persondetailsList = persondetailsList;
	}
	
}
