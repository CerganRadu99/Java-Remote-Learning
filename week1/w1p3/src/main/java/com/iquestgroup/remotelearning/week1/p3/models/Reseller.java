package com.iquestgroup.remotelearning.week1.p3.models;

public class Reseller {

  private Registrar registrar;

  public Reseller(Registrar registrar) {
    this.registrar = registrar;
  }

  public Domain triggerCreateDomainProcess(String domainName, String ownerName, String ownerCnp,
      String host) {
    return registrar.getDomain(domainName, ownerName, ownerCnp, host);
  }
}