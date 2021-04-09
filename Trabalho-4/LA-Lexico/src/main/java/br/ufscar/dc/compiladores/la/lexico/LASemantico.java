package br.ufscar.dc.compiladores.la.lexico;

import br.ufscar.dc.compiladores.la.lexico.TabelaDeEntradas;
import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Pair;
import org.antlr.v4.runtime.tree.TerminalNode;

public class LASemantico extends LABaseVisitor<Void> {

    TabelaDeEntradas entradas;

    @Override
    public Void visitPrograma(LAParser.ProgramaContext ctx) {
        //System.out.println("AAAAAAAAAAAAAAA");
        entradas = new TabelaDeEntradas();
        return super.visitPrograma(ctx);
    }
    
    @Override
    public Void visitDefinicao(LAParser.DefinicaoContext ctx){
        //System.out.println("AAAAAAAAAAAAAAA");
        entradas = LASemanticoUtils.visitaDefinicoes(ctx, entradas);
        return super.visitDefinicao(ctx);
    }
    
    @Override
    public Void visitDeclaracao(LAParser.DeclaracaoContext ctx){
        //System.out.println("BBBBBBBBBBBBB");
        entradas = LASemanticoUtils.visitaDeclaracoes(ctx, entradas);
        return super.visitDeclaracao(ctx);
    }
    

    

    

   
}
