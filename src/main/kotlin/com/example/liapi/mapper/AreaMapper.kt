package com.example.liapi.mapper

import com.example.liapi.entity.Area
import com.github.pagehelper.Page
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update
import org.springframework.stereotype.Repository

@Repository
interface AreaMapper {
    @Insert("INSERT INTO `areas` VALUES(#{id,jdbcType=INTEGER},#{areaId,jdbcType=CHAR},#{area,jdbcType=VARCHAR},#{cityId,jdbcType=CHAR})")
    fun addArea(areas: Area):Int

    @Delete("DELETE FROM `areas` WHERE areaid = #{areaId,jdbcType=VARCHAR}")
    fun delArea(areasId: String):Int

    @Update("UPDATE `areas`\n" +
            "        SET area = #{area,jdbcType=VARCHAR}, cityid = #{cityId,jdbcType=CHAR}\n" +
            "        WHERE areaid = #{areaId,jdbcType=VARCHAR}")
    fun upArea(areas: Area):Int

    @Select("SELECT * FROM `areas` WHERE areaid = #{areaId,jdbcType=VARCHAR}")
    fun queryById(areasId:String):List<Area>

    @Select("select * from `areas`")
    fun listArea():Page<Area>

    @Select("SELECT * FROM `areas` WHERE cityid = #{cityId,jdbcType=VARCHAR}")
    fun queryByCityId(cityId:String):List<Area>
}