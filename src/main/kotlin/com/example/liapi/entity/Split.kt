package com.example.liapi.entity

/**
 * 列表的分页
 */
data class Split(
        var pageNum:Int? = 1,
        var pageSize:Int? = 20
)