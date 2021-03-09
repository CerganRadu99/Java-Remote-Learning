package com.iquestgroup.remotelearning.week5.p4;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    PigLatinTranslator pigLatinTranslator = new PigLatinTranslatorImpl();
    System.out.println("Enter English phrases. Close the frame when you want to finish");
    Scanner scanner = new Scanner(System.in);
    while (true) {
      pigLatinTranslator.translatePhrase(scanner.nextLine());
    }
  }
}
