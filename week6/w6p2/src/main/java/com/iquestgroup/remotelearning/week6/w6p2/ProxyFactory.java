package com.iquestgroup.remotelearning.week6.w6p2;

public class ProxyFactory {

  public ProxyFactory() {
  }

  public ProxiScientificCalculator createCalculator() {
    Calculator calculator = new ScientificCalculator();
    return new ProxiScientificCalculator(calculator);
  }
}
