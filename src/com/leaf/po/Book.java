package com.leaf.po;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class Book {

    private String b_name;
    private String b_id;
    private Date p_date;
    private Integer b_type;
    private String pub;

	public String getB_name(){
		return b_name;
	}

	public String getB_id(){
		return b_id;
	}

	public Date getP_date(){
		return p_date;
	}

	public Integer getB_type(){
		return b_type;
	}

	public String getPub(){
		return pub;
	}

	public void setB_name(String b_name){
		this.b_name=b_name;
	}

	public void setB_id(String b_id){
		this.b_id=b_id;
	}

	public void setP_date(Date p_date){
		this.p_date=p_date;
	}

	public void setB_type(Integer b_type){
		this.b_type=b_type;
	}

	public void setPub(String pub){
		this.pub=pub;
	}

}