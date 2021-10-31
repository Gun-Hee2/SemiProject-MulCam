package our.own.trip.dto;

import java.io.Serializable;

public class MemberDto implements Serializable{
	
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String gender;
	private int auth;		// 유저:1 관리자:0
	
	public MemberDto() {
		
	}

	public MemberDto(String id, String pwd, String name, String email, String gender, int auth) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.auth = auth;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAuth() {
		return auth;
	}

	public void setAuth(int auth) {
		this.auth = auth;
	}

	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email + ", gender=" + gender
				+ ", auth=" + auth + "]";
	}

	
	
	

}
