package com.eCertificate.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.eCertificate.dao.CertificateDao;
import com.eCertificate.dao.impl.CertificateDaoImpl;

/**
 * @author YangHaoyan
 */
public class OrganizationAddressServlet extends HttpServlet {
	// 构造方法
	public OrganizationAddressServlet() {
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
		// 实例化CertificateDao
		CertificateDao dao = new CertificateDaoImpl();
		// 获得客户端请求参数
		String user_id = request.getParameter("user_id");
		String certificate_type = request.getParameter("certificate_id");
		String longitude = request.getParameter("local_longitud");
		String latitude = request.getParameter("local_latitude");
		// 获取办证材料
		/*if (user_id == null || certificate_type == null)
			out.print("failed");
		else {
			JSONObject obj = dao.(Integer.parseInt(user_id), Integer.parseInt(certificate_type));
			out.print(obj);
		}*/
		out.flush();
		out.close();
	}

	// 响应Post请求
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	// 初始化方法
	public void init() throws ServletException {
	}
}
