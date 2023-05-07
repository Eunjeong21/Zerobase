import java.util.List;

import org.json.JSONObject;

public class DbMain {
	public static void main(String[] args) {
		
		JsonParse json = new JsonParse();
		JSONObject jObject = json.JsonParser();
		
		DbInfo dbInfo = new DbInfo();
		dbInfo.dbInsert(jObject);
		
		List<WifiInfo> wifiInfoList = dbInfo.dbSelect();
		

		
		WifiInfo wifiInfo = new WifiInfo();

	}

}
