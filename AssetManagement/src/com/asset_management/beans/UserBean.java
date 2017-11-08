package com.asset_management.beans;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="users")
public class UserBean {
	
	String firstname;
	String lastname;
	@Id	
	String emailid;
	String password;	
	int managerid;
	String designation;	
	int employeeid;
	String mobile;
	String dateofjoining;	
	int supportid;
	
	
	int userid;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	@Transient
	int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Transient
	int newmanagerid;
	@Transient
	int newsupportid;
	@Transient
	int newemployeeid;
	
	

	String status;
	
	@GeneratedValue
	int auto;
	
	public int getAuto() {
		return auto;
	}
	public void setAuto(int auto) {
		this.auto = auto;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getNewmanagerid() {
		return newmanagerid;
	}
	public void setNewmanagerid(int newmanagerid) {
		this.newmanagerid = newmanagerid;
	}
	public int getNewemployeeid() {
		return newemployeeid;
	}
	public void setNewemployeeid(int newemployeeid) {
		this.newemployeeid = newemployeeid;
	}
	public int getNewsupportid() {
		return newsupportid;
	}
	public void setNewsupportid(int newsupportid) {
		this.newsupportid = newsupportid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getManagerid() {
		return managerid;
	}
	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getDateofjoining() {
		return dateofjoining;
	}
	public void setDateofjoining(String dateofjoining) {
		this.dateofjoining = dateofjoining;
	}
	public int getSupportid() {
		return supportid;
	}
	public void setSupportid(int supportid) {
		this.supportid = supportid;
	}
}
