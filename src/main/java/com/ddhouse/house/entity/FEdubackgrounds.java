package com.ddhouse.house.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author cyx
 * @since 2019-04-27
 */
@TableName("f_edubackgrounds")
public class FEdubackgrounds extends Model<FEdubackgrounds> {

    private static final long serialVersionUID = 1L;

	@TableId(value="uid", type= IdType.AUTO)
	private Integer uid;
	private String diplomainfo;
	private String school;
	private Date entertime;
	private Date cometime;
	private String education;


	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getDiplomainfo() {
		return diplomainfo;
	}

	public void setDiplomainfo(String diplomainfo) {
		this.diplomainfo = diplomainfo;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public Date getEntertime() {
		return entertime;
	}

	public void setEntertime(Date entertime) {
		this.entertime = entertime;
	}

	public Date getCometime() {
		return cometime;
	}

	public void setCometime(Date cometime) {
		this.cometime = cometime;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	@Override
	protected Serializable pkVal() {
		return this.uid;
	}

}
