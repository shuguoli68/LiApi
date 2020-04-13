package com.example.liapi.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 省市区-区
 */
@ApiModel(value = "Area",description = "省市区-区")
public class Area {
    @ApiModelProperty(value = "表自增的id")
    private int id;
    @ApiModelProperty(value = "区的id")
    private String areaId;
    @ApiModelProperty(value = "区的名称")
    private String area;
    @ApiModelProperty(value = "区所在市的id")
    private String cityId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }
}
