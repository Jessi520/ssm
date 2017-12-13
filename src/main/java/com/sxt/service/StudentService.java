package com.sxt.service;

import java.util.List;

import com.sxt.entity.Student;

public interface StudentService {
	/**
	 * 新增学生
	 * @param student  学生对象
	 * @return   是否新增成功
	 * @throws Exception
	 */
    public boolean addStudent(Student student) throws Exception;
    
    /**
     * 分页查询学生信息
     * @param pageId 页码
     * @param pageSize 每页行数
     * @return   学生列表
     * @throws Exception
     */
    public List<Student> showStuByPage(int pageId,int pageSize) throws Exception;
    
    /**
     * 登录的业务方法
     * @param stuName 姓名
     * @param stuPwd  密码
     * @return  学生对象
     * @throws Exception
     */
    public Student login(String stuName,String stuPwd) throws Exception;
}
