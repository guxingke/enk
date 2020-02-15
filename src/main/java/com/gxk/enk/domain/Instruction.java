package com.gxk.enk.domain;

import org.objectweb.asm.MethodVisitor;

public interface Instruction {

  void apply(MethodVisitor methodVisitor);
}
