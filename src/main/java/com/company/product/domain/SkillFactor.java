package com.company.product.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "skillfactor")
public class SkillFactor {
	private int id;
	@NotEmpty
	private	String factorName;
	private	Date createdDate;
	private	boolean isDelete;

	public SkillFactor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SkillFactor(int id, String factorName, Date createdDate,
			boolean isDelete) {
		super();
		this.id = id;
		this.factorName = factorName;
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

	@Column(name = "FACTOR_NAME", nullable = false, length = 50)
	public String getFactorName() {
		return factorName;
	}

	public void setFactorName(String factorName) {
		this.factorName = factorName;
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
		return "SkillFactor [id=" + id + ", factorName=" + factorName
				+ ", createdDate=" + createdDate + ", isDelete=" + isDelete
				+ "]";
	}

}
