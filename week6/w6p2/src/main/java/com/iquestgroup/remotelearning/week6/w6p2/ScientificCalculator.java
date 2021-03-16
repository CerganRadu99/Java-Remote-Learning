package com.iquestgroup.remotelearning.week6.w6p2;

public class ScientificCalculator implements Calculator {

  private static final double DELTA = 0.001;

  public ScientificCalculator() {
  }

  @Logged
  @Override
  public int add(int firstNumber, int secondNumber) {
    return firstNumber + secondNumber;
  }

  @Logged
  @Override
  public int sub(int firstNumber, int secondNumber) {
    return firstNumber - secondNumber;
  }

  @Override
  public int multiply(int firstNumber, int secondNumber) {
    return firstNumber * secondNumber;
  }
}
