package com.eCertificate.dao;

import net.sf.json.JSONObject;
/**
 * @author YangHaoyan
 * 用户相关管理接口
 */
public interface UserDao {
	// 登录方法
	public JSONObject login(String account, String password);
	// 注册方法
	public JSONObject addUser(String account, String password);
	// 更新用户信息
	public JSONObject updateUser(int user_id, String name, int gender, int age, String address, int has_married);
}
