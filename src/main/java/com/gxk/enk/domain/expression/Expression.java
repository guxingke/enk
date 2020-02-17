package com.gxk.enk.domain.expression;

import com.gxk.enk.gen.ExpressionGenerator;

public abstract class Expression {

  public abstract void accept(ExpressionGenerator generator);

  public abstract int getType();
}
