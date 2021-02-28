package com.iquestgroup.remotelearning.week1.p3;

public class Main {

  public static void main(String[] args) {
    Registrar registrar = new Registrar(new Registry());
    Reseller reseller = new Reseller(registrar);
    Customer customer = new Customer(reseller);
    customer.howManyDomains();
    customer.buyNewDomain("Facebook.com", "Mark Zuckerberg", "1990903160071", "host");
    customer.buyNewDomain("Instagram.com", "Mark Zuckerberg", "1990903160071", "host");
    customer.buyNewDomain("Twitter.com", "Mark Zuckerberg", "1990903160071", "host");
    customer.howManyDomains();
  }

}
