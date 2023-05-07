import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class BookmarkDb {
	public List<WifiInfo> bookmarkInquiry() {

		List<WifiInfo> bookmarkInquiryList = new ArrayList<>();
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

			String sql = "SELECT id, group_name, main_nm, bookmark_regist" + " FROM bookmark ";

			preparedStatement = connection.prepareStatement(sql);
			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String groupName = rs.getString("group_name");
				String mainNm = rs.getString("main_nm");
				Timestamp bookmarkRegist = rs.getTimestamp("bookmark_regist");
				
				WifiInfo wifiInfo = new WifiInfo();
				
				wifiInfo.setId(id);
				wifiInfo.setGroupName(groupName);
				wifiInfo.setxSwifiMainNm(mainNm);
				wifiInfo.setBookmarkRegist(bookmarkRegist);
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
		return bookmarkInquiryList;
	}

	public void bookmarkAdd(Integer id, String groupName, String mainNm, Timestamp bookmarkRegist) {
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

			String sql = "INSERT INTO bookmark(id, group_name, main_nm, bookmark_regist) VALUES (?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, groupName);
			preparedStatement.setString(3, mainNm);
			preparedStatement.setTimestamp(4, bookmarkRegist);

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

	public void bookmarkRemove(String groupName, String mainNm, Timestamp bookmarkRegist) {
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

			String sql = " DELETE FROM bookmark " + "WHERE group_name = ? and main_nm = ? and bookmark_regist = ? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, groupName);
			preparedStatement.setString(2, mainNm);
			preparedStatement.setTimestamp(3, bookmarkRegist);

			int affected = preparedStatement.executeUpdate();

			if (affected > 0) {
				System.out.println(" 삭제 성공 ");
			} else {
				System.out.println(" 삭제 실패 ");
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
