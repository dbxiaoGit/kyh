package kyh.entity.master;

import java.util.Date;

public class User {
	private Long id;
	private String membercode;
	private String user_name;
	private String mobile;
	private String trade_password;
	private String idcard;
	private String reg_channel;
	private String gender;
	private String race;
	private String birthdate;
	private String address;
	private String valid_date;
	private String id_expired_time;
	private Date created_time;
	private Date updated_time;
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMembercode() {
		return membercode;
	}
	public void setMembercode(String membercode) {
		this.membercode = membercode;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getTrade_password() {
		return trade_password;
	}
	public void setTrade_password(String trade_password) {
		this.trade_password = trade_password;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getReg_channel() {
		return reg_channel;
	}
	public void setReg_channel(String reg_channel) {
		this.reg_channel = reg_channel;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getValid_date() {
		return valid_date;
	}
	public void setValid_date(String valid_date) {
		this.valid_date = valid_date;
	}
	public String getId_expired_time() {
		return id_expired_time;
	}
	public void setId_expired_time(String id_expired_time) {
		this.id_expired_time = id_expired_time;
	}
	public Date getCreated_time() {
		return created_time;
	}
	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
	}
	public Date getUpdated_time() {
		return updated_time;
	}
	public void setUpdated_time(Date updated_time) {
		this.updated_time = updated_time;
	}
	
}
