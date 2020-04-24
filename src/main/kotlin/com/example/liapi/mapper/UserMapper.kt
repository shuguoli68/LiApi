package com.example.liapi.mapper

import com.example.liapi.entity.User
import com.github.pagehelper.Page
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update
import org.springframework.stereotype.Repository

@Repository
interface UserMapper {
    @Insert("INSERT INTO `user` VALUES(#{id},#{userId},#{phone},#{name},#{nickname},#{autograph},#{email},#{remarks},#{headerImg},#{vipGrade})")
    fun addUser(user: User):Int

    @Delete("DELETE FROM `user` WHERE user_id = #{userId}")
    fun delUser(userId: String):Int

    @Update("UPDATE `user`\n" +
            "        SET nick_name = #{nickname}, autograph = #{autograph}, email = #{email}, remarks = #{remarks}, header_img = #{headerImg}, vip_grade = #{vipGrade}\n" +
            "        WHERE user_id = #{userId}")
    fun upUser(user: User):Int

    @Select("SELECT * FROM `user` WHERE user_id = #{userId}")
    fun queryById(userId:String):List<User>

    @Select("SELECT * FROM `user` WHERE user_id = #{userId}")
    fun queryByNickname(userId:String):List<User>

    @Select("select * from `user`")
    fun listUser():Page<User>
}