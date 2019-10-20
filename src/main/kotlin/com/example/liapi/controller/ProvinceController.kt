package com.example.liapi.controller

import com.example.liapi.base.MyResponse
import com.example.liapi.entity.Province
import com.example.liapi.entity.Split
import com.example.liapi.mapper.ProvinceMapper
import com.github.pagehelper.PageHelper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class ProvinceController {

    @Autowired
    lateinit var provinceMapper: ProvinceMapper

    @RequestMapping(value = ["/province/add"], method = [RequestMethod.POST])
    fun addProvinces(@RequestBody province: Province) : MyResponse<Boolean> {
        var response = MyResponse(201, "标题或内容为空", false)
        if (province.provinceId==null || province.province.isNullOrBlank()){
            return response
        }
        val list = provinceMapper.queryById(province.provinceId)
        if (list.isNotEmpty()){
            val value = provinceMapper.upProvinces(province)
            if (value>0){
                response.msg = "该Provinces已存在,更新成功"
                response.code = 200
                response.data = true
                return response
            }
            response.msg = "该Provinces已存在,更新失败，存入数据库失败"
            return response
        }
        val value = provinceMapper.addProvinces(province)
        if (value>0){
            response.msg = "添加成功"
            response.code = 200
            response.data = true
            return response
        }
        response.msg = "添加失败，存入数据库失败"
        return response
    }

    @RequestMapping(value = ["/province/del"], method = [RequestMethod.POST])
    fun delProvinces(@RequestBody province: Province) : MyResponse<Boolean> {
        var response = MyResponse(201, "ProvincesId为空", false)
        if (province.provinceId == null){
            return response
        }
        val value = provinceMapper.delProvinces(province.provinceId)
        if (value>0){
            response.msg = "删除成功"
            response.code = 200
            response.data = true
            return response
        }
        response.msg = "删除失败，从数据库删除失败"
        return response
    }

    @RequestMapping(value = ["/province/listById"], method = [RequestMethod.POST])
    fun listProvincesById(@RequestBody province: Province) : MyResponse<List<Province>> {
        var response = MyResponse(201, "provinceId为空", listOf<Province>())
        if (province.provinceId==null){
            return response
        }
        val list = provinceMapper.queryById(province.provinceId)
        response.msg = "查询成功"
        response.code = 200
        response.data = list
        return response
    }

    @RequestMapping(value = ["/province/list"], method = [RequestMethod.POST])
    fun listProvinces(@RequestBody split: Split) : MyResponse<List<Province>> {
        PageHelper.startPage<Province>(split.pageNum?:1, split.pageSize?:20)
        val list = provinceMapper.listProvinces()
        return MyResponse(200, "查询成功", list)
    }
}