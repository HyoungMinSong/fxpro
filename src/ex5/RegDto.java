package ex5;

import java.util.ArrayList;

public class RegDto {
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPwCf() {
		return pwCf;
	}
	public void setPwCf(String pwCf) {
		this.pwCf = pwCf;
	}
	
	public String getAgeGroup() {
		return ageGroup;
	}
	public void setAgeGroup(String ageGroup) {
		this.ageGroup = ageGroup;
	}
	public ArrayList<String> getHobby() {
		return hobby;
	}

	private String name;
	private String id;
	private String pw;
	private String pwCf;
	private String sex;
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setHobby(ArrayList<String> hobby) {
		this.hobby = hobby;
	}

	private String ageGroup;
	private ArrayList<String> hobby;
	
	
}
