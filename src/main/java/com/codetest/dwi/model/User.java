package com.codetest.dwi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.codetest.dwi.common.BaseEntity;

@Entity
@Table(name = "[user]")
public class User extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "internal_id")
	private Long internalId;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "date_of_birth")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	@Column(name = "gender")
	private String gender;

	@Column(name = "email")
	private String email;

	@Transient
	private int dateBirth;
	
	@Transient
	private int monthBirth;
	
	@Transient
	private int yearBirth;

	public Long getInternalId() {
		return internalId;
	}

	public void setInternalId(Long internalId) {
		this.internalId = internalId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(int dateBirth) {
		this.dateBirth = dateBirth;
	}

	public int getMonthBirth() {
		return monthBirth;
	}

	public void setMonthBirth(int monthBirth) {
		this.monthBirth = monthBirth;
	}

	public int getYearBirth() {
		return yearBirth;
	}

	public void setYearBirth(int yearBirth) {
		this.yearBirth = yearBirth;
	}

}
