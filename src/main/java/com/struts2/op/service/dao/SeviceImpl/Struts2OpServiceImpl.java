package com.struts2.op.service.dao.SeviceImpl;
import java.util.Date;
import java.util.List;


import com.struts2.op.entity.PersonEntity;

import org.hibernate.Query;
import org.hibernate.Session;

import com.struts2.op.Listener.HibernateListener;
import com.struts2.op.service.dao.Struts2OpService;




import org.hibernate.Transaction;


public class Struts2OpServiceImpl implements Struts2OpService{
	Transaction transaction = null;
	private Session session = HibernateListener.getSessionFactory().openSession();

public List<PersonEntity> getAllPersonDetails() {
	List<PersonEntity> personDetailsList = null;
	try {
		
		Query query = session.createQuery("from PersonEntity a order by a.createdDate desc");
		personDetailsList = query.list();
	} catch (Exception e) {
		
		//LOG.error("Exception while Getting branch details:" + e);
	}
	return personDetailsList;
	}

public void addPersonDetails(PersonEntity personEntity) {
	//try {
		transaction = session.beginTransaction();
		session.save(personEntity);
		transaction.commit();
	//} catch (Exception e) {
	//	if (transaction != null)
		//	transaction.rollback();
		//LOG.error("Exception while adding new account details:" + e);
	}


public void updatePersonDetails(PersonEntity perEntity){
	System.out.print("Getting info updating person details");
	System.out.println("personEntitu*****id===" + perEntity.getId());
	//System.out.println("dekha id ====="+ id);
	try{
		System.out.print("updatin person details");
		
		transaction = session.beginTransaction();
		PersonEntity person = (PersonEntity) session.get(PersonEntity.class,perEntity.getId());
				
		System.out.println("**Emp Id updating***" + perEntity.getId());
		//System.out.println("person id ====="+ );
		if (person != null) {
			
			person.setName(perEntity.getName());
			person.setId(perEntity.getId());
			System.out.println("abako id ==="+person.getId());
			person.setName(perEntity.getName());
			person.setEmailId(perEntity.getEmailId());
			person.setMobile(perEntity.getMobile());
			person.setCreatedDate(perEntity.getCreatedDate());
			person.setModifiedDate(new Date());
			session.update(person);
			transaction.commit();
			System.out.println("updation successful -----"+person.getId());
		}
	}catch(Exception e){
			System.out.println("error in updating person details" + e);

		}
	
}


	
@Override
public void deletePersonById(Integer id) {
	
	System.out.println("Deleting book details by id::"+id);
	try {
		transaction = session.beginTransaction();
		PersonEntity personEntity = (PersonEntity) session.get(
				PersonEntity.class, id);
		if (personEntity != null) {
			session.delete(personEntity);
			System.out.println("**Deleted book successfully::**" + personEntity.getId());
			transaction.commit();
		}
	}catch (Exception e) {
		if(transaction != null)
			transaction.commit();
		System.out.println("Exception occured in deleting book by id::" + e);
	}
	
	
}
	/*try {
		//if(pname != null){
			System.out.println("persn name ===="+ name);
		transaction = session.beginTransaction();
		Query query = session.createQuery("delete from PersonEntity a where name=:pname");
		query.setParameter("pname", name);
		query.executeUpdate();
		transaction.commit();
		
	} catch (Exception e) {
		if (transaction != null)
			transaction.rollback();
		System.out.print("Exception occured while delete person record" + e);
	} */
	
}



