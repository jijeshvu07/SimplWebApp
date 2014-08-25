package com.company.product.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "technology")
public class Technology {
	private int id;
	@NotEmpty
	private String name;

	private Department department;
	private Date createdDate;
	private boolean isDelete;

	public Technology() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Technology(int id, String name, Department department,
			Date createdDate, boolean isDelete) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
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

	@ManyToOne
	@JoinColumn(name = "DEPARTMENT_ID", nullable = false)
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
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
		return "Technology [id=" + id + ", name=" + name + ", department="
				+ department + ", createdDate=" + createdDate + ", isDelete="
				+ isDelete + "]";
	}

}
