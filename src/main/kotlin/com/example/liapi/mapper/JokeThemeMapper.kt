package com.example.liapi.mapper

import com.example.liapi.entity.JokeTheme
import com.github.pagehelper.Page
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update
import org.springframework.stereotype.Repository

@Repository
interface JokeThemeMapper {
    @Insert("INSERT INTO `joke_theme` VALUES(#{id,jdbcType=INTEGER},#{themeId,jdbcType=VARCHAR},#{title,jdbcType=VARCHAR},#{brief,jdbcType=VARCHAR},#{picUrl,jdbcType=VARCHAR},#{count,jdbcType=INTEGER})")
    fun addJokeTheme(joke_theme: JokeTheme):Int

    @Delete("DELETE FROM `joke_theme` WHERE theme_id = #{themeId,jdbcType=VARCHAR}")
    fun delJokeTheme(joke_themeId: String):Int

    @Update("UPDATE `joke_theme`\n" +
            "        SET title = #{title,jdbcType=VARCHAR}, brief = #{brief,jdbcType=VARCHAR}, pic_url = #{picUrl,jdbcType=VARCHAR}, count = #{count,jdbcType=INTEGER}\n" +
            "        WHERE theme_id = #{themeId,jdbcType=VARCHAR}")
    fun upJokeTheme(joke_theme: JokeTheme):Int

    @Select("SELECT * FROM `joke_theme` WHERE theme_id = #{themeId,jdbcType=VARCHAR}")
    fun queryById(joke_themeId:String):List<JokeTheme>

    @Select("select * from `joke_theme`")
    fun listJokeTheme():Page<JokeTheme>
}