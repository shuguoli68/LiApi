package com.example.liapi

import com.example.liapi.controller.JokeThemeCtl
import com.example.liapi.entity.JokeTheme
import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.runApplication

@MapperScan("com.example.liapi.mapper")
@SpringBootApplication
class LiapiApplication

fun main(args: Array<String>) {
    runApplication<LiapiApplication>(*args)
//    Thread{
//        addJokeTheme()
//    }.start()
}

@Override
fun configure(builder: SpringApplicationBuilder) : SpringApplicationBuilder {
    return builder.sources(LiapiApplication::class.java)
}

private fun addJokeTheme(){
    val str = "|全部|冷笑话|幽默|爱情|夫妻|爆笑男女|爆笑|综合|儿童|校园|简短|经典|整人|动物|恐怖|英语|内涵|小笑话|短信|短笑话|一句话|极品|数学|超级|短篇|四川方言|顺口溜|名著暴笑|搞笑歌词|恋爱必读|求爱秘籍|原创|哈哈趣闻|数码|搞笑|各地方言|重口味|"
    val titles = str.split("|")
    val a = JokeThemeCtl()
    val theme = JokeTheme()
    for (i in titles.indices) {
        theme.id = 0
        theme.title = titles[i]
        theme.themeId = (1000+i).toString()
        theme.brief = titles[i]+"搞笑的吹牛、内涵冷段子"
        theme.picUrl = "http://${i}hui${i}.png"
        theme.count = 1
        a.addJokeTheme(theme)
    }
}