package com.eCertificate.Test;
import net.sf.json.JSONObject;

import com.eCertificate.dao.UserDao;
import com.eCertificate.dao.impl.CertificateDaoImpl;
import com.eCertificate.dao.impl.UserDaoImpl;

public class Test {
	public static void main(String[] args) {
		loginTest();
		registerTest();
		updateTest();
		details();
	}

	private static void loginTest() {
		UserDao dao = new UserDaoImpl();
		JSONObject u = dao.login("abddc", "111");
		System.out.println(u);
	}

	private static void registerTest() {
		UserDao dao = new UserDaoImpl();
		JSONObject u = dao.addUser("abcdefgh", "111");
		System.out.println(u);
	}
	public static void updateTest(){
		UserDao dao=new UserDaoImpl();
		JSONObject u=dao.updateUser(11,"yanghaoyan",1,20,"广东省汕头市金平路28号301",-2);
		System.out.println(u);
	}
	public static void details(){
		CertificateDaoImpl dao=new CertificateDaoImpl();
		JSONObject u=dao.queryOrganization(1);
		System.out.println(u);
	}
}