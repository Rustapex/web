package notice;

import java.util.Date;

public class Notice {
	String notice_id;
	String title;
	java.util.Date date;
	public Notice() {
		
	}
	public Notice(String notice_id, String title, Date date) {
		
		this.notice_id = notice_id;
		this.title = title;
		this.date = date;
	}
	public String getNotice_id() {
		return notice_id;
	}
	public void setNotice_id(String notice_id) {
		this.notice_id = notice_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public java.util.Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Notice [notice_id=" + notice_id + ", title=" + title + ", date=" + date + "]";
	}
	
	
}
