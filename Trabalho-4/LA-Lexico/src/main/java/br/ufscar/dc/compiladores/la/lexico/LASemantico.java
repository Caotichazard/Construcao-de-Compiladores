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
    
    
    
    

    

    

   
}
