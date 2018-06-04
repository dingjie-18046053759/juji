package test.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBManager {

	private static Connection con;

	public DBManager() {
	}

	/**
	 * 获取连接
	 * @return
	 */
	public static Connection getCon() {
		if (con == null) {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException cnfe) {
				cnfe.printStackTrace();
			}
			String conn = null;
			String sa = null;
			String password = null;
			try {
				conn = "jdbc:sqlserver://118.194.194.35:1433;DatabaseName=JES";
				sa = "jes";
				password = "123456";
				con = DriverManager.getConnection(conn,
					 sa, password);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return con;
	}

	public static void closeConnection() {
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		con = null;
	}

	public static void closePreparedStatement(PreparedStatement pstm) {
		if (pstm != null) {
			try {
				pstm.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			pstm = null;
		}
	}

	public static void closeStatement(Statement stm) {
		if (stm != null) {
			try {
				stm.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		stm = null;
	}

	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		rs = null;
	}

	public static void main(String[] args) {
		Connection c = DBManager.getCon();
		if (c != null) {
			System.out.print("ok");
		} else {
			System.out.print("fail");
		}
	}
}
