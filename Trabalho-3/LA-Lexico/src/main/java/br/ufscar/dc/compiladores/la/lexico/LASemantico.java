package br.ufscar.dc.compiladores.la.lexico;

import br.ufscar.dc.compiladores.la.lexico.TabelaDeSimbolos.TipoLA;
import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Pair;
import org.antlr.v4.runtime.tree.TerminalNode;

public class LASemantico extends LABaseVisitor<Void> {

    Escopos escopo;

    @Override
    public Void visitPrograma(LAParser.ProgramaContext ctx) {
        escopo = new Escopos();
        return super.visitPrograma(ctx);
    }

    @Override
    public Void visitDeclaracao_global(LAParser.Declaracao_globalContext ctx) {
        System.out.println("decl global\n");
        return super.visitDeclaracao_global(ctx);
    }

    @Override
    public Void visitDeclaracao_local(LAParser.Declaracao_localContext ctx) {
        String decl = ctx.getStart().getText();
        switch (decl) {
            case ("declare"):
                escopo = LASemanticoUtils.verificaVariavel(escopo, ctx.variavel());
                break;
        }
        return super.visitDeclaracao_local(ctx);
    }

    @Override
    public Void visitCmd_atribuicao(LAParser.Cmd_atribuicaoContext ctx) {
        List<TipoLA> membrosAtribuicao = new ArrayList<>();
        LAParser.ExpressaoContext exp = ctx.expressao();
        LAParser.IdentificadorContext ident = ctx.identificador();
        TipoLA tipo = escopo.obterEscopoAtual().verificar(ident.getText());
        membrosAtribuicao.add(tipo);
        membrosAtribuicao.add(LASemanticoUtils.verificaExpressao(escopo,ctx.expressao()));
        System.out.println("cmd = " + ident.getText() + " de tipo "+ tipo + " <- " + exp.getText());
        System.out.println(membrosAtribuicao);
        if (!LASemanticoUtils.tiposCompativeis(membrosAtribuicao)){
            System.out.println(ctx.getText());
            if(ctx.getText().contains("^")){
                LASemanticoUtils.adicionaErro("Linha " + ctx.identificador().getStart().getLine() + ": atribuicao nao compativel para ^" + ident.getText());
            }else{
                LASemanticoUtils.adicionaErro("Linha " + ctx.identificador().getStart().getLine() + ": atribuicao nao compativel para " + ident.getText());
            }
            
        }
        
        return super.visitCmd_atribuicao(ctx);
    }

    @Override
    public Void visitIdentificador(LAParser.IdentificadorContext ctx) {
        for (TerminalNode value : ctx.IDENT()) {
            Token ident = value.getSymbol();
            System.out.println("ident=" + ident.getText());
            boolean existeIDENT = escopo.obterEscopoAtual().existe(ident.getText());
            if (!existeIDENT) {
                LASemanticoUtils.adicionaErro("Linha " + ident.getLine() + ": identificador " + ident.getText() + " nao declarado");
            }
        }
        return super.visitIdentificador(ctx);
    }

    @Override
    public Void visitTipo(LAParser.TipoContext ctx) {
        TipoLA tipoVar = LASemanticoUtils.verificaTipo(ctx);
        if (tipoVar == TipoLA.INVALIDO) {
            LASemanticoUtils.adicionaErro("Linha " + ctx.getStart().getLine() + ": tipo " + ctx.getStart().getText() + " nao declarado");
        }
        return super.visitTipo(ctx);
    }
}
