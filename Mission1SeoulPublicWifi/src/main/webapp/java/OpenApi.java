import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;

public class OpenApi {
	public static String openApi() throws IOException {
		StringBuilder sb = new StringBuilder();
		
		JSONObject jObject = new JSONObject();
		
		try {
			OpenApi oApi = new OpenApi();
			String s = openApi();
			jObject = new JSONObject(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JSONArray jArray = (JSONArray) jObject.get("list_total_count");
		String jString = jArray.toString();
		
		int count = 1000;
		int page = 0;
		int total = Integer.parseInt(jString);
		
		for (page = 1; page < total; page += count, count += count) {
			StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088");
			urlBuilder.append("/" + URLEncoder.encode("447069726f646d733836447946596f", "UTF-8"));
			urlBuilder.append("/" + URLEncoder.encode("json", "UTF-8"));
			urlBuilder.append("/" + URLEncoder.encode("TbPublicWifiInfo", "UTF-8"));
			urlBuilder.append("/" + URLEncoder.encode(Integer.toString(page), "UTF-8"));
			urlBuilder.append("/" + URLEncoder.encode(Integer.toString(count), "UTF-8"));

			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/xml");
			System.out.println("Response code: " + conn.getResponseCode());
			BufferedReader rd;

			if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			rd.close();
			conn.disconnect();
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
}