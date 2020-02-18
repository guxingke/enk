package com.gxk.enk.domain;

import com.gxk.enk.domain.expression.Expression;
import com.gxk.enk.gen.ExpressionGenerator;

public class LocalVariableReference extends Expression {

  private final LocalVariable variable;

  public LocalVariableReference(LocalVariable variable) {
    this.variable = variable;
  }

  @Override
  public void accept(ExpressionGenerator generator) {
    generator.gen(this);
  }

  @Override
  public int getType() {
    return variable.getType();
  }

  public LocalVariable getVariable() {
    return variable;
  }
}
