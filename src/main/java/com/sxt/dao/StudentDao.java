package com.sxt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sxt.entity.Student;

public interface StudentDao {
	/**
	 * 插入学生记录
	 * @param student 学生对象
	 * @return  成功插入的记录数
	 */
    public int insertStudent(Student student);
    
    /**
     * 分页查询学生信息
     * @param pageId  页码
     * @param pageSize 每页行数
     * @return  学生列表
     */
    public List<Student> selectStuByPage(@Param("pageId")int pageId, @Param("pageSize")int pageSize);
    
    /**
     * 根据姓名及密码查询学生
     * @param stuName 姓名
     * @param stuPwd 密码
     * @return 学生
     */
    public Student selectStu(@Param("stuName")String stuName, @Param("stuPwd")String stuPwd);
}
