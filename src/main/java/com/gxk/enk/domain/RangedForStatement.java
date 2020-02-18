package com.gxk.enk.domain;

import com.gxk.enk.domain.expression.Expression;
import com.gxk.enk.domain.statement.Statement;
import com.gxk.enk.gen.StatementGenerator;

public class RangedForStatement extends Statement {

  private final Statement iteratorVariable;
  private final Expression startExpression;
  private final Expression endExpression;
  private final Statement statement;
  private final String varName;
  private final Scope scope;

  public RangedForStatement(Statement iteratorVariable, Expression startExpression,
      Expression endExpression, Statement statement, String varName, Scope scope) {

    this.iteratorVariable = iteratorVariable;
    this.startExpression = startExpression;
    this.endExpression = endExpression;
    this.statement = statement;
    this.varName = varName;
    this.scope = scope;
  }

  @Override
  public void accept(StatementGenerator generator) {
    generator.gen(this);
  }

  public Statement getIteratorVariable() {
    return iteratorVariable;
  }

  public Expression getStartExpression() {
    return startExpression;
  }

  public Expression getEndExpression() {
    return endExpression;
  }

  public Statement getStatement() {
    return statement;
  }

  public String getVarName() {
    return varName;
  }

  public Scope getScope() {
    return scope;
  }
}
