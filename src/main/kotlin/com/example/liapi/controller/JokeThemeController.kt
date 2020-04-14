package com.example.liapi.controller

import com.example.liapi.base.MyResponse
import com.example.liapi.entity.JokeTheme
import com.example.liapi.entity.Province
import com.example.liapi.entity.Split
import com.example.liapi.mapper.JokeThemeMapper
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
class JokeThemeController {

    @Autowired
    lateinit var jokeThemeMapper: JokeThemeMapper

    @ApiOperation(value = "增加jokeTheme")
    @RequestMapping(value = ["/jokeTheme/add"], method = [RequestMethod.POST])
    fun addJokeTheme(@RequestBody jokeTheme: JokeTheme) : MyResponse<Boolean> {
        var response = MyResponse(201, "标题或内容为空", false)
        if (jokeTheme.title.isNullOrBlank() || jokeTheme.title.isNullOrBlank()){
            return response
        }
        val list = jokeThemeMapper.queryById(jokeTheme.themeId)
        if (list.isNotEmpty()){
            val value = jokeThemeMapper.upJokeTheme(jokeTheme)
            if (value > 0){
                response.msg = "该JokeTheme已存在，更新成功"
                response.code = 200
                response.data = true
                return response
            }
            response.msg = "该JokeTheme已存在，更新失败，存入数据库失败"
            return response
        }
        val value = jokeThemeMapper.addJokeTheme(jokeTheme)
        if (value>0){
            response.msg = "添加成功"
            response.code = 200
            response.data = true
            return response
        }
        response.msg = "添加失败，存入数据库失败"
        return response
    }

    @ApiOperation(value = "删除jokeTheme")
    @RequestMapping(value = ["/jokeTheme/del"], method = [RequestMethod.POST])
    fun delJokeTheme(@RequestBody jokeTheme: JokeTheme) : MyResponse<Boolean> {
        var response = MyResponse(201, "JokeThemeId为空", false)
        if (jokeTheme.themeId.isNullOrBlank()){
            return response
        }
        val value = jokeThemeMapper.delJokeTheme(jokeTheme.themeId)
        if (value>0){
            response.msg = "删除成功"
            response.code = 200
            response.data = true
            return response
        }
        response.msg = "删除失败，从数据库删除失败"
        return response
    }

    @ApiOperation(value = "查询jokeTheme")
    @RequestMapping(value = ["/jokeTheme/listById"], method = [RequestMethod.POST])
    fun listProvincesById(@RequestBody jokeTheme: JokeTheme) : MyResponse<List<JokeTheme>> {
        var response = MyResponse(201, "JokeThemeId为空", listOf<JokeTheme>())
        if (jokeTheme.themeId.isNullOrBlank()){
            return response
        }
        val list = jokeThemeMapper.queryById(jokeTheme.themeId)
        response.msg = "查询成功"
        response.code = 200
        response.data = list
        return response
    }

    @ApiOperation(value = "jokeTheme列表")
    @RequestMapping(value = ["/jokeTheme/list"], method = [RequestMethod.POST])
    fun listJokeTheme(@RequestBody split: Split) : MyResponse<List<JokeTheme>> {
        PageHelper.startPage<JokeTheme>(split.pageNum?:1, split.pageSize?:20)
        val list = jokeThemeMapper.listJokeTheme()
        return MyResponse(200, "查询成功", list)
    }
}