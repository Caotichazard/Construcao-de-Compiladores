package br.ufscar.dc.compiladores.la.lexico;

import br.ufscar.dc.compiladores.la.lexico.TabelaDeEntradas;
import br.ufscar.dc.compiladores.la.lexico.TabelaDeEntradas.CampoDefinicao;
import br.ufscar.dc.compiladores.la.lexico.TabelaDeEntradas.Tipos;

import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Pair;
import br.ufscar.dc.compiladores.la.lexico.LASemantico;


import org.antlr.v4.runtime.tree.TerminalNode;

public class LASemanticoUtils {

    public static List<String> erros = new ArrayList<>();

    public static void adicionaErro(String msg) {
        erros.add(msg);
    }
    
    public static TabelaDeEntradas visitaDefinicoes(LAParser.DefinicaoContext ctx, TabelaDeEntradas entradas){
        //System.out.println(ctx.IDENT());
        if(entradas.existeDefinicao(ctx.IDENT().getText())){
            adicionaErro("Linha " + ctx.getStart().getLine() + ": identificador " + ctx.IDENT().getText() + " já usado anteriormente");
        }else{
        List<CampoDefinicao> campos = new ArrayList<>();
        boolean error = false;
        Tipos tipoTmp;
        for(LAParser.CampoContext campo: ctx.campo()){
            error = false;
            //System.out.println(campo.IDENT().getText() + " : " + campo.tipo().getText());
            for(CampoDefinicao campTmp : campos){
                if(campTmp.nome.equals(campo.IDENT().getText())){
                    error = true;
                    adicionaErro("Linha " + campo.getStart().getLine() + ": identificador " + campo.IDENT().getText() + " já usado anteriormente");
                }
            }
            tipoTmp = confereTipo(campo.tipo());
            if(tipoTmp == Tipos.INVALIDO){
                error = true;
                adicionaErro("Linha " + campo.getStart().getLine() + ": tipo invalido declarado");

            }
            if(!error){
                CampoDefinicao campoTmp = entradas.new CampoDefinicao(campo.IDENT().getText(),tipoTmp);
                campos.add(campoTmp);
            }
            
        }
        
        
        
        entradas.adicionaDefinicao(ctx.IDENT().getText(), campos);
        entradas.adicionaTabelaDeclaracao(ctx.IDENT().getText());
        
        System.out.println(entradas.getDefinicao(ctx.IDENT().getText()).nome);
        }
        return entradas;
        
    }
    
    public static TabelaDeEntradas visitaDeclaracoes(LAParser.DeclaracaoContext ctx, TabelaDeEntradas entradas){
        System.out.println(ctx.IDENT());
        String nomeDef = ctx.IDENT().getText();
        if(entradas.existeDefinicao(nomeDef)){
            TabelaDeEntradas.EntradaDefinicao definicao= entradas.getDefinicao(ctx.IDENT().getText());
            TabelaDeEntradas.ListaDeclaracoes listaDeclaracoes = entradas.getListaDeclaracao(ctx.IDENT().getText());
            
            for(LAParser.ValoresContext valores: ctx.valores()){
                List<TabelaDeEntradas.CampoDeclaracao> listCampos = new ArrayList();
                for(LAParser.ValorContext valor: valores.valor()){
                    boolean campoPresente = false;
                    boolean campoValido = false;
                    String campoEntrada = valor.IDENT().getText();
                    if(campoEntrada != null){
                        for(CampoDefinicao campos: definicao.tipos){
                            if(campos.nome.equals(campoEntrada)){
                                System.out.println("CAMPO PRESENTE");
                                campoPresente = true;
                                if(valor.entradaSimples() != null){
                                    Tipos tipoEntrada = confereTipoEntrada(valor.entradaSimples().entrada());
                                    String valorStr = valor.entradaSimples().entrada().getText();
                                    if(tipoEntrada == Tipos.REFERENCIA){
                                        TabelaDeEntradas.CampoDeclaracao tmpDecl = criaReferencia(valor.entradaSimples().entrada().referencia(),entradas,campos);
                                        if(tmpDecl != null){
                                            listCampos.add(tmpDecl);
                                            campoValido = true;
                                        }
                                    }
                                    if(tipoEntrada == campos.tipo){
                                        TabelaDeEntradas.CampoDeclaracao tmpCampo= entradas.new CampoSimples(campos.nome,campos.tipo,valorStr);
                                        listCampos.add(tmpCampo);
                                        campoValido = true;
                                    }
                                }else{
                                    System.out.println("AAAAAAAAAAAAAAAAAAAA");
                                    List<TabelaDeEntradas.CampoDeclaracao> listCamposVec = new ArrayList();
                                    for(LAParser.EntradaContext vet: valor.entradaVetor().entrada()){
                                        Tipos tipoEntrada = confereTipoEntrada(vet);
                                        String valorStr = vet.getText();
                                        if(tipoEntrada == Tipos.REFERENCIA){
                                            TabelaDeEntradas.CampoDeclaracao tmpDecl = criaReferencia(vet.referencia(),entradas,campos);
                                            if(tmpDecl != null){
                                                listCamposVec.add(tmpDecl);
                                                campoValido = true;
                                            }
                                        }
                                        if(tipoEntrada == campos.tipo){
                                            TabelaDeEntradas.CampoDeclaracao tmpCampo= entradas.new CampoSimples(campos.nome,campos.tipo,valorStr);
                                            listCamposVec.add(tmpCampo);
                                            campoValido = true;
                                        }
                                    }
                                    
                                    TabelaDeEntradas.CampoDeclaracao tmpCampo = entradas.new CampoVetor(campos.nome,Tipos.VETOR,campos.tipo,listCamposVec);
                                    listCampos.add(tmpCampo);
                                }
                                
                            }
                            

                        }
                        if(!campoPresente){
                                adicionaErro("Linha "+valor.getStart().getLine() + " : " + "Atributo " + campoEntrada + " não definido");
                        }
                        if(!campoValido){
                                adicionaErro("Linha "+valor.getStart().getLine() + " : " + "Tipos não compativeis");
                        }


                        
                    }
                    

                }
                String nomeDecl = valores.IDENT().getText();
                if(nomeDecl != null){
                    if("_".equals(nomeDecl)){
                        nomeDecl = nomeDef + listaDeclaracoes.declaracoesList.size();
                    }
                    TabelaDeEntradas.EntradaDeclaracao declTmp = entradas.new EntradaDeclaracao(nomeDecl,listCampos);
                    listaDeclaracoes.declaracoesList.add(declTmp);
                }
                
            }
            
            
        }else{
            adicionaErro("Linha " + ctx.getStart().getLine() + " : Definição de "+ ctx.IDENT() +" não declarada anteriormente");
        }
       
        /*
        for(CampoDefinicao campos: definicao.tipos){
            System.out.println(campos.nome + " : " + campos.tipo);
            
        }
*/
        
        
        return entradas;
    }
    
    
    
    
    public static TabelaDeEntradas.CampoDeclaracao criaReferencia(LAParser.ReferenciaContext ctx, TabelaDeEntradas entradas, CampoDefinicao campos){
        TabelaDeEntradas.CampoDeclaracao declRet = null;
        String valorStr = null;
        String refSource = null;
        
        refSource = ctx.IDENT(0).getText();
        
        
        
        if(entradas.existeDefinicao(refSource)){
            System.out.println("Referinfo a :" + refSource);
            TabelaDeEntradas.ListaDeclaracoes listaDeclaracoesRef = entradas.getListaDeclaracao(refSource);
            String refEntry = ctx.IDENT(1).getText();
            System.out.println("Buscando entrada :" + refEntry);
            boolean foundEntry = false;
            for(TabelaDeEntradas.EntradaDeclaracao entryDecl : listaDeclaracoesRef.declaracoesList){

                if(refEntry.equals(entryDecl.nome)){
                    foundEntry = true;
                    System.out.println("Entrada " + refEntry + " encontrada");
                    String refCamp = ctx.IDENT(2).getText();
                    System.out.println("Buscando campo :" + refCamp);
                    boolean foundCamp = false;
                    for(TabelaDeEntradas.CampoDeclaracao entryCamo : entryDecl.campos){
                        
                        if(refCamp.equals(entryCamo.nome)){
                            foundCamp = true;
                            System.out.println("Campo " + refCamp + " encontrado "+ entryCamo.tipo + entryDecl.nome) ;
                            if(entryCamo.tipo == Tipos.VETOR){
                                System.out.println("Campo " + refCamp + " é vetor") ;
                                if(ctx.IDENT(3) != null){
                                    
                                    String refIndex = ctx.IDENT(3).getText();
                                    int refIndexint = Integer.parseInt(refIndex);
                                    System.out.println(entryCamo.getCampos().toArray());
                                    TabelaDeEntradas.CampoDeclaracao entryCamoAux = entryCamo.getCampos().get(refIndexint);
                                    Tipos tipoEntradaAux = entryCamoAux.tipo;
                                    valorStr = entryCamoAux.getValor();
                                    if(tipoEntradaAux == campos.tipo){
                                        TabelaDeEntradas.CampoDeclaracao tmpCampo= entradas.new CampoSimples(campos.nome,campos.tipo,valorStr);
                                        declRet = tmpCampo;
                                        //campoValido = true;
                                    }else{
                                        adicionaErro ("Linha " + ctx.getStart().getLine() + " : Incompatibilidade de tipos");
                                    }
                                }else{
                                    List<TabelaDeEntradas.CampoDeclaracao> entryCamoAux = entryCamo.getCampos();
                                    System.out.println("A");
                                    Tipos tipoEntradaAux = entryCamoAux.get(0).tipo;
                                    System.out.println("B");
                                    if(tipoEntradaAux == campos.tipo){
                                        TabelaDeEntradas.CampoDeclaracao tmpCampo= entradas.new CampoVetor(campos.nome,Tipos.VETOR,campos.tipo,entryCamoAux);
                                        declRet = tmpCampo;
                                    }
                                    else{
                                        adicionaErro ("Linha " + ctx.getStart().getLine() + " : Incompatibilidade de tipos");
                                    }
                                }
                                

                            }else{
                                System.out.println("Campo " + refCamp + " não é vetor") ;
                                Tipos tipoEntradaAux = entryCamo.tipo;
                                valorStr = entryCamo.getValor();
                                System.out.println(valorStr);
                                if(tipoEntradaAux == campos.tipo){
                                    System.out.println(valorStr);
                                    TabelaDeEntradas.CampoDeclaracao tmpCampo= entradas.new CampoSimples(campos.nome,campos.tipo,valorStr);
                                    declRet = tmpCampo;
                                    //campoValido = true;
                                }else{
                                        adicionaErro ("Linha " + ctx.getStart().getLine() + " : Incompatibilidade de tipos");
                                }
                            }
                        }

                    }
                    if(!foundCamp){
                        adicionaErro("Linha "+ctx.getStart().getLine() + " : Campo " + refCamp + " não encontrado");
                    }
                }
            }

            if(!foundEntry){
                adicionaErro("Linha "+ctx.getStart().getLine() + " : Declaração " + refEntry + " não encontrado");
            }
        }else{
             adicionaErro("Linha "+ctx.getStart().getLine() + " : Definição " + refSource + " não encontrado");
        }
        return declRet;
    }
   
    public static Tipos confereTipoEntrada(LAParser.EntradaContext ctx){
        Tipos tipoRet = Tipos.INVALIDO;
        if(ctx.CADEIA() != null){
            tipoRet = Tipos.CADEIA;
        }
        if(ctx.NUM() != null){
            tipoRet = Tipos.NUMERO;
        }
        if(ctx.DATA() != null){
            tipoRet = Tipos.DATA;
        }
        if(ctx.referencia() != null){
            tipoRet = Tipos.REFERENCIA;
        }
        
        
        
        return tipoRet;
    }
    
    public static Tipos confereTipo(LAParser.TipoContext ctx){
        Tipos tipoRet = Tipos.INVALIDO;
        String tipoStr = ctx.getText();
        switch (tipoStr){
                case "NUMERO":
                    tipoRet = Tipos.NUMERO;
                    break;
                case "CADEIA":
                    tipoRet = Tipos.CADEIA;
                    break;
                case "DATA":
                    tipoRet = Tipos.DATA;
                    break;
        }
                    
        return tipoRet;
    }
}
