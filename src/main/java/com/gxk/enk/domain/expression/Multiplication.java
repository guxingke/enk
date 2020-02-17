package com.gxk.enk.domain.expression;

import com.gxk.enk.domain.expression.Expression;
import com.gxk.enk.gen.ExpressionGenerator;

public class Multiplication extends Expression {

  private final int type;
  private final Expression left;
  private final Expression right;

  public Multiplication(Expression leftExp, Expression rightExp) {
    type = leftExp.getType();
    this.left = leftExp;
    this.right = rightExp;
  }

  @Override
  public void accept(ExpressionGenerator generator) {
    generator.gen(this);
  }

  @Override
  public int getType() {
    return type;
  }

  public Expression getLeft() {
    return left;
  }

  public Expression getRight() {
    return right;
  }
}
