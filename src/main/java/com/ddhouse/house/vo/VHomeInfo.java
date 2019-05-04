package com.ddhouse.house.vo;

import com.ddhouse.house.entity.FHomedetails;
import com.ddhouse.house.entity.FHomemerit;
import lombok.Data;

import java.util.List;

@Data
public class VHomeInfo {

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

    private List<FHomemerit> meritList;
    private FHomedetails homedetails;
}
