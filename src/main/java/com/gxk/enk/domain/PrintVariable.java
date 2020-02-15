package com.gxk.enk.domain;

import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.GETSTATIC;
import static org.objectweb.asm.Opcodes.ILOAD;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;

import com.gxk.enk.antlr.EnkelLexer;
import org.objectweb.asm.MethodVisitor;

public class PrintVariable implements Instruction {

  private final Variable variable;

  public PrintVariable(Variable variable) {
    this.variable = variable;
  }

  @Override
  public void apply(MethodVisitor mv) {
    final int type = variable.getType();
    final int id = variable.getId();
    mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
    if (type == EnkelLexer.NUMBER) {
      mv.visitVarInsn(ILOAD, id);
      mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
    } else if (type == EnkelLexer.STRING) {
      mv.visitVarInsn(ALOAD, id);
      mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V",
          false);
    }
  }
}
