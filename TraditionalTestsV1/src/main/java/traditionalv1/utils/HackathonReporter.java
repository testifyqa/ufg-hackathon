package traditionalv1.utils;

import java.io.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HackathonReporter {

  private static final Logger log = LoggerFactory.getLogger(HackathonReporter.class.getName());

  public boolean checkDomIds(
      int task,
      String testName,
      String domId,
      String browser,
      int viewportWidth,
      int viewportHeight,
      String device,
      boolean comparisonResult) {
    try (var writer = new BufferedWriter(new FileWriter("Traditional-V1-TestResults.txt", true))) {
      writer.write(
          "Task: "
              + task
              + ", Test Name: "
              + testName
              + ", DOM Id: "
              + domId
              + ", Browser: "
              + browser
              + ", Viewport: "
              + viewportWidth
              + "x"
              + viewportHeight
              + ", Device: "
              + device
              + ", Status: "
              + (comparisonResult ? "Pass" : "Fail"));
      writer.newLine();
    } catch (IOException e) {
      log.error(" :: Error writing to report file -> " + e.getMessage());
    }
    return comparisonResult;
  }
}
