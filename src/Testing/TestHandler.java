package Testing;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestHandler {
  public static void main(String[] args) {
    Result result = JUnitCore.runClasses(PhotoTest.class, PhotoMergerTest.class, ProjectControllerTest.class, InputValidatorTest.class);
    for (Failure failure : result.getFailures()) {
      System.out.println(failure.toString());
    }
  }
}