package com.example.liapi.controller

import com.example.liapi.base.MyResponse
import com.example.liapi.entity.JokeTheme
import com.example.liapi.entity.Split
import com.example.liapi.mapper.JokeMapper
import com.example.liapi.mapper.JokeThemeMapper
import com.github.pagehelper.PageHelper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class JokeThemeController {

    @Autowired
    lateinit var jokeThemeMapper: JokeThemeMapper

    @RequestMapping(value = ["/jokeTheme/add"], method = [RequestMethod.POST])
    fun addJokeTheme(@RequestBody jokeTheme: JokeTheme) : MyResponse<Boolean> {
        var response = MyResponse(201, "标题或内容为空", false)
        if (jokeTheme.title.isNullOrBlank() || jokeTheme.title.isNullOrBlank()){
            return response
        }
        val list = jokeThemeMapper.queryById(jokeTheme.themeId)
        if (list.isNotEmpty()){
            response.msg = "添加失败，该JokeTheme已存在"
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

    @RequestMapping(value = ["/jokeTheme/update"], method = [RequestMethod.POST])
    fun upJokeTheme(@RequestBody jokeTheme: JokeTheme) : MyResponse<Boolean> {
        var response = MyResponse(201, "标题或内容为空", false)
        if (jokeTheme.title.isNullOrBlank() || jokeTheme.title.isNullOrBlank()){
            return response
        }
        val value = jokeThemeMapper.upJokeTheme(jokeTheme)
        if (value>0){
            response.msg = "修改成功"
            response.code = 200
            response.data = true
            return response
        }
        response.msg = "修改失败，存入数据库失败"
        return response
    }

    @RequestMapping(value = ["/jokeTheme/list"], method = [RequestMethod.POST])
    fun listJokeTheme(@RequestBody split: Split) : MyResponse<List<JokeTheme>> {
        PageHelper.startPage<JokeTheme>(split.pageNum?:1, split.pageSize?:20)
        val list = jokeThemeMapper.listJokeTheme()
        return MyResponse(200, "查询成功", list)
    }
}