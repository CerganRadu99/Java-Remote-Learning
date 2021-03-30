package com.iquestgroup.remotelearning.week8.w8p1.models;

public class Country implements Comparable<Country> {

  private final String name;
  private final String capital;

  public Country(String name, String capital) {
    this.name = name;
    this.capital = capital;
  }

  public String getName() {
    return name;
  }

  public String getCapital() {
    return capital;
  }

  @Override
  public int compareTo(Country country) {
    return name.compareTo(country.getName());
  }
}
