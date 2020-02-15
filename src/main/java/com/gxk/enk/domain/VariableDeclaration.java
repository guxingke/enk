package com.gxk.enk.domain;

import static org.objectweb.asm.Opcodes.ASTORE;
import static org.objectweb.asm.Opcodes.BIPUSH;
import static org.objectweb.asm.Opcodes.ISTORE;

import com.gxk.enk.antlr.EnkelLexer;
import org.objectweb.asm.MethodVisitor;

public class VariableDeclaration implements Instruction {

  Variable variable;

  public VariableDeclaration(Variable variable) {
    this.variable = variable;
  }

  @Override
  public void apply(MethodVisitor mv) {
    final int type = variable.getType();
    if (type == EnkelLexer.NUMBER) {
      int val = Integer.parseInt(variable.getValue());
      mv.visitIntInsn(BIPUSH, val);
      mv.visitVarInsn(ISTORE, variable.getId());
    } else if (type == EnkelLexer.STRING) {
      mv.visitLdcInsn(variable.getValue());
      mv.visitVarInsn(ASTORE, variable.getId());
    }
  }
}