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

/**
 * 
 * @author YangHaoyan 
 * 响应 Android客户端发来的用户登录请求
 */
public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置响应类型
		response.setContentType("text/html");
		// 获得响应对象的输出流，用于输出文本信息
		PrintWriter out = response.getWriter();
		// 实例化UserDao
		UserDao dao = new UserDaoImpl();
		// 获得客户端请求参数
		String account = request.getParameter("user_name");
		String password = request.getParameter("password");
		if (account == null || password == null) {
			out.print("failed");
		} else {
			// 登录用户
			JSONObject status = dao.login(account, password);
			// 返回客户端信息
			out.print(status);
		}
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void init() throws ServletException {
	}

	public LoginServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}
}
