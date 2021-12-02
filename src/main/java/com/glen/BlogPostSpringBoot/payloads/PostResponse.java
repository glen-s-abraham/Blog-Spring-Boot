package com.glen.BlogPostSpringBoot.payloads;

import java.util.List;

import com.glen.BlogPostSpringBoot.models.Post;

public class PostResponse {
	private List<Post> content;
	private Integer pageNo;
	private Integer pageSize;
	private Long totalElements;
	private Integer totalPages;
	private Boolean last;
	public PostResponse() {
		
		
	}
	public PostResponse(List<Post> content, Integer pageNo, Integer pageSize, Long totalElements , Integer totalPages,
			Boolean last) {
		this.content = content;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalElements = totalElements;
		this.totalPages = totalPages;
		this.last = last;
	}
	public List<Post> getContent() {
		return content;
	}
	public void setContent(List<Post> content) {
		this.content = content;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}
	public Integer getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	public Boolean getLast() {
		return last;
	}
	public void setLast(Boolean last) {
		this.last = last;
	}
	
	
	
}
