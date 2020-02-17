package com.gxk.enk.gen;

import com.gxk.enk.domain.CompilationUnit;
import com.gxk.enk.domain.statement.Statement;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class Gen {

  public byte[] gen(CompilationUnit compilationUnit, String className) {
    ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS + ClassWriter.COMPUTE_FRAMES);
    cw.visit(52, Opcodes.ACC_PUBLIC + Opcodes.ACC_SUPER, className, null, "java/lang/Object", null);
    {
      MethodVisitor mv = cw.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "main",
          "([Ljava/lang/String;)V", null, null);

      StatementGenerator statementGenerator = new StatementGenerator(mv,
          compilationUnit.getScope());
      for (Statement statement : compilationUnit.getStatements()) {
        statement.accept(statementGenerator);
      }

      mv.visitInsn(Opcodes.RETURN);
      mv.visitMaxs(-1, -1);

      mv.visitEnd();
    }
    return cw.toByteArray();
  }
}
