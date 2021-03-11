package com.iquestgroup.remotelearning.week2.w2p2.models;

import java.util.ArrayList;
import java.util.List;

public class TankImpl implements Tank<TankObject> {

  private static final int FIRST_INDEX_TANK_OBJECTS = 0;
  private static final int SECOND_INDEX_TANK_OBJECTS = 1;
  private final int numberTankObjects;
  private final int id;
  private final List<TankObject> tankObjects;

  public TankImpl(int numberTankObjects, int id) {
    this.numberTankObjects = numberTankObjects;
    this.id = id;
    tankObjects = new ArrayList<>(numberTankObjects);
    fillTank();
  }

  @Override
  public void fillTank() {
    for (int index = FIRST_INDEX_TANK_OBJECTS; index < numberTankObjects; index++) {
      push(new TankObject());
    }
  }

  @Override
  public void emptyTank() {
    for (int index = FIRST_INDEX_TANK_OBJECTS; index < tankObjects.size(); index++) {
      pop();
    }
  }

  @Override
  public boolean isFull() {
    return tankObjects.size() == numberTankObjects;
  }

  @Override
  public void push(TankObject value) {
    if (!isFull()) {
      tankObjects.add(value);
    } else {
      System.out.println("Stack is full. You can not add anymore!");
    }
  }

  @Override
  public TankObject pop() {
    if (!isEmpty()) {
      return tankObjects.remove(tankObjects.size() - SECOND_INDEX_TANK_OBJECTS);
    }
    throw new IndexOutOfBoundsException("List is empty!");
  }

  @Override
  public boolean isEmpty() {
    return tankObjects.isEmpty();
  }

  @Override
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
