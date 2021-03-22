package com.iquestgroup.remotelearning.week5.w5p1.models;

import com.iquestgroup.remotelearning.week5.w5p1.exceptions.CustomException;
import com.iquestgroup.remotelearning.week5.w5p1.models.List;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.lang3.math.NumberUtils;

public class StringList implements List<String> {

  private static final int LIST_CAPACITY = 4;
  private static final int STRINGS_ARE_EQUAL = 0;
  private final java.util.List<String> operations = new ArrayList<>();
  private Integer[] numbers = new Integer[LIST_CAPACITY];
  private int indexNumber;

  public StringList() {
    indexNumber = 0;
  }

  public java.util.List<String> getOperations() {
    return operations;
  }

  @Override
  public void add(String element) throws CustomException {
    operations.add("add()");
    if (isNullOrEmpty(element)) {
      throw new CustomException("Null");
    } else if (!NumberUtils.isCreatable(element)) {
      throw new CustomException("Invalid number.");
    } else {
      if (numbers.length == LIST_CAPACITY) {
        resizeArray();
      }
      numbers[indexNumber++] = Integer.parseInt(element);
    }
  }

  @Override
  public String get(int position) throws CustomException {
    operations.add("get()");
    if (isIndexOutOfBounds(position)) {
      throw new CustomException("Index out of bounds.");
    } else {
      return Integer.toString(numbers[position]);
    }
  }

  @Override
  public boolean contains(String element) {
    operations.add("contains()");
    for (Integer currentNumber : numbers) {
      if (Integer.toString(currentNumber).compareTo(element) == STRINGS_ARE_EQUAL) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean containsAll(List<String> foreignList) {
    operations.add("containsAll()");
    java.util.List arrayAsList = Arrays.asList(numbers);
    for (int index = 0; index < foreignList.size(); index++) {
      if (!arrayAsList.contains(foreignList.get(index))) {
        return false;
      }
    }
    return true;
  }

  @Override
  public int size() {
    operations.add("size()");
    return indexNumber;
  }

  private boolean isNullOrEmpty(String currentString) {
    return currentString == null || currentString.isEmpty();
  }

  private boolean isIndexOutOfBounds(int index) {
    return index >= indexNumber;
  }

  private void resizeArray() {
    Integer[] oldNumbers = Arrays.copyOf(numbers, LIST_CAPACITY);
    numbers = new Integer[LIST_CAPACITY * 2];
    for (int index = 0; index < oldNumbers.length; index++) {
      numbers[index] = oldNumbers[index];
    }
  }
}
