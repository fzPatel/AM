package com.asset_management.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="AssetTransfer")
public class AssetTransferBean 
{

@Id
@GeneratedValue
int transferid;

int fromempid;
int managerid;
int assetid;
String assetname;
int toempid;
String transferrequestdate;

@Column(columnDefinition = "varchar(15) default null")
String transferdate;


@Column(columnDefinition = "int default 0")
int transferstatus;




public String getTransferrequestdate() {
	return transferrequestdate;
}
public void setTransferrequestdate(String transferrequestdate) {
	this.transferrequestdate = transferrequestdate;
}
public int getTransferid() {
	return transferid;
}
public void setTransferid(int transferid) {
	this.transferid = transferid;
}
public int getFromempid() {
	return fromempid;
}
public void setFromempid(int fromempid) {
	this.fromempid = fromempid;
}
public int getManagerid() {
	return managerid;
}
public void setManagerid(int managerid) {
	this.managerid = managerid;
}
public int getAssetid() {
	return assetid;
}
public void setAssetid(int assetid) {
	this.assetid = assetid;
}
public String getAssetname() {
	return assetname;
}
public void setAssetname(String assetname) {
	this.assetname = assetname;
}
public int getToempid() {
	return toempid;
}
public void setToempid(int toempid) {
	this.toempid = toempid;
}
public String getTransferdate() {
	return transferdate;
}
public void setTransferdate(String transferdate) {
	this.transferdate = transferdate;
}
public int getTransferstatus() {
	return transferstatus;
}
public void setTransferstatus(int transferstatus) {
	this.transferstatus = transferstatus;
}


}