package com.company.product.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "user")
public class User {

	private int id;
	@NotEmpty
	private String name;
	@NotEmpty
	private String password;
	
	private Department department;
	@NotEmpty
	private String email;
	
	private String authority;

	public User() {
		super();
		
	}

	public User(int id, String name, String password, String email,Department department,
			String authority) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.department=department;
		this.authority = authority;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "authority")
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int i) {
		this.id = i;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@ManyToOne
	@JoinColumn(name = "department_id", nullable = false)
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password
				+ ", department=" + department + ", email=" + email
				+ ", authority=" + authority + "]";
	}


}