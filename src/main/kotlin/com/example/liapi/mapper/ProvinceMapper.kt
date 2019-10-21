package com.example.liapi.mapper

import com.example.liapi.entity.Province
import com.github.pagehelper.Page
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository
import kotlin.Result

@Repository
interface ProvinceMapper {
    @Insert("INSERT INTO `provinces` VALUES(#{id,jdbcType=INTEGER},#{provinceId,jdbcType=INTEGER},#{province,jdbcType=VARCHAR})")
    fun addProvinces(province: Province):Int

    @Delete("DELETE FROM `provinces` WHERE provinceid = #{provinceId,jdbcType=VARCHAR}")
    fun delProvinces(provinceId: Int):Int

    @Update("UPDATE `provinces`\n" +
            "        SET province = #{province,jdbcType=VARCHAR}\n" +
            "        WHERE provinceid = #{provinceId,jdbcType=VARCHAR}")
    fun upProvinces(province: Province):Int

    @Select("SELECT * FROM `provinces` WHERE provinceid = #{provinceId,jdbcType=VARCHAR}")
    fun queryById(provinceId:Int):List<Province>

    @Select("select * from `provinces`")
    @Results(
            Result(property = "provinceId", column = "provinceid"),
            Result(property = "cities", column = "provinceid", many = Many(select = "com.example.liapi.mapper.CityMapper.queryByProvinceId")))
    fun listProvinces():Page<Province>

    @Select("SELECT * FROM `provinces` WHERE provinceid = #{provinceId,jdbcType=VARCHAR}")
    @Results(
            Result(property = "provinceId", column = "provinceid"),
            Result(property = "cities", column = "provinceid", many = Many(select = "com.example.liapi.mapper.CityMapper.queryByProvinceId")))
    fun queryPC(provinceId:Int):Province
}