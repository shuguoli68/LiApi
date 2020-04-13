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
    @Insert("INSERT INTO `wy_news` VALUES(#{id},#{path},#{image},#{title},#{passtime})")
    fun addWYNews(wy_news: WYNews):Int

    @Delete("DELETE FROM `wy_news` WHERE path = #{path,jdbcType=VARCHAR}")
    fun delWYNews(path: String):Int

    @Update("UPDATE `wy_news`\n" +
            "        SET image = #{image}, title = #{title}, passtime = #{passtime}\n" +
            "        WHERE path = #{path}")
    fun upWYNews(wy_news: WYNews):Int

    @Select("SELECT * FROM `wy_news` WHERE path = #{path}")
    fun queryById(path:String):List<WYNews>

    @Select("select * from `wy_news`")
    fun listWYNews():Page<WYNews>
}