package com.iquestgroup.remotelearning.week16.w16p1.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "address")
public class Address {

  @Id
  private int id;

  private String street;

  private int streetNumber;

  private String city;

  private String country;
}
