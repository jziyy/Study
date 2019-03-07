package aaaa.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcUtil {

	public static Connection getConnection() throws Exception {
			//加载数据库驱动程序
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.22.41.114:1521/orcl", "o2optzq", "o2optzq");
			return conn;
	}
	
	
	public static void close(ResultSet rs,Statement st,Connection conn){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(st != null){
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@SuppressWarnings("unchecked")
	public static List getList(String sql) {
		 Connection conOrcale = null;
		 Statement stat = null;
		 ResultSet rs;
		 ResultSetMetaData rsmd;
		 PreparedStatement pstat;
		List ll = new ArrayList();
		try {
			conOrcale =getConnection();
			stat = conOrcale.createStatement();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			// �õ������
			rs = stat.executeQuery(sql);
			// ���ڻ�ȡ���� ResultSet �������е����ͺ�������Ϣ�Ķ���
			rsmd = rs.getMetaData();
			while (rs.next()) {
				try {
					Map rowData = new HashMap();
					for (int i = 1; i <= rsmd.getColumnCount(); i++)
						rowData.put(rsmd.getColumnName(i), rs.getString(i));
					ll.add(rowData);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			stat.close();
			conOrcale.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ll;
	}

}
