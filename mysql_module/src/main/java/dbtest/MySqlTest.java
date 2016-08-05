package dbtest;

import java.sql.*;

public class MySqlTest {
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  static final String DB_URL = "jdbc:mysql://localhost:5000/root";

  static final String USER = "root";
  static final String PASS = "root";

  public static final int TYPE_QUERY = 1;
  public static final int TYPE_UPDATE = 2;

  public ResultSet executeQuery(String query, int type) throws Exception {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      stmt = conn.createStatement();
      if(type == TYPE_QUERY)
        rs = stmt.executeQuery(query);
      else if (type == TYPE_UPDATE)
        stmt.executeUpdate(query);
    } catch(SQLException se) {
      se.printStackTrace();
      throw se;
    } catch(Exception e) {
      e.printStackTrace();
      throw e;
    }

    return rs;
  }
}
