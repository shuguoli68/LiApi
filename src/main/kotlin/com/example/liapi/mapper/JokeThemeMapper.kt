package com.example.liapi.mapper

import com.example.liapi.entity.Joke
import com.example.liapi.entity.JokeTheme
import com.github.pagehelper.Page
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update
import org.springframework.stereotype.Repository

@Repository
interface JokeThemeMapper {
    @Insert("INSERT INTO `joke_theme` VALUES(#{joke_themeId,jdbcType=VARCHAR},#{title,jdbcType=VARCHAR})")
    fun addJokeTheme(joke_theme: JokeTheme):Int

    @Delete("DELETE FROM `joke_theme` WHERE joke_theme_id = #{joke_themeId,jdbcType=VARCHAR}")
    fun delJokeTheme(joke_themeId: String):Int

    @Update("UPDATE `joke_theme`\n" +
            "        SET title = #{title,jdbcType=VARCHAR}, content = #{content,jdbcType=VARCHAR}\n" +
            "        WHERE joke_theme_id = #{joke_themeId,jdbcType=VARCHAR}")
    fun upJokeTheme(joke_theme: JokeTheme):Int

    @Select("SELECT * FROM `joke_theme` WHERE joke_theme_id = #{joke_themeId,jdbcType=VARCHAR}")
    fun queryById(joke_themeId:String):List<JokeTheme>

    @Select("select * from `joke_theme`")
    fun listJokeTheme():Page<JokeTheme>
}