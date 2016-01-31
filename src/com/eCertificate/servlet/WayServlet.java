package com.eCertificate.servlet;

import java.awt.print.Printable;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.eCertificate.dao.CertificateDao;
import com.eCertificate.dao.impl.CertificateDaoImpl;
import com.eCertificate.util.Status;

public class WayServlet extends HttpServlet{

	public WayServlet(){}
	public void init(){}
	public void destroy(){}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		// 设置响应类型
		response.setContentType("text/html");
		// 获得响应对象的输出流，用于输出文本信息
		PrintWriter out=response.getWriter();
		// 实例化CertificateDao
		CertificateDao dao=new CertificateDaoImpl();
		// 获得请求参数
		String user_id=request.getParameter("user_id");
		String certificate_id=request.getParameter("certificate_id");
		String longitude=request.getParameter("local_longitude");
		String latitude =request.getParameter("local_latitude");
		// 获取地址信息
		JSONArray jsonArray=dao.queryAddress(Integer.parseInt(certificate_id));
		if(jsonArray==null)
			out.print("failed");
		boolean result=sort(jsonArray);
		JSONObject obj=new JSONObject();
		if(result){
			obj.put("status", Status.SUCCESS);
			obj.put("certificate_related_address",jsonArray);
			out.print(obj);
		}
		out.flush();
		out.close();
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
		this.doGet(request, response);
	}
	public boolean sort(JSONArray jsonArray){
		if (true)
			return true;
		else
			return false;
	}
}
