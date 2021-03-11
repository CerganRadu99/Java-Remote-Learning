package com.iquestgroup.remotelearning.week1.w1p3.models;

import java.util.ArrayList;
import java.util.List;

public class Customer {

  private final Reseller reseller;
  private List<Domain> domains;

  public Customer(Reseller reseller) {
    this.reseller = reseller;
    domains = new ArrayList<Domain>();
  }

  public void addDomain(Domain domain) {
    domains.add(domain);
  }

  public void buyNewDomain(String domainName, String ownerName, String ownerCnp, String host) {
    addDomain(reseller.triggerCreateDomainProcess(domainName, ownerName, ownerCnp, host));
  }

  public void howManyDomains() {
    System.out.println(domains.size());
  }
}