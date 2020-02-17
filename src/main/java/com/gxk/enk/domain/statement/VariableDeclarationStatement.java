package com.gxk.enk.domain.statement;

import com.gxk.enk.domain.expression.Expression;
import com.gxk.enk.gen.StatementGenerator;
import org.objectweb.asm.MethodVisitor;

public class VariableDeclarationStatement extends Statement {

  private final String name;
  private final Expression expression;

  public VariableDeclarationStatement(String name, Expression expression) {
    this.name = name;
    this.expression = expression;
  }

  @Override
  public void accept(StatementGenerator generator) {
    generator.gen(this);
  }

  public String getName() {
    return name;
  }

  public Expression getExpression() {
    return expression;
  }

//  @Override
//  public void apply(MethodVisitor methodVisitor) {
//
//    expression.apply(methodVisitor);

//    int index = scope.getLocalVariableIndex(name);
//    final int type = variable.getType();
//    if (type == EnkelLexer.NUMBER) {
//      int val = Integer.parseInt(variable.getValue());
//      mv.visitIntInsn(BIPUSH, val);
//      mv.visitVarInsn(ISTORE, variable.getId());
//    } else if (type == EnkelLexer.STRING) {
//      mv.visitLdcInsn(variable.getValue());
//      mv.visitVarInsn(ASTORE, variable.getId());
//    }
//  }
}
