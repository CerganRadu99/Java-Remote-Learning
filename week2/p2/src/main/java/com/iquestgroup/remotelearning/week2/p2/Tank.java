package com.iquestgroup.remotelearning.week2.p2;

import java.util.ArrayList;
import java.util.List;

public class Tank<T> implements Stackable<T> {

  private final int numberTankObjects;
  private List<T> tankObjects;

  Tank(int numberTankObjects) {
    this.numberTankObjects = numberTankObjects;
    tankObjects = new ArrayList<T>(numberTankObjects);
    fillTank();
  }

  public void fillTank() {
    for (int index = 0; index < numberTankObjects; index++) {
      push((T) new TankObject());
    }
  }

  public void emptyTank() {
    tankObjects.clear();
  }

  @Override
  public void push(T value) {
    tankObjects.add(value);
  }

  @Override
  public T pop() {
    return tankObjects.remove(tankObjects.size() - 1);
  }

  @Override
  public T peek() {
    return tankObjects.get(tankObjects.size() - 1);
  }

  @Override
  public boolean isEmpty() {
    return tankObjects.isEmpty();
  }

  @Override
  public int size() {
    return tankObjects.size();
  }

  protected void finalize() {
    if (!isEmpty()) {
      System.out.println("Error: not empty!");
    }
  }
}
