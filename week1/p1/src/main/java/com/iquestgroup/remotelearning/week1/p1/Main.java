package com.iquestgroup.remotelearning.week1.p1;

import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws Exception {
    String fileName = "/txt/W1P1input.txt";
    InputStream inputStream = Main.class.getResourceAsStream(fileName);
    if (inputStream == null) {
      throw new Exception("resource not found: " + fileName);
    }
    InputStreamReader inputReader = new InputStreamReader(inputStream);
    App application = new App();
    application.executeApp(inputReader);
  }

}
