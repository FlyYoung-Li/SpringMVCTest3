package com.web.dao;

import com.web.entity.Teacher;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author 李晓扬
 * @version 1.0
 * @description: TODO
 * @date 2021/8/3 11:36
 */
public interface TeacherDaoAnnotation {
    @Select("SELECT *\n" + "FROM t_teacher\n" + "WHERE id = #{id}")
    public Teacher getTeacherById(Integer id);
    @Update("UPDATE t_teacher\n" + "SET `name`=#{name},\n" + "`age`=#{age},\n" + " `location`=#{location}\n" + "WHERE id = #{id}")
    public Integer updateTeacher(Teacher teacher);
    @Insert(" INSERT\n" + "t_teacher (name,age,location)\n" + "VALUES(#{name},#{age},#{location})")
    public Integer insertTeacher(Teacher teacher);
    @Delete(" DELETE from t_teacher WHERE id =#{id}")
    public Integer deleteTeacherById(Integer id);
}
