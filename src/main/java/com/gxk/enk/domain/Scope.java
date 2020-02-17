package com.gxk.enk.domain;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Scope {

  private List<LocalVariable> localVariables = new ArrayList<>();

  public void addLocalVariable(LocalVariable localVariable) {
    this.localVariables.add(localVariable);
  }

  public LocalVariable getLocalVariable(String name) {
    for (LocalVariable localVariable : localVariables) {
      if (Objects.equals(localVariable.getName(), name)) {
        return localVariable;
      }
    }
    throw new IllegalStateException();
  }

  public int getLocalVariableIndex(String name) {
    int i = 0;
    for (LocalVariable localVariable : localVariables) {
      if (Objects.equals(localVariable.getName(), name)) {
        return i;
      }
      i++;
    }
    throw new IllegalStateException();
  }
}
