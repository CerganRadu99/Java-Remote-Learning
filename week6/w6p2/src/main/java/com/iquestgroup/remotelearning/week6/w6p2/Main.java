package com.iquestgroup.remotelearning.week6.w6p2;

import com.iquestgroup.remotelearning.week6.w6p2.models.Calculator;
import com.iquestgroup.remotelearning.week6.w6p2.models.ProxyFactory;
import com.iquestgroup.remotelearning.week6.w6p2.models.ScientificCalculator;
import com.iquestgroup.remotelearning.week6.w6p2.models.ScientificCalculatorHandler;

public class Main {

  public static void main(String[] args) {
    ProxyFactory proxyFactory = new ProxyFactory();
    ScientificCalculator scientificCalculator = new ScientificCalculator();
    ScientificCalculatorHandler handler = new ScientificCalculatorHandler(scientificCalculator);
    Calculator calculator = (Calculator) proxyFactory
        .createProxy(Calculator.class.getClassLoader(), new Class[]{Calculator.class}, handler);
    System.out.println(calculator.add(10, 5));
    System.out.println(calculator.sub(10, 5));
    System.out.println(calculator.multiply(10, 5));
  }
}
