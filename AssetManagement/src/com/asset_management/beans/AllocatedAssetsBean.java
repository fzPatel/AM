package com.asset_management.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="allocatedassets")
public class AllocatedAssetsBean {

	@Id
	@GeneratedValue
	int assetid;
	@Override
	public String toString() {
		return "AllocatedAssetsBean [assetid=" + assetid + ", userid=" + userid + ", assetname=" + assetname
				+ ", dateofallocation=" + dateofallocation + ", emailid=" + emailid + "]";
	}
	int userid;
	String assetname;
	String dateofallocation;
	String emailid;
	public int getAssetid() {
		return assetid;
	}
	public void setAssetid(int assetid) {
		this.assetid = assetid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getAssetname() {
		return assetname;
	}
	public void setAssetname(String assetname) {
		this.assetname = assetname;
	}
	public String getDateofallocation() {
		return dateofallocation;
	}
	public void setDateofallocation(String dateofallocation) {
		this.dateofallocation = dateofallocation;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}	
}
