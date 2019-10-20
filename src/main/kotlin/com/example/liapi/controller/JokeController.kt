package com.example.liapi.controller

import com.example.liapi.base.MyResponse
import com.example.liapi.entity.Joke
import com.example.liapi.entity.Split
import com.example.liapi.mapper.JokeMapper
import com.github.pagehelper.Page
import com.github.pagehelper.PageHelper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class JokeController {

    @Autowired
    lateinit var jokeMapper: JokeMapper

    @RequestMapping(value = ["/joke/add"], method = [RequestMethod.POST])
    fun addJoke(@RequestBody joke: Joke) : MyResponse<Boolean> {
        var response = MyResponse(201, "标题或内容为空", false)
        if (joke.jokeId.isNullOrBlank() || joke.content.isNullOrBlank()){
            return response
        }
        val list = jokeMapper.queryById(joke.jokeId)
        if (list.isNotEmpty()){
            val value = jokeMapper.upJoke(joke)
            if (value>0){
                response.msg = "该Joke已存在，更新成功"
                response.code = 200
                response.data = true
                return response
            }
            response.msg = "该Joke已存在，更新失败，存入数据库失败"
            return response
        }
        val value = jokeMapper.addJoke(joke)
        if (value>0){
            response.msg = "添加成功"
            response.code = 200
            response.data = true
            return response
        }
        response.msg = "添加失败，存入数据库失败"
        return response
    }

    @RequestMapping(value = ["/joke/del"], method = [RequestMethod.POST])
    fun delJoke(@RequestBody joke: Joke) : MyResponse<Boolean> {
        var response = MyResponse(201, "JokeId为空", false)
        if (joke.jokeId.isNullOrBlank()){
            return response
        }
        val value = jokeMapper.delJoke(joke.jokeId)
        if (value>0){
            response.msg = "删除成功"
            response.code = 200
            response.data = true
            return response
        }
        response.msg = "删除失败，从数据库删除失败"
        return response
    }

    @RequestMapping(value = ["/joke/listByThemeId"], method = [RequestMethod.POST])
    fun listByThemeId(@RequestBody request:Map<String, Any>) : MyResponse<List<Joke>> {
        val pageNum = request["pageNum"] as Int
        val pageSize = request["pageSize"] as Int
        val themeId = request["themeId"] as String
        if (pageNum == null || pageSize == null || themeId.isNullOrBlank()){
            return MyResponse(201, "查询失败，参数错误", Page<Joke>())
        }
        PageHelper.startPage<Joke>(pageNum, pageSize)
        val list = jokeMapper.listByThemeId(themeId)
        return MyResponse(200, "查询成功", list)
    }

    @RequestMapping(value = ["/joke/list"], method = [RequestMethod.POST])
    fun listJoke(@RequestBody split: Split) : MyResponse<List<Joke>> {
        PageHelper.startPage<Joke>(split.pageNum?:1, split.pageSize?:20)
        val list = jokeMapper.listJoke()
        return MyResponse(200, "查询成功", list)
    }
}