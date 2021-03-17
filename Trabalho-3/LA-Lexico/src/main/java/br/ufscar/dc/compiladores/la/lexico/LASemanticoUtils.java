package br.ufscar.dc.compiladores.la.lexico;

import br.ufscar.dc.compiladores.la.lexico.TabelaDeSimbolos.TipoLA;
import br.ufscar.dc.compiladores.la.lexico.TabelaDeSimbolos;
import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Pair;
import br.ufscar.dc.compiladores.la.lexico.LASemantico;
import br.ufscar.dc.compiladores.la.lexico.TabelaDeSimbolos.Variavel;
import org.antlr.v4.runtime.tree.TerminalNode;

public class LASemanticoUtils {

    public static List<String> erros = new ArrayList<>();

    public static void adicionaErro(String msg) {
        erros.add(msg);
    }
    /*
    public static Escopos verificarDeclare(Escopos escopo, LAParser.VariavelContext ctx) {
        Token tipo = ctx.tipo().getStart();
        // retorna uma lista contendo o <nome, tipo> da variavel
        List<Pair<String, TipoLA>> ret = new ArrayList<>();
        // para cada identificador da declaracao
        for (var value : ctx.identificador()) {
            Token ident = value.getStart();
            List<TabelaDeSimbolos> lts = escopo.percorrerEscoposAninhados();
            for (TabelaDeSimbolos ts : lts) {
                if (ts.existe(ident.getText())) {
                    // se a variavel ja existe
                    LASemanticoUtils.adicionaErro("Linha " + ident.getLine() + ": identificador " + ident.getText() + " ja declarado anteriormente");
                } else {
                    ret.add(new Pair<>(ident.getText(), verificaTipo(ctx.tipo())));
                    escopo.obterEscopoAtual().adicionar(ident.getText(), verificaTipo(ctx.tipo()));
                }
            }
            System.out.println("declare=" + ident.getText() + ", " + tipo.getText());
        } 
        return escopo; 
    } */
    
    public static Escopos verificaVariavel(Escopos escopo, LAParser.VariavelContext ctx) {
        // retorna variáveis válidas deste escopo
        
        TipoLA tipo = verificaTipo(ctx.tipo());
        for (LAParser.IdentificadorContext id : ctx.identificador()) {
            String ident = verificaExistenciaIdentificador(escopo.obterEscopoAtual(), id.getStart());
            if (ident != null) {
                if(tipo == TipoLA.REGISTRO){
                
                }else
                if(tipo == TipoLA.PONTEIRO){
                    System.out.println("PONTAS");
                    System.out.println("ident= " + ident);
                    System.out.println("tipo= " + tipo);
                    System.out.println("tipo= " + verificaTipo(ctx.tipo().getText().replace("^","")));
                    System.out.println("-----------------");
                    
                    escopo.obterEscopoAtual().adicionar(ident,TipoLA.PONTEIRO,verificaTipo(ctx.tipo().getText().replace("^","")));
                }else{
                    System.out.println("ident= " + ident);
                    System.out.println("tipo= " + tipo);
                    System.out.println("-----------------");
                    escopo.obterEscopoAtual().adicionar(ident, tipo);
                }
            }
        }
        return escopo;
    }
    
    
    public static Escopos verificaCmdAtribuicao(Escopos escopo, LAParser.Cmd_atribuicaoContext ctx) {
        Token tokenLHS = ctx.identificador().getStart(); // token do lado esquerdo
        TipoLA tipoLHS = escopo.obterEscopoAtual().verificar(tokenLHS.getText()); // expressão do lado direito
        System.out.println("tipoLHS=" + tokenLHS.getText());
        TipoLA tipoRHS = verificaExpressao(escopo,ctx.expressao());
        return escopo;
    }

    
    public static TipoLA verificaExpressao(Escopos escopo, LAParser.ExpressaoContext ctx) {
        List<TipoLA> tipoTermoLogico = new ArrayList<>();
        boolean hasDiff = false;
        for (LAParser.Termo_logicoContext termoLogico : ctx.termo_logico()) {
            tipoTermoLogico.add(verificaTermoLogico(escopo,termoLogico));
        }
        
        if(ctx.op_logico_1() != null){
            System.out.println("Tem logica");
            if (!tipoTermoLogico.contains(TipoLA.INVALIDO)){
                return tipoTermoLogico.get(0);
            }
        }else{
            System.out.println("N tem logica");
            if (tiposCompativeis(tipoTermoLogico)){
                return tipoTermoLogico.get(0);
            }
        }
        return TipoLA.INVALIDO;
    }
    
    public static TipoLA verificaTermoLogico(Escopos escopo, LAParser.Termo_logicoContext ctx) {
        List<TipoLA> tipoFatorLogico = new ArrayList<>();
        for (LAParser.Fator_logicoContext fatorLogico : ctx.fator_logico()) {
            tipoFatorLogico.add(verificaFatorLogico(escopo,fatorLogico));
        }
        if(ctx.op_logico_2() != null){
            System.out.println("Tem logica");
            if (!tipoFatorLogico.contains(TipoLA.INVALIDO)){
                return tipoFatorLogico.get(0);
            }
        }else{
            System.out.println("N tem logica");
            if (tiposCompativeis(tipoFatorLogico)){
                return tipoFatorLogico.get(0);
            }
        }
        
        return TipoLA.INVALIDO;
        
    }
    
    public static TipoLA verificaFatorLogico(Escopos escopo, LAParser.Fator_logicoContext ctx) {
        return verificaParcelaLogica(escopo,ctx.parcela_logica());
    }
    
    public static TipoLA verificaParcelaLogica(Escopos escopo, LAParser.Parcela_logicaContext ctx) {
        if (ctx.exp_relacional() != null) {
            
            return verificarExpressaoRelacional(escopo,ctx.exp_relacional());
        }
        if(ctx.TIPO_LOGICO != null){
            return TipoLA.LOGICO;
        }
        return TipoLA.INVALIDO;
    }
    
    public static TipoLA verificarExpressaoRelacional(Escopos escopo, LAParser.Exp_relacionalContext ctx){
        List<TipoLA> tipoExpRelacional = new ArrayList<>();
        for (LAParser.Exp_aritmeticaContext exp_aritmetica : ctx.exp_aritmetica() ) {
            tipoExpRelacional.add(verificarExpressaoAritmetica(escopo,exp_aritmetica));
        }
        
        if(ctx.op_relacional() != null){
            if (tiposCompativeis(tipoExpRelacional)){
                return TipoLA.LOGICO;
            }
        }else{
            
            return tipoExpRelacional.get(0);
            
        }
        
        
        return TipoLA.INVALIDO;
        
    }
    
    public static TipoLA verificarExpressaoAritmetica(Escopos escopo, LAParser.Exp_aritmeticaContext ctx ){
        
        List<TipoLA> tipoTermoAritmetica = new ArrayList<>();
        for (LAParser.TermoContext termoAritmetico : ctx.termo() ) {
            tipoTermoAritmetica.add(verificaTermoAritmetica(escopo,termoAritmetico));
        }
        if (tiposCompativeis(tipoTermoAritmetica)){
                return tipoTermoAritmetica.get(0);
        }
        return TipoLA.INVALIDO;
    }
    
    public static TipoLA verificaTermoAritmetica(Escopos escopo, LAParser.TermoContext ctx) {
        
        List<TipoLA> tipoFatorAritmetica = new ArrayList<>();
        for (LAParser.FatorContext fatorAritmetico : ctx.fator()) {
            tipoFatorAritmetica.add(verificaFatorAritmetica(escopo,fatorAritmetico));
        }
        if (tiposCompativeis(tipoFatorAritmetica)){
                return tipoFatorAritmetica.get(0);
        }
        return TipoLA.INVALIDO;
    }
    
    public static TipoLA verificaFatorAritmetica(Escopos escopo, LAParser.FatorContext ctx) {
        
        List<TipoLA> tipoParcelaAritmetica = new ArrayList<>();
        for (LAParser.ParcelaContext parcelaAritmetico : ctx.parcela()) {
            tipoParcelaAritmetica.add(verificaParcelaAritmetica(escopo,parcelaAritmetico));
        }
        if (tiposCompativeis(tipoParcelaAritmetica)){
                return tipoParcelaAritmetica.get(0);
        }
        return TipoLA.INVALIDO;
    }
    
    public static TipoLA verificaParcelaAritmetica(Escopos escopo, LAParser.ParcelaContext ctx) {
        
        if(ctx.parcela_unario() != null){
            return verificarParcelaUnario(escopo,ctx.parcela_unario());
        }
        if(ctx.parcela_nao_unario() != null){
            return verificarParcelaNaoUnario(escopo,ctx.parcela_nao_unario());
        }
        return TipoLA.INVALIDO;
    }
    
    public static TipoLA verificarParcelaUnario(Escopos escopo, LAParser.Parcela_unarioContext ctx){
        
        if( ctx.NUM_INT() != null){
            
            return TipoLA.INTEIRO;
        }
        if( ctx.NUM_REAL() != null){
            
            return TipoLA.REAL;
        }
        if( ctx.identificador() != null){
            
            return verificarTipoIdentificador(escopo,ctx.identificador());
        }
        if( ctx.IDENT() != null){
           
            List<TipoLA> tipoExpressao = new ArrayList<>();
            for (LAParser.ExpressaoContext express : ctx.expressao()) {
                tipoExpressao.add(verificaExpressao(escopo,express));
            }
            if (tiposCompativeis(tipoExpressao)){
                return tipoExpressao.get(0);
            }
            
        }else if (ctx.expressao() != null){
            
            List<TipoLA> tipoExpressao = new ArrayList<>();
            for (LAParser.ExpressaoContext express : ctx.expressao()) {
                tipoExpressao.add(verificaExpressao(escopo,express));
            }
            
            
            if (tiposCompativeis(tipoExpressao)){
                return tipoExpressao.get(0);
            }
        }
        
        return TipoLA.INVALIDO;
    }
    public static TipoLA verificarParcelaNaoUnario(Escopos escopo, LAParser.Parcela_nao_unarioContext ctx){
        
        if( ctx.CADEIA() != null){
            return TipoLA.CADEIA;
        }
        if ( ctx.identificador() != null){
            return verificarTipoIdentificador(escopo,ctx.identificador() );
        }
        return TipoLA.INVALIDO;
    }

    public static String verificaExistenciaIdentificador(TabelaDeSimbolos ts, Token ident) {
        if (ts.existe(ident.getText())) { 
            LASemanticoUtils.adicionaErro("Linha " + ident.getLine() + ": identificador " + ident.getText() + " ja declarado anteriormente");
            return null;
        } 
        return ident.getText();
    }
    
    public static boolean tiposCompativeis(List<TipoLA> listaTipos){
        boolean isCompatible = true;
        
        
        if(listaTipos.contains(TipoLA.CADEIA) && (listaTipos.contains(TipoLA.REAL) || listaTipos.contains(TipoLA.INTEIRO) || listaTipos.contains(TipoLA.LOGICO))){
            isCompatible = false;
        }
        if(listaTipos.contains(TipoLA.LOGICO) && (listaTipos.contains(TipoLA.REAL) || listaTipos.contains(TipoLA.INTEIRO) || listaTipos.contains(TipoLA.CADEIA))){
            isCompatible = false;
        }
        if(listaTipos.contains(TipoLA.INVALIDO )){
            isCompatible = false;
        }
        
        return isCompatible;
    }
    
    public static TipoLA verificarTipoIdentificador(Escopos escopo, LAParser.IdentificadorContext ctx){
        TabelaDeSimbolos ts = escopo.obterEscopoAtual();
        List<TipoLA> listaTipos = new ArrayList<>();
        for(TerminalNode ident: ctx.IDENT()){
            if(ts.existe(ident.toString())){
                listaTipos.add(ts.verificar(ident.toString()));
            }
        }
        
        boolean hasDiff = false;
        for (TipoLA tipo: listaTipos){
            if(tipo != listaTipos.get(0)){
                hasDiff = true;
            }
        }
        if (!hasDiff){
            return listaTipos.get(0);
        }
        return TipoLA.INVALIDO;
    }
    
    
    
    public static TipoLA verificaTipo(LAParser.TipoContext ctx) {
        TipoLA tipoVar = TipoLA.INVALIDO;
        if(ctx.registro()!=null){
            tipoVar = TipoLA.REGISTRO;
        }else{
            LAParser.Tipo_estendidoContext tipoEstendido = ctx.tipo_estendido();
            if("^".equals(tipoEstendido.getStart().getText())){
                tipoVar = TipoLA.PONTEIRO;
            }else{
                Token tipo = ctx.getStart();
                //System.out.println("tipo=" + tipo.getText());
        
                switch (tipo.getText()) {
                    case "inteiro":
                        tipoVar = TipoLA.INTEIRO;
                        break;
                    case "real":
                        tipoVar = TipoLA.REAL;
                        break;
                    case "literal":
                        tipoVar = TipoLA.CADEIA;
                        break;
                    case "logico":
                        tipoVar = TipoLA.LOGICO;
                        break;

                }  
            }
        }
        
        
        return tipoVar;
    }
    
    public static TipoLA verificaTipo(String tipoStr){
        TipoLA tipoVar = TipoLA.INVALIDO;
        switch (tipoStr) {
                    case "inteiro":
                        tipoVar = TipoLA.INTEIRO;
                        break;
                    case "real":
                        tipoVar = TipoLA.REAL;
                        break;
                    case "literal":
                        tipoVar = TipoLA.CADEIA;
                        break;
                    case "logico":
                        tipoVar = TipoLA.LOGICO;
                        break;
        }
        return tipoVar;
    }
}
