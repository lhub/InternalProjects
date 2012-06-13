package com.action;

import java.util.Collections;
import java.util.*;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.beans.Employee;
import com.dao.EmpDao;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "showcase")
public class JsonTable extends ActionSupport 
{
	private static final long serialVersionUID = 1L;

	private List gridModel;
	private Integer rows = 0;
	private Integer page = 0;
	private String sord;
	private String sidx;
	private String searchField;
	private String searchString;
	private String searchOper;
	private Integer total = 0;
	private Integer records = 0;
	private boolean loadonce = false;
  @SuppressWarnings("unchecked")
  @Actions( {
    @Action(value = "/jsontable", results = {
      @Result(name = "success", type = "json")
    })
  })
  public String execute()
  {
    EmpDao empDao = new EmpDao();

    try
    {
    	 //Count Rows (select count(*) from custumer)
    	System.out.println("Page " + getPage()+" Rows " + getRows() +" Sorting Order "+ getSord()+" Index Row :" + getSidx());
        records = empDao.getAllRecords().size();
        System.out.println("i am printing count here :"+records+"printing rows : "+rows);

        //Your logic to search and select the required data.
        gridModel = empDao.getAllRecords();
        
        if (getSord() != null && getSord().equalsIgnoreCase("asc"))
        {
          Collections.sort(gridModel);
        }
        if (getSord() != null && getSord().equalsIgnoreCase("desc"))
        {
          Collections.sort(gridModel);
          Collections.reverse(gridModel);
        }
        int to = (getRows() * getPage());
        int from = to - getRows();
        
        setRecords(records);
        
        if (to > getRecords()) 
        	to = getRecords();

        if (loadonce)
        {
          setGridModel(gridModel);
        }
        
        setTotal((int) Math.ceil((double) getRecords() / (double) getRows()));
        return "success";
    }
    catch (Exception e) {
		// TODO: handle exception
    	System.out.println("Exception here : "+e);
    	return "input";
	}
  }

  public String getJSON()
  {
    return execute();
  }

	public List<Employee> getGridModel() {
		return gridModel;
	}

	public void setGridModel(List<Employee> gridModel) {
		this.gridModel = gridModel;
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
}