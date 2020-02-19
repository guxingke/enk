// Generated from Enkel.g4 by ANTLR 4.7.2
package com.gxk.enk.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link EnkelParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface EnkelVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link EnkelParser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(EnkelParser.CompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnkelParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(EnkelParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnkelParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(EnkelParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnkelParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(EnkelParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnkelParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(EnkelParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnkelParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(EnkelParser.NameContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnkelParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(EnkelParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnkelParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(EnkelParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnkelParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(EnkelParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnkelParser#forCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForCondition(EnkelParser.ForConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnkelParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(EnkelParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ADD}
	 * labeled alternative in {@link EnkelParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitADD(EnkelParser.ADDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SUBSTRACT}
	 * labeled alternative in {@link EnkelParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSUBSTRACT(EnkelParser.SUBSTRACTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionalExpression}
	 * labeled alternative in {@link EnkelParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExpression(EnkelParser.ConditionalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MULTIPLY}
	 * labeled alternative in {@link EnkelParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMULTIPLY(EnkelParser.MULTIPLYContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VALUE}
	 * labeled alternative in {@link EnkelParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVALUE(EnkelParser.VALUEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VARREFERENCE}
	 * labeled alternative in {@link EnkelParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVARREFERENCE(EnkelParser.VARREFERENCEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DIVIDE}
	 * labeled alternative in {@link EnkelParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDIVIDE(EnkelParser.DIVIDEContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnkelParser#varReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarReference(EnkelParser.VarReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnkelParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(EnkelParser.ValueContext ctx);
}