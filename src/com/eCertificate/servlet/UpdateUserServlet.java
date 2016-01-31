package com.eCertificate.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.eCertificate.dao.UserDao;
import com.eCertificate.dao.impl.UserDaoImpl;
import com.eCertificate.util.Status;

/**
 * @author YangHaoyan
 * 完成数据更新功能
 */
public class UpdateUserServlet extends HttpServlet {
	// 构造方法
	public UpdateUserServlet() {
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
		// 实例化UseDao
		UserDao dao = new UserDaoImpl();
		// 获得请求参数
		String user_id = request.getParameter("user_id");
		String name = request.getParameter("name");
		String gender = request.getParameter("sex");
		String age = request.getParameter("age");
		String address = request.getParameter("address");
		String has_married = request.getParameter("has_marriage");
		// 更新用户个人信息
		if (user_id == null || name == null || gender == null || age == null
				|| address == null || has_married == null) {
			out.print(Status.FAIL);
		} else {
			JSONObject obj = dao.updateUser(Integer.parseInt(user_id), name,
					Integer.parseInt(gender), Integer.parseInt(age), address,
					Integer.parseInt(has_married));
			// 返回客户端信息
			out.print(obj);
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
