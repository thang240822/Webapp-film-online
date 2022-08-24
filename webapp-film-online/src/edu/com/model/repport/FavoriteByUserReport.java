package edu.com.model.repport;

import java.util.Date;

public class FavoriteByUserReport {
 String id;
 String fullname;
 String email;
 Date likeDate;
 public FavoriteByUserReport() {
	// TODO Auto-generated constructor stub
}
public FavoriteByUserReport(String id, String fullname, String email, Date likeDate) {
	super();
	this.id = id;
	this.fullname = fullname;
	this.email = email;
	this.likeDate = likeDate;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getFullname() {
	return fullname;
}
public void setFullname(String fullname) {
	this.fullname = fullname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Date getLikeDate() {
	return likeDate;
}
public void setLikeDate(Date likeDate) {
	this.likeDate = likeDate;
}
 
}
