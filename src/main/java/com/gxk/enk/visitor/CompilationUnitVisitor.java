package com.gxk.enk.visitor;

import com.gxk.enk.antlr.EnkelBaseVisitor;
import com.gxk.enk.antlr.EnkelParser.CompilationUnitContext;
import com.gxk.enk.antlr.EnkelParser.StatementContext;
import com.gxk.enk.domain.CompilationUnit;
import com.gxk.enk.domain.Scope;
import com.gxk.enk.domain.statement.Statement;
import java.util.ArrayList;
import java.util.List;

public class CompilationUnitVisitor extends EnkelBaseVisitor<CompilationUnit> {

  private Scope scope = new Scope();

  @Override
  public CompilationUnit visitCompilationUnit(CompilationUnitContext ctx) {
    BlockStatementVisitor blockStatementVisitor = new BlockStatementVisitor(scope);
    List<Statement> statements = new ArrayList<>();
    for (StatementContext statementContext : ctx.function().get(0).block().statement()) {
      Statement statement = statementContext.accept(blockStatementVisitor);
      statements.add(statement);
    }

    return new CompilationUnit(statements, scope);
  }
}
