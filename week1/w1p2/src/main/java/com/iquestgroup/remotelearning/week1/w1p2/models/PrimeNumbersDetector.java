package com.iquestgroup.remotelearning.week1.w1p2.models;

public class PrimeNumbersDetector implements NumbersPrinter, PrimeChecker {

  private int upperLimit;

  public PrimeNumbersDetector(int upperLimit) {
    this.upperLimit = upperLimit;
  }

  public int getUpperLimit() {
    return upperLimit;
  }

  @Override
  public boolean isPrime(int currentNumber) {
    if (currentNumber <= 1) {
      return false;
    } else if (currentNumber == 2) {
      return true;
    } else if (currentNumber % 2 == 0) {
      return false;
    }
    for (int possibleDivider = 3; possibleDivider <= Math.sqrt(currentNumber);
        possibleDivider += 2) {
      if (currentNumber % possibleDivider == 0) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean isLastNumber(int currentNumber) {
    return currentNumber == this.getUpperLimit() ? true : false;
  }

  @Override
  public void printNumbers() {
    System.out.print(1 + ", ");
    for (int currentNumber = 2; currentNumber <= this.getUpperLimit(); currentNumber++) {
      if (isPrime(currentNumber) && isLastNumber(currentNumber)) {
        System.out.print(currentNumber + "-PRIME" + ").");
      } else if (isPrime(currentNumber)) {
        System.out.print(currentNumber + "-PRIME" + ", ");
      } else if (isLastNumber(currentNumber)) {
        System.out.print(currentNumber + "). ");
      } else {
        System.out.print(currentNumber + ", ");
      }
    }
  }
}