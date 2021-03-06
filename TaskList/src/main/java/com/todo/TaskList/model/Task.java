package com.todo.TaskList.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Task {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
    
	private String description, status;
	
	@CreatedDate
	private Date createdDate;	

	@CreatedBy
	private String createdBy;

	@LastModifiedDate 
	private Date lastModifiedDate;
	
	@LastModifiedBy 
	private String lastModifiedBy;
	

	public Task() {
		
	}
	
	public Task(long id, String description, String status, Date createdDate, String createdBy, Date lastModifiedDate,
			String lastModifiedBy) {
		super();
		this.id = id;
		this.description = description;
		this.status = status;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.lastModifiedDate = lastModifiedDate;
		this.lastModifiedBy = lastModifiedBy;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", description=" + description + ", status=" + status + ", createdDate=" + createdDate
				+ ", createdBy=" + createdBy + ", lastModifiedDate=" + lastModifiedDate + ", lastModifiedBy="
				+ lastModifiedBy + "]";
	}
	
	
	
	
}
