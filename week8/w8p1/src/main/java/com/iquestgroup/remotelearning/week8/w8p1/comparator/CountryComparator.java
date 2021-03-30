package com.iquestgroup.remotelearning.week8.w8p1.comparator;

import com.iquestgroup.remotelearning.week8.w8p1.models.Country;
import java.util.Comparator;

public class CountryComparator implements Comparator<Country> {

  @Override
  public int compare(Country o1, Country o2) {
    return o1.getCapital().compareTo(o2.getCapital());
  }
}
