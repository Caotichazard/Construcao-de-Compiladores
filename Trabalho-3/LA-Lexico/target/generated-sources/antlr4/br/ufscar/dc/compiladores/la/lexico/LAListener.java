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
	 * Enter a parse tree produced by {@link LAParser#decl_global_local}.
	 * @param ctx the parse tree
	 */
	void enterDecl_global_local(LAParser.Decl_global_localContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#decl_global_local}.
	 * @param ctx the parse tree
	 */
	void exitDecl_global_local(LAParser.Decl_global_localContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#declaracao_local}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao_local(LAParser.Declaracao_localContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#declaracao_local}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao_local(LAParser.Declaracao_localContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#variavel}.
	 * @param ctx the parse tree
	 */
	void enterVariavel(LAParser.VariavelContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#variavel}.
	 * @param ctx the parse tree
	 */
	void exitVariavel(LAParser.VariavelContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#identificador}.
	 * @param ctx the parse tree
	 */
	void enterIdentificador(LAParser.IdentificadorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#identificador}.
	 * @param ctx the parse tree
	 */
	void exitIdentificador(LAParser.IdentificadorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#dimensao}.
	 * @param ctx the parse tree
	 */
	void enterDimensao(LAParser.DimensaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#dimensao}.
	 * @param ctx the parse tree
	 */
	void exitDimensao(LAParser.DimensaoContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link LAParser#tipo_basico}.
	 * @param ctx the parse tree
	 */
	void enterTipo_basico(LAParser.Tipo_basicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#tipo_basico}.
	 * @param ctx the parse tree
	 */
	void exitTipo_basico(LAParser.Tipo_basicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#tipo_basico_ident}.
	 * @param ctx the parse tree
	 */
	void enterTipo_basico_ident(LAParser.Tipo_basico_identContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#tipo_basico_ident}.
	 * @param ctx the parse tree
	 */
	void exitTipo_basico_ident(LAParser.Tipo_basico_identContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#tipo_estendido}.
	 * @param ctx the parse tree
	 */
	void enterTipo_estendido(LAParser.Tipo_estendidoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#tipo_estendido}.
	 * @param ctx the parse tree
	 */
	void exitTipo_estendido(LAParser.Tipo_estendidoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#valor_constante}.
	 * @param ctx the parse tree
	 */
	void enterValor_constante(LAParser.Valor_constanteContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#valor_constante}.
	 * @param ctx the parse tree
	 */
	void exitValor_constante(LAParser.Valor_constanteContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#registro}.
	 * @param ctx the parse tree
	 */
	void enterRegistro(LAParser.RegistroContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#registro}.
	 * @param ctx the parse tree
	 */
	void exitRegistro(LAParser.RegistroContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#declaracao_global}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao_global(LAParser.Declaracao_globalContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#declaracao_global}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao_global(LAParser.Declaracao_globalContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#parametro}.
	 * @param ctx the parse tree
	 */
	void enterParametro(LAParser.ParametroContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#parametro}.
	 * @param ctx the parse tree
	 */
	void exitParametro(LAParser.ParametroContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#parametros}.
	 * @param ctx the parse tree
	 */
	void enterParametros(LAParser.ParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#parametros}.
	 * @param ctx the parse tree
	 */
	void exitParametros(LAParser.ParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#corpo}.
	 * @param ctx the parse tree
	 */
	void enterCorpo(LAParser.CorpoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#corpo}.
	 * @param ctx the parse tree
	 */
	void exitCorpo(LAParser.CorpoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(LAParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(LAParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#cmd_leia}.
	 * @param ctx the parse tree
	 */
	void enterCmd_leia(LAParser.Cmd_leiaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#cmd_leia}.
	 * @param ctx the parse tree
	 */
	void exitCmd_leia(LAParser.Cmd_leiaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#cmd_escreva}.
	 * @param ctx the parse tree
	 */
	void enterCmd_escreva(LAParser.Cmd_escrevaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#cmd_escreva}.
	 * @param ctx the parse tree
	 */
	void exitCmd_escreva(LAParser.Cmd_escrevaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#cmd_se}.
	 * @param ctx the parse tree
	 */
	void enterCmd_se(LAParser.Cmd_seContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#cmd_se}.
	 * @param ctx the parse tree
	 */
	void exitCmd_se(LAParser.Cmd_seContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#cmd_caso}.
	 * @param ctx the parse tree
	 */
	void enterCmd_caso(LAParser.Cmd_casoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#cmd_caso}.
	 * @param ctx the parse tree
	 */
	void exitCmd_caso(LAParser.Cmd_casoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#cmd_para}.
	 * @param ctx the parse tree
	 */
	void enterCmd_para(LAParser.Cmd_paraContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#cmd_para}.
	 * @param ctx the parse tree
	 */
	void exitCmd_para(LAParser.Cmd_paraContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#cmd_enquanto}.
	 * @param ctx the parse tree
	 */
	void enterCmd_enquanto(LAParser.Cmd_enquantoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#cmd_enquanto}.
	 * @param ctx the parse tree
	 */
	void exitCmd_enquanto(LAParser.Cmd_enquantoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#cmd_faca}.
	 * @param ctx the parse tree
	 */
	void enterCmd_faca(LAParser.Cmd_facaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#cmd_faca}.
	 * @param ctx the parse tree
	 */
	void exitCmd_faca(LAParser.Cmd_facaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#cmd_atribuicao}.
	 * @param ctx the parse tree
	 */
	void enterCmd_atribuicao(LAParser.Cmd_atribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#cmd_atribuicao}.
	 * @param ctx the parse tree
	 */
	void exitCmd_atribuicao(LAParser.Cmd_atribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#cmd_chamada}.
	 * @param ctx the parse tree
	 */
	void enterCmd_chamada(LAParser.Cmd_chamadaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#cmd_chamada}.
	 * @param ctx the parse tree
	 */
	void exitCmd_chamada(LAParser.Cmd_chamadaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#cmd_retorne}.
	 * @param ctx the parse tree
	 */
	void enterCmd_retorne(LAParser.Cmd_retorneContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#cmd_retorne}.
	 * @param ctx the parse tree
	 */
	void exitCmd_retorne(LAParser.Cmd_retorneContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#selecao}.
	 * @param ctx the parse tree
	 */
	void enterSelecao(LAParser.SelecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#selecao}.
	 * @param ctx the parse tree
	 */
	void exitSelecao(LAParser.SelecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#item_selecao}.
	 * @param ctx the parse tree
	 */
	void enterItem_selecao(LAParser.Item_selecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#item_selecao}.
	 * @param ctx the parse tree
	 */
	void exitItem_selecao(LAParser.Item_selecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#constantes}.
	 * @param ctx the parse tree
	 */
	void enterConstantes(LAParser.ConstantesContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#constantes}.
	 * @param ctx the parse tree
	 */
	void exitConstantes(LAParser.ConstantesContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#numero_intervalo}.
	 * @param ctx the parse tree
	 */
	void enterNumero_intervalo(LAParser.Numero_intervaloContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#numero_intervalo}.
	 * @param ctx the parse tree
	 */
	void exitNumero_intervalo(LAParser.Numero_intervaloContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#op_unario}.
	 * @param ctx the parse tree
	 */
	void enterOp_unario(LAParser.Op_unarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#op_unario}.
	 * @param ctx the parse tree
	 */
	void exitOp_unario(LAParser.Op_unarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#exp_aritmetica}.
	 * @param ctx the parse tree
	 */
	void enterExp_aritmetica(LAParser.Exp_aritmeticaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#exp_aritmetica}.
	 * @param ctx the parse tree
	 */
	void exitExp_aritmetica(LAParser.Exp_aritmeticaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(LAParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(LAParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterFator(LAParser.FatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitFator(LAParser.FatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#op1}.
	 * @param ctx the parse tree
	 */
	void enterOp1(LAParser.Op1Context ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#op1}.
	 * @param ctx the parse tree
	 */
	void exitOp1(LAParser.Op1Context ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#op2}.
	 * @param ctx the parse tree
	 */
	void enterOp2(LAParser.Op2Context ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#op2}.
	 * @param ctx the parse tree
	 */
	void exitOp2(LAParser.Op2Context ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#op3}.
	 * @param ctx the parse tree
	 */
	void enterOp3(LAParser.Op3Context ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#op3}.
	 * @param ctx the parse tree
	 */
	void exitOp3(LAParser.Op3Context ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#parcela}.
	 * @param ctx the parse tree
	 */
	void enterParcela(LAParser.ParcelaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#parcela}.
	 * @param ctx the parse tree
	 */
	void exitParcela(LAParser.ParcelaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#parcela_unario}.
	 * @param ctx the parse tree
	 */
	void enterParcela_unario(LAParser.Parcela_unarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#parcela_unario}.
	 * @param ctx the parse tree
	 */
	void exitParcela_unario(LAParser.Parcela_unarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#parcela_nao_unario}.
	 * @param ctx the parse tree
	 */
	void enterParcela_nao_unario(LAParser.Parcela_nao_unarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#parcela_nao_unario}.
	 * @param ctx the parse tree
	 */
	void exitParcela_nao_unario(LAParser.Parcela_nao_unarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#exp_relacional}.
	 * @param ctx the parse tree
	 */
	void enterExp_relacional(LAParser.Exp_relacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#exp_relacional}.
	 * @param ctx the parse tree
	 */
	void exitExp_relacional(LAParser.Exp_relacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#op_relacional}.
	 * @param ctx the parse tree
	 */
	void enterOp_relacional(LAParser.Op_relacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#op_relacional}.
	 * @param ctx the parse tree
	 */
	void exitOp_relacional(LAParser.Op_relacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterExpressao(LAParser.ExpressaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitExpressao(LAParser.ExpressaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#termo_logico}.
	 * @param ctx the parse tree
	 */
	void enterTermo_logico(LAParser.Termo_logicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#termo_logico}.
	 * @param ctx the parse tree
	 */
	void exitTermo_logico(LAParser.Termo_logicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#fator_logico}.
	 * @param ctx the parse tree
	 */
	void enterFator_logico(LAParser.Fator_logicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#fator_logico}.
	 * @param ctx the parse tree
	 */
	void exitFator_logico(LAParser.Fator_logicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#parcela_logica}.
	 * @param ctx the parse tree
	 */
	void enterParcela_logica(LAParser.Parcela_logicaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#parcela_logica}.
	 * @param ctx the parse tree
	 */
	void exitParcela_logica(LAParser.Parcela_logicaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#op_logico_1}.
	 * @param ctx the parse tree
	 */
	void enterOp_logico_1(LAParser.Op_logico_1Context ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#op_logico_1}.
	 * @param ctx the parse tree
	 */
	void exitOp_logico_1(LAParser.Op_logico_1Context ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#op_logico_2}.
	 * @param ctx the parse tree
	 */
	void enterOp_logico_2(LAParser.Op_logico_2Context ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#op_logico_2}.
	 * @param ctx the parse tree
	 */
	void exitOp_logico_2(LAParser.Op_logico_2Context ctx);
}