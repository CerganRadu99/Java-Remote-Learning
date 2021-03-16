package com.iquestgroup.remotelearning.week6.w6p2;

public class Main {

  public static void main(String[] args) {
    ProxyFactory proxyFactory = new ProxyFactory();
    Calculator calculator = proxyFactory.createCalculator();
    System.out.println(calculator.add(5, 10));
    System.out.println(calculator.sub(50, 10));
    System.out.println(calculator.multiply(5, 10));
  }
}
