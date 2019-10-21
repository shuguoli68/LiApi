package com.example.liapi.mapper

import com.example.liapi.entity.City
import com.github.pagehelper.Page
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository

@Repository
interface CityMapper {
    @Insert("INSERT INTO `cities` VALUES(#{id,jdbcType=INTEGER},#{cityId,jdbcType=CHAR},#{city,jdbcType=VARCHAR},#{provinceId,jdbcType=CHAR})")
    fun addCity(city: City):Int

    @Delete("DELETE FROM `cities` WHERE cityid = #{cityId,jdbcType=VARCHAR}")
    fun delCity(cityId: String):Int

    @Update("UPDATE `cities`\n" +
            "        SET city = #{city,jdbcType=VARCHAR}, provinceid = #{provinceId,jdbcType=CHAR}\n" +
            "        WHERE cityid = #{cityId,jdbcType=VARCHAR}")
    fun upCity(city: City):Int

    @Select("SELECT * FROM `cities` WHERE cityid = #{cityId,jdbcType=VARCHAR}")
    fun queryById(cityId:String):List<City>

    @Select("SELECT * FROM `cities` WHERE provinceid = #{provinceId,jdbcType=VARCHAR}")
    @Results(
            Result(property = "cityId", column = "cityid"),
            Result(property = "areas", column = "cityid", many = Many(select = "com.example.liapi.mapper.AreaMapper.queryByCityId")))
    fun queryByProvinceId(provinceId:String):List<City>

    @Select("select * from `cities`")
    @Results(
            Result(property = "cityId", column = "cityid"),
            Result(property = "areas", column = "cityid", many = Many(select = "com.example.liapi.mapper.AreaMapper.queryByCityId")))
    fun listCity():Page<City>

    @Select("SELECT * FROM `cities` WHERE cityid = #{cityId,jdbcType=VARCHAR}")
    @Results(
            Result(property = "cityId", column = "cityid"),
            Result(property = "areas", column = "cityid", many = Many(select = "com.example.liapi.mapper.AreaMapper.queryByCityId")))
    fun queryCA(cityId:String):City
}