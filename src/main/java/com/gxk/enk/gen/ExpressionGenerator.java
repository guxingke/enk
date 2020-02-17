package com.gxk.enk.gen;

import com.gxk.enk.antlr.EnkelLexer;
import com.gxk.enk.domain.expression.Addition;
import com.gxk.enk.domain.LocalVariable;
import com.gxk.enk.domain.Scope;
import com.gxk.enk.domain.expression.ConditionalExpression;
import com.gxk.enk.domain.expression.Division;
import com.gxk.enk.domain.expression.Expression;
import com.gxk.enk.domain.expression.Multiplication;
import com.gxk.enk.domain.expression.Substraction;
import com.gxk.enk.domain.expression.ValueExpression;
import com.gxk.enk.domain.expression.VarReferenceExpression;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class ExpressionGenerator {

  private final MethodVisitor mv;
  private final Scope scope;

  public ExpressionGenerator(MethodVisitor mv, Scope scope) {
    this.mv = mv;
    this.scope = scope;
  }

  public void gen(ValueExpression expression) {
    int type = expression.getType();
    String val = expression.getVal();
    if (type == EnkelLexer.NUMBER) {
      int intValue = Integer.parseInt(val);
      mv.visitIntInsn(Opcodes.BIPUSH, intValue);
    } else if (type == EnkelLexer.STRING) {
      mv.visitLdcInsn(val.substring(1, val.length() - 1));
    }
  }

  public void gen(VarReferenceExpression expression) {
    String varName = expression.getVarName();
    LocalVariable localVariable = scope.getLocalVariable(varName);
    int index = scope.getLocalVariableIndex(varName);
    int type = localVariable.getType();
    if (type == EnkelLexer.NUMBER) {
      mv.visitVarInsn(Opcodes.ILOAD, index);
    } else {
      mv.visitVarInsn(Opcodes.ALOAD, index);
    }
  }

  public void gen(Addition expression) {
    expression.getLeft().accept(this);
    expression.getRight().accept(this);
    mv.visitInsn(Opcodes.IADD);
  }

  public void gen(Multiplication expression) {
    expression.getLeft().accept(this);
    expression.getRight().accept(this);
    mv.visitInsn(Opcodes.IMUL);
  }

  public void gen(Substraction expression) {
    expression.getLeft().accept(this);
    expression.getRight().accept(this);
    mv.visitInsn(Opcodes.ISUB);
  }

  public void gen(Division expression) {
    expression.getLeft().accept(this);
    expression.getRight().accept(this);
    mv.visitInsn(Opcodes.IDIV);
  }

  public void gen(ConditionalExpression expression) {
    Expression left = expression.getLeft();
    Expression right = expression.getRight();
    if (left.getType() != right.getType()) {
      throw new IllegalStateException("type not match");
    }
    left.accept(this);
    right.accept(this);

    Label trueLabel = new Label();
    Label endLabel = new Label();
    if (left.getType() == EnkelLexer.STRING) {
      throw new UnsupportedOperationException();
    }

    int opCode = Opcodes.NOP;
    switch (expression.getOp()) {
      case "==":
        opCode = Opcodes.IF_ICMPEQ;
        break;
      case "!=":
        opCode = Opcodes.IF_ICMPNE;
        break;
      case ">":
        opCode = Opcodes.IF_ICMPGT;
        break;
      case ">=":
        opCode = Opcodes.IF_ICMPGE;
        break;
      case "<":
        opCode = Opcodes.IF_ICMPLT;
        break;
      case "<=":
        opCode = Opcodes.IF_ICMPLE;
        break;
    }
    mv.visitJumpInsn(opCode, trueLabel);
    mv.visitInsn(Opcodes.ICONST_0);
    mv.visitJumpInsn(Opcodes.GOTO, endLabel);
    mv.visitLabel(trueLabel);
    mv.visitInsn(Opcodes.ICONST_1);
    mv.visitLabel(endLabel);
  }
}
