package com.iquestgroup.remotelearning.week1.p3;

public class Domain {

  private String domainName;
  private String ownerName;
  private String ownerCnp;
  private String host;

  Domain(String domainName, String ownerName, String ownerCnp, String host) {
    this.domainName = domainName;
    this.ownerName = ownerName;
    this.ownerCnp = ownerCnp;
    this.host = host;
  }

  public void displayDetails() {
    System.out.println(domainName + " " + ownerName + " " + ownerCnp + " " + host);
  }
}