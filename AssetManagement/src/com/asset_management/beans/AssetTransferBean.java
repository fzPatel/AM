package com.asset_management.beans;

import javax.persistence.Id;

public class AssetTransferBean 
{

@Id
int transferid;
int fromempid;
int managerid;
int assetid;
String assetname;
int toempid;
String transferdate;
int transferstatus;
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