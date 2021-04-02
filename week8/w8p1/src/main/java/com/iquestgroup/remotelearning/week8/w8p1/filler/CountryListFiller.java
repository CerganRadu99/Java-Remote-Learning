package com.iquestgroup.remotelearning.week8.w8p1.filler;

import com.iquestgroup.remotelearning.week8.w8p1.models.Country;
import com.iquestgroup.remotelearning.week8.w8p1.models.CountryGenerator;
import java.util.ArrayList;
import java.util.List;

public class CountryListFiller {

  public List<Country> fillCountryList(CountryGenerator countryGenerator, int length) {
    List<Country> countries = new ArrayList<>();
    for (int index = 0; index < length; index++) {
      countries.add(countryGenerator.next());
    }
    return countries;
  }
}
