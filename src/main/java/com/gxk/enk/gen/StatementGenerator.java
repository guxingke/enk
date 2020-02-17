package com.gxk.enk.gen;

import com.gxk.enk.antlr.EnkelLexer;
import com.gxk.enk.domain.Scope;
import com.gxk.enk.domain.expression.Expression;
import com.gxk.enk.domain.statement.ExpressionListStatement;
import com.gxk.enk.domain.statement.PrintStatement;
import com.gxk.enk.domain.statement.VariableDeclarationStatement;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class StatementGenerator {

  private final MethodVisitor mv;
  private final Scope scope;
  private final ExpressionGenerator expressionGenerator;

  public StatementGenerator(MethodVisitor mv, Scope scope) {
    this.mv = mv;
    this.scope = scope;
    expressionGenerator = new ExpressionGenerator(mv, scope);
  }

  public void gen(PrintStatement statement) {
    Expression expression = statement.getExpression();
    mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
    expression.accept(expressionGenerator);
    int type = expression.getType();

    if (type == EnkelLexer.NUMBER) {
      mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
    } else if (type == EnkelLexer.STRING) {
      mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println",
          "(Ljava/lang/String;)V", false);
    }
  }

  public void gen(ExpressionListStatement statement) {
    for (Expression expression : statement.getExpressions()) {
      expression.accept(expressionGenerator);
    }
  }

  public void gen(VariableDeclarationStatement statement) {
    Expression expression = statement.getExpression();
    expression.accept(expressionGenerator);
    int index = scope.getLocalVariableIndex(statement.getName());
    int type = expression.getType();
    if (type == EnkelLexer.NUMBER) {
      mv.visitVarInsn(Opcodes.ISTORE, index);
    } else if (type == EnkelLexer.STRING) {
      mv.visitVarInsn(Opcodes.ASTORE, index);
    }
  }
}