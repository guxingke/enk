package com.gxk.enk.domain.expression;

import com.gxk.enk.gen.ExpressionGenerator;

public class VarReferenceExpression extends Expression {

  private final String varName;
  private final int type;

  public VarReferenceExpression(String varName, int type) {
    this.varName = varName;
    this.type = type;
  }

  public String getVarName() {
    return varName;
  }

  public int getType() {
    return type;
  }

  @Override
  public void accept(ExpressionGenerator generator) {
    generator.gen(this);
  }
}