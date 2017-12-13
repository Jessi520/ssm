package com.sxt.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sxt.entity.Student;
import com.sxt.service.StudentService;

@Controller
public class StudentController {
   
	@Resource(name="studentService")
	private StudentService studentService;
	
	@RequestMapping("/register.action")
	public String register(Student student,MultipartFile photo,Model model,HttpServletRequest request){
		boolean ok = false;		
		
		try {
			//获取上传的文件的名称
			String fileName = photo.getOriginalFilename();
			//获取服务器上的photoes文件夹的绝对路径
			String path = request.getSession().getServletContext().getRealPath("/photoes");
			//准备目标文件对象
			File destFile = new File(path, fileName);
			//将临时文件内容保存到目标文件中
			photo.transferTo(destFile);
			
			//将图片名称保存到student对象中
			student.setStuPhoto(fileName);
			
			//调用业务方法完成学生的保存
			studentService.addStudent(student);
			model.addAttribute("student", student);
			ok = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//跳转到成功
		if (ok) {
			return "/page/registerSuccess.jsp";
		}else{
			return "/page/registerFail.jsp";
		}
	}
	
	@RequestMapping("/download.action")
	public void download(String fileName,HttpServletRequest request,HttpServletResponse response){
		try {
			//获取服务器上的photoes文件夹的绝对路径
			String path = request.getSession().getServletContext().getRealPath("/photoes");
			//准备源文件对象
			File sourceFile = new File(path, fileName);
			//读取源文件的内容
			byte[] data = FileUtils.readFileToByteArray(sourceFile);
			
			//设置下载文件的类型
			response.setContentType("application/octet-stream");
			//设置响应头信息
			response.setHeader("Content-Disposition", "attachment;filename="+fileName);
			
			//从响应对象中获取输出流对象
			OutputStream os = response.getOutputStream();
			os.write(data);
			os.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/showStudentList.action")
	public String showStudentList(@RequestParam(value="pageId",defaultValue="1")int pageId,Model model) throws Exception{
		  System.out.println("分页查询学生信息的业务处理方法执行了。。。。");
		  //调用分页查询的业务方法
		  List<Student> stuList = studentService.showStuByPage(pageId, 5);
		  //存数据
		  model.addAttribute("stuList", stuList);
		  model.addAttribute("pageId", pageId);
		  //跳转页面
		  return "forward:/page/showStudentList.jsp";
	}
	
	@RequestMapping("/stuLogin.action")
	public String stuLogin(String stuName,String stuPwd,HttpSession session) throws Exception{
		//调用登录的业务方法 
		Student student = studentService.login(stuName, stuPwd);
		if (student != null) {
			//将学生保存到会话中
			session.setAttribute("student", student);
			return "showStudentList.action";
		}else{
			return "/page/login.jsp";
		}
	}
}
