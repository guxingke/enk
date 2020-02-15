package com.gxk.enk.gen;

import com.gxk.enk.domain.Instruction;
import java.util.List;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class Gen {

  public byte[] gen(List<Instruction> instructions) {
    ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
    cw.visit(52, Opcodes.ACC_PUBLIC + Opcodes.ACC_SUPER, "Test", null, "java/lang/Object", null);
    {
      MethodVisitor mv = cw.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "main",
          "([Ljava/lang/String;)V", null, null);
      for (Instruction instruction : instructions) {
        instruction.apply(mv);
      }
      mv.visitInsn(Opcodes.RETURN);
      mv.visitMaxs(-1, -1);

      mv.visitEnd();
    }
    return cw.toByteArray();
  }
}
