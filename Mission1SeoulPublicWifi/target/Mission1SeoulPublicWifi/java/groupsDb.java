import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class groupsDb {
	public List<WifiInfo> GroupInquiry() {
		List<WifiInfo> groupInquiryList = new ArrayList<>();
		
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

			String sql = "SELECT id, group_name, personal_num, groups_regist, edit_time" + " FROM bookmark_groups ";

			preparedStatement = connection.prepareStatement(sql);
			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String groupName = rs.getString("group_name");
				Integer personalNum = rs.getInt("personal_num");
				Timestamp groupRegist = rs.getTimestamp("group_regist");
				Timestamp editTime = rs.getTimestamp("edit_time");
				
				WifiInfo wifiInfo = new WifiInfo();
				
				wifiInfo.setId(id);
				wifiInfo.setGroupName(groupName);
				wifiInfo.setPersonalNum(personalNum);
				wifiInfo.setGroupRegist(groupRegist);
				wifiInfo.setEditTime(editTime);
				
				groupInquiryList.add(wifiInfo);
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
		return groupInquiryList;
	}

	public void groupAdd(Integer id, String groupName, Integer personalNum, Timestamp bookmarkRegist,
			Timestamp editTime) {
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

			String sql = "INSERT INTO bookmark(id, group_name, personal_num, group_regist, edit_time) VALUES (?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, groupName);
			preparedStatement.setInt(3, personalNum);
			preparedStatement.setTimestamp(4, bookmarkRegist);
			preparedStatement.setTimestamp(5, editTime);

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

	public void GroupEdit(String groupName, Integer personalNum) {
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

			String sql = " UPDATE bookmark SET " + " group_name = ? and personal_num = ? ";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, groupName);
			preparedStatement.setInt(2, personalNum);

			int affected = preparedStatement.executeUpdate();

			if (affected > 0) {
				System.out.println(" 수정 성공 ");
			} else {
				System.out.println(" 수정 실패 ");
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

	public void groupRemove(String groupName, Integer personalNum) {
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

			String sql = " DELETE FROM bookmark_groups " + "WHERE group_name = ? and personal_num ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, groupName);
			preparedStatement.setInt(2, personalNum);

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
