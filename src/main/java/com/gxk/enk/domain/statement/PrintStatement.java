package com.gxk.enk.domain.statement;

import com.gxk.enk.domain.expression.Expression;
import com.gxk.enk.gen.StatementGenerator;

public class PrintStatement extends Statement {

  private final Expression expression;

  public PrintStatement(Expression expression) {
    this.expression = expression;
  }

  @Override
  public void accept(StatementGenerator generator) {
    generator.gen(this);
  }

  public Expression getExpression() {
    return expression;
  }
}
