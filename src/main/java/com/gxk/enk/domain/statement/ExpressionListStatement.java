package com.gxk.enk.domain.statement;

import com.gxk.enk.domain.expression.Expression;
import com.gxk.enk.gen.StatementGenerator;
import java.util.List;

public class ExpressionListStatement extends Statement {

  private final List<Expression> expressions;

  public ExpressionListStatement(List<Expression> expressions) {
    this.expressions = expressions;
  }

  @Override
  public void accept(StatementGenerator generator) {
    generator.gen(this);
  }

  public List<Expression> getExpressions() {
    return expressions;
  }
}
