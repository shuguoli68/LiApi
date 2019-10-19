package com.example.liapi.base

data class MyResponse<T> (
        var code:Int,
        var msg:String,
        var data:T
)