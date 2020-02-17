package com.gxk.enk.domain.expression;

import com.gxk.enk.gen.ExpressionGenerator;

public class ConditionalExpression extends Expression{

  private final String op;
  private final Expression left;
  private final Expression right;

  public ConditionalExpression(String op, Expression left,
      Expression right) {
    this.op = op;
    this.left = left;
    this.right = right;
  }

  public String getOp() {
    return op;
  }

  public Expression getLeft() {
    return left;
  }

  public Expression getRight() {
    return right;
  }

  @Override
  public void accept(ExpressionGenerator generator) {
    generator.gen(this);
  }

  @Override
  public int getType() {
    return left.getType();
  }
}
