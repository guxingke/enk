package com.gxk.enk.domain.statement;

import com.gxk.enk.domain.expression.Expression;
import com.gxk.enk.gen.StatementGenerator;

public class IfStatement extends Statement {

  private final Expression condition;
  private final Statement trueStatement;
  private final Statement falseStatement;

  public IfStatement(Expression condition, Statement trueStatement,
      Statement falseStatement) {
    this.condition = condition;
    this.trueStatement = trueStatement;
    this.falseStatement = falseStatement;
  }

  @Override
  public void accept(StatementGenerator generator) {
    generator.gen(this);
  }

  public Expression getCondition() {
    return condition;
  }

  public Statement getTrueStatement() {
    return trueStatement;
  }

  public Statement getFalseStatement() {
    return falseStatement;
  }
}
