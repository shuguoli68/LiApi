package com.example.liapi.controller


import com.example.liapi.base.MyResponse
import com.example.liapi.entity.Area
import com.example.liapi.entity.Split
import com.example.liapi.mapper.AreaMapper
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
class AreaCtl {

    @Autowired
    lateinit var areaMapper: AreaMapper

    @ApiOperation(value = "增加area")
    @RequestMapping(value = ["/area/add"], method = [RequestMethod.POST])
    fun addArea(@RequestBody area: Area) : MyResponse<Boolean> {
        var response = MyResponse(201, "标题或内容为空", false)
        if (area.areaId.isNullOrBlank() || area.area.isNullOrBlank()){
            return response
        }
        val list = areaMapper.queryById(area.areaId)
        if (list.isNotEmpty()){
            val value = areaMapper.upArea(area)
            if (value>0){
                response.msg = "该Area已存在,更新成功"
                response.code = 200
                response.data = true
                return response
            }
            response.msg = "该Area已存在,更新失败，存入数据库失败"
            return response
        }
        val value = areaMapper.addArea(area)
        if (value>0){
            response.msg = "添加成功"
            response.code = 200
            response.data = true
            return response
        }
        response.msg = "添加失败，存入数据库失败"
        return response
    }

    @ApiOperation(value = "删除area")
    @RequestMapping(value = ["/area/del"], method = [RequestMethod.POST])
    fun delArea(@RequestBody area: Area) : MyResponse<Boolean> {
        var response = MyResponse(201, "AreaId为空", false)
        if (area.areaId.isNullOrBlank()){
            return response
        }
        val value = areaMapper.delArea(area.areaId)
        if (value>0){
            response.msg = "删除成功"
            response.code = 200
            response.data = true
            return response
        }
        response.msg = "删除失败，从数据库删除失败"
        return response
    }

    @ApiOperation(value = "查询area")
    @RequestMapping(value = ["/area/listById"], method = [RequestMethod.POST])
    fun listById(@RequestBody area: Area) : MyResponse<List<Area>> {
        val list = areaMapper.queryById(area.areaId)
        return MyResponse(200,"查询成功",list)
    }

    @ApiOperation(value = "查询area列表")
    @RequestMapping(value = ["/area/list"], method = [RequestMethod.POST])
    fun listArea(@RequestBody split: Split) : MyResponse<List<Area>> {
        PageHelper.startPage<Area>(split.pageNum?:1, split.pageSize?:20)
        val list = areaMapper.listArea()
        return MyResponse(200, "查询成功", list)
    }
}