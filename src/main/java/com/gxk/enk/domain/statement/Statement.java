package com.gxk.enk.domain.statement;

import com.gxk.enk.gen.StatementGenerator;

public abstract class Statement {

  public abstract void accept(StatementGenerator generator);
}
