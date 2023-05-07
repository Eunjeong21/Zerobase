import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class DbInfo {
	
	public List<WifiInfo> dbSelect() {
		List<WifiInfo> wifiInfoList = new ArrayList<>();
		
		String url = "jdbc:mariadb://192.168.222.130:3306/db1";
		String dbUserId = "user1";
		String dbPassword = "zerobase";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException classError) {
			classError.printStackTrace();
		}
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			connection = DriverManager.getConnection(url, dbUserId, dbPassword);
			
			String sql = " SELECT ngr_no, wrdofc, main_nm, adres1, adres2,instl_floor, instl_ty, instl_mby, svc_se, cnstc_year, inout_door, remars3, lat, lnt, work_dttm" + 
			" FROM wifi_info " ;
			
			preparedStatement = connection.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				String ngrNo= rs.getString("ngr_no");
				String wrdofc = rs.getString("wrdofc");
				String mainNm = rs.getString("main_nm");
				String adres1 = rs.getString("adres1");
				String adres2 = rs.getString("adres2");
				String instlFloor = rs.getString("instl_floor");
				String instlTy = rs.getString("instl_ty");
				String instlMby = rs.getString("instl_mby");
				String svcSe = rs.getString("svc_se");
				Integer cnstcYear = rs.getInt("cnstc_year");
				String inoutDoor = rs.getString("inout_door");
				String remars3 = rs.getString("remars3");
				Float lat = rs.getFloat("lat");
				Float lnt = rs.getFloat("lnt");
				Timestamp workDttm = rs.getTimestamp("work_dttm");
				
				WifiInfo wifiInfo = new WifiInfo();
				
				wifiInfo.setxSwifiMgrNo(ngrNo);
				wifiInfo.setxSwifiWrdofc(wrdofc);
				wifiInfo.setxSwifiMainNm(mainNm);
				wifiInfo.setxSwifiAdres1(adres1);
				wifiInfo.setxSwifiAdres2(adres2);
				wifiInfo.setxSwifiInstlFloor(instlFloor);
				wifiInfo.setxSwifiInstlTy(instlTy);
				wifiInfo.setxSwifiInstlMby(instlMby);
				wifiInfo.setxSwifiSvcSe(svcSe);
				wifiInfo.setxSwifiCnstcYear(cnstcYear);
				wifiInfo.setxSwifiInoutDoor(inoutDoor);
				wifiInfo.setxSwifiRemars3(remars3);
				wifiInfo.setLat(lat);
				wifiInfo.setLnt(lnt);
				wifiInfo.setWorkDttm(workDttm);
				
				wifiInfoList.add(wifiInfo);
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (preparedStatement != null && !preparedStatement.isClosed()) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return wifiInfoList;
	}

	
	public WifiInfo wifiDetail() {
		WifiInfo wifiInfo = null;
		
		String url = "jdbc:mariadb://192.168.222.130:3306/db1";
		String dbUserId = "user1";
		String dbPassword = "zerobase";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException classError) {
			classError.printStackTrace();
		}
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			connection = DriverManager.getConnection(url, dbUserId, dbPassword);
			
			String sql = " SELECT ngr_no, wrdofc, main_nm, adres1, adres2,instl_floor, instl_ty, instl_mby, svc_se, cnstc_year, inout_door, remars3, lat, lnt, work_dttm" + 
			" FROM wifi_info " ;
			
			preparedStatement = connection.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				wifiInfo = new WifiInfo();
				
				wifiInfo.setxSwifiMgrNo(rs.getString("ngr_no"));
				wifiInfo.setxSwifiWrdofc(rs.getString("wrdofc"));
				wifiInfo.setxSwifiMainNm(rs.getString("main_nm"));
				wifiInfo.setxSwifiAdres1(rs.getString("adres1"));
				wifiInfo.setxSwifiAdres2(rs.getString("adres2"));
				wifiInfo.setxSwifiInstlFloor(rs.getString("instl_floor"));
				wifiInfo.setxSwifiInstlTy(rs.getString("instl_ty"));
				wifiInfo.setxSwifiInstlMby(rs.getString("instl_mby"));
				wifiInfo.setxSwifiSvcSe(rs.getString("svc_se"));
				wifiInfo.setxSwifiCnstcYear(rs.getInt("cnstc_year"));
				wifiInfo.setxSwifiInoutDoor(rs.getString("inout_door"));
				wifiInfo.setxSwifiRemars3(rs.getString("remars3"));
				wifiInfo.setLat(rs.getFloat("lat"));
				wifiInfo.setLnt(rs.getFloat("lnt"));
				wifiInfo.setWorkDttm(rs.getTimestamp("work_dttm"));
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (preparedStatement != null && !preparedStatement.isClosed()) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return wifiInfo;
	}


	public void dbInsert(JSONObject jObject) {
		String url = "jdbc:mariadb://192.168.222.130:3306/db1";
		String dbUserId = "user1";
		String dbPassword = "zerobase";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException classError) {
			classError.printStackTrace();
		}
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			connection = DriverManager.getConnection(url, dbUserId, dbPassword);
			
			String sql = "INSERT INTO WIFIINFO(NGR_NO, WRDOFC, MAIN_NM, ADRES1, ADRES2, INSTL_FLOOR, INSTL_TY, INSTL_TY, INSTL_MBY, SVC_SE, CNSTC_YEAR, INOUT_DOOR, REMARS3, LAT, LNT, WORK_DTTM) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, jObject.getString("NGR_NO"));
			preparedStatement.setString(2, jObject.getString("WRDOFC"));
			preparedStatement.setString(3, jObject.getString("MAIN_NM"));
			preparedStatement.setString(4, jObject.getString("ADRES1"));
			preparedStatement.setString(5, jObject.getString("ADRES2"));
			preparedStatement.setString(6, jObject.getString("INSTL_FLOOR"));
			preparedStatement.setString(7, jObject.getString("INSTL_TY"));
			preparedStatement.setString(8, jObject.getString("INSTL_MBY"));
			preparedStatement.setString(9, jObject.getString("SVC_SE"));
			preparedStatement.setInt(10, jObject.getInt("CNSTC_YEAR"));
			preparedStatement.setString(11, jObject.getString("INOUT_DOOR"));
			preparedStatement.setString(12, jObject.getString("REMARS3"));
			preparedStatement.setFloat(13, jObject.getFloat("LAT"));
			preparedStatement.setFloat(14, jObject.getFloat("LNT"));
			preparedStatement.setTimestamp(15, jObject.getTimestamp("WORK_DTTM"));

			int affected = preparedStatement.executeUpdate();
			
			if (affected > 0) {
				System.out.println(" 저장 성공 ");
			} else {
				System.out.println(" 저장 실패 ");
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (preparedStatement != null && !preparedStatement.isClosed()) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
}
