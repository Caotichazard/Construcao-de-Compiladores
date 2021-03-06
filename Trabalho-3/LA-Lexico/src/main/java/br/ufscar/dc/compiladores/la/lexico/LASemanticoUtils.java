package br.ufscar.dc.compiladores.la.lexico;

import br.ufscar.dc.compiladores.la.lexico.TabelaDeSimbolos.TipoLA;
import br.ufscar.dc.compiladores.la.lexico.TabelaDeSimbolos;
import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Pair;
import br.ufscar.dc.compiladores.la.lexico.LASemantico;
import br.ufscar.dc.compiladores.la.lexico.TabelaDeSimbolos.EntradaTabelaDeSimbolos;
import br.ufscar.dc.compiladores.la.lexico.TabelaDeSimbolos.Variavel;
import org.antlr.v4.runtime.tree.TerminalNode;

public class LASemanticoUtils {

    public static List<String> erros = new ArrayList<>();

    public static void adicionaErro(String msg) {
        erros.add(msg);
    }
    
    public static Escopos visitaDeclGlobal(Escopos escopo, LAParser.Declaracao_globalContext ctx){
        String inicio = ctx.getStart().getText();
        switch(inicio){
            case("funcao"):
                System.out.println(inicio);
                escopo = visitaFuncao(escopo,ctx);
                break;
            case("procedimento"):
                System.out.println(inicio);
                
                break;
        }
        return escopo;
    }
    
    public static Escopos visitaFuncao(Escopos escopo, LAParser.Declaracao_globalContext ctx){
        String funcName = ctx.IDENT().getText();
        System.out.println(funcName);
        List<TipoLA> tiposParametros = new ArrayList<>();
        TipoLA tipoRetorno = verificaTipo(escopo,ctx.tipo_estendido());
        escopo.criarNovoEscopo();
        
        if(ctx.parametros() != null){
            for(LAParser.ParametroContext param:ctx.parametros().parametro()){
                TipoLA paramTipo = verificaTipo(escopo,param.tipo_estendido());
                for(LAParser.IdentificadorContext ident: param.identificador()){
                    escopo.obterEscopoAtual().adicionar(ident.getText(), paramTipo);
                    tiposParametros.add(paramTipo);
                }
            }
        }
        
        if(ctx.declaracao_local() != null){
            for(LAParser.Declaracao_localContext decl: ctx.declaracao_local()){
                escopo = visitaDeclLocal(escopo,decl);
            }
        }
        
        if(ctx.cmd()!= null){
            for(LAParser.CmdContext cmd: ctx.cmd()){
                escopo = visitaCmd(escopo,cmd);
                if(cmd.cmd_retorne()!=null){
                    TipoLA tipoCmdRetorno = visitaExpressao(escopo,cmd.cmd_retorne().expressao());
                    if(tipoCmdRetorno != tipoRetorno){
                        adicionaErro("");
                    }
                }
            }
        }
        
        
        
        escopo.abandonarEscopo();
        
        escopo.obterEscopoAtual().adicionar(funcName,tiposParametros, tipoRetorno);
        return escopo;
    }
    
   
    
    public static Escopos visitaDeclLocal(Escopos escopo, LAParser.Declaracao_localContext ctx){
        String inicio = ctx.getStart().getText();
        
        switch(inicio){
            case("declare"):
                System.out.println(inicio);
                escopo = visitaVariavel(escopo, ctx.variavel());
                break;
            case("tipo"):
                System.out.println(inicio);
                escopo = visitaTipo(escopo, ctx.IDENT(),ctx.tipo());
                break;
        }
                
                    
        return escopo;
    }
    
    public static Escopos visitaTipo(Escopos escopo, TerminalNode ident, LAParser.TipoContext ctx){
        TipoLA tipo = verificaTipo(escopo,ctx);
        System.out.println(tipo);
        
        if(tipo == TipoLA.REGISTRO){
            List<EntradaTabelaDeSimbolos> variaveis = new ArrayList<>();
            for(LAParser.VariavelContext var: ctx.registro().variavel()){
                for(LAParser.IdentificadorContext varIdent: var.identificador()){
                    escopo.obterEscopoAtual().adicionaTipo(varIdent.getText(), verificaTipo(escopo,var.tipo()));
                    variaveis.add(escopo.obterEscopoAtual().getTipoCustomizado(varIdent.getText()));
                }
            }
            
            escopo.obterEscopoAtual().adicionaTipo(ident.getText(), variaveis);
            escopo.obterEscopoAtual().adicionar(ident.getText(), TipoLA.CUSTOMIZADO);
        }
        
        return escopo;
    }
    
    public static Escopos visitaCmd(Escopos escopo, LAParser.CmdContext ctx){
        System.out.println("vistando comando");
        if(ctx.cmd_leia()!=null){
            System.out.println("leia");
            verificaCmdLeia(escopo,ctx.cmd_leia());
            
        }
        if(ctx.cmd_escreva()!=null){
            System.out.println("escreva");
            verificaCmdEscreva(escopo,ctx.cmd_escreva());
        }
        if(ctx.cmd_atribuicao()!=null){
            System.out.println("atribuicao");
            verificaCmdAtribuicao(escopo,ctx.cmd_atribuicao());
        }
        if(ctx.cmd_caso()!=null){
            
        }
        if(ctx.cmd_chamada()!=null){
            
        }
        if(ctx.cmd_enquanto()!=null){
            System.out.println("enquanto");
            verificaCmdEnquanto(escopo,ctx.cmd_enquanto());
        }
        if(ctx.cmd_faca()!=null){
            System.out.println("faca");
            verificaCmdFaca(escopo,ctx.cmd_faca());
        }
        if(ctx.cmd_para()!=null){
            
        }
        if(ctx.cmd_retorne()!=null){
            System.out.println("retorne");
            verificaCmdRetorne(escopo,ctx.cmd_retorne());
        }
        if(ctx.cmd_se()!=null){
            System.out.println("se");
            verificaCmdSe(escopo,ctx.cmd_se());
        }
        
        return escopo;
    }
    public static void verificaCmdRetorne(Escopos escopo, LAParser.Cmd_retorneContext ctx){
        TipoLA expTipo = visitaExpressao(escopo,ctx.expressao());
    }
    public static void verificaCmdFaca(Escopos escopo, LAParser.Cmd_facaContext ctx){
        TipoLA expTipo = visitaExpressao(escopo,ctx.expressao());
        for(LAParser.CmdContext cmd: ctx.cmd()){
            visitaCmd(escopo,cmd);
        }
    }
    public static void verificaCmdEnquanto(Escopos escopo, LAParser.Cmd_enquantoContext ctx){
        TipoLA expTipo = visitaExpressao(escopo,ctx.expressao());
        for(LAParser.CmdContext cmd: ctx.cmd()){
            visitaCmd(escopo,cmd);
        }
    }
    
    public static void verificaCmdSe(Escopos escopo, LAParser.Cmd_seContext ctx){
        TipoLA expTipo = visitaExpressao(escopo,ctx.expressao());
        for(LAParser.CmdContext cmd: ctx.cmd()){
            visitaCmd(escopo,cmd);
        }
    }
    
    public static void verificaCmdAtribuicao(Escopos escopo, LAParser.Cmd_atribuicaoContext ctx){
        String ident;
        if(ctx.getStart().getText().contains("^")){
            ident = "^" + ctx.identificador().getText();
        }else{
            ident = ctx.identificador().getText();
        }
        TipoLA tipoIdent = visitaIdentificador(escopo,ident);
        TipoLA tipoExp = visitaExpressao(escopo,ctx.expressao());
        System.out.print(tipoIdent);
        System.out.print("  ");
        System.out.println(tipoExp);
        System.out.println(verificaTiposCompativeis(tipoIdent,tipoExp));
        if(!verificaTiposCompativeis(tipoIdent,tipoExp)){
            adicionaErro("Linha "+ctx.identificador().getStart().getLine()+": atribuicao nao compativel para " + ident);
        }
    }
    public static void verificaCmdLeia(Escopos escopo, LAParser.Cmd_leiaContext ctx){
        for(LAParser.IdentificadorContext ident: ctx.identificador()){
            String nome = ident.getText();
            if(!escopo.obterEscopoAtual().existe(nome)){
                adicionaErro("Linha "+ident.getStart().getLine()+": identificador "+nome+" nao declarado");
            }
        }
    }
    
    public static void verificaCmdEscreva(Escopos escopo, LAParser.Cmd_escrevaContext ctx){
        for(LAParser.ExpressaoContext exp: ctx.expressao()){
            visitaExpressao(escopo,exp);
        }
    }
    
    public static TipoLA visitaExpressao(Escopos escopo, LAParser.ExpressaoContext ctx){
        TipoLA tipoRetorno = TipoLA.INVALIDO;
        
        int qtdTermos = ctx.termo_logico().size();
        List<TipoLA> tiposTermos = new ArrayList<>();
        for(LAParser.Termo_logicoContext termoLogico:ctx.termo_logico()){
            tiposTermos.add(visitaTermoLogico(escopo,termoLogico));
        }
        
        
        if(qtdTermos>1){
            if(verificaTiposCompativeis(tiposTermos)){
                tipoRetorno = TipoLA.LOGICO;
            }
            
        }else{
            tipoRetorno = tiposTermos.get(0);
        }
        return tipoRetorno;
    }
    public static TipoLA visitaTermoLogico(Escopos escopo, LAParser.Termo_logicoContext ctx){
        TipoLA tipoRetorno = TipoLA.INVALIDO;
        
        int qtdTermos = ctx.fator_logico().size();
        List<TipoLA> tiposTermos = new ArrayList<>();
        for(LAParser.Fator_logicoContext fatorLogico:ctx.fator_logico()){
            tiposTermos.add(visitaFatorLogico(escopo,fatorLogico));
        }
        if(qtdTermos>1){
            if(verificaTiposCompativeis(tiposTermos)){
                tipoRetorno = TipoLA.LOGICO;
            }
        }else{
            tipoRetorno = tiposTermos.get(0);
        }
        return tipoRetorno;
    }
    
    public static TipoLA visitaFatorLogico(Escopos escopo, LAParser.Fator_logicoContext ctx){
        TipoLA tipoRetorno = TipoLA.INVALIDO;
        TipoLA tipoParcela = visitaParcelaLogica(escopo,ctx.parcela_logica());
        if(ctx.getStart().equals("não")){
            if(tipoParcela == TipoLA.LOGICO){
                tipoRetorno = TipoLA.LOGICO;
            }
        }else{
            tipoRetorno = tipoParcela;
        }
        
        return tipoRetorno;
    }
    
    public static TipoLA visitaParcelaLogica(Escopos escopo, LAParser.Parcela_logicaContext ctx){
        TipoLA tipoRetorno = TipoLA.INVALIDO;
        if(ctx.exp_relacional()!=null){
            tipoRetorno = visitaExpRelacional(escopo,ctx.exp_relacional());
        }else{
            tipoRetorno = TipoLA.LOGICO;
        }
        
        return tipoRetorno;
    }
    
    public static TipoLA visitaExpRelacional(Escopos escopo, LAParser.Exp_relacionalContext ctx){
        TipoLA tipoRetorno = TipoLA.INVALIDO;
        
        int qtdTermos = ctx.exp_aritmetica().size();
        List<TipoLA> tiposExps = new ArrayList<>();
        for(LAParser.Exp_aritmeticaContext expArit:ctx.exp_aritmetica()){
            tiposExps.add(visitaExpAritmetica(escopo,expArit));
        }
        if(qtdTermos>1){
            if(verificaTiposCompativeis(tiposExps)){
                tipoRetorno = TipoLA.LOGICO;
            }
        }else{
            tipoRetorno = tiposExps.get(0);
        }
        return tipoRetorno;
    }
    
    public static TipoLA visitaExpAritmetica(Escopos escopo, LAParser.Exp_aritmeticaContext ctx){
        TipoLA tipoRetorno = TipoLA.INVALIDO;
        
        int qtdTermos = ctx.termo().size();
        List<TipoLA> tiposExps = new ArrayList<>();
        for(LAParser.TermoContext expArit:ctx.termo()){
            tiposExps.add(visitaTermoAritmetico(escopo,expArit));
        }
        if(qtdTermos>1){
            if(verificaTiposCompativeis(tiposExps)){
                tipoRetorno = tiposExps.get(0);
            }
        }else{
            tipoRetorno = tiposExps.get(0);
        }
        return tipoRetorno;
    }
    public static TipoLA visitaTermoAritmetico(Escopos escopo, LAParser.TermoContext ctx){
        TipoLA tipoRetorno = TipoLA.INVALIDO;
        
        int qtdTermos = ctx.fator().size();
        List<TipoLA> tiposExps = new ArrayList<>();
        for(LAParser.FatorContext expArit:ctx.fator()){
            tiposExps.add(visitaFatorAritmetico(escopo,expArit));
        }
        if(qtdTermos>1){
            if(verificaTiposCompativeis(tiposExps)){
                tipoRetorno = tiposExps.get(0);
            }
        }else{
            tipoRetorno = tiposExps.get(0);
        }
        return tipoRetorno;
    }
    public static TipoLA visitaFatorAritmetico(Escopos escopo, LAParser.FatorContext ctx){
        TipoLA tipoRetorno = TipoLA.INVALIDO;
        
        int qtdTermos = ctx.parcela().size();
        List<TipoLA> tiposExps = new ArrayList<>();
        for(LAParser.ParcelaContext expArit:ctx.parcela()){
            tiposExps.add(visitaParcelaAritmetica(escopo,expArit));
        }
        if(qtdTermos>1){
            if(verificaTiposCompativeis(tiposExps)){
                tipoRetorno = tiposExps.get(0);
            }
        }else{
            tipoRetorno = tiposExps.get(0);
        }
        return tipoRetorno;
    }
    
    public static TipoLA visitaParcelaAritmetica(Escopos escopo, LAParser.ParcelaContext ctx){
        TipoLA tipoRetorno = TipoLA.INVALIDO;
        if(ctx.parcela_nao_unario()!= null){
            tipoRetorno = visitaParcelaNaoUnaria(escopo,ctx.parcela_nao_unario());
        }else{
            tipoRetorno = visitaParcelaUnaria(escopo,ctx.parcela_unario());
        }
        
        return tipoRetorno;
    }
    
    public static TipoLA visitaParcelaUnaria(Escopos escopo, LAParser.Parcela_unarioContext ctx){
        TipoLA tipoRetorno = TipoLA.INVALIDO;
        if(ctx.NUM_INT()!=null){
            tipoRetorno = TipoLA.INTEIRO;
        }
        if(ctx.NUM_REAL()!=null){
            tipoRetorno = TipoLA.REAL;
        }
        if(ctx.identificador()!=null){
            
            if(escopo.obterEscopoAtual().existe(ctx.identificador().getText())){
                tipoRetorno = escopo.obterEscopoAtual().verificar(ctx.identificador().getText());
            }else{
                adicionaErro("Linha "+ctx.identificador().getStart().getLine()+": identificador "+ctx.identificador().getText()+" nao declarado");
            }
        }
        if(ctx.IDENT()!=null){
            System.out.println("Chamando " + ctx.IDENT().getText());
            List<TipoLA> tiposParametros = new ArrayList<>();
            for(LAParser.ExpressaoContext exp: ctx.expressao()){
                tiposParametros.add(visitaExpressao(escopo,exp));
            }
            System.out.println(tiposParametros);
            if(!escopo.obterEscopoAtual().getEntrada(ctx.IDENT().getText()).getParametros().equals(tiposParametros)){
                adicionaErro("Linha "+ctx.IDENT().getSymbol().getLine()+": incompatibilidade de parametros na chamada de "+ctx.IDENT().getText());
            }
            tipoRetorno = escopo.obterEscopoAtual().getEntrada(ctx.IDENT().getText()).getTipo();
        }else{
            for(LAParser.ExpressaoContext exp: ctx.expressao()){
                tipoRetorno = visitaExpressao(escopo,exp);
            }
        }
        return tipoRetorno;
    }
    
    public static TipoLA visitaParcelaNaoUnaria(Escopos escopo, LAParser.Parcela_nao_unarioContext ctx){
        TipoLA tipoRetorno = TipoLA.INVALIDO;
        if(ctx.CADEIA()!=null){
            tipoRetorno = TipoLA.CADEIA;
        }else{
            if(escopo.obterEscopoAtual().existe(ctx.identificador().getText())){
                tipoRetorno = escopo.obterEscopoAtual().verificar(ctx.identificador().getText());
            }else{
                adicionaErro("Linha "+ctx.identificador().getStart().getLine()+": identificador "+ctx.identificador().getText()+" nao declarado");
            }
            
        }
        return tipoRetorno;
    }
    public static Escopos visitaVariavel(Escopos escopo, LAParser.VariavelContext ctx){
        for(LAParser.IdentificadorContext ident: ctx.identificador()){
            String identificadorNome = ident.getText();
            if(!escopo.obterEscopoAtual().existe(identificadorNome)){
                
                TipoLA tipo = verificaTipo(escopo,ctx.tipo());
               
                escopo = adicionaVariavel(escopo,identificadorNome,tipo,ctx.tipo());
               
                
                
            }else{
                adicionaErro("Linha "+ident.getStart().getLine()+": identificador "+ ident.getStart().getText() +" ja declarado anteriormente");         
            }
            
            
        }
        return escopo;
    }
    public static Escopos visitaVariavel(Escopos escopo, LAParser.VariavelContext ctx, String identificador){
        for(LAParser.IdentificadorContext ident: ctx.identificador()){
            String identificadorNome = identificador+ "." + ident.getText();
            if(!escopo.obterEscopoAtual().existe(identificadorNome)){
                
                TipoLA tipo = verificaTipo(escopo,ctx.tipo());
                if(ident.dimensao()!=null){
                    System.out.println(ident.dimensao().getText());
                }else{
                    escopo = adicionaVariavel(escopo,identificadorNome,tipo,ctx.tipo());
                }
                
               
                
                
            }else{
                adicionaErro("Linha "+ident.getStart().getLine()+": identificador "+ ident.getStart().getText() +" ja declarado anteriormente");         
            }
            
            
        }
        return escopo;
    }
    
    public static Escopos adicionaVariavel(Escopos escopo, String identificador,TipoLA tipo, LAParser.TipoContext ctx){
        System.out.println(tipo);
        if(tipo == TipoLA.CADEIA || tipo == TipoLA.INTEIRO || tipo == TipoLA.REAL || tipo == TipoLA.LOGICO || tipo == TipoLA.INVALIDO){
            escopo.obterEscopoAtual().adicionar(identificador, tipo);
        }
        if(tipo == TipoLA.PONTEIRO){
            
            escopo.obterEscopoAtual().adicionar("^"+identificador, tipo);
            escopo.obterEscopoAtual().adicionar(identificador, verificaTipo(escopo,ctx.tipo_estendido().tipo_basico_ident()));
        }
        if(tipo == TipoLA.REGISTRO){
            
            for(LAParser.VariavelContext var : ctx.registro().variavel()){
                visitaVariavel(escopo, var, identificador);
            }
        }
        if(tipo == TipoLA.CUSTOMIZADO){
            System.out.println("OIA O CUSTOM");
            System.out.println(identificador);
            List<EntradaTabelaDeSimbolos> variaveis = escopo.obterEscopoAtual().getTipoCustomizado(ctx.getText()).getCampos();
            for(EntradaTabelaDeSimbolos var: variaveis){
                escopo = adicionaVariavel(escopo,identificador+"."+var.getNome(),var.getTipo(),ctx);
            }
            
            escopo.obterEscopoAtual().adicionar(identificador, tipo);
           
        }
        
        return escopo;
    }
    
    public static TipoLA verificaTipo(Escopos escopo,LAParser.TipoContext ctx){
        TipoLA tipoRetorno = TipoLA.INVALIDO;
        if(ctx.tipo_estendido()!= null){
            tipoRetorno = verificaTipo(escopo,ctx.tipo_estendido());
        }else{//registro
            tipoRetorno = TipoLA.REGISTRO;
        }
        return tipoRetorno;
    }
    
    public static TipoLA verificaTipo(Escopos escopo,LAParser.Tipo_estendidoContext ctx){
        TipoLA tipoRetorno = TipoLA.INVALIDO;
        if(ctx.getStart().getText().contains("^")){
            System.out.println("EH O PONTAS");
            tipoRetorno = TipoLA.PONTEIRO;
        }else{
            tipoRetorno = verificaTipo(escopo,ctx.tipo_basico_ident());
        }
        return tipoRetorno; 
    }
    
    public static TipoLA verificaTipo(Escopos escopo,LAParser.Tipo_basico_identContext ctx){
        TipoLA tipoRetorno = TipoLA.INVALIDO;
        if(ctx.tipo_basico()!=null){
            String tipoBasico = ctx.tipo_basico().getText();
            switch(tipoBasico){
                case("inteiro"):
                    tipoRetorno = TipoLA.INTEIRO;
                    break;
                case("real"):
                    tipoRetorno = TipoLA.REAL;
                    break;
                case("literal"):
                    tipoRetorno = TipoLA.CADEIA;
                    break;
                case("logico"):
                    tipoRetorno = TipoLA.LOGICO;
                    break;
            }
        }else{
            //tipo ident
            //verifica tipo de registro
            if(escopo.obterEscopoAtual().existeTipo(ctx.IDENT().getText())){
                tipoRetorno = TipoLA.CUSTOMIZADO;
            }else{
                tipoRetorno = TipoLA.INVALIDO;
                adicionaErro("Linha "+ctx.IDENT().getSymbol().getLine()+": tipo "+ctx.IDENT().getText()+" nao declarado");
            }
            
        }
        return tipoRetorno; 
    }
    
    public static TipoLA visitaIdentificador(Escopos escopo, LAParser.IdentificadorContext ctx){
        TipoLA tipoRetorno = TipoLA.INVALIDO;
        if(escopo.obterEscopoAtual().existe(ctx.getText())){
            tipoRetorno = escopo.obterEscopoAtual().verificar(ctx.getText());
        }
        return tipoRetorno; 
    }
    public static TipoLA visitaIdentificador(Escopos escopo, String ident){
        TipoLA tipoRetorno = TipoLA.INVALIDO;
        if(escopo.obterEscopoAtual().existe(ident)){
            tipoRetorno = escopo.obterEscopoAtual().verificar(ident);
        }
        return tipoRetorno; 
    }
    
    public static boolean verificaTiposCompativeis(TipoLA tipoA, TipoLA tipoB){
        boolean ehCompativel = true;
        if(tipoA == TipoLA.INVALIDO || tipoB == TipoLA.INVALIDO){
            ehCompativel = false;
        }else{
            if(tipoA != tipoB){
                if(!((tipoA == TipoLA.REAL || tipoA == TipoLA.INTEIRO) && (tipoB == TipoLA.REAL || tipoB == TipoLA.INTEIRO))){
                    ehCompativel = false;
                }
                
            }
        }
        
        return ehCompativel;
    }
    
    public static boolean verificaTiposCompativeis(List<TipoLA> tipos){
        boolean ehCompativel = false;
        if(!tipos.contains(TipoLA.INVALIDO)){
            if(tipos.contains(TipoLA.INTEIRO) ||tipos.contains(TipoLA.REAL)){
                if(!(tipos.contains(TipoLA.CADEIA) || tipos.contains(TipoLA.CUSTOMIZADO) || tipos.contains(TipoLA.LOGICO) ||  tipos.contains(TipoLA.REGISTRO))){
                    ehCompativel = true;
                }
            }else{
                if(tipos.contains(TipoLA.CADEIA)){
                    if(!(tipos.contains(TipoLA.CUSTOMIZADO) || tipos.contains(TipoLA.LOGICO) ||  tipos.contains(TipoLA.REGISTRO))){
                        ehCompativel = true;
                    }
                }else
                if(tipos.contains(TipoLA.CUSTOMIZADO)){
                    if(!(tipos.contains(TipoLA.CADEIA) || tipos.contains(TipoLA.LOGICO) ||  tipos.contains(TipoLA.REGISTRO))){
                        ehCompativel = true;
                    }
                }else
                if(tipos.contains(TipoLA.LOGICO)){
                    if(!(tipos.contains(TipoLA.CADEIA) || tipos.contains(TipoLA.CUSTOMIZADO) ||  tipos.contains(TipoLA.REGISTRO))){
                        ehCompativel = true;
                    }
                }
                else
                if(tipos.contains(TipoLA.REGISTRO)){
                    if(!(tipos.contains(TipoLA.CADEIA) || tipos.contains(TipoLA.CUSTOMIZADO) || tipos.contains(TipoLA.LOGICO) )){
                        ehCompativel = true;
                    }
                }
            }
           
        }
        
        
        return ehCompativel;
    }
}
