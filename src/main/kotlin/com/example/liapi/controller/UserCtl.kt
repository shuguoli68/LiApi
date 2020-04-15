package com.example.liapi.controller

import com.example.liapi.base.MyResponse
import com.example.liapi.entity.Split
import com.example.liapi.entity.User
import com.example.liapi.mapper.UserMapper
import com.github.pagehelper.PageHelper
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController


@Api(value = "User", tags = arrayOf("操作User"))
@RestController
class UserCtl {

    @Autowired
    lateinit var userMapper: UserMapper

    @ApiOperation(value = "增加user")
    @RequestMapping(value = ["/user/add"], method = [RequestMethod.POST])
    fun addUser(@RequestBody user: User) : MyResponse<Boolean> {
        var response = MyResponse(201, "标题或内容为空", false)
        if (user.userId.isNullOrBlank()){
            return response
        }
        val list = userMapper.queryById(user.userId)
        if (list.isNotEmpty()){
            val value = userMapper.upUser(user)
            if (value>0){
                response.msg = "该User已存在,更新成功"
                response.code = 200
                response.data = true
                return response
            }
            response.code = 202
            response.msg = "该User已存在,更新失败，存入数据库失败"
            return response
        }
        val value = userMapper.addUser(user)
        if (value>0){
            response.msg = "添加成功"
            response.code = 200
            response.data = true
            return response
        }
        response.code = 202
        response.msg = "添加失败，存入数据库失败"
        return response
    }

    @ApiOperation(value = "删除user")
    @RequestMapping(value = ["/user/del"], method = [RequestMethod.POST])
    fun delUser(@RequestBody user: User) : MyResponse<Boolean> {
        var response = MyResponse(201, "UserId为空", false)
        if (user.userId.isNullOrBlank()){
            return response
        }
        val value = userMapper.delUser(user.userId)
        if (value>0){
            response.msg = "删除成功"
            response.code = 200
            response.data = true
            return response
        }
        response.code = 202
        response.msg = "删除失败，从数据库删除失败"
        return response
    }

    @ApiOperation(value = "根据ID查询user")
    @RequestMapping(value = ["/user/listById"], method = [RequestMethod.POST])
    fun listUserById(@RequestBody  user: User) : MyResponse<List<User>> {
        var response = MyResponse(201, "UserId为空", listOf<User>())
        if (user.userId.isNullOrBlank()){
           return response
        }
        val list = userMapper.queryById(user.userId)
        return MyResponse(200, "查询成功", list)
    }

    @ApiOperation(value = "user列表")
    @RequestMapping(value = ["/user/list"], method = [RequestMethod.POST])
    fun listUser(@RequestBody split: Split) : MyResponse<List<User>> {
        PageHelper.startPage<User>(split.pageNum?:1, split.pageSize?:20)
        val list = userMapper.listUser()
        return MyResponse(200, "查询成功", list)
    }
}