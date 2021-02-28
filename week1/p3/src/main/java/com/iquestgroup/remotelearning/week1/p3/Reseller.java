package com.iquestgroup.remotelearning.week1.p3;

public class Reseller {

  private Registrar registrar;

  Reseller(Registrar registrar) {
    this.registrar = registrar;
  }

  public Domain triggerCreateDomainProcess(String domainName, String ownerName, String ownerCnp,
      String host) {
    return registrar.getDomain(domainName, ownerName, ownerCnp, host);
  }
}