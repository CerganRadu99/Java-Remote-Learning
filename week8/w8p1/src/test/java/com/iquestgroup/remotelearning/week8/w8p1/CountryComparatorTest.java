package com.iquestgroup.remotelearning.week8.w8p1;

import static org.junit.Assert.assertEquals;

import com.iquestgroup.remotelearning.week8.w8p1.filler.CountryListFiller;
import com.iquestgroup.remotelearning.week8.w8p1.comparator.CountryComparator;
import com.iquestgroup.remotelearning.week8.w8p1.generator.CountryGeneratorImpl;
import com.iquestgroup.remotelearning.week8.w8p1.models.Country;
import com.iquestgroup.remotelearning.week8.w8p1.models.CountryGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.junit.BeforeClass;
import org.junit.Test;

public class CountryComparatorTest {

  public static final ArrayList<Country> ARRAYLIST_SORTED_BY_NAME;
  public static final ArrayList<Country> ARRAYLIST_SORTED_BY_CAPITAL;
  public static final int VALID_RANDOM_SEED;
  public static final int INDEX_SEARCHED_ELEMENT_WHEN_SORTED_BY_NAME;
  public static final int INDEX_SEARCHED_ELEMENT_WHEN_SORTED_BY_CAPITAL;
  public static final Country VALID_SEARCHED_ELEMENT;

  private static ArrayList<Country> countriesArrayList;

  static {
    ARRAYLIST_SORTED_BY_NAME = new ArrayList<>();
    ARRAYLIST_SORTED_BY_NAME.add(new Country("Colombia", "Bogota"));
    ARRAYLIST_SORTED_BY_NAME.add(new Country("Colombia", "Bogota"));
    ARRAYLIST_SORTED_BY_NAME.add(new Country("Croatia", "Zagreb"));
    ARRAYLIST_SORTED_BY_NAME.add(new Country("Croatia", "Zagreb"));
    ARRAYLIST_SORTED_BY_NAME.add(new Country("Finland", "Helsinki"));
    ARRAYLIST_SORTED_BY_NAME.add(new Country("France", "Paris"));
    ARRAYLIST_SORTED_BY_NAME.add(new Country("Poland", "Warsaw"));
    ARRAYLIST_SORTED_BY_NAME.add(new Country("Portugal", "Lisbon"));
    ARRAYLIST_SORTED_BY_NAME.add(new Country("Sweden", "Stockholm"));
    ARRAYLIST_SORTED_BY_NAME.add(new Country("Sweden", "Stockholm"));
    ARRAYLIST_SORTED_BY_CAPITAL = new ArrayList<>();
    ARRAYLIST_SORTED_BY_CAPITAL.add(new Country("Colombia", "Bogota"));
    ARRAYLIST_SORTED_BY_CAPITAL.add(new Country("Colombia", "Bogota"));
    ARRAYLIST_SORTED_BY_CAPITAL.add(new Country("Finland", "Helsinki"));
    ARRAYLIST_SORTED_BY_CAPITAL.add(new Country("Portugal", "Lisbon"));
    ARRAYLIST_SORTED_BY_CAPITAL.add(new Country("France", "Paris"));
    ARRAYLIST_SORTED_BY_CAPITAL.add(new Country("Sweden", "Stockholm"));
    ARRAYLIST_SORTED_BY_CAPITAL.add(new Country("Sweden", "Stockholm"));
    ARRAYLIST_SORTED_BY_CAPITAL.add(new Country("Poland", "Warsaw"));
    ARRAYLIST_SORTED_BY_CAPITAL.add(new Country("Croatia", "Zagreb"));
    ARRAYLIST_SORTED_BY_CAPITAL.add(new Country("Croatia", "Zagreb"));
    INDEX_SEARCHED_ELEMENT_WHEN_SORTED_BY_NAME = 5;
    INDEX_SEARCHED_ELEMENT_WHEN_SORTED_BY_CAPITAL = 4;
    VALID_SEARCHED_ELEMENT = new Country("France", "Paris");
    VALID_RANDOM_SEED = 49;
  }

  @BeforeClass
  public static void beforeTests() {
    CountryGenerator countryGenerator = new CountryGeneratorImpl();
    CountryListFiller countryListFiller = new CountryListFiller();
    countriesArrayList = (ArrayList<Country>)countryListFiller.fillCountryList(countryGenerator, 10);
  }

  @Test
  public void testSortingByName() {
    Collections.sort(countriesArrayList);
    for (int index = 0; index < countriesArrayList.size(); index++) {
      String expectedName = ARRAYLIST_SORTED_BY_NAME.get(index).getName();
      String actualName = countriesArrayList.get(index).getName();
      String expectedCapital = ARRAYLIST_SORTED_BY_NAME.get(index).getCapital();
      String actualCapital = countriesArrayList.get(index).getCapital();
      assertEquals(expectedName, actualName);
      assertEquals(expectedCapital, actualCapital);
    }
  }

  @Test
  public void testSortingByCapital() {
    Comparator<Country> countryComparator = new CountryComparator();
    countriesArrayList.sort(countryComparator);
    for (int index = 0; index < countriesArrayList.size(); index++) {
      String expectedName = ARRAYLIST_SORTED_BY_CAPITAL.get(index).getName();
      String actualName = countriesArrayList.get(index).getName();
      String expectedCapital = ARRAYLIST_SORTED_BY_CAPITAL.get(index).getCapital();
      String actualCapital = countriesArrayList.get(index).getCapital();
      assertEquals(expectedName, actualName);
      assertEquals(expectedCapital, actualCapital);
    }
  }

  @Test
  public void testBinarySearchWhenSortedByName() {
    Collections.sort(countriesArrayList);
    int actualIndex = Collections.binarySearch(countriesArrayList, VALID_SEARCHED_ELEMENT);
    assertEquals(INDEX_SEARCHED_ELEMENT_WHEN_SORTED_BY_NAME, actualIndex);
  }

  @Test
  public void testBinarySearchWhenSortedByCapital() {
    Comparator<Country> countryComparator = new CountryComparator();
    countriesArrayList.sort(countryComparator);
    int actualIndex = Collections.binarySearch(countriesArrayList, VALID_SEARCHED_ELEMENT, countryComparator);
    assertEquals(INDEX_SEARCHED_ELEMENT_WHEN_SORTED_BY_CAPITAL, actualIndex);
  }
}
