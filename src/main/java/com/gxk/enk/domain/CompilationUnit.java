package com.gxk.enk.domain;

import com.gxk.enk.domain.statement.Statement;
import java.util.List;

public class CompilationUnit {

  private final List<Statement> statements;
  private final Scope scope;

  public CompilationUnit(List<Statement> statements, Scope scope) {
    this.statements = statements;
    this.scope = scope;
  }

  public List<Statement> getStatements() {
    return statements;
  }

  public Scope getScope() {
    return scope;
  }
}
