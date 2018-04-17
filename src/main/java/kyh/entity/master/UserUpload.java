package kyh.entity.master;

import java.util.Date;

public class UserUpload {
	private Long id;
	private Long user_id;
	private Long type;
	private String file_path;
	private String url;
	private String ocr_result;
	private Date created_time;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public Long getType() {
		return type;
	}
	public void setType(Long type) {
		this.type = type;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getOcr_result() {
		return ocr_result;
	}
	public void setOcr_result(String ocr_result) {
		this.ocr_result = ocr_result;
	}
	public Date getCreated_time() {
		return created_time;
	}
	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
	}


}



