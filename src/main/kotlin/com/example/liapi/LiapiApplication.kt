package com.example.liapi

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@MapperScan("com.example.liapi.mapper")
@SpringBootApplication
class LiapiApplication

fun main(args: Array<String>) {
    runApplication<LiapiApplication>(*args)
}
