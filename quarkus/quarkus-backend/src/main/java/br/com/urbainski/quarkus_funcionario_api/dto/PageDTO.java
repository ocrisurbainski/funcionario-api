package br.com.urbainski.quarkus_funcionario_api.dto;

import java.util.List;

public class PageDTO<T> {
	
	private List<T> data;
	
	private int pageNumber;
	
	private int pageSize;
	
	public PageDTO() {
		
	}

	public PageDTO(List<T> data, int pageNumber, int pageSize) {
		super();
		this.data = data;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}
	
	public List<T> getData() {
		return data;
	}
	
	public void setData(List<T> data) {
		this.data = data;
	}
	
	public int getPageNumber() {
		return pageNumber;
	}
	
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}