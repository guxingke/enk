// Generated from Enkel.g4 by ANTLR 4.7.2
package com.gxk.enk.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class EnkelParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		VARIABLE=18, PRINT=19, EQUALS=20, NUMBER=21, STRING=22, ID=23, WS=24;
	public static final int
		RULE_compilationUnit = 0, RULE_block = 1, RULE_statement = 2, RULE_variableDeclaration = 3, 
		RULE_name = 4, RULE_printStatement = 5, RULE_ifStatement = 6, RULE_expressionList = 7, 
		RULE_expression = 8, RULE_varReference = 9, RULE_value = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"compilationUnit", "block", "statement", "variableDeclaration", "name", 
			"printStatement", "ifStatement", "expressionList", "expression", "varReference", 
			"value"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'if'", "'('", "')'", "'else'", "','", "'*'", "'/'", 
			"'+'", "'-'", "'>'", "'<'", "'=='", "'!='", "'>='", "'<='", "'val'", 
			"'print'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "VARIABLE", "PRINT", "EQUALS", "NUMBER", 
			"STRING", "ID", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Enkel.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public EnkelParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CompilationUnitContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(EnkelParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public CompilationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compilationUnit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EnkelVisitor ) return ((EnkelVisitor<? extends T>)visitor).visitCompilationUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompilationUnitContext compilationUnit() throws RecognitionException {
		CompilationUnitContext _localctx = new CompilationUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compilationUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__3) | (1L << VARIABLE) | (1L << PRINT) | (1L << NUMBER) | (1L << STRING) | (1L << ID))) != 0)) {
				{
				{
				setState(22);
				statement();
				}
				}
				setState(27);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(28);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EnkelVisitor ) return ((EnkelVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(T__0);
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__3) | (1L << VARIABLE) | (1L << PRINT) | (1L << NUMBER) | (1L << STRING) | (1L << ID))) != 0)) {
				{
				{
				setState(31);
				statement();
				}
				}
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(37);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public PrintStatementContext printStatement() {
			return getRuleContext(PrintStatementContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EnkelVisitor ) return ((EnkelVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(44);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				block();
				}
				break;
			case VARIABLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(40);
				variableDeclaration();
				}
				break;
			case PRINT:
				enterOuterAlt(_localctx, 3);
				{
				setState(41);
				printStatement();
				}
				break;
			case T__3:
			case NUMBER:
			case STRING:
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(42);
				expressionList();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 5);
				{
				setState(43);
				ifStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclarationContext extends ParserRuleContext {
		public TerminalNode VARIABLE() { return getToken(EnkelParser.VARIABLE, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(EnkelParser.EQUALS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EnkelVisitor ) return ((EnkelVisitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_variableDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(VARIABLE);
			setState(47);
			name();
			setState(48);
			match(EQUALS);
			setState(49);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(EnkelParser.ID, 0); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EnkelVisitor ) return ((EnkelVisitor<? extends T>)visitor).visitName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintStatementContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(EnkelParser.PRINT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EnkelVisitor ) return ((EnkelVisitor<? extends T>)visitor).visitPrintStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintStatementContext printStatement() throws RecognitionException {
		PrintStatementContext _localctx = new PrintStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_printStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(PRINT);
			setState(54);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStatementContext extends ParserRuleContext {
		public StatementContext trueStatement;
		public StatementContext falseStatement;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EnkelVisitor ) return ((EnkelVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(T__2);
			setState(58);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(57);
				match(T__3);
				}
				break;
			}
			setState(60);
			expression(0);
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(61);
				match(T__4);
				}
			}

			setState(64);
			((IfStatementContext)_localctx).trueStatement = statement();
			setState(67);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(65);
				match(T__5);
				setState(66);
				((IfStatementContext)_localctx).falseStatement = statement();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EnkelVisitor ) return ((EnkelVisitor<? extends T>)visitor).visitExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			expression(0);
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(70);
				match(T__6);
				setState(71);
				expression(0);
				}
				}
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ADDContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ADDContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EnkelVisitor ) return ((EnkelVisitor<? extends T>)visitor).visitADD(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SUBSTRACTContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public SUBSTRACTContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EnkelVisitor ) return ((EnkelVisitor<? extends T>)visitor).visitSUBSTRACT(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConditionalExpressionContext extends ExpressionContext {
		public Token cmp;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ConditionalExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EnkelVisitor ) return ((EnkelVisitor<? extends T>)visitor).visitConditionalExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MULTIPLYContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public MULTIPLYContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EnkelVisitor ) return ((EnkelVisitor<? extends T>)visitor).visitMULTIPLY(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VALUEContext extends ExpressionContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public VALUEContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EnkelVisitor ) return ((EnkelVisitor<? extends T>)visitor).visitVALUE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VARREFERENCEContext extends ExpressionContext {
		public VarReferenceContext varReference() {
			return getRuleContext(VarReferenceContext.class,0);
		}
		public VARREFERENCEContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EnkelVisitor ) return ((EnkelVisitor<? extends T>)visitor).visitVARREFERENCE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DIVIDEContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DIVIDEContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EnkelVisitor ) return ((EnkelVisitor<? extends T>)visitor).visitDIVIDE(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				_localctx = new VARREFERENCEContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(78);
				varReference();
				}
				break;
			case 2:
				{
				_localctx = new VALUEContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(79);
				value();
				}
				break;
			case 3:
				{
				_localctx = new MULTIPLYContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(80);
				match(T__3);
				setState(81);
				expression(0);
				setState(82);
				match(T__7);
				setState(83);
				expression(0);
				setState(84);
				match(T__4);
				}
				break;
			case 4:
				{
				_localctx = new DIVIDEContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(86);
				match(T__3);
				setState(87);
				expression(0);
				setState(88);
				match(T__8);
				setState(89);
				expression(0);
				setState(90);
				match(T__4);
				}
				break;
			case 5:
				{
				_localctx = new ADDContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(92);
				match(T__3);
				setState(93);
				expression(0);
				setState(94);
				match(T__9);
				setState(95);
				expression(0);
				setState(96);
				match(T__4);
				}
				break;
			case 6:
				{
				_localctx = new SUBSTRACTContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(98);
				match(T__3);
				setState(99);
				expression(0);
				setState(100);
				match(T__10);
				setState(101);
				expression(0);
				setState(102);
				match(T__4);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(138);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(136);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new MULTIPLYContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(106);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(107);
						match(T__7);
						setState(108);
						expression(14);
						}
						break;
					case 2:
						{
						_localctx = new DIVIDEContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(109);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(110);
						match(T__8);
						setState(111);
						expression(12);
						}
						break;
					case 3:
						{
						_localctx = new ADDContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(112);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(113);
						match(T__9);
						setState(114);
						expression(10);
						}
						break;
					case 4:
						{
						_localctx = new SUBSTRACTContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(115);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(116);
						match(T__10);
						setState(117);
						expression(8);
						}
						break;
					case 5:
						{
						_localctx = new ConditionalExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(118);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(119);
						((ConditionalExpressionContext)_localctx).cmp = match(T__11);
						setState(120);
						expression(7);
						}
						break;
					case 6:
						{
						_localctx = new ConditionalExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(121);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(122);
						((ConditionalExpressionContext)_localctx).cmp = match(T__12);
						setState(123);
						expression(6);
						}
						break;
					case 7:
						{
						_localctx = new ConditionalExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(124);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(125);
						((ConditionalExpressionContext)_localctx).cmp = match(T__13);
						setState(126);
						expression(5);
						}
						break;
					case 8:
						{
						_localctx = new ConditionalExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(127);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(128);
						((ConditionalExpressionContext)_localctx).cmp = match(T__14);
						setState(129);
						expression(4);
						}
						break;
					case 9:
						{
						_localctx = new ConditionalExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(130);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(131);
						((ConditionalExpressionContext)_localctx).cmp = match(T__15);
						setState(132);
						expression(3);
						}
						break;
					case 10:
						{
						_localctx = new ConditionalExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(133);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(134);
						((ConditionalExpressionContext)_localctx).cmp = match(T__16);
						setState(135);
						expression(2);
						}
						break;
					}
					} 
				}
				setState(140);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class VarReferenceContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(EnkelParser.ID, 0); }
		public VarReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varReference; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EnkelVisitor ) return ((EnkelVisitor<? extends T>)visitor).visitVarReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarReferenceContext varReference() throws RecognitionException {
		VarReferenceContext _localctx = new VarReferenceContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_varReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(EnkelParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(EnkelParser.STRING, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EnkelVisitor ) return ((EnkelVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			_la = _input.LA(1);
			if ( !(_la==NUMBER || _la==STRING) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 8:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 13);
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 9);
		case 3:
			return precpred(_ctx, 7);
		case 4:
			return precpred(_ctx, 6);
		case 5:
			return precpred(_ctx, 5);
		case 6:
			return precpred(_ctx, 4);
		case 7:
			return precpred(_ctx, 3);
		case 8:
			return precpred(_ctx, 2);
		case 9:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\32\u0094\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\3\2\7\2\32\n\2\f\2\16\2\35\13\2\3\2\3\2\3\3\3\3\7\3#\n\3"+
		"\f\3\16\3&\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\5\4/\n\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\5\b=\n\b\3\b\3\b\5\bA\n\b\3\b\3\b\3\b\5"+
		"\bF\n\b\3\t\3\t\3\t\7\tK\n\t\f\t\16\tN\13\t\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\5\nk\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\7\n\u008b\n\n\f\n\16\n\u008e\13\n\3\13\3\13\3\f\3\f\3\f\2\3\22\r\2"+
		"\4\6\b\n\f\16\20\22\24\26\2\3\3\2\27\30\2\u00a1\2\33\3\2\2\2\4 \3\2\2"+
		"\2\6.\3\2\2\2\b\60\3\2\2\2\n\65\3\2\2\2\f\67\3\2\2\2\16:\3\2\2\2\20G\3"+
		"\2\2\2\22j\3\2\2\2\24\u008f\3\2\2\2\26\u0091\3\2\2\2\30\32\5\6\4\2\31"+
		"\30\3\2\2\2\32\35\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\36\3\2\2\2\35"+
		"\33\3\2\2\2\36\37\7\2\2\3\37\3\3\2\2\2 $\7\3\2\2!#\5\6\4\2\"!\3\2\2\2"+
		"#&\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%\'\3\2\2\2&$\3\2\2\2\'(\7\4\2\2(\5\3\2"+
		"\2\2)/\5\4\3\2*/\5\b\5\2+/\5\f\7\2,/\5\20\t\2-/\5\16\b\2.)\3\2\2\2.*\3"+
		"\2\2\2.+\3\2\2\2.,\3\2\2\2.-\3\2\2\2/\7\3\2\2\2\60\61\7\24\2\2\61\62\5"+
		"\n\6\2\62\63\7\26\2\2\63\64\5\22\n\2\64\t\3\2\2\2\65\66\7\31\2\2\66\13"+
		"\3\2\2\2\678\7\25\2\289\5\22\n\29\r\3\2\2\2:<\7\5\2\2;=\7\6\2\2<;\3\2"+
		"\2\2<=\3\2\2\2=>\3\2\2\2>@\5\22\n\2?A\7\7\2\2@?\3\2\2\2@A\3\2\2\2AB\3"+
		"\2\2\2BE\5\6\4\2CD\7\b\2\2DF\5\6\4\2EC\3\2\2\2EF\3\2\2\2F\17\3\2\2\2G"+
		"L\5\22\n\2HI\7\t\2\2IK\5\22\n\2JH\3\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2"+
		"\2M\21\3\2\2\2NL\3\2\2\2OP\b\n\1\2Pk\5\24\13\2Qk\5\26\f\2RS\7\6\2\2ST"+
		"\5\22\n\2TU\7\n\2\2UV\5\22\n\2VW\7\7\2\2Wk\3\2\2\2XY\7\6\2\2YZ\5\22\n"+
		"\2Z[\7\13\2\2[\\\5\22\n\2\\]\7\7\2\2]k\3\2\2\2^_\7\6\2\2_`\5\22\n\2`a"+
		"\7\f\2\2ab\5\22\n\2bc\7\7\2\2ck\3\2\2\2de\7\6\2\2ef\5\22\n\2fg\7\r\2\2"+
		"gh\5\22\n\2hi\7\7\2\2ik\3\2\2\2jO\3\2\2\2jQ\3\2\2\2jR\3\2\2\2jX\3\2\2"+
		"\2j^\3\2\2\2jd\3\2\2\2k\u008c\3\2\2\2lm\f\17\2\2mn\7\n\2\2n\u008b\5\22"+
		"\n\20op\f\r\2\2pq\7\13\2\2q\u008b\5\22\n\16rs\f\13\2\2st\7\f\2\2t\u008b"+
		"\5\22\n\fuv\f\t\2\2vw\7\r\2\2w\u008b\5\22\n\nxy\f\b\2\2yz\7\16\2\2z\u008b"+
		"\5\22\n\t{|\f\7\2\2|}\7\17\2\2}\u008b\5\22\n\b~\177\f\6\2\2\177\u0080"+
		"\7\20\2\2\u0080\u008b\5\22\n\7\u0081\u0082\f\5\2\2\u0082\u0083\7\21\2"+
		"\2\u0083\u008b\5\22\n\6\u0084\u0085\f\4\2\2\u0085\u0086\7\22\2\2\u0086"+
		"\u008b\5\22\n\5\u0087\u0088\f\3\2\2\u0088\u0089\7\23\2\2\u0089\u008b\5"+
		"\22\n\4\u008al\3\2\2\2\u008ao\3\2\2\2\u008ar\3\2\2\2\u008au\3\2\2\2\u008a"+
		"x\3\2\2\2\u008a{\3\2\2\2\u008a~\3\2\2\2\u008a\u0081\3\2\2\2\u008a\u0084"+
		"\3\2\2\2\u008a\u0087\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c"+
		"\u008d\3\2\2\2\u008d\23\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0090\7\31\2"+
		"\2\u0090\25\3\2\2\2\u0091\u0092\t\2\2\2\u0092\27\3\2\2\2\f\33$.<@ELj\u008a"+
		"\u008c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}