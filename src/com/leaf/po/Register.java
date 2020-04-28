package com.leaf.po;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class Register {

    private String r_email;
    private String r_password;
    private String r_name;
    private String r_gender;
    private String r_id;
    private Date r_birthday;
    
	public String getR_email() {
		return r_email;
	}
	public void setR_email(String r_email) {
		this.r_email = r_email;
	}
	public String getR_password() {
		return r_password;
	}
	public void setR_password(String r_password) {
		this.r_password = r_password;
	}
	public String getR_name() {
		return r_name;
	}
	public void setR_name(String r_name) {
		this.r_name = r_name;
	}
	public String getR_gender() {
		return r_gender;
	}
	public void setR_gender(String r_gender) {
		this.r_gender = r_gender;
	}
	public String getR_id() {
		return r_id;
	}
	public void setR_id(String r_id) {
		this.r_id = r_id;
	}
	public Date getR_birthday() {
		return r_birthday;
	}
	public void setR_birthday(Date r_birthday) {
		this.r_birthday = r_birthday;
	}

}