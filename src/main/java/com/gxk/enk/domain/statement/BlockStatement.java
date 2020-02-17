package com.gxk.enk.domain.statement;

import com.gxk.enk.gen.StatementGenerator;
import java.util.List;

public class BlockStatement extends Statement {

  private final List<Statement> statements;

  public BlockStatement(List<Statement> statements) {
    this.statements = statements;
  }

  @Override
  public void accept(StatementGenerator generator) {
    generator.gen(this);
  }

  public List<Statement> getStatements() {
    return statements;
  }
}
