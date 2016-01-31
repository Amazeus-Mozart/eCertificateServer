package com.eCertificate.dao;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * @author YangHaoyan
 * 证件信息管理接口
 */
public interface CertificateDao {
	// 查询同类型的证件
	public JSONObject queryType(String certificate_type);
	// 获取办证材料
	public JSONObject queryMaterials(int certificate_id);
	// 获取办证步骤
	public JSONObject queryProcess(int certificate_id);
	// 获取办证机构信息
	public JSONObject queryOrganization(int certificate_id);
	// 获取办证地址
	public JSONArray queryAddress(int certificate_id);
}
