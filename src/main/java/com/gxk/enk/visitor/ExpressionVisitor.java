package com.gxk.enk.visitor;

import com.gxk.enk.antlr.EnkelBaseVisitor;
import com.gxk.enk.antlr.EnkelParser.ADDContext;
import com.gxk.enk.antlr.EnkelParser.DIVIDEContext;
import com.gxk.enk.antlr.EnkelParser.ExpressionContext;
import com.gxk.enk.antlr.EnkelParser.MULTIPLYContext;
import com.gxk.enk.antlr.EnkelParser.SUBSTRACTContext;
import com.gxk.enk.antlr.EnkelParser.VALUEContext;
import com.gxk.enk.antlr.EnkelParser.VARREFERENCEContext;
import com.gxk.enk.antlr.EnkelParser.VarReferenceContext;
import com.gxk.enk.domain.expression.Addition;
import com.gxk.enk.domain.LocalVariable;
import com.gxk.enk.domain.Scope;
import com.gxk.enk.domain.expression.Division;
import com.gxk.enk.domain.expression.Expression;
import com.gxk.enk.domain.expression.Multiplication;
import com.gxk.enk.domain.expression.Substraction;
import com.gxk.enk.domain.expression.ValueExpression;
import com.gxk.enk.domain.expression.VarReferenceExpression;

public class ExpressionVisitor extends EnkelBaseVisitor<Expression> {

  private final Scope scope;

  public ExpressionVisitor(Scope scope) {
    this.scope = scope;
  }

  @Override
  public Expression visitVALUE(VALUEContext ctx) {
    String val = ctx.getText();
    return new ValueExpression(val);
  }

  @Override
  public Expression visitVARREFERENCE(VARREFERENCEContext ctx) {
    VarReferenceContext varCtx = ctx.varReference();
    String text = varCtx.getText();
    LocalVariable localVariable = scope.getLocalVariable(text);
    return new VarReferenceExpression(text, localVariable.getType());
  }

  @Override
  public Expression visitADD(ADDContext ctx) {
    ExpressionContext left = ctx.expression(0);
    ExpressionContext right = ctx.expression(1);
    Expression leftExp = left.accept(this);
    Expression rightExp = right.accept(this);

    return new Addition(leftExp, rightExp);
  }

  @Override
  public Expression visitMULTIPLY(MULTIPLYContext ctx) {
    ExpressionContext left = ctx.expression(0);
    ExpressionContext right = ctx.expression(1);
    Expression leftExp = left.accept(this);
    Expression rightExp = right.accept(this);

    return new Multiplication(leftExp, rightExp);
  }

  @Override
  public Expression visitSUBSTRACT(SUBSTRACTContext ctx) {
    ExpressionContext left = ctx.expression(0);
    ExpressionContext right = ctx.expression(1);
    Expression leftExp = left.accept(this);
    Expression rightExp = right.accept(this);

    return new Substraction(leftExp, rightExp);
  }

  @Override
  public Expression visitDIVIDE(DIVIDEContext ctx) {
    ExpressionContext left = ctx.expression(0);
    ExpressionContext right = ctx.expression(1);
    Expression leftExp = left.accept(this);
    Expression rightExp = right.accept(this);

    return new Division(leftExp, rightExp);
  }
}
