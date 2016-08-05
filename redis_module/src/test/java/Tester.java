import static org.junit.Assert.assertEquals;
import org.junit.Test;
import redistest.RedisTest;
import java.sql.*;

public class Tester {
  @Test
  public void allInOneTest() throws Exception {
    RedisTest redis = new RedisTest();
    redis.connect("localhost", 6379);

    redis.set("Amogh", "Rathore");
    System.out.println("Value for Amogh: " + redis.get("Amogh"));
    assertEquals("Value for key Amogh should be Rathore", "Rathore", redis.get("Amogh"));
  }
}
