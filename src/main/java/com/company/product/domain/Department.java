package com.company.product.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "department")
public class Department {
	int id;
	@NotEmpty
	String name;
	Date createdDate;
	boolean isDelete;

	public Department() {
		super();

	}

	public Department(int id, String name, Date createdDate, boolean isDelete) {
		super();
		this.id = id;
		this.name = name;
		this.createdDate = createdDate;
		this.isDelete = isDelete;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, length = 19)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "NAME", nullable = false, length = 50)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "CREATED_DATE", nullable = false)
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "IS_DELETE")
	public boolean getDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", createdDate="
				+ createdDate + ", isDelete=" + isDelete + "]";
	}

}
