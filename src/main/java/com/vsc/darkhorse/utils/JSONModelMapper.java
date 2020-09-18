package com.vsc.darkhorse.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.vsc.darkhorse.model.Product;

public class JSONModelMapper {
	private static String URL = "https://s3.amazonaws.com/open-to-cors/assignment.json";

	@SuppressWarnings("unchecked")
	public static Map<String, JSONObject> parseJSONResponse() {
		Map<String, JSONObject> valueMap = new HashMap<>();
		try {
			JSONParser parser = new JSONParser();
			//System.out.println(ParserUtils.callAPI(URL));
			JSONObject jsonObj = (JSONObject) parser.parse(ParserUtils.callAPI(URL));
			Map<String, JSONObject> jsonMapObject = new HashMap<>();
			jsonMapObject = (Map<String, JSONObject>) jsonObj.get("products");
			for (Entry<String, JSONObject> entry : jsonMapObject.entrySet()) {
				valueMap.put(entry.getKey(), entry.getValue());
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return valueMap;
	}
	
	public static List<Product> getProductObject() {
		
		List<Product> listOfProducts = new ArrayList<>();
		Map<String, JSONObject> valueMap = parseJSONResponse();
		for (Entry<String, JSONObject> entry : valueMap.entrySet()) {
			Product product = new Product();
			String product_id = entry.getKey();
			JSONObject productJSONObj = entry.getValue();
			product.setProduct_id(Integer.parseInt(product_id));
			product.setSubcategory((String) productJSONObj.get("subcategory"));
			product.setPrice(Long.parseLong((String) productJSONObj.get("price")));
			product.setPopularity(Long.parseLong((String) productJSONObj.get("popularity")));
			product.setTitle((String) productJSONObj.get("title"));
			listOfProducts.add(product);
		}
		return listOfProducts;
	}
}
