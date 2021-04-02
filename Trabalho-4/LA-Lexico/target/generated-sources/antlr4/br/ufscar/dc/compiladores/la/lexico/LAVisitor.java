// Generated from br/ufscar/dc/compiladores/la/lexico/LA.g4 by ANTLR 4.7.2
package br.ufscar.dc.compiladores.la.lexico;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LAParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LAVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LAParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(LAParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#definicoes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinicoes(LAParser.DefinicoesContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#declaracoes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracoes(LAParser.DeclaracoesContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#definicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinicao(LAParser.DefinicaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#declaracao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracao(LAParser.DeclaracaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#campo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCampo(LAParser.CampoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#valores}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValores(LAParser.ValoresContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#valor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValor(LAParser.ValorContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(LAParser.TipoContext ctx);
}