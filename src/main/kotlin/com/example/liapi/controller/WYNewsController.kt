package com.example.liapi.controller


import com.example.liapi.base.MyResponse
import com.example.liapi.entity.Split
import com.example.liapi.entity.WYNews
import com.example.liapi.mapper.WYNewsMapper
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
class WYNewsController {

    @Autowired
    lateinit var wyNewsMapper: WYNewsMapper

    @ApiOperation(value = "增加wyNews")
    @RequestMapping(value = ["/wyNews/add"], method = [RequestMethod.POST])
    fun addWYNews(@RequestBody wyNews: WYNews) : MyResponse<Boolean> {
        var response = MyResponse(201, "标题或内容为空", false)
        if (wyNews.title.isNullOrBlank() || wyNews.path.isNullOrBlank()){
            return response
        }
        val list = wyNewsMapper.queryById(wyNews.path)
        if (list.isNotEmpty()){
            val value = wyNewsMapper.upWYNews(wyNews)
            if (value>0){
                response.msg = "该WYNews已存在,更新成功"
                response.code = 200
                response.data = true
                return response
            }
            response.msg = "该WYNews已存在,更新失败，存入数据库失败"
            return response
        }
        val value = wyNewsMapper.addWYNews(wyNews)
        if (value>0){
            response.msg = "添加成功"
            response.code = 200
            response.data = true
            return response
        }
        response.msg = "添加失败，存入数据库失败"
        return response
    }

    @ApiOperation(value = "删除wyNews")
    @RequestMapping(value = ["/wyNews/del"], method = [RequestMethod.POST])
    fun delWYNews(@RequestBody wyNews: WYNews) : MyResponse<Boolean> {
        var response = MyResponse(201, "WYNewsId为空", false)
        if (wyNews.path.isNullOrBlank()){
            return response
        }
        val value = wyNewsMapper.delWYNews(wyNews.path)
        if (value>0){
            response.msg = "删除成功"
            response.code = 200
            response.data = true
            return response
        }
        response.msg = "删除失败，从数据库删除失败"
        return response
    }

    @ApiOperation(value = "查询wyNews")
    @RequestMapping(value = ["/wyNews/listById"], method = [RequestMethod.POST])
    fun listWYNewsById(@RequestBody  wyNews: WYNews) : MyResponse<List<WYNews>> {
        val list = wyNewsMapper.queryById(wyNews.path)
        return MyResponse(200, "查询成功", list)
    }

    @ApiOperation(value = "wyNews列表")
    @RequestMapping(value = ["/wyNews/list"], method = [RequestMethod.POST])
    fun listWYNews(@RequestBody split: Split) : MyResponse<List<WYNews>> {
        PageHelper.startPage<WYNews>(split.pageNum?:1, split.pageSize?:20)
        val list = wyNewsMapper.listWYNews()
        return MyResponse(200, "查询成功", list)
    }
}