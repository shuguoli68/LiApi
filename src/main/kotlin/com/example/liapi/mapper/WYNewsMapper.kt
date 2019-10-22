package com.example.liapi.mapper

import com.example.liapi.entity.WYNews
import com.github.pagehelper.Page
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update
import org.springframework.stereotype.Repository

@Repository
interface WYNewsMapper {
    @Insert("INSERT INTO `wy_news` VALUES(#{path,jdbcType=INTEGER},#{image,jdbcType=VARCHAR},#{title,jdbcType=VARCHAR},#{passtime,jdbcType=VARCHAR})")
    fun addWYNews(wy_news: WYNews):Int

    @Delete("DELETE FROM `wy_news` WHERE path = #{path,jdbcType=VARCHAR}")
    fun delWYNews(path: String):Int

    @Update("UPDATE `wy_news`\n" +
            "        SET image = #{image,jdbcType=VARCHAR}, title = #{title,jdbcType=VARCHAR}, passtime = #{passtime,jdbcType=VARCHAR}\n" +
            "        WHERE path = #{path,jdbcType=VARCHAR}")
    fun upWYNews(wy_news: WYNews):Int

    @Select("SELECT * FROM `wy_news` WHERE path = #{path,jdbcType=VARCHAR}")
    fun queryById(path:String):List<WYNews>

    @Select("select * from `wy_news`")
    fun listWYNews():Page<WYNews>
}