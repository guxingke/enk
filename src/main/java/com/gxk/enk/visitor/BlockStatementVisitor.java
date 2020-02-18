package com.gxk.enk.visitor;

import com.gxk.enk.antlr.EnkelBaseVisitor;
import com.gxk.enk.antlr.EnkelParser.BlockContext;
import com.gxk.enk.antlr.EnkelParser.ExpressionContext;
import com.gxk.enk.antlr.EnkelParser.ExpressionListContext;
import com.gxk.enk.antlr.EnkelParser.ForConditionContext;
import com.gxk.enk.antlr.EnkelParser.ForStatementContext;
import com.gxk.enk.antlr.EnkelParser.IfStatementContext;
import com.gxk.enk.antlr.EnkelParser.PrintStatementContext;
import com.gxk.enk.antlr.EnkelParser.StatementContext;
import com.gxk.enk.antlr.EnkelParser.VarReferenceContext;
import com.gxk.enk.antlr.EnkelParser.VariableDeclarationContext;
import com.gxk.enk.domain.LocalVariable;
import com.gxk.enk.domain.RangedForStatement;
import com.gxk.enk.domain.Scope;
import com.gxk.enk.domain.expression.Expression;
import com.gxk.enk.domain.statement.BlockStatement;
import com.gxk.enk.domain.statement.ExpressionListStatement;
import com.gxk.enk.domain.statement.IfStatement;
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

  @Override
  public Statement visitBlock(BlockContext ctx) {
    List<Statement> statements = new ArrayList<>();
    for (StatementContext statementContext : ctx.statement()) {
      Statement statement = statementContext.accept(this);
      statements.add(statement);
    }
    return new BlockStatement(statements);
  }

  @Override
  public Statement visitIfStatement(IfStatementContext ctx) {
    ExpressionContext expression = ctx.expression();

    ExpressionVisitor expressionVisitor = new ExpressionVisitor(scope);
    Expression cond = expression.accept(expressionVisitor);

    Statement trueStatement = ctx.trueStatement.accept(this);
    Statement falseStatement = ctx.falseStatement.accept(this);

    return new IfStatement(cond, trueStatement, falseStatement);
  }

  @Override
  public Statement visitForStatement(ForStatementContext ctx) {
    Scope newScope = scope;
    ForConditionContext forConditionContext = ctx.forCondition();
    ExpressionVisitor expressionVisitor = new ExpressionVisitor(newScope);
    Expression startExpression = forConditionContext.left.accept(expressionVisitor);
    Expression endExpression = forConditionContext.right.accept(expressionVisitor);
    VarReferenceContext iterator = forConditionContext.iterator;
    String varName = iterator.getText();
    newScope.addLocalVariable(new LocalVariable(varName, startExpression.getType()));
    Statement iteratorVariable = new VariableDeclarationStatement(varName, startExpression);
    Statement statement = ctx.statement().accept(this);
    return new RangedForStatement(iteratorVariable, startExpression, endExpression, statement, varName, newScope);
  }

}
