package com.example.liapi.mapper

import com.example.liapi.entity.City
import com.github.pagehelper.Page
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update
import org.springframework.stereotype.Repository

@Repository
interface CityMapper {
    @Insert("INSERT INTO `cities` VALUES(#{id,jdbcType=INTEGER},#{cityId,jdbcType=CHAR},#{city,jdbcType=VARCHAR},#{provinceId,jdbcType=CHAR})")
    fun addCity(city: City):Int

    @Delete("DELETE FROM `cities` WHERE cityid = #{cityId,jdbcType=VARCHAR}")
    fun delCity(cityId: String):Int

    @Update("UPDATE `city`\n" +
            "        SET city = #{city,jdbcType=VARCHAR}, provinceId = #{provinceId,jdbcType=CHAR}\n" +
            "        WHERE cityid = #{cityId,jdbcType=VARCHAR}")
    fun upCity(city: City):Int

    @Select("SELECT * FROM `cities` WHERE cityid = #{cityId,jdbcType=VARCHAR}")
    fun queryById(cityId:String):List<City>

    @Select("select * from `cities`")
    fun listCity():Page<City>
}