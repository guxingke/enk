package com.gxk.enk;

import com.gxk.enk.antlr.EnkelLexer;
import com.gxk.enk.antlr.EnkelParser;
import com.gxk.enk.domain.Instruction;
import com.gxk.enk.gen.Gen;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {

  public static void main(String[] args) throws IOException {
    CharStream stream = CharStreams
        .fromString("val x = 1\n print x\nval xx =\"test\"\nprint xx\nprint x");
    EnkelLexer lexer = new EnkelLexer(stream);
    CommonTokenStream tokenStream = new CommonTokenStream(lexer);
    EnkelParser parser = new EnkelParser(tokenStream);

    EnkListener listener = new EnkListener();
    parser.addParseListener(listener);

    parser.compilationUnit();

    List<Instruction> insts = listener.getInsts();

    Gen gen = new Gen();
    byte[] bytes = gen.gen(insts);

    Files.write(Paths.get("Test.class"), bytes);
  }
}
