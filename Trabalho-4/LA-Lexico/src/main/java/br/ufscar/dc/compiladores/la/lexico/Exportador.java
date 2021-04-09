/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.compiladores.la.lexico;

import br.ufscar.dc.compiladores.la.lexico.TabelaDeEntradas.Tipos;
import java.io.PrintWriter;

/**
 *
 * @author salomao
 */
public class Exportador {
    public static String geraArquivo(TabelaDeEntradas declaracoes, PrintWriter writer){
        System.out.println("EXPORTANDO CODIGO");
        writer.println("{");
        int count = 0;
        for (String keys : declaracoes.getNomeDeclaracoes()){
            writer.print("\t");
            writer.println('"' +  keys + '"' + ": {");
            TabelaDeEntradas.ListaDeclaracoes lista = declaracoes.getListaDeclaracao(keys);
            for(TabelaDeEntradas.EntradaDeclaracao entradas : lista.declaracoesList){
                writer.print("\t\t");
                writer.println('"' + entradas.nome +'"'+ " : {");
                for(TabelaDeEntradas.CampoDeclaracao campos : entradas.campos){
                    writer.print("\t\t\t");
                    writer.print('"' + campos.nome + '"' +" : ");
                    if(campos.tipo == Tipos.VETOR){
                        writer.print("[\n");
                        for(TabelaDeEntradas.CampoDeclaracao camps : campos.getCampos()){
                            writer.print("\t\t\t\t");
                            if(camps.tipo == Tipos.DATA){
                                writer.print('"'+ camps.getValor()+'"' );
                            }else{
                                writer.print( camps.getValor() );
                            }
                            
                            if(campos.getCampos().indexOf(camps) != campos.getCampos().size()-1){
                                
                                writer.print(",");
                            }
                            writer.print("\n");
                            
                        }
                        writer.print("\t\t\t");
                        writer.print("]");
                    }else{
                        
                        if(campos.tipo == Tipos.DATA){
                                writer.print('"'+ campos.getValor()+'"');
                            }else{
                                writer.print( campos.getValor() );
                            }
                    }
                    if(entradas.campos.indexOf(campos) != entradas.campos.size()-1){   
                        writer.print(",");
                    }
                    writer.print("\n");
                }
                writer.print("\t\t");
                writer.print("}");
                if(lista.declaracoesList.indexOf(entradas) != lista.declaracoesList.size()-1){   
                        writer.print(",");
                }
                writer.print("\n");
            }
            writer.print("\t");
            writer.print("}");
            if( count != declaracoes.getNomeDeclaracoes().size()-1){   
                    writer.print(",");
            }
            writer.print("\n");
            count++;
        }
        writer.println("}");
        return "A";
    }
}
