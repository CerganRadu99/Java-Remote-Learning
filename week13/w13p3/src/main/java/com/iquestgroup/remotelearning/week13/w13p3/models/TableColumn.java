package com.iquestgroup.remotelearning.week13.w13p3.models;

import java.util.Objects;

public class TableColumn {

  private final String name;
  private final String type;
  private final int size;

  public TableColumn(String name, String type, int size) {
    this.name = name;
    this.type = type;
    this.size = size;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    TableColumn that = (TableColumn) object;
    return size == that.size && Objects.equals(name, that.name) && Objects.equals(type, that.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, type, size);
  }
}
