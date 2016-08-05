import static org.junit.Assert.assertEquals;
import org.junit.Test;
import dbtest.MySqlTest;
import java.sql.*;

public class Tester {
  @Test
  public void allInOneTest() throws Exception {
    MySqlTest db = new MySqlTest();
    String sql;

    try{
      ResultSet rs = null;

      sql = "DROP TABLE IF EXISTS employees";
      rs = db.executeQuery(sql, MySqlTest.TYPE_UPDATE);

      sql = "CREATE TABLE employees( " +
        "id integer not null auto_increment," +
        "name varchar(40) default ''," +
        "age integer, " +
        "PRIMARY KEY (id))";

      rs = db.executeQuery(sql, MySqlTest.TYPE_UPDATE);

      sql = "INSERT INTO employees (name, age) values('Amogh', 21)";
      rs = db.executeQuery(sql, MySqlTest.TYPE_UPDATE);

      sql = "SELECT * FROM employees";
      rs = db.executeQuery(sql, MySqlTest.TYPE_QUERY);

      while(rs.next()){
        System.out.printf("Name: %s, Age: %s\n", rs.getString("name"), rs.getString("age"));
        String name = rs.getString("name");
        assertEquals("name must be Amogh", "Amogh", name);
      }

      rs.close();
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }
}
