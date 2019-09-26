package cn.com.pms.util;

import java.util.ArrayList;
import java.util.List;

public class Page<T>{
	
	private Integer currPageNo;
	private Integer perPageSize = 3;
	private Integer allRecordNo;
	private Integer allPageNo;
	private List<T> list = new ArrayList<T>();
	
	public Page() {}
	
	public Page(Integer currPageNo, Integer perPageSize, Integer allRecordNo, Integer allPageNo, List<T> list) {
		super();
		this.currPageNo = currPageNo;
		this.perPageSize = perPageSize;
		this.allRecordNo = allRecordNo;
		this.allPageNo = allPageNo;
		this.list = list;
	}
	public Integer getCurrPageNo() {
		return currPageNo;
	}
	public void setCurrPageNo(Integer currPageNo) {
		this.currPageNo = currPageNo;
	}
	public Integer getPerPageSize() {
		return perPageSize;
	}
	public void setPerPageSize(Integer perPageSize) {
		this.perPageSize = perPageSize;
	}
	public Integer getAllRecordNo() {
		return allRecordNo;
	}
	public void setAllRecordNo(Integer allRecordNo) {
		this.allRecordNo = allRecordNo;
	}
	public Integer getAllPageNo() {
		return allPageNo;
	}
	public void setAllPageNo(Integer allPageNo) {
		this.allPageNo = allPageNo;
	}
	public List<T> getList() {
		return list;
	}
	public void setEmpList(List<T> list) {
		this.list = list;
	}
	
}
