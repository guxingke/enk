package com.gxk.enk.domain.expression;

import com.gxk.enk.antlr.EnkelLexer;
import com.gxk.enk.gen.ExpressionGenerator;

public class ValueExpression extends Expression {

  private final String val;

  public ValueExpression(String val) {
    this.val = val;
  }

  @Override
  public void accept(ExpressionGenerator generator) {
    generator.gen(this);
  }

  @Override
  public int getType() {
    if (val.startsWith("\"")) {
      return EnkelLexer.STRING;
    }
    return EnkelLexer.NUMBER;
  }

  public String getVal() {
    return val;
  }
}
