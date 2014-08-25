package com.company.product.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "userrating")
public class UserRating {
	private int id;
	private User userId;
	private Technology technologyId;
	private SkillFactor skillFactorId;
	private Rating ratingId;
	private Date attendDate;
	private Date createdDate;
	private boolean isDelete;

	public UserRating() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRating(int id, User userId, Technology technologyId,
			SkillFactor skillFactorId, Rating ratingId, Date attendDate,
			Date createdDate, boolean isDelete) {
		super();
		this.id = id;
		this.userId = userId;
		this.technologyId = technologyId;
		this.skillFactorId = skillFactorId;
		this.ratingId = ratingId;
		this.attendDate = attendDate;
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
	@ManyToOne
	@JoinColumn(name = "USER_ID", nullable = false)
	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}
	@ManyToOne
	@JoinColumn(name = "TECHNOLOGICAL_ID", nullable = false)
	public Technology getTechnologyId() {
		return technologyId;
	}

	public void setTechnologyId(Technology technologyId) {
		this.technologyId = technologyId;
	}
	@ManyToOne
	@JoinColumn(name = "SKILL_FACTORS_ID", nullable = false)
	public SkillFactor getSkillFactorId() {
		return skillFactorId;
	}

	public void setSkillFactorId(SkillFactor skillFactorId) {
		this.skillFactorId = skillFactorId;
	}
	@ManyToOne
	@JoinColumn(name = "RATING_ID", nullable = false)
	public Rating getRatingId() {
		return ratingId;
	}

	public void setRatingId(Rating ratingId) {
		this.ratingId = ratingId;
	}
	
	@Column(name = "ATTEND_DATE", nullable = false)
	public Date getAttendDate() {
		return attendDate;
	}

	public void setAttendDate(Date attendDate) {
		this.attendDate = attendDate;
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
		return "UserRating [id=" + id + ", userId=" + userId
				+ ", technologyId=" + technologyId + ", skillFactorId="
				+ skillFactorId + ", ratingId=" + ratingId + ", attendDate="
				+ attendDate + ", createdDate=" + createdDate + ", isDelete="
				+ isDelete + "]";
	}

}
