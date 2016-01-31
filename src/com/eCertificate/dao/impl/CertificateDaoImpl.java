package com.eCertificate.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.eCertificate.dao.CertificateDao;
import com.eCertificate.util.*;
/**
 * @author YangHaoyan
 */
public class CertificateDaoImpl implements CertificateDao {

	@Override
	public JSONObject queryType(String certificate_type) {
		// 封装JSON数据
		JSONObject obj = new JSONObject();
		JSONArray jsonArray=new JSONArray();
		HashMap map=new HashMap();
		// 执行SQL语句
		String sqlSelect = " select C.id, C.certificate";
		String sqlFrom = "from certificate as C,certificate_type as CT,type as T";
		String sqlWhere = "where CT.certificate_id=CT.type_id and T.type=?";
		// 数据库连接工具类
		DBUtil util = new DBUtil();
		// 获得连接
		Connection conn = util.openConnection();
		try {
			// 获得预定义语句
			PreparedStatement pstmt = conn.prepareStatement(sqlSelect+" "+sqlFrom+" "+sqlWhere);
			// 设置参数
			pstmt.setString(1, certificate_type);
			// 获取查询结果
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				map.put("certificate_id", rs.getInt(1));
				map.put("certificate_title",rs.getString(2));
				jsonArray.add(map);
			}
			obj.put("status",Status.SUCCESS);
			obj.put("certificate",jsonArray);
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
	@Override
	public JSONArray queryAddress(int certificate_id){
		// SQL语句
		String sqlSelect="select O.address,O.longitude,O.latitude ";
		String sqlFrom="from certificate as C,certificate_organization as CO,organization as O ";
		String sqlWhere="where C.id=CO.certificate_id and CO.organization_id=O.id and C.id=?";
		// 用于数据封装JSON
		JSONArray jsonArray=new JSONArray();
		HashMap map=new HashMap();
		// 使用数据库工具
		DBUtil util=new DBUtil();
		// 连接数据库
		Connection conn=util.openConnection();
		try {
			// 获得预定义语句
			PreparedStatement pstmt = conn.prepareStatement(sqlSelect+" "+sqlFrom+" "+sqlWhere);
			// 设置参数
			pstmt.setInt(1, certificate_id);
			// 执行查询
			ResultSet rs=pstmt.executeQuery();
			// 将结果封装成JSON
			while(rs.next()){
				map.put("map_address", rs.getString(1));
				map.put("longitude",rs.getString(2));
				map.put("latitude",rs.getString(3));
				jsonArray.add(map);
			}
			return jsonArray;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConn(conn);
		}
		return jsonArray;
	}
	@Override
	public JSONObject queryMaterials(int certificate_id){
		// SQL语句
		String sqlSelect="select M.id,M.material,M.introduction,M.access,M.imageUrl";
		String sqlFrom="from certificate as C,certificate_material as CM,material as M ";
		String sqlWhere="where C.id=CM.certificate_id and CM.material_id=M.id and C.id=?";
		// 用于数据封装JSON
		JSONObject obj=new JSONObject();
		JSONArray jsonArray=new JSONArray();
		HashMap map=new HashMap();
		// 使用数据库工具
		DBUtil util=new DBUtil();
		// 连接数据库
		Connection conn=util.openConnection();
		try {
			// 获得预定义语句
			PreparedStatement pstmt = conn.prepareStatement(sqlSelect+" "+sqlFrom+" "+sqlWhere);
			// 设置参数
			pstmt.setInt(1, certificate_id);
			// 执行查询
			ResultSet rs=pstmt.executeQuery();
			// 将结果封装成JSON
			while(rs.next()){
				map.put("certificate_material_id", rs.getString(1));
				map.put("certificate_material_title",rs.getString(2));
				map.put("certificate_material_introduction", rs.getString(3));
				map.put("certificate_material_access",rs.getString(4));
				map.put("certificate_material_image", rs.getString(5));
				jsonArray.add(map);
			}
			obj.put("status", Status.SUCCESS);
			obj.put("certificate_material",jsonArray);
			return obj;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		obj.put("status", Status.FAIL);
		return obj;
	}
	@Override
	public JSONObject queryProcess(int certificate_id){
		// SQL语句
		String sqlSelect="select P.id,P.process,P.content ";
		String sqlFrom="from certificate as C,certificate_process as CP,process as P ";
		String sqlWhere="where C.id=CP.certificate_id and CP.process_id=P.id and C.id=?";
		// 用于数据封装JSON
		JSONObject obj=new JSONObject();
		JSONArray jsonArray=new JSONArray();
		HashMap map=new HashMap();
		// 使用数据库工具
		DBUtil util=new DBUtil();
		// 连接数据库
		Connection conn=util.openConnection();
		try {
			// 获得预定义语句
			PreparedStatement pstmt = conn.prepareStatement(sqlSelect+" "+sqlFrom+" "+sqlWhere);
			// 设置参数
			pstmt.setInt(1, certificate_id);
			// 执行查询
			ResultSet rs=pstmt.executeQuery();
			// 将结果封装成JSON
			while(rs.next()){
				map.put("process_id", rs.getString(1));
				map.put("certificate_handle_title",rs.getString(2));
				map.put("certificate_handle_content",rs.getString(3));
				jsonArray.add(map);
			}
			obj.put("status", Status.SUCCESS);
			obj.put("certificate_process",jsonArray);
			return obj;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		obj.put("status", Status.FAIL);
		return obj;
	}
	@Override
	public JSONObject queryOrganization(int certificate_id){
		// SQL语句
		String sqlSelect="select O.id,O.organization,O.phone,O.address,O.imageUrl ";
		String sqlFrom="from certificate as C,certificate_organization as CO,organization as O ";
		String sqlWhere="where C.id=CO.certificate_id and CO.organization_id=O.id and C.id=?";
		// 用于数据封装JSON
		JSONObject obj=new JSONObject();
		JSONArray jsonArray=new JSONArray();
		HashMap map=new HashMap();
		// 使用数据库工具
		DBUtil util=new DBUtil();
		// 连接数据库
		Connection conn=util.openConnection();
		try {
			// 获得预定义语句
			PreparedStatement pstmt = conn.prepareStatement(sqlSelect+" "+sqlFrom+" "+sqlWhere);
			// 设置参数
			pstmt.setInt(1, certificate_id);
			// 执行查询
			ResultSet rs=pstmt.executeQuery();
			// 将结果封装成JSON
			while(rs.next()){
				map.put("certificate_organization_id", rs.getString(1));
				map.put("certificate_organization_title",rs.getString(2));
				map.put("certificate_organization_phone",rs.getString(3));
				map.put("certificate_organization_address",rs.getString(4));
				map.put("certificate_organization_image",rs.getString(5));
				jsonArray.add(map);
			}
			obj.put("status", Status.SUCCESS);
			obj.put("certificate_organization",jsonArray);
			return obj;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		obj.put("status", Status.FAIL);
		return obj;
	}
}
