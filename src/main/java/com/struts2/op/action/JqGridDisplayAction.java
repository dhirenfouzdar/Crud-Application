package com.struts2.op.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;

import com.opensymphony.xwork2.ActionSupport;
import com.struts2.op.entity.PersonEntity;
import com.struts2.op.service.dao.Struts2OpService;
import com.struts2.op.service.dao.SeviceImpl.Struts2OpServiceImpl;

public class JqGridDisplayAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer rows;
	private Integer page;
	private String sord;
	private String sidx;
	private String searchField;
	private String searchString;
	private String searchOper;
	private Integer total;
	private Integer records;
	List<PersonEntity> persondetailsList = new ArrayList<PersonEntity>();
	Struts2OpService struts2opService;
	private static Logger LOG = Logger.getLogger(JqGridDisplayAction.class);
	public JqGridDisplayAction() {
		struts2opService = new Struts2OpServiceImpl();
		this.rows = 0;
		this.page = 0;
		this.sord = "asc";
		this.total = 0;
		this.records = 0;
	}

	public String execute() throws Exception {
		return SUCCESS;
	}

	
	@SuppressWarnings("unused")
	public String getPersonDetailsList(){
		LOG.info("****************Getting logs in books list in jqgrid:********");
		try {
			int to = (rows * page);
			int from = to - rows;
			DetachedCriteria criteria = DetachedCriteria
					.forClass(PersonEntity.class);
			criteria.setProjection(null);
			criteria.setResultTransformer(Criteria.ROOT_ENTITY);
			persondetailsList = struts2opService.getAllPersonDetails();
			LOG.info("booksList size :::" +persondetailsList.size());
			if(persondetailsList != null && persondetailsList.size() != 0){
			records = persondetailsList.size();
			total = (int) Math.ceil((double) records / (double) rows);
			LOG.info("size::" + persondetailsList.size());
			}
		} catch (Throwable e) {
			// System.out.println("Runtime Error::");
			LOG.error("Exception occurred while displaying branch JqGrid{}", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getSord() {
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public String getSearchOper() {
		return searchOper;
	}

	public void setSearchOper(String searchOper) {
		this.searchOper = searchOper;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getRecords() {
		return records;
	}

	public void setRecords(Integer records) {
		this.records = records;
	}

	public List<PersonEntity> getPersondetailsList() {
		return persondetailsList;
	}

	public void setPersondetailsList(List<PersonEntity> persondetailsList) {
		this.persondetailsList = persondetailsList;
	}
	

}
