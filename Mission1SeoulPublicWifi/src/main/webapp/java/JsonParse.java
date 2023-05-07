import org.json.JSONObject;

public class JsonParse {
	public static JSONObject JsonParser() {
		JSONObject jObject = new JSONObject();
		try {
			OpenApi OpenApi = new OpenApi();
			String s = OpenApi.openApi();
			jObject = new JSONObject(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jObject;
	}
}