package com.iquestgroup.remotelearning.week1.p3.models;

public class Registrar {

  private final Registry registry;

  public Registrar(Registry registry) {
    this.registry = registry;
  }

  public Domain getDomain(String domainName, String ownerName, String ownerCnp, String host) {
    return registry.createDomain(domainName, ownerName, ownerCnp, host);
  }
}