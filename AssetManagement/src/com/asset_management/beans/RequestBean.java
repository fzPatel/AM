package com.asset_management.beans;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="request")
public class RequestBean {
		int userid;
		int assetid;
		String emailid;
		
		public String getEmailid() {
			return emailid;
		}
		public void setEmailid(String emailid) {
			this.emailid = emailid;
		}
		public int getAssetid() {
			return assetid;
		}
		public void setAssetid(int assetid) {
			this.assetid = assetid;
		}
		String dateofallocation;
		public String getDateofallocation() {
			return dateofallocation;
		}
		public void setDateofallocation(String dateofallocation) {
			this.dateofallocation = dateofallocation;
		}
		public int getUserid() {
			return userid;
		}
		public void setUserid(int userid) {
			this.userid = userid;
		}
		@Transient
		int usersession;
		public int getUsersession() {
			return usersession;
		}
		public void setUsersession(int usersession) {
			this.usersession = usersession;
		}
		@Id
		@GeneratedValue
		int requestid;
		@Override
		public String toString() {
			return "RequestBean [userid=" + userid + ", assetid=" + assetid + ", emailid=" + emailid
					+ ", dateofallocation=" + dateofallocation + ", usersession=" + usersession + ", requestid="
					+ requestid + ", employeeid=" + employeeid + ", managerid=" + managerid + ", managerapproveddate="
					+ managerapproveddate + ", assetname=" + assetname + ", requestdate=" + requestdate + ", status="
					+ status + ", " + ", remarks=" + remarks + "]";
		}
		int employeeid;
		int managerid;
		String managerapproveddate;
		String assetname;
		String requestdate;
		int status;
		public int getRequestid() {
			return requestid;
		}
		public void setRequestid(int requestid) {
			this.requestid = requestid;
		}
		public int getEmployeeid() {
			return employeeid;
		}
		public void setEmployeeid(int employeeid) {
			this.employeeid = employeeid;
		}
		public int getManagerid() {
			return managerid;
		}
		public void setManagerid(int managerid) {
			this.managerid = managerid;
		}
		public String getManagerapproveddate() {
			return managerapproveddate;
		}
		public void setManagerapproveddate(String managerapproveddate) {
			this.managerapproveddate = managerapproveddate;
		}
		public String getAssetname() {
			return assetname;
		}
		public void setAssetname(String assetname) {
			this.assetname = assetname;
		}
		public String getRequestdate() {
			return requestdate;
		}
		public void setRequestdate(String requestdate) {
			this.requestdate = requestdate;
		}
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}
		
		

		int supportid;
		
		
		public String getRemarks() {
			return remarks;
		}
		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}
		String remarks;

		public int getSupportid() {
			return supportid;
		}
		public void setSupportid(int supportid) {
			this.supportid = supportid;
		}
		
		
		String designation;

		public String getDesignation() {
			return designation;
		}
		public void setDesignation(String designation) {
			this.designation = designation;
		}
		
		
		
}
