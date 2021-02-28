package com.iquestgroup.remotelearning.week2.p2.models;

import java.util.ArrayList;
import java.util.List;

public class TankImpl<T> implements Tank<T> {

  private final int numberTankObjects;
  private final int id;
  private List<T> tankObjects;

  public TankImpl(int numberTankObjects, int id) {
    this.numberTankObjects = numberTankObjects;
    this.id = id;
    tankObjects = new ArrayList<T>(numberTankObjects);
    fillTank();
  }

  @Override
  public void fillTank() {
    for (int index = 0; index < numberTankObjects; index++) {
      push((T) new TankObject());
    }
  }

  @Override
  public void emptyTank() {
    for (int index = 0; index < tankObjects.size(); index++) {
      pop();
    }
  }

  @Override
  public boolean isFull() {
    return tankObjects.size() == numberTankObjects;
  }

  @Override
  public void push(T value) {
    if (!isFull()) {
      tankObjects.add(value);
    } else {
      System.out.println("Stack is full. You can not add anymore!");
    }
  }

  @Override
  public T pop() {
    if (!isEmpty()) {
      return tankObjects.remove(tankObjects.size() - 1);
    }
    return null;
  }

  @Override
  public boolean isEmpty() {
    return tankObjects.isEmpty();
  }

  protected void finalize() throws Throwable {
    if (!isEmpty()) {
      System.out.println("tank " + id + " is not empty!");
      return;
    } else {
      System.out.println("tank " + id + " is empty!");
    }
    super.finalize();
  }
}
