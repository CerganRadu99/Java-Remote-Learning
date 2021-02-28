package com.iquestgroup.remotelearning.week1.p3;

import java.util.HashMap;

public class Registry {

  private HashMap<String, Domain> domains;

  Registry() {
    domains = new HashMap<String, Domain>();
  }

  public Domain createDomain(String domainName, String ownerName, String ownerCnp, String host) {
    Domain currentDomain = new Domain(domainName, ownerName, ownerCnp, host);
    domains.put(ownerName, currentDomain);
    return currentDomain;
  }
}