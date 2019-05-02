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
@TableName("f_home")
public class FHome extends Model<FHome> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private String area;
    /**
     * 租房方式
     */
	private String htype;
	private String hpicture;
	private String address;
	private Integer price;
	private String hdescribe;
	private String region;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getHtype() {
		return htype;
	}

	public void setHtype(String htype) {
		this.htype = htype;
	}

	public String getHpicture() {
		return hpicture;
	}

	public void setHpicture(String hpicture) {
		this.hpicture = hpicture;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getHdescribe() {
		return hdescribe;
	}

	public void setHdescribe(String hdescribe) {
		this.hdescribe = hdescribe;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
