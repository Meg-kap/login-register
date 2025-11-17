package model;

public class User implements java.io.Serializable {
	
	private Integer id;
	private String nameSei;
	private String nameMei;
	private String nameSeiKana;
	private String nameMeiKana;
//	private LocalDate birthday;
	private String gender;
	private String email;
	private String mobile;
	private String post;
	private String pref;
	private String address;
	private String password;
	
	public User() {}
	public User(
		    String nameSei,
		    String nameMei,
		    String nameSeiKana,
		    String nameMeiKana,
//		    LocalDate birthday,
		    String gender,
		    String email,
		    String mobile,
		    String post,
		    String pref,
		    String address,
		    String password
		) {
		    this.nameSei = nameSei;
		    this.nameMei = nameMei;
		    this.nameSeiKana = nameSeiKana;
		    this.nameMeiKana = nameMeiKana;
//		    this.birthday = birthday;
		    this.gender = gender;
		    this.email = email;
		    this.mobile = mobile;
		    this.post = post;
		    this.pref = pref;
		    this.address = address;
		    this.password = password;
		}

	//getter
	public String getName() { 
	    return this.nameSei + " " + this.nameMei;
	}
	
	public String getNameSei() { 
		return this.nameSei;}
	
	public String getNameMei() { 
		return  this.nameMei;}
	
	public String getNameSeiKana() { 
		return this.nameSeiKana;}
	
	public String getNameMeiKana() { 
		return this.nameMeiKana;}
	
	public String getGender() {
	    return gender;
	}

	public String getEmail() {
	    return email;
	}

	public String getMobile() {
	    return mobile;
	}

	public String getPost() {
	    return post;
	}

	public String getPref() {
	    return pref;
	}

	public String getAddress() {
	    return address;
	}
	
	public String getPassword() {
	    return password;
	}
	
	//setter
	public void setNameSei(String nameSei) {
	    this.nameSei = nameSei;
	}

	public void setNameMei(String nameMei) {
	    this.nameMei = nameMei;
	}

	public void setNameSeiKana(String nameSeiKana) {
	    this.nameSeiKana = nameSeiKana;
	}

	public void setNameMeiKana(String nameMeiKana) {
	    this.nameMeiKana = nameMeiKana;
	}

	public void setGender(String gender) {
	    this.gender = gender;
	}

	public void setEmail(String email) {
	    this.email = email;
	}

	public void setMobile(String mobile) {
	    this.mobile = mobile;
	}

	public void setPost(String post) {
	    this.post = post;
	}

	public void setPref(String pref) {
	    this.pref = pref;
	}

	public void setAddress(String address) {
	    this.address = address;
	}

	public void setPassword(String password) {
	    this.password = password;
	}

}
