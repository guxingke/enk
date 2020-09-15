package com.gxk.enk.gen;

import com.gxk.enk.antlr.EnkelLexer;
import com.gxk.enk.domain.LocalVariable;
import com.gxk.enk.domain.LocalVariableReference;
import com.gxk.enk.domain.RangedForStatement;
import com.gxk.enk.domain.Scope;
import com.gxk.enk.domain.expression.ConditionalExpression;
import com.gxk.enk.domain.expression.Expression;
import com.gxk.enk.domain.statement.BlockStatement;
import com.gxk.enk.domain.statement.ExpressionListStatement;
import com.gxk.enk.domain.statement.IfStatement;
import com.gxk.enk.domain.statement.PrintStatement;
import com.gxk.enk.domain.statement.Statement;
import com.gxk.enk.domain.statement.VariableDeclarationStatement;
import org.objectweb.asm.Label;
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

  public void gen(IfStatement ifStatement) {
    Expression condition = ifStatement.getCondition();
    condition.accept(expressionGenerator);

    Label falseLabel = new Label();
    Label endLabel = new Label();

    mv.visitJumpInsn(Opcodes.IFEQ, falseLabel);
    ifStatement.getTrueStatement().accept(this);
    mv.visitJumpInsn(Opcodes.GOTO, endLabel);
    mv.visitLabel(falseLabel);
    ifStatement.getFalseStatement().accept(this);
    mv.visitLabel(endLabel);
  }

  public void gen(BlockStatement blockStatement) {
    for (Statement statement : blockStatement.getStatements()) {
      statement.accept(this);
    }
  }

  public void gen(RangedForStatement rangedForStatement) {
    Scope newScope = rangedForStatement.getScope();
    StatementGenerator scopeGeneratorWithNewScope = new StatementGenerator(mv, newScope);
    ExpressionGenerator exprGeneratorWithNewScope = new ExpressionGenerator(mv, newScope);
    Statement iterator = rangedForStatement.getIteratorVariable();
    Label incrementationSection = new Label();
    Label decrementationSection = new Label();
    Label endLoopSection = new Label();
    String iteratorVarName = rangedForStatement.getVarName();
    Expression endExpression = rangedForStatement.getEndExpression();

    LocalVariable variable = new LocalVariable(iteratorVarName, EnkelLexer.NUMBER);
    Expression iteratorVariable = new LocalVariableReference(variable);

    ConditionalExpression iteratorGreaterThanEndConditional = new ConditionalExpression(">",
        iteratorVariable, endExpression);
    ConditionalExpression iteratorLessThanEndConditional = new ConditionalExpression("<",
        iteratorVariable, endExpression);

    iterator.accept(scopeGeneratorWithNewScope);

    iteratorLessThanEndConditional.accept(exprGeneratorWithNewScope);
    mv.visitJumpInsn(Opcodes.IFEQ, decrementationSection);

//    iteratorGreaterThanEndConditional.accept(exprGeneratorWithNewScope);
//    mv.visitJumpInsn(Opcodes.IFEQ, incrementationSection);

    mv.visitLabel(incrementationSection);
    rangedForStatement.getStatement().accept(scopeGeneratorWithNewScope);
    mv.visitIincInsn(newScope.getLocalVariableIndex(iteratorVarName), 1);
    iteratorGreaterThanEndConditional.accept(exprGeneratorWithNewScope);
    mv.visitJumpInsn(Opcodes.IFNE, endLoopSection);
    mv.visitJumpInsn(Opcodes.GOTO, incrementationSection);

    mv.visitLabel(decrementationSection);
    rangedForStatement.getStatement().accept(scopeGeneratorWithNewScope);
    mv.visitIincInsn(newScope.getLocalVariableIndex(iteratorVarName), -1);
    iteratorLessThanEndConditional.accept(exprGeneratorWithNewScope);
    mv.visitJumpInsn(Opcodes.IFNE, endLoopSection);
    mv.visitJumpInsn(Opcodes.GOTO, decrementationSection);

    mv.visitLabel(endLoopSection);
  }
}
