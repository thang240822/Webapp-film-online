package edu.com.model.repport;

import java.util.Date;

public class FavoriteReport {
  String videotitle;
  Long favoriteCount;
  Date newdate;
  Date olddate;
  public FavoriteReport() {
	// TODO Auto-generated constructor stub
}
public FavoriteReport(String videotitle, Long favoriteCount, Date newdate, Date olddate) {

	this.videotitle = videotitle;
	this.favoriteCount = favoriteCount;
	this.newdate = newdate;
	this.olddate = olddate;
}
public String getVideotitle() {
	return videotitle;
}
public void setVideotitle(String videotitle) {
	this.videotitle = videotitle;
}
public Long getFavoriteCount() {
	return favoriteCount;
}
public void setFavoriteCount(Long favoriteCount) {
	this.favoriteCount = favoriteCount;
}
public Date getNewdate() {
	return newdate;
}
public void setNewdate(Date newdate) {
	this.newdate = newdate;
}
public Date getOlddate() {
	return olddate;
}
public void setOlddate(Date olddate) {
	this.olddate = olddate;
}
  
}
