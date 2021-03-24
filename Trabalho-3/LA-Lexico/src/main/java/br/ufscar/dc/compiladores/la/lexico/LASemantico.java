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
    public Void visitDecl_global_local(LAParser.Decl_global_localContext ctx){
        if(ctx.declaracao_global()!=null){
            escopo = LASemanticoUtils.visitaDeclGlobal(escopo,ctx.declaracao_global());
        }else{
            escopo = LASemanticoUtils.visitaDeclLocal(escopo, ctx.declaracao_local());
        }
        
        
        return super.visitDecl_global_local(ctx);
    }

    @Override
    public Void visitCorpo(LAParser.CorpoContext ctx){
        
            for(LAParser.Declaracao_localContext decl: ctx.declaracao_local())
                escopo = LASemanticoUtils.visitaDeclLocal(escopo, decl);
        
        
            for(LAParser.CmdContext cmd: ctx.cmd())
                escopo = LASemanticoUtils.visitaCmd(escopo, cmd);
        
        return super.visitCorpo(ctx);
    }

    
    
    
    

    

    

   
}
