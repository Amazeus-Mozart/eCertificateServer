package com.eCertificate.Test;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SurveyServlet extends HttpServlet {
	String resultsDir;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		resultsDir = getInitParameter("resultsDir");
		if (resultsDir == null) {
			Enumeration initParams = getInitParameterNames();
			System.err.println("The init parameters were: ");
			while (initParams.hasMoreElements()) {
				System.err.println(initParams.nextElement());
			}
			System.err.println("Should have seen one parameter name");
			throw new UnavailableException(this, "Not given a directory to write survey results!");
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter toClient = res.getWriter();

		try {
			// 打开文件将调查结果写入文件
			String surveyName = req.getParameterValues("survey")[0];
			FileWriter resultsFile = new FileWriter(resultsDir
					+ System.getProperty("file.separator") + surveyName
					+ ".txt", true);
			PrintWriter toFile = new PrintWriter(resultsFile);
			toFile.println("<BEGIN>");
			Enumeration values = req.getParameterNames();
			while (values.hasMoreElements()) {
				String name = (String) values.nextElement();
				String value = req.getParameterValues(name)[0];
				if (name.compareTo("submit") != 0) {
					toFile.println(name + ": " + value);
				}
			}
			toFile.println("<END>");
			// 关闭文件
			resultsFile.close();

			// 响应客户
			toClient.println("<html>");
			toClient.println("<title>Thank you!</title>");
			toClient.println("<body bgcolor=#ffffff><p><img src=images/BEA_Button_Final_web.gif align=right>"
					+ "<font face=\"Helvetica\">"
					+ "Thank you for participating</font></body>");
			toClient.println("</html>");

		} catch (IOException e) {
			e.printStackTrace();
			toClient.println("A problem occured while recording your answers. "
					+ "Please try again.");
		}

	}
}