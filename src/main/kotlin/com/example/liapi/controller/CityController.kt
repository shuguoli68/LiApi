package com.example.liapi.controller


import com.example.liapi.base.MyResponse
import com.example.liapi.entity.City
import com.example.liapi.entity.Joke
import com.example.liapi.entity.Province
import com.example.liapi.entity.Split
import com.example.liapi.mapper.CityMapper
import com.github.pagehelper.Page
import com.github.pagehelper.PageHelper
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@Api(value = "AreaController", tags = arrayOf("操作Area，增删改查"))
@RestController
class CityController {

    @Autowired
    lateinit var cityMapper: CityMapper

    @ApiOperation(value = "增加city")
    @RequestMapping(value = ["/city/add"], method = [RequestMethod.POST])
    fun addCity(@RequestBody city: City) : MyResponse<Boolean> {
        var response = MyResponse(201, "标题或内容为空", false)
        if (city.cityId.isNullOrBlank() || city.city.isNullOrBlank()){
            return response
        }
        val list = cityMapper.queryById(city.cityId)
        if (list.isNotEmpty()){
            val value = cityMapper.upCity(city)
            if (value>0){
                response.msg = "该City已存在,更新成功"
                response.code = 200
                response.data = true
                return response
            }
            response.msg = "该City已存在,更新失败，存入数据库失败"
            return response
        }
        val value = cityMapper.addCity(city)
        if (value>0){
            response.msg = "添加成功"
            response.code = 200
            response.data = true
            return response
        }
        response.msg = "添加失败，存入数据库失败"
        return response
    }

    @ApiOperation(value = "删除city")
    @RequestMapping(value = ["/city/del"], method = [RequestMethod.POST])
    fun delCity(@RequestBody city: City) : MyResponse<Boolean> {
        var response = MyResponse(201, "CityId为空", false)
        if (city.cityId.isNullOrBlank()){
            return response
        }
        val value = cityMapper.delCity(city.cityId)
        if (value>0){
            response.msg = "删除成功"
            response.code = 200
            response.data = true
            return response
        }
        response.msg = "删除失败，从数据库删除失败"
        return response
    }

    @ApiOperation(value = "查询city")
    @RequestMapping(value = ["/city/query"], method = [RequestMethod.POST])
    fun queryCA(@RequestBody city: City) : MyResponse<City> {
        val pro = cityMapper.queryCA(city.cityId)
        return MyResponse(200, "查询成功", pro)
    }

    @ApiOperation(value = "city列表")
    @RequestMapping(value = ["/city/list"], method = [RequestMethod.POST])
    fun listCity(@RequestBody split: Split) : MyResponse<Page<City>> {
        PageHelper.startPage<City>(split.pageNum?:1, split.pageSize?:20)
        val list = cityMapper.listCity()
        return MyResponse(200, "查询成功", list)
    }
}