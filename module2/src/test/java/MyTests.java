import static org.junit.Assert.assertEquals;
import org.junit.Test;
import module2.hello.Arithmetic;

public class MyTests {
  @Test
  public void multiplicationTest() {
    Arithmetic tester = new Arithmetic();

    assertEquals("3 x 15 must be 45", 45, tester.multiply(3, 15));
    assertEquals("5 x 20 must be 100", 100, tester.multiply(5, 20));
  }
}
