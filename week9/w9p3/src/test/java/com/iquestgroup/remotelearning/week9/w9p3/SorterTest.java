package com.iquestgroup.remotelearning.week9.w9p3;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class SorterTest {

  public static final List<Integer> SORTED_LIST;

  static {
    SORTED_LIST = new ArrayList<>(Arrays.asList(-13, -3, 11, 28, 33, 99, 113));
  }

  private Sorter sorter;

  @Before
  public void setup() {
    initData();
  }

  @Test
  public void testSortGenericList() {
    List<Integer> unsortedList = getUnsortedList();
    List<Integer> sortedList = sorter.sort(unsortedList);
    for (int index = 0; index < unsortedList.size(); index++) {
      int expectedResult = SORTED_LIST.get(index);
      int actualResult = sortedList.get(index);
      assertEquals(expectedResult, actualResult);
    }
  }

  private void initData() {
    sorter = new Sorter();
  }

  private ArrayList<Integer> getUnsortedList() {
    ArrayList<Integer> unsortedList = new ArrayList<>();
    unsortedList.add(11);
    unsortedList.add(99);
    unsortedList.add(33);
    unsortedList.add(28);
    unsortedList.add(-13);
    unsortedList.add(113);
    unsortedList.add(-3);
    return unsortedList;
  }
}
