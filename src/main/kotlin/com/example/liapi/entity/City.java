package com.example.liapi.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * 省市区-市
 */
@ApiModel(value = "City",description = "省市区-市")
public class City {
    @ApiModelProperty(value = "表自增的id")
    private int id;
    @ApiModelProperty(value = "市的id")
    private String cityId;
    @ApiModelProperty(value = "市的名称")
    private String city;
    @ApiModelProperty(value = "市所在省的id")
    private String provinceId;
    @ApiModelProperty(value = "市包含的所有区")
    private List<Area> areas = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }
}
