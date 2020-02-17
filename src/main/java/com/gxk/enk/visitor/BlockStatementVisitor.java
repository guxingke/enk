package com.gxk.enk.visitor;

import com.gxk.enk.antlr.EnkelBaseVisitor;
import com.gxk.enk.antlr.EnkelParser.ExpressionContext;
import com.gxk.enk.antlr.EnkelParser.ExpressionListContext;
import com.gxk.enk.antlr.EnkelParser.PrintStatementContext;
import com.gxk.enk.antlr.EnkelParser.VariableDeclarationContext;
import com.gxk.enk.domain.LocalVariable;
import com.gxk.enk.domain.Scope;
import com.gxk.enk.domain.expression.Expression;
import com.gxk.enk.domain.statement.ExpressionListStatement;
import com.gxk.enk.domain.statement.PrintStatement;
import com.gxk.enk.domain.statement.Statement;
import com.gxk.enk.domain.statement.VariableDeclarationStatement;
import java.util.ArrayList;
import java.util.List;

public class BlockStatementVisitor extends EnkelBaseVisitor<Statement> {

  private final Scope scope;

  public BlockStatementVisitor(Scope scope) {
    this.scope = scope;
  }

  @Override
  public Statement visitPrintStatement(PrintStatementContext ctx) {
    ExpressionContext expCtx = ctx.expression();
    Expression expression = expCtx.accept(new ExpressionVisitor(scope));
    return new PrintStatement(expression);
  }

  @Override
  public Statement visitVariableDeclaration(VariableDeclarationContext ctx) {
    String text = ctx.name().getText();

    Expression expression = ctx.expression().accept(new ExpressionVisitor(scope));

    scope.addLocalVariable(new LocalVariable(text, expression.getType()));
    return new VariableDeclarationStatement(text, expression);
  }

  @Override
  public Statement visitExpressionList(ExpressionListContext ctx) {
    List<Expression> expressions = new ArrayList<>();
    ExpressionVisitor expressionVisitor = new ExpressionVisitor(scope);
    for (ExpressionContext expressionContext : ctx.expression()) {
      Expression expression = expressionContext.accept(expressionVisitor);
      expressions.add(expression);
    }
    return new ExpressionListStatement(expressions);
  }
}
