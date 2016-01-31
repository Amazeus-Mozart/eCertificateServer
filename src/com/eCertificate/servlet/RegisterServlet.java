package com.eCertificate.servlet;

//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import net.sf.json.JSONObject;
//
//import com.eCertificate.dao.UserDao;
//import com.eCertificate.dao.impl.UserDaoImpl;
///**
// * @author YangHaoyan
// * 用户注册
// */
//public class RegisterServlet extends HttpServlet {
//	// 构造方法
//	public RegisterServlet() {
//		super();
//	}
//	// 销毁方法
//	public void destroy() {
//		super.destroy(); 
//	}
//	// 响应Get请求
//	public void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// 设置响应类型
//		response.setContentType("text/html");
//		// 获得响应对象的输出流，用于输出文本信息
//		PrintWriter out = response.getWriter();
//		// 获得请求参数
//		String account = request.getParameter("user_name");
//		String password = request.getParameter("password");
//		// 实例化UserDao
//		UserDao dao = new UserDaoImpl();
//		if (account == null || password == null) {
//			out.print("failed");
//		} else {
//			// 注册用户
//			JSONObject status = dao.addUser(account, password);
//			// 返回客户端信息
//			out.println(status);
//		}
//		out.flush();
//		out.close();
//	}
//	// 响应Post请求
//	public void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		doGet(request,response);
//	}
//	// 初始化方法
//	public void init() throws ServletException {
//	}
//
//}


//package com.bepotato.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author YangHaoyan
 * 用户注册
 */
public class RegisterServlet extends HttpServlet {
	// 构造方法
	public RegisterServlet() {
		super();
	}
	// 销毁方法
	public void destroy() {
		super.destroy(); 
	}
	// 响应Get请求
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置响应类型
		response.setContentType("text/html");
		// 获得响应对象的输出流，用于输出文本信息
		PrintWriter out = response.getWriter();
		// 获得请求参数
		String account = request.getParameter("user_name");
		String password = request.getParameter("password");
		if (account == null || password == null) {
			out.print("failed");
		} else {
			out.print("success");
		}
		out.flush();
		out.close();
	}
	// 响应Post请求
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
	// 初始化方法
	public void init() throws ServletException {
	}

}
