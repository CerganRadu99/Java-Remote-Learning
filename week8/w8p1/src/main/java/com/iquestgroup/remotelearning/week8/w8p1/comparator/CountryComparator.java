package com.iquestgroup.remotelearning.week8.w8p1.generator;

import com.iquestgroup.remotelearning.week8.w8p1.models.Country;
import java.util.Comparator;

public class CountryComparator implements Comparator<Country> {

  @Override
  public int compare(Country country1, Country country2) {
    return country1.getCapital().compareTo(country2.getCapital());
  }
}
