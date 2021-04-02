// Generated from br/ufscar/dc/compiladores/la/lexico/LA.g4 by ANTLR 4.7.2
package br.ufscar.dc.compiladores.la.lexico;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LAParser}.
 */
public interface LAListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LAParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(LAParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(LAParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#definicoes}.
	 * @param ctx the parse tree
	 */
	void enterDefinicoes(LAParser.DefinicoesContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#definicoes}.
	 * @param ctx the parse tree
	 */
	void exitDefinicoes(LAParser.DefinicoesContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracoes(LAParser.DeclaracoesContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracoes(LAParser.DeclaracoesContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#definicao}.
	 * @param ctx the parse tree
	 */
	void enterDefinicao(LAParser.DefinicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#definicao}.
	 * @param ctx the parse tree
	 */
	void exitDefinicao(LAParser.DefinicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#declaracao}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao(LAParser.DeclaracaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#declaracao}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao(LAParser.DeclaracaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#campo}.
	 * @param ctx the parse tree
	 */
	void enterCampo(LAParser.CampoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#campo}.
	 * @param ctx the parse tree
	 */
	void exitCampo(LAParser.CampoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#valores}.
	 * @param ctx the parse tree
	 */
	void enterValores(LAParser.ValoresContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#valores}.
	 * @param ctx the parse tree
	 */
	void exitValores(LAParser.ValoresContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#valor}.
	 * @param ctx the parse tree
	 */
	void enterValor(LAParser.ValorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#valor}.
	 * @param ctx the parse tree
	 */
	void exitValor(LAParser.ValorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(LAParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(LAParser.TipoContext ctx);
}