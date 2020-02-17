package com.gxk.enk.domain;

public class LocalVariable {

  private final String name;
  private final int type;

  public LocalVariable(String name, int type) {
    this.name = name;
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public int getType() {
    return type;
  }
}
