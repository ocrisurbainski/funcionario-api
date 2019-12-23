package br.com.urbainski.quarkus_funcionario_api.dto;

import javax.ws.rs.QueryParam;

public class PageableDTO {

	@QueryParam("pageSize")
	private int pageSize;
	
	@QueryParam("pageNumber")
	private int pageNumber;
	
	public PageableDTO() {
		
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