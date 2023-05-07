import java.util.List;
import java.util.Scanner;

import org.json.JSONObject;

public class DbMain {
	public static void main(String[] args) {
		
		JsonParse json = new JsonParse();
		JSONObject jObject = json.JsonParser();
		
		DbInfo dbInfo = new DbInfo();
		dbInfo.dbInsert(jObject);
		
		List<WifiInfo> wifiInfoList = dbInfo.dbSelect();
		
		Scanner sc = new Scanner(System.in);
		
		//북마크 그룹 추가
		String groupName = sc.next();
		String personalNum = sc.next();
		
		WifiInfo wifiInfo = new WifiInfo();
		wifiInfo.getGroupName(groupName);
		wifiInfo.getPersonalNum(personalNum);
		
		GroupsDb groupsDb = new GroupsDb();
		groupsDb.groupAdd(wifiInfo);
		
		//북마크 그룹 수정
		String groupName = sc.next();
		String personalNum = sc.next();
		
		WifiInfo wifiInfo = new WifiInfo();
		wifiInfo.getGroupName(groupName);
		wifiInfo.getPersonalNum(personalNum);
		
		GroupsDb groupsDb = new GroupsDb();
		groupsDb.groupEdit(wifiInfo);

	}

}
