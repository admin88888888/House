package com.ddhouse.house.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

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
@TableName("f_rules")
public class FRules extends Model<FRules> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 如：0-7%
     */
	private String commission;
    /**
     * 与房产关联（伪外键）
     */
	private Integer houseid;
	private String commissionrule;
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")

	private Date startdate;
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")

	private Date enddate;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCommission() {
		return commission;
	}

	public void setCommission(String commission) {
		this.commission = commission;
	}

	public Integer getHouseid() {
		return houseid;
	}

	public void setHouseid(Integer houseid) {
		this.houseid = houseid;
	}

	public String getCommissionrule() {
		return commissionrule;
	}

	public void setCommissionrule(String commissionrule) {
		this.commissionrule = commissionrule;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
