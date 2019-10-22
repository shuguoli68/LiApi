package com.example.liapi.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 省市区-省
 */
public class Province {
    private int id = 0;
    private int provinceId = 0;
    private String province = "";
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
