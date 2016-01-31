package com.eCertificate.util;

import java.util.HashMap;
import java.util.Map;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * 
 * @author YangHaoyan
 * 数据格式预处理
 */
public class DataPerpareProcess {
	public static JSONObject bulidJsonObject() {
//		JSONObject result = new JSONObject();
//		JSONArray material_array = new JSONArray();
//		JSONArray process_array = new JSONArray();
//		JSONArray organization_array = new JSONArray();
//		JSONArray attention_array = new JSONArray();
//		JSONArray address_array = new JSONArray();
//		Map material_map = new HashMap();
//		Map process_map = new HashMap();
//		Map organization_map = new HashMap();
//		Map attention_map = new HashMap();
//		Map address_map = new HashMap();
//		result.put("status", 0);
//		material_map.put("id", 1234);
//		material_map.put("introduction", "myintroductio");
//		material_map.put("access", "myaccess");
//		material_map.put("imageurl", "http");
//		material_array = material_array.fromObject(material_map);
//		result.put("material", material_array);
//		process_map.put("title", "myprocess");
//		process_map.put("content", "testtesttestprocess");
//		process_array = process_array.fromObject(process_map);
//		result.put("process", process_array);
//		organization_map.put("id", "1234");
//		organization_map.put("title", "organization");
//		organization_array = organization_array.fromObject(organization_map);
//		result.put("organization", organization_array);
//		attention_map.put("content", "attention");
//		attention_array = attention_array.fromObject(attention_array);
//		result.put("attention", attention_array);
//		address_map.put("map_address", "testaddress");
//		address_map.put("longitude", "testlongitude");
//		address_map.put("latitude", "testlatitude");
//		address_array = address_array.fromObject(address_map);
//		result.put("related_address", address_array);
//		return result;
		JSONObject result = new JSONObject();
		JSONArray material_array = new JSONArray();
		JSONArray process_array = new JSONArray();
		JSONArray organization_array = new JSONArray();
		JSONArray attention_array = new JSONArray();
		JSONArray address_array = new JSONArray();
		JSONObject material_map = new JSONObject();
		Map process_map = new HashMap();
		Map organization_map = new HashMap();
		Map attention_map = new HashMap();
		Map address_map = new HashMap();
		result.put("status", 1);
		material_map.put("id", 1234);
		material_map.put("introduction", "myintroductio");
		material_map.put("access", "myaccess");
		material_map.put("imageurl", "http");
		material_array = material_array.fromObject(material_map);
		result.put("material", material_array);
		process_map.put("title", "myprocess");
		process_map.put("content", "testtesttestprocess");
		process_array = process_array.fromObject(process_map);
		result.put("process", process_array);
		organization_map.put("id", "1234");
		organization_map.put("title", "organization");
		organization_array = organization_array.fromObject(organization_map);
		result.put("organization", organization_array);
		attention_map.put("content", "attention");
		attention_array = attention_array.fromObject(attention_array);
		result.put("attention", attention_array);
		address_map.put("map_address", "testaddress");
		address_map.put("longitude", "testlongitude");
		address_map.put("latitude", "testlatitude");
		address_array = address_array.fromObject(address_map);
		result.put("related_address", address_array);
		return result;
	}
}