package com.sxt.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sxt.entity.Student;

public class LoginInterceptor implements HandlerInterceptor {

	//在执行业务处理方法之前运行
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		System.out.println("登录验证拦截器的preHandle()执行了。。。。。");
		
		//获取用户请求的url,如果是登录操作则直接放行，不需拦截
		String url = request.getRequestURI();
		if (url.indexOf("stuLogin.action") > 0) {
			return true;
		}if (url.indexOf("register.action") > 0) {
			return true;
		}
		
		//从会话中获取用户信息
		Student student = (Student) request.getSession().getAttribute("student");
		if (student != null) {
			return true;
		}
		
		//将请求重定向到登录页面
		response.sendRedirect(request.getContextPath()+"/page/login.jsp");
		//如果返回false表示将请求拦截下来，业务处理方法得不到执行机会；如果返回true表示放行，接下来去执行业务处理方法
		return false;
	}
	
	//在执行业务处理方法之后，返回modelAndView之前运行(可以将共享数据，共享视图放入modelAndView中)
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) throws Exception {
		System.out.println("登录验证拦截器的postHandle()执行了。。。。。");
	}
	
	//在执行业务处理方法之后，视图渲染之后(可以完成统一的异常处理，日志记录)
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("登录验证拦截器的afterCompletion()执行了。。。。。");
	}

	

	

}
