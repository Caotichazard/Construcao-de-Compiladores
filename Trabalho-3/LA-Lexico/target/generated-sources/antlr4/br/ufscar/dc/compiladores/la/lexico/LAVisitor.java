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
	 * Visit a parse tree produced by {@link LAParser#declaracoes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracoes(LAParser.DeclaracoesContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#decl_global_local}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl_global_local(LAParser.Decl_global_localContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#declaracao_local}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracao_local(LAParser.Declaracao_localContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#variavel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariavel(LAParser.VariavelContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#identificador}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentificador(LAParser.IdentificadorContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#dimensao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimensao(LAParser.DimensaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(LAParser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#tipo_basico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_basico(LAParser.Tipo_basicoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#tipo_basico_ident}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_basico_ident(LAParser.Tipo_basico_identContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#tipo_estendido}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_estendido(LAParser.Tipo_estendidoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#valor_constante}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValor_constante(LAParser.Valor_constanteContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#registro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegistro(LAParser.RegistroContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#declaracao_global}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracao_global(LAParser.Declaracao_globalContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#parametro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametro(LAParser.ParametroContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#parametros}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametros(LAParser.ParametrosContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#corpo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCorpo(LAParser.CorpoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmd(LAParser.CmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#cmd_leia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmd_leia(LAParser.Cmd_leiaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#cmd_escreva}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmd_escreva(LAParser.Cmd_escrevaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#cmd_se}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmd_se(LAParser.Cmd_seContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#cmd_caso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmd_caso(LAParser.Cmd_casoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#cmd_para}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmd_para(LAParser.Cmd_paraContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#cmd_enquanto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmd_enquanto(LAParser.Cmd_enquantoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#cmd_faca}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmd_faca(LAParser.Cmd_facaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#cmd_atribuicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmd_atribuicao(LAParser.Cmd_atribuicaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#cmd_chamada}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmd_chamada(LAParser.Cmd_chamadaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#cmd_retorne}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmd_retorne(LAParser.Cmd_retorneContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#selecao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelecao(LAParser.SelecaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#item_selecao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItem_selecao(LAParser.Item_selecaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#constantes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantes(LAParser.ConstantesContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#numero_intervalo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumero_intervalo(LAParser.Numero_intervaloContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#op_unario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_unario(LAParser.Op_unarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#exp_aritmetica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_aritmetica(LAParser.Exp_aritmeticaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#termo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermo(LAParser.TermoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#fator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFator(LAParser.FatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#op1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp1(LAParser.Op1Context ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#op2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp2(LAParser.Op2Context ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#op3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp3(LAParser.Op3Context ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#parcela}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela(LAParser.ParcelaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#parcela_unario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela_unario(LAParser.Parcela_unarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#parcela_nao_unario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela_nao_unario(LAParser.Parcela_nao_unarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#exp_relacional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_relacional(LAParser.Exp_relacionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#op_relacional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_relacional(LAParser.Op_relacionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressao(LAParser.ExpressaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#termo_logico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermo_logico(LAParser.Termo_logicoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#fator_logico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFator_logico(LAParser.Fator_logicoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#parcela_logica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela_logica(LAParser.Parcela_logicaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#op_logico_1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_logico_1(LAParser.Op_logico_1Context ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#op_logico_2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_logico_2(LAParser.Op_logico_2Context ctx);
}