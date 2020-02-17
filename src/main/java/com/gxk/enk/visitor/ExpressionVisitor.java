package com.gxk.enk.visitor;

import com.gxk.enk.antlr.EnkelBaseVisitor;
import com.gxk.enk.antlr.EnkelParser.VALUEContext;
import com.gxk.enk.antlr.EnkelParser.VARREFERENCEContext;
import com.gxk.enk.antlr.EnkelParser.VarReferenceContext;
import com.gxk.enk.domain.LocalVariable;
import com.gxk.enk.domain.Scope;
import com.gxk.enk.domain.expression.Expression;
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
}
