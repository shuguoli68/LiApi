package com.example.liapi.mapper

import com.example.liapi.entity.Joke
import com.github.pagehelper.Page
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update
import org.springframework.stereotype.Repository

@Repository
interface JokeMapper {
    @Insert("INSERT INTO `joke` VALUES(#{id,jdbcType=INTEGER},#{jokeId,jdbcType=VARCHAR},#{content,jdbcType=VARCHAR},#{themeId,jdbcType=VARCHAR})")
    fun addJoke(joke: Joke):Int

    @Delete("DELETE FROM `joke` WHERE joke_id = #{jokeId,jdbcType=VARCHAR}")
    fun delJoke(jokeId: String):Int

    @Update("UPDATE `joke`\n" +
            "        SET theme_id = #{themeId,jdbcType=VARCHAR}, content = #{content,jdbcType=VARCHAR}\n" +
            "        WHERE joke_id = #{jokeId,jdbcType=VARCHAR}")
    fun upJoke(joke: Joke):Int

    @Select("SELECT * FROM `joke` WHERE joke_id = #{jokeId,jdbcType=VARCHAR}")
    fun queryById(jokeId:String):List<Joke>

    @Select("SELECT * FROM `joke` WHERE theme_id = #{themeId,jdbcType=VARCHAR}")
    fun listByThemeId(themeId:String):Page<Joke>

    @Select("select * from `joke`")
    fun listJoke():Page<Joke>
}