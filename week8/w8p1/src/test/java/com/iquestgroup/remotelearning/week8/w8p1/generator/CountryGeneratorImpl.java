package com.iquestgroup.remotelearning.week8.w8p1.generator;

import com.iquestgroup.remotelearning.week8.w8p1.models.Country;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CountryGeneratorImpl implements CountryGenerator {

  private static final int RANDOM_SEED = 49;
  private static final Random RANDOM = new Random(RANDOM_SEED);
  private static final Map<String, String> COUNTRIES = new HashMap<>();
  private static final String[] NAMES_OF_COUNTRIES;

  static {
    COUNTRIES.put("Colombia", "Bogota");
    COUNTRIES.put("Croatia", "Zagreb");
    COUNTRIES.put("Portugal", "Lisbon");
    COUNTRIES.put("Poland", "Warsaw");
    COUNTRIES.put("Finland", "Helsinki");
    COUNTRIES.put("Spain", "Madrid");
    COUNTRIES.put("France", "Paris");
    COUNTRIES.put("Sweden", "Stockholm");
    COUNTRIES.put("Romania", "Bucharest");
    NAMES_OF_COUNTRIES = new String[]{"Colombia", "Croatia", "Portugal", "Poland", "Finland", "Spain", "Sweden", "Romania", "France"};
  }

  @Override
  public Country next() {
    String countryName = NAMES_OF_COUNTRIES[RANDOM.nextInt(COUNTRIES.size())];
    String countryCapital = COUNTRIES.get(countryName);
    return new Country(countryName, countryCapital);
  }
}
