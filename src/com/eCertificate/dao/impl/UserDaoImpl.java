package com.eCertificate.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.sf.json.JSONObject;

import com.eCertificate.dao.UserDao;
import com.eCertificate.util.DBUtil;
import com.eCertificate.util.Status;

/**
 * @author
 * YangHaoyan 用户登录DAO实现类
 */
public class UserDaoImpl implements UserDao {
	public JSONObject login(String user_name, String password) {
		// 查询SQL语句
		String sql1 = " select id,account,password,name,age,address "
				+ " from user " + " where account=? ";
		String sql2 = " select id,account,password,name,age,address "
				+ " from user " + " where account=? and password=? ";
		// 封装JSON数据变量
		JSONObject obj = new JSONObject();
		// 数据库连接工具类
		DBUtil util = new DBUtil();
		// 获得连接
		Connection conn = util.openConnection();
		try {
			// 获得预定义语句
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			// 设置查询参数
			pstmt1.setString(1, user_name);
			// 执行查询
			ResultSet rs1 = pstmt1.executeQuery();
			if (rs1.next()) {
				// 获得预定义语句
				PreparedStatement pstmt2 = conn.prepareStatement(sql2);
				// 设置查询参数
				pstmt2.setString(1, user_name);
				pstmt2.setString(2, password);
				// 执行查询
				ResultSet rs2 = pstmt2.executeQuery();
				// 判断用户是否存在
				if (rs2.next()) {
					obj.put("status", Status.SUCCESS);
					obj.put("token", "acc");
					obj.put("user_id", rs2.getInt(1) + "");
				} else
					obj.put("status", Status.NOT_MATCH);
			} else
				obj.put("status", Status.FAIL);
			return obj;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
		obj.put("status", Status.FAIL);
		return obj;
	}

	public JSONObject addUser(String account, String password) {
		// 封装JSON数据
		JSONObject obj = new JSONObject();
		// SQL语句
		String sql = " select id,account from user where account=?";
		String sql2 = " insert into user (account, password) values (?,?)";
		// 数据库连接工具类
		DBUtil util = new DBUtil();
		// 获得连接
		Connection conn = util.openConnection();
		try {
			// 手动提交事务
			conn.setAutoCommit(false);
			// 查询重复用户
			// 获得预定义语句
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 设置参数
			pstmt.setString(1, account);
			// 获得SQL执行结果集
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				obj.put("status", Status.ACCOUNT_EXIST);
				return obj;
			}
			// 添加新用户
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setString(1, account);
			pstmt2.setString(2, password);
			pstmt2.executeUpdate();
			// 获得新添加用户id
			pstmt.setString(1, account);
			rs = pstmt.executeQuery();
			int id = 0;
			if (rs.next())
				id = rs.getInt(1);
			conn.commit();
			// 将数据封装进JSON
			obj.put("status", Status.SUCCESS);
			return obj;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			util.closeConn(conn);
		}
		obj.put("status", Status.FAIL);
		return obj;
	}

	public JSONObject updateUser(int user_id, String name, int gender, int age,
			String address, int has_married) {
		// SQL语句
		String sql = "update user set name=?,gender=?,age=?,address=?,has_married=? where id=?";
		// 封装JSON数据
		JSONObject obj = new JSONObject();
		// 数据库连接工具类
		DBUtil util = new DBUtil();
		// 获得连接
		Connection conn = util.openConnection();
		try {
			// 手动提交事务
			conn.setAutoCommit(false);
			// 获得预定义语句
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 设置参数
			pstmt.setString(1, name);
			pstmt.setInt(2, gender);
			pstmt.setInt(3, age);
			pstmt.setString(4, address);
			pstmt.setInt(5, has_married);
			pstmt.setInt(6, user_id);
			// 判断更新是否成功
			int i = pstmt.executeUpdate();
			if (i == 0)
				obj.put("status", Status.FAIL);
			else
				obj.put("status", Status.SUCCESS);
			conn.commit();
			return obj;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			util.closeConn(conn);
		}
		obj.put("status", Status.FAIL);
		return obj;

	}
}