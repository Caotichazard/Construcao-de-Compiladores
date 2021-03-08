/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.compiladores.la.lexico;

/**
 *
 * @author salomao
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.ParseCancellationException;


public class Principal {
    
    
    public static void main(String[] args) {
        
       
        
        // args[0] é a localização e nome do arquivo de entrada
        // args[1] é a localização e nome do arquivo de saida
        try(PrintWriter pw = new PrintWriter(new File(args[1]))) {
            CharStream cs = CharStreams.fromFileName(args[0]);
            LALexer lex = new LALexer(cs);
            
            Token t = null;
            while( (t = lex.nextToken()).getType() != Token.EOF) {
                System.out.println("<" + LALexer.VOCABULARY.getDisplayName(t.getType()) + "," + t.getText() + ">");
            }
            CommonTokenStream tokens = new CommonTokenStream(lex);
            LAParser parser = new LAParser(tokens);

            MyErrorListener mcel = new MyErrorListener(pw);
            parser.addErrorListener(mcel);

            parser.programa();
        }catch(IOException ex){
            
        }
            
    }
    
    //Função responsável por Receber a lista de strings a serem salvas no arquivo e salvar no arquivo
    public static void saveToFile(List<String> list,String pathToFile){
        try{
            //Cria ou abre o arquivo caso exitisse anteriormente e limpa o arquivo
            PrintWriter out = new PrintWriter(new FileWriter(pathToFile));
            for (String temp: list) {//Para cada string na lista de strings
                out.println(temp);//salva no arquivo
            }
        out.close();//fechar o arquivo
        }catch(IOException ex){
            
        }
    }
    
    //Função responsável por receber um token e gerar a string que será salva no arquivo
    public static String tokenParser(Token token){
        String tmp = LALexer.VOCABULARY.getDisplayName(token.getType());
        if(null == tmp){
            return "<" + LALexer.VOCABULARY.getDisplayName(token.getType())  + "," + token.getText() + ">";
        }else switch (tmp) {//para cada token diferente recebido, gera a string necessária
            case "IDENT":
                return "<'"+token.getText() + "'," + "IDENT>";
            case "CADEIA":
                return "<'"+token.getText() + "'," + "CADEIA>";
            case "NUM_INT":
                return "<'"+token.getText() + "'," + "NUM_INT>";
            case "NUM_REAL":
                return "<'"+token.getText() + "'," + "NUM_REAL>";
            case "ERROR_CHAR":
                return "Linha "+ token.getLine() + ": " + token.getText() + " - simbolo nao identificado";
            case "COMENT_NFECHADO":
                return "Linha "+ token.getLine() + ": comentario nao fechado";
            case "CADEIA_NFIM":
                System.out.println("AAAAAAAa");
                return "Linha "+ token.getLine() + ": cadeia literal nao fechada";
            default:
                return "<'" + token.getText() + "','"+token.getText()+"'>";
        }
        
    }
    
}
