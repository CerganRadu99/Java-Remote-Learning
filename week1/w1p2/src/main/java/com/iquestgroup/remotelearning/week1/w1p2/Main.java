package com.iquestgroup.remotelearning.week1.w1p2;

import com.iquestgroup.remotelearning.week1.w1p2.models.PrimeNumbersDetector;


public class Main {

  public static void main(String[] args) {
    if (args.length > 0) {
      try {
        int upperLimit = Integer.parseInt(args[0]);
        PrimeNumbersDetector primeNumbersDetector = new PrimeNumbersDetector(upperLimit);
        primeNumbersDetector.printNumbers();
      } catch (NumberFormatException e) {
        e.printStackTrace();
      }
    } else {
      System.out
          .println("This prime numbers works only with numbers provided as an argument!");
    }
  }

}
