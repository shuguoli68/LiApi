package com.example.liapi.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * 省市区-省
 */
@ApiModel(value = "Province",description = "省市区-省")
public class Province {
    @ApiModelProperty(value = "表自增的id")
    private int id = 0;
    @ApiModelProperty(value = "省的id")
    private int provinceId = 0;
    @ApiModelProperty(value = "省的名称")
    private String province = "";
    @ApiModelProperty(value = "省下辖的所有市")
    private List<City> cities = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
