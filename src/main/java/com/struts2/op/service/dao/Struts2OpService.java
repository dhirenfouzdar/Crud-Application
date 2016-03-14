package com.struts2.op.service.dao;


import java.util.List;

import com.struts2.op.entity.PersonEntity;
public interface Struts2OpService {
	public List<PersonEntity> getAllPersonDetails();
	public void addPersonDetails(PersonEntity personEntity);
	public void deletePersonById(Integer id);
	public void updatePersonDetails(PersonEntity personEntity); 
	
}
