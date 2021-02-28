package com.iquestgroup.remotelearning.week1.p2;

public class PrimeNumbersDetector implements NumbersPrinter, PrimeChecker {

  private int upperLimit;

  PrimeNumbersDetector(int upperLimit) {
    this.upperLimit = upperLimit;
  }

  public int getUpperLimit() {
    return upperLimit;
  }

  @Override
  public boolean isPrime(int currentNumber) {
    for (int possibleDivider = 2; possibleDivider <= currentNumber / 2; possibleDivider++) {
      if (currentNumber % possibleDivider == 0) {
        return true;
      }
    }
    return false;
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