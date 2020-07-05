package traditionalv2.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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
    try (var writer =
        new BufferedWriter(new FileWriter("../Traditional-V2-TestResults_UNSORTED.txt", true))) {
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

  public void sortAlphabetically() {
    try {
      FileReader fileReader = new FileReader("../Traditional-V2-TestResults_UNSORTED.txt");
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      String inputLine;
      List<String> lineList = new ArrayList<String>();
      while ((inputLine = bufferedReader.readLine()) != null) {
        lineList.add(inputLine);
      }
      fileReader.close();
      Collections.sort(lineList);
      FileWriter fileWriter = new FileWriter("../Traditional-V2-TestResults.txt");
      PrintWriter out = new PrintWriter(fileWriter);
      for (String outputLine : lineList) {
        out.println(outputLine);
      }
      out.flush();
      out.close();
      fileWriter.close();
    } catch (FileNotFoundException e) {
      log.error(" :: File not found -> " + e.getMessage());
    } catch (IOException e) {
      log.error(" :: Error writing sorted file -> " + e.getMessage());
    }
  }
}
