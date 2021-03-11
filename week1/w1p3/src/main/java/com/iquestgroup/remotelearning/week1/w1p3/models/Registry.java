package com.iquestgroup.remotelearning.week1.w1p3.models;

import java.util.HashMap;

public class Registry {

  private HashMap<String, Domain> domains;

  public Registry() {
    domains = new HashMap<String, Domain>();
  }

  public Domain createDomain(String domainName, String ownerName, String ownerCnp, String host) {
    Domain currentDomain = new Domain(domainName, ownerName, ownerCnp, host);
    domains.put(ownerName, currentDomain);
    return currentDomain;
  }
}