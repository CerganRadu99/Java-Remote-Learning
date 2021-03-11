package com.iquestgroup.remotelearning.week1.w1p1;

import com.iquestgroup.remotelearning.week1.w1p1.models.PersonProcessor;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws Exception {
    String fileName = "/W1P1input.txt";
    InputStream inputStream = Main.class.getResourceAsStream(fileName);
    if (inputStream == null) {
      throw new Exception("resource not found: " + fileName);
    }
    InputStreamReader inputReader = new InputStreamReader(inputStream);
    PersonProcessor personProcessor = new PersonProcessor();
    personProcessor.execute(inputReader);
  }

}

