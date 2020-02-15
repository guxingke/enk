package com.gxk.enk;

import com.gxk.enk.antlr.EnkelBaseListener;
import com.gxk.enk.antlr.EnkelParser.PrintContext;
import com.gxk.enk.antlr.EnkelParser.ValueContext;
import com.gxk.enk.antlr.EnkelParser.VariableContext;
import com.gxk.enk.domain.Instruction;
import com.gxk.enk.domain.PrintVariable;
import com.gxk.enk.domain.Variable;
import com.gxk.enk.domain.VariableDeclaration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.antlr.v4.runtime.tree.TerminalNode;

public class EnkListener extends EnkelBaseListener {

  private Map<String, Variable> variables = new HashMap<>();
  private List<Instruction> insts = new ArrayList<>();

  @Override
  public void exitVariable(VariableContext ctx) {
    TerminalNode id = ctx.ID();
    ValueContext value = ctx.value();
    int varType = value.getStart().getType();
    String text = value.getText();
    Variable var = new Variable(variables.size(), varType, text);
    variables.put(id.getText(), var);
    insts.add(new VariableDeclaration(var));
  }

  @Override
  public void exitPrint(PrintContext ctx) {
    TerminalNode id = ctx.ID();
    String name = id.getText();
    Variable val = variables.get(id.getText());
    if (val == null) {
      throw new IllegalStateException();
    }
    PrintVariable inst = new PrintVariable(val);
    insts.add(inst);
  }

  public List<Instruction> getInsts() {
    return insts;
  }
}
