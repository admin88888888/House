package com.ddhouse.house.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author cyx
 * @since 2019-04-27
 */
@TableName("f_houseparticulars")
public class FHouseparticulars extends Model<FHouseparticulars> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private Integer houseid;
	private String address;
    /**
     * 海外/国内
     */
	private String type;
    /**
     * 1 顺销 ...
     */
	private Integer marketing;
	private Integer recustomer;
	private Integer takecustomer;
	private Integer overcustomer;
	private Integer partner;
	private Integer homesum;
	private String map;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getHouseid() {
		return houseid;
	}

	public void setHouseid(Integer houseid) {
		this.houseid = houseid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getMarketing() {
		return marketing;
	}

	public void setMarketing(Integer marketing) {
		this.marketing = marketing;
	}

	public Integer getRecustomer() {
		return recustomer;
	}

	public void setRecustomer(Integer recustomer) {
		this.recustomer = recustomer;
	}

	public Integer getTakecustomer() {
		return takecustomer;
	}

	public void setTakecustomer(Integer takecustomer) {
		this.takecustomer = takecustomer;
	}

	public Integer getOvercustomer() {
		return overcustomer;
	}

	public void setOvercustomer(Integer overcustomer) {
		this.overcustomer = overcustomer;
	}

	public Integer getPartner() {
		return partner;
	}

	public void setPartner(Integer partner) {
		this.partner = partner;
	}

	public Integer getHomesum() {
		return homesum;
	}

	public void setHomesum(Integer homesum) {
		this.homesum = homesum;
	}

	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
