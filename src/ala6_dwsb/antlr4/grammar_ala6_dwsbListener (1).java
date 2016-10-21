// Generated from grammar_ala6_dwsb.g4 by ANTLR 4.4
package ala6_dwsb.antlr4;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link grammar_ala6_dwsbParser}.
 */
public interface grammar_ala6_dwsbListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link grammar_ala6_dwsbParser#formal}.
	 * @param ctx the parse tree
	 */
	void enterFormal(@NotNull grammar_ala6_dwsbParser.FormalContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_ala6_dwsbParser#formal}.
	 * @param ctx the parse tree
	 */
	void exitFormal(@NotNull grammar_ala6_dwsbParser.FormalContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_ala6_dwsbParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(@NotNull grammar_ala6_dwsbParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_ala6_dwsbParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(@NotNull grammar_ala6_dwsbParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_ala6_dwsbParser#goal}.
	 * @param ctx the parse tree
	 */
	void enterGoal(@NotNull grammar_ala6_dwsbParser.GoalContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_ala6_dwsbParser#goal}.
	 * @param ctx the parse tree
	 */
	void exitGoal(@NotNull grammar_ala6_dwsbParser.GoalContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_ala6_dwsbParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull grammar_ala6_dwsbParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_ala6_dwsbParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull grammar_ala6_dwsbParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_ala6_dwsbParser#mainClass}.
	 * @param ctx the parse tree
	 */
	void enterMainClass(@NotNull grammar_ala6_dwsbParser.MainClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_ala6_dwsbParser#mainClass}.
	 * @param ctx the parse tree
	 */
	void exitMainClass(@NotNull grammar_ala6_dwsbParser.MainClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_ala6_dwsbParser#formalList}.
	 * @param ctx the parse tree
	 */
	void enterFormalList(@NotNull grammar_ala6_dwsbParser.FormalListContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_ala6_dwsbParser#formalList}.
	 * @param ctx the parse tree
	 */
	void exitFormalList(@NotNull grammar_ala6_dwsbParser.FormalListContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_ala6_dwsbParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull grammar_ala6_dwsbParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_ala6_dwsbParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull grammar_ala6_dwsbParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_ala6_dwsbParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull grammar_ala6_dwsbParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_ala6_dwsbParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull grammar_ala6_dwsbParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_ala6_dwsbParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(@NotNull grammar_ala6_dwsbParser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_ala6_dwsbParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(@NotNull grammar_ala6_dwsbParser.VarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_ala6_dwsbParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(@NotNull grammar_ala6_dwsbParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_ala6_dwsbParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(@NotNull grammar_ala6_dwsbParser.ClassDeclarationContext ctx);
}