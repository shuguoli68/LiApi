package com.example.liapi.mapper

import com.example.liapi.entity.Province
import com.github.pagehelper.Page
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update
import org.springframework.stereotype.Repository

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
    fun listProvinces():Page<Province>
}